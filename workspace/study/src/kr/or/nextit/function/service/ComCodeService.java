package kr.or.nextit.function.service;

import java.util.List;

import kr.or.nextit.common.error.BizException;

public interface ComCodeService {

	/**
	 * groupId 를 가지고서 비지니스 플로우를 처리 하는 기능으로,
	 * 공통 코드 리스트를 반환(List<CommCodeVo>)
	 * @param groupId
	 * @return List<CommCodeVo>
	 */
	public List<CommCodeVo> getCodeList(String groupId);
	
	/**]
	 * 키(key) 값을 넘겨서 CommCodeVo 객체를 반환함.
	 * @param codeKey
	 * @return
	 */
	public CommCodeVo getCodeName(String codeKey);
	
	public void getErrorTest(String testValue) throws Exception;
	
	public void getErrorTest2(String testValue) throws Exception;
	
	public void getBizErrorTest(String testValue) throws BizException;
	
	public void getBizErrorTest2(String testValue) throws Exception;
	
	/**
	 * 공통 코드 테이블에서 IP 목록을 가지고 온다.
	 * @return
	 * @throws Exception
	 */
	public List<CommCodeVo> getIpList() throws Exception;
	
	/**
	 * 클라이언트 접근 IP 정보를 조건으로 접근 승인 체크
	 * @param clientIp
	 * @return
	 * @throws Exception
	 */
	public CommCodeVo getIpItem(String clientIp) throws Exception;
}