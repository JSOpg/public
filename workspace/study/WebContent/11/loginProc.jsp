<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.nextit.login.service.LoginVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.nextit.common.utils.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	List<LoginVo> memberList = new ArrayList();
	memberList.add(new LoginVo("홍길동", "master", "12345", "master@nextit.or.kr"));
	memberList.add(new LoginVo("오하영", "admin", "12345", "admin@nextit.or.kr"));
	memberList.add(new LoginVo("이영애", "user", "12345", "user@nextit.or.kr"));
	memberList.add(new LoginVo("말자", "biz", "12345", "biz@nextit.or.kr"));
	memberList.add(new LoginVo("철수", "total", "12345", "total@nextit.or.kr"));
		



	CookieBox cookieBox = new CookieBox(request);

	String userRemember = request.getParameter("userRemember");
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");

	if ("Y".equals(userRemember)) {
		Cookie cId = CookieBox.createCookie("userId", userId);
		Cookie cRemember = CookieBox.createCookie("userRemember", userRemember);
		response.addCookie(cId);
		response.addCookie(cRemember);
	} else {
		Cookie cId = CookieBox.createCookie("userId", "", "/", 0);
		Cookie cRemember = CookieBox.createCookie("userRemember", "", "/", 0);
		response.addCookie(cId);
		response.addCookie(cRemember);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
	요청신 ID : ${param.userId }
	요청신 PW : ${param.userPw }
	아이디 저장 유무 : ${param.userRemember }
<%
	out.println(session.getId());
	out.println(session.getCreationTime());
	out.println(session.getLastAccessedTime());
	
	for(LoginVo loginVo : memberList){
		out.println(loginVo.getUserId());
		out.println(loginVo.getUserPw());
		
		if(userId.equals(loginVo.getUserId()) 
			&& userPw.equals(loginVo.getUserPw())){
			
			loginVo.setResult(true);
			loginVo.setMessage("로그인 하신걸 축하 드림니다.");
			session.setAttribute("loginInfo", loginVo);
			//request.getSession().setAttribute("loginInfo", loginInfo);
			// 아이디와 비밀번호가 일치 합니다.
			break;
		} else {
			// session 을 완전희 초기화 시킴 (반복문 안에서는 절대로 하면 안됨.)
			//session.invalidate();
			session.setAttribute("loginInfo", null);
			session.removeAttribute("loginInfo");
			
		}
	}
	
	response.sendRedirect(String.format("%s/11/loginForm.jsp", request.getContextPath()));
	
%>
 
</pre>




</body>
</html>