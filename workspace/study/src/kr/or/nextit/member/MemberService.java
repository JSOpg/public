package kr.or.nextit.member;

import java.util.HashMap;

public interface MemberService {

	// interface 에서는 private 는 선언할수 없다.
	
	/**
	 * HashMap 회원 가입 ~~
	 * @param params
	 */
	public void insertUserInfo(HashMap<String, Object> params);
	
	public MemberVo insertUserInfo(String userId, HashMap<String, Object> params); 
	
}

