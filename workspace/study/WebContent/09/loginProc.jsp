<%@page import="kr.or.nextit.common.utils.CookieBox"%>
<%@page import="kr.or.nextit.login.service.LoginVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		LoginVo loginVo = new LoginVo();
		loginVo.setMessage("메시지");

		String userId = request.getParameter("userId");
		loginVo.setUserId(userId);
		loginVo.setUserPw(request.getParameter("userPw"));
		loginVo.setUserRemember(request.getParameter("userRemember"));
	%>
	<pre>
	아이디 : <%=loginVo.getUserId()%>
	비번 :<%=loginVo.getUserPw()%>
	아이디 저장 유무 : <%=loginVo.getUserRemember()%>
</pre>

	<jsp:useBean id="loginInfo" class="kr.or.nextit.login.service.LoginVo"
		scope="page"></jsp:useBean>

	<jsp:setProperty property="*" name="loginInfo" />
	<%-- <jsp:setProperty property="userId" name="loginInfo"/> --%>
	<%-- <jsp:setProperty property="userPw" name="loginInfo"/> --%>
	<%-- <jsp:setProperty property="userRemember" name="loginInfo"/> --%>
	<jsp:setProperty property="userEmail" name="loginInfo"
		value="master@nextit.or.kr" />
	<pre>
	아이디 : ${loginInfo.userId }
	비번 :   ${loginInfo.userPw }
	아이디 저장 유무 : ${loginInfo.userRemember == 'Y' ? '아이디저장' : '아이디 저장 안해' }
	사용자 이메일 : ${loginInfo.userEmail }
</pre>

	<jsp:setProperty property="userId" name="loginInfo" value="master" />

	<pre>
	아이디 : <jsp:getProperty property="userId" name="loginInfo" />
	비번 :   <jsp:getProperty property="userPw" name="loginInfo" />
	아이디 저장 유무 : <jsp:getProperty property="userRemember" name="loginInfo" />
	사용자 이메일 : <jsp:getProperty property="userEmail" name="loginInfo" />
</pre>


	<%
		CookieBox cookieBox = new CookieBox(request);
		String userRemember = request.getParameter("userRemember");
		
		if ("Y".equals(userRemember)){
			out.println(userRemember);
			Cookie cId = CookieBox.createCookie("userId", request.getParameter("userId") );
			Cookie cRemember = CookieBox.createCookie("userRemember", userRemember);	
			response.addCookie(cId);
			response.addCookie(cRemember);
			
		} else {
			
			Cookie cId = CookieBox.createCookie("userId", "", "/", 0 );
			Cookie cRemember = CookieBox.createCookie("userRemember", "", "/",0);
			response.addCookie(cId);
			response.addCookie(cRemember);
		}
		

		response.sendRedirect(request.getContextPath() + "/09/loginForm.jsp");
	%>



</body>
</html>