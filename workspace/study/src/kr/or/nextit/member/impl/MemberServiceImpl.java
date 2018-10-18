package kr.or.nextit.member.impl;

import java.util.HashMap;
import java.util.List;

import kr.or.nextit.function.MemberUtil;
import kr.or.nextit.function.service.CommCodeVo;
import kr.or.nextit.member.MemberService;
import kr.or.nextit.member.MemberVo;

public class MemberServiceImpl implements MemberService {

	@Override
	public void insertUserInfo(HashMap<String, Object> params) {
		System.out.println(params);
		System.out.println(params);
		System.out.println(params);
	}

	@Override
	public MemberVo insertUserInfo(String userId, HashMap<String, Object> params) {

		MemberVo result = new MemberVo();

		result.setUserId(userId);
		result.setUserName((String) params.get("userName"));
		result.setUserEmail((String.format("신청하신 : %s", params.get("userEmail"))));

		List<CommCodeVo> hobbyItems = MemberUtil.getHobbyItems();
		String[] userHobbys = (String[]) params.get("userHobby");

		int i = 0;
		for (String userHobby : userHobbys) {
			for (CommCodeVo item : hobbyItems) {
				if (userHobby.equals(item.getKey())) {
					userHobbys[i] = String.format("%s (%s)", item.getValue(), item.getKey());
					i++;
					break;
				}
			}
		}

		result.setUserHobby(userHobbys);

		return null;
	}

}
