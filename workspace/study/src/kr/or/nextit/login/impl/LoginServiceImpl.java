package kr.or.nextit.login.impl;

import javax.servlet.http.HttpServletRequest;

import kr.or.nextit.login.LoginService;
import kr.or.nextit.login.service.LoginVo;
import sun.reflect.generics.tree.Tree;

public class LoginServiceImpl implements LoginService {

	@Override
	public void loginCheck(HttpServletRequest req) {

		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");

		if ("master".equals(userId) && "12345".equals(userPw)) {
			req.setAttribute("result", true);
			req.setAttribute("message", "정상 로그인~~");
		} else {
			req.setAttribute("result", false);
			req.setAttribute("message", "아이디 또는 비밀번호가 누락 되었습니다.");
		}
	}

	@Override
	public LoginVo loginCheck(String userId, String userPw) {

		LoginVo result = new LoginVo();

		try {
			if ("admin".equals(userId) &&  "12345".equals(userPw)) {
				result.setUserId(userId);
				result.setUserPw("");
				result.setUserName("관리자");
				result.setUserEmail("admin@nextit.or.kr");
				result.setResult(true);
				result.setMessage("정상 로그인");
			} else {
				result.setUserId(userId);
				result.setUserPw("");
				result.setUserName("");
				result.setUserEmail("");
				result.setResult(false);
				result.setMessage("로그인 실패~~");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setResult(false);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}

}
