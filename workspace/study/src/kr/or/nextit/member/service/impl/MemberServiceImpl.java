package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.nextit.function.MemberUtil;
import kr.or.nextit.function.service.CommCodeVo;
import kr.or.nextit.jdbc.MybatisSqlSessionFactory;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

public class MemberServiceImpl implements MemberService {
	
	// mybatis session Factory 객체 인스턴스 생성
	private SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	private MemberMapper memberMapper;
	
	@Override
	public void insertUserInfo(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		System.out.println(params);
		System.out.println(params);
		System.out.println(params);
		

	}

	@Override
	public MemberVo insertUserInfo(
			String userId, 
			HashMap<String, Object> params) {

		MemberVo result = new MemberVo();
		
		result.setUserId(userId);
		result.setUserName((String)params.get("userName"));
		result.setUserEmail(String.format(" 신청하신 : %s", 
				params.get("userEmail")));
		
		List<CommCodeVo> hobbyItems = MemberUtil.getHobbyItems();
		String[] userHobbys = (String[]) params.get("userHobby");
		
		int i = 0;
		for (String userHobby : userHobbys) {
			for (CommCodeVo item : hobbyItems) {
				if (userHobby.equals(item.getKey())) {
					userHobbys[i] = 
				String.format("%s (%s)", item.getValue(), item.getKey());
					i++;
					break;
				}
			}
		}
		
		result.setUserHobby(userHobbys);
		
		return result;
	}

	@Override
	public List<MemberVo> getMemberList(MemberVo memberVo) throws Exception {
		
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			memberMapper = session.getMapper(MemberMapper.class);
			
			return memberMapper.selectMemberList(memberVo);
			
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
	public MemberVo getMemberItem(String userId) throws Exception {
		
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			memberMapper = session.getMapper(MemberMapper.class);
			
			MemberVo memberInfo = memberMapper.selectMemberItem(userId);
			// INSERT, UPDATE, DELETE 사용 시에 COMMIT
			// session.commit();
			return memberInfo;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// INSERT, UPDATE, DELETE 구현시 에러가 발생하면 추가, 변경, 삭제된 데이터를 원래 상태로 복구한다.
			// session.rollback();
			// return new MemberVo();
			return null;
			
		} finally {
			if(session != null) {
				try {
					session.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
}
