package kr.or.nextit.board.service;

import java.util.List;

public interface BoardService {

	/**
	 * Board 글 등록
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public boolean InsertboardItem(BoardVo boardVo) throws Exception;
	
	/**
	 * Board List 구현
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public List<BoardVo> getBoardList(BoardVo boardVo) throws Exception;
	
	/**
	 * 1개의 정보를 가지고 온다.
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public BoardVo getBoardItem(BoardVo boardVo) throws Exception;
	
	/**
	 * seqNo 로 삭제하는 기능
	 * @param seqNo
	 * @throws Exception
	 */
	public void deleteBoardItem(String seqNo) throws Exception;
	
	/**
	 * 제목과 내용을 수정한다.
	 * @param params
	 * @throws Exception
	 */
	public void updateBoardItem(BoardVo params) throws Exception;
}
