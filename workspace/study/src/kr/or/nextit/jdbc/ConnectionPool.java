package kr.or.nextit.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
	
	// 커넥션 풀.
	private static Vector<Connection> pool = new Vector<>();
	
	//private static ConnectionPool instance = new ConnectionPool();
	
	private static ConnectionPool instance = null;
	
	public static ConnectionPool getInstance() {
		if(instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
		
	private ConnectionPool() {
		try {
			initPool();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 풀 초기화
	private synchronized void initPool() throws SQLException {
		
		destroyPool();
		
		ConnectionFactory factory = ConnectionFactory.getInstance();
		
		for(int i = 0; i < factory.getMaxConnection(); i++) {
			Connection conn = factory.getConnection();
			pool.add(conn);
		}
		
		System.out.println(pool.size() + "개의 커넥션이 풀에 준비완료.");
	}
	
	// 커넥션 풀 폐기
	private synchronized void destroyPool() throws SQLException {
		
		for(Connection conn : pool) {
			
			conn.close();
			
		}
		pool.clear();	
	}
	
	// 커넥션 대여(제공)
	public synchronized Connection getConnection() {
		
		if(pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Connection conn = pool.remove(pool.size() - 1);
		
		return conn;
	}
	
	// 커넥션 반납(회수)
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}
}




