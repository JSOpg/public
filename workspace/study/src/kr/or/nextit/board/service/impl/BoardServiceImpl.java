package kr.or.nextit.board.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.jdbc.MybatisSqlSessionFactory;

public class BoardServiceImpl implements BoardService{

	private SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	private BoardMapper boardMapper;
	
	@Override
	public boolean InsertboardItem(BoardVo boardVo) throws Exception {
		
		SqlSession session = null;
		
		try {
			boardVo.setSeqNo(UUID.randomUUID().toString());
			//boardVo.setServiceType("NOTICE");
			
			session = sessionFactory.openSession();
			
			boardMapper = session.getMapper(BoardMapper.class);
			
			boardMapper.insertBoardItem(boardVo);
			
			session.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return false;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo boardVo) throws Exception {
		
		SqlSession session = null;
		
		List<BoardVo> result;
		try {
			session = sessionFactory.openSession();
			boardMapper = session.getMapper(BoardMapper.class);
			
			result = boardMapper.selectBoardList(boardVo);
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public BoardVo getBoardItem(BoardVo boardVo) throws Exception {
		
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			boardMapper = session.getMapper(BoardMapper.class);
			
			// 조회수 처리(+1)
			boardMapper.updateBoardCountItem(boardVo);
			
			BoardVo Boardresult = boardMapper.selectBoardItem(boardVo);
			session.commit();
			
			return Boardresult;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
			throw new Exception(e.getMessage(),e);
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteBoardItem(String seqNo) throws Exception {
		
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			boardMapper = session.getMapper(BoardMapper.class);
			
			boardMapper.deleteBoardItem(seqNo);
			session.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
			throw new Exception();
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateBoardItem(BoardVo params) throws Exception {
		
		SqlSession conn = null;
		
		try {
			conn = sessionFactory.openSession();
			
			boardMapper = conn.getMapper(BoardMapper.class);
			
			boardMapper.updateBoardItem(params);
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}

	
}
