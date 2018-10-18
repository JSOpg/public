package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import kr.or.nextit.member.service.MemberVo;

/**
 * 회원 정보의 데이터베이스에서 처리한 결과를 받아오는 데이터 레이어 처리 영역
 * @author pc36
 *
 */
public interface MemberMapper {
	
	/**
	 * 회원 정보(데이터)를 목록으로 받아오는 기능
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(MemberVo memberVo) throws Exception;
	
	/**
	 * 선택된 정보(userId)를 가지고 회원 정보를 불러오는 기능
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberItem(String userId) throws Exception;
	
	public HashMap<String, Object> selectMemberInfo(HashMap<String, Object> params) throws Exception;
	
	public HashMap<String, Object> selectMemberInfoList(HashMap<String, Object> params) throws Exception;
}
