package kr.or.nextit.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import kr.or.nextit.member.service.MemberVo;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, Object> parameterType = new HashMap<>();
		parameterType.put("memberVo",new MemberVo());
		parameterType.put("userId","master");
		parameterType.put("userId",3);
		parameterType.put("userId",3.141592);
		
		List<MemberVo> memberList = new ArrayList<>();
		
		Set<String> keys = parameterType.keySet();
		
		for(String key : keys) {
			System.out.println(key);
			System.out.println(parameterType.get(key));
			memberList.add((MemberVo) parameterType.get(key));
		}
		
		for(MemberVo memberInfo : memberList) {
			System.out.println(memberInfo);
		}
		
		HashMap<String, Object> resultType = new HashMap<>();
		
		MemberVo memberVo = new MemberVo();
		
		memberVo.setUserId("");
		
		HashMap<String, Object> vo = new HashMap<>();
		vo.put("userId", memberVo.getUserId());
		vo.put("userName", memberVo.getUserName());
		vo.put("userEmail", memberVo.getUserEmail());

	}

}