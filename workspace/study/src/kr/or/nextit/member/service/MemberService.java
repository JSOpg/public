package kr.or.nextit.member.service;

import java.util.HashMap;
import java.util.List;

public interface MemberService {

	/**
	 * HashMap 회원 가입 ~~
	 * @param params
	 */
	public void insertUserInfo(HashMap<String, Object> params);
	
	public MemberVo insertUserInfo(
			String userId, 
			HashMap<String, Object> params );
	
	public List<MemberVo> getMemberList(MemberVo memberVo) throws Exception;
	
	/**
	 * 선택된(userId) 회원 정보를 가지고 오는 것.
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MemberVo getMemberItem(
								String userId
								) throws Exception;
 
}