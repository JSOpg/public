package kr.or.nextit.function.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.nextit.function.service.CommCodeVo;

/**
 * 공통 코드를 처리하는 데이터 레이어 영역 클래스
 * @author pc36
 *
 */
public class ComCodeServiceDao {
	
	/**
	 * ComCodeServiceDao 인스턴스 생성(new Object)
	 */
	private static ComCodeServiceDao instance = new ComCodeServiceDao();
	// private static ComCodeServiceDao instance = null;
	
	/**
	 * instance 가 null일 경우 new instance 생성
	 * @return ComCodeServiceDao 에 생성된 instance 반환
	 */
	public static ComCodeServiceDao getInstance() {
		if(instance == null) {
			instance = new ComCodeServiceDao();
		}
		return instance;
	}
	
	/**
	 * 공통 코드 테이블에서 groupId 조건에 해당하는 값을 반환
	 * @param conn (데이터베이스 연결 Connection 객체 param 값으로 받아옴)
	 * @param groupId (공통 코드 테이블에 들어갈 조건)
	 * @return List<CommCodeVo> 반환
	 * @throws SQLException
	 */
	public List<CommCodeVo> selectCodeList(Connection conn, String groupId) throws SQLException {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT CODE_ID, CODE_NAME FROM TB_COM_CODE");
		query.append("	WHERE GROUP_ID = ?");
		
		PreparedStatement pstmt = conn.prepareStatement(query.toString());
		pstmt.setString(1, groupId);
		
		ResultSet rs = pstmt.executeQuery(); 
		
		List<CommCodeVo> result = new ArrayList<>();
		
		while(rs.next()) {
			result.add(new CommCodeVo(rs.getString("CODE_ID"),rs.getString("CODE_NAME")));
		}
		
		return result;
	}
	
	
	/**
	 * DB에서 codeKey 값을 조건절로 찾아서 반환
	 * @param conn
	 * @param codeKey
	 * @return
	 * @throws SQLException 
	 */
	public CommCodeVo selectCodeName(Connection conn, String codeKey) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
				
		sql.append("		SELECT                     ");
		sql.append("	    group_id,                  ");
		sql.append("	    code_id,                   ");
		sql.append("	    code_name,                 ");
		sql.append("	    reg_date                   ");
		sql.append("	FROM                           ");
		sql.append("	    tb_com_code                ");
		sql.append("	WHERE                          ");
		sql.append("	    CODE_ID = ?  ");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, codeKey);
		
		ResultSet rs = pstmt.executeQuery();
		
		// CommCodeVo codeResult = new CommCodeVo();
		CommCodeVo codeResult = null;
		
		if(rs.next()) {
			codeResult = new CommCodeVo(rs.getString("code_id"),rs.getString("code_name"));
		}
		
		return codeResult;
	}
	
}