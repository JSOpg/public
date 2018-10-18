package kr.or.nextit.mber.service;

public interface MberService {

	/**
	 * 회원 상세 정보
	 * @param memId
	 * @return
	 */
	public MberVo getMemberItem(String memId);
	
	/**
	 * 회원 정보 수정
	 * @param memId
	 * @param memPwd
	 * @param memName
	 * @param memPhone
	 * @param memEmail
	 * @return
	 */
	public MberVo updateMemberItem(
			String memId,
			String memPwd,
			String memName,
			String memPhone,
			String memEmail
			);
	
	/**
	 * 회원 삭제
	 * @param memId
	 * @return
	 */
	public boolean deleteMemberItem(String memId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
