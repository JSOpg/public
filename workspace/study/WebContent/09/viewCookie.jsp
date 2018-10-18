<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 Info</title>
</head>
<body>

	<%
	// 쿠키 생성
	Cookie createCookie = new Cookie("test",
							URLEncoder.encode("안녕하세요 ~~ 여러분~~", "UTF-8"));
// 	createCookie.setDomain("127.0.0.1");
	createCookie.setPath("/");
	createCookie.setMaxAge(5);
	response.addCookie(createCookie);
	
	Cookie cookie2 = new Cookie("review",
							URLEncoder.encode("review 에서만 보이는 쿠키", "UTF-8"));
// 	cookie2.setDomain("127.0.0.1");
	cookie2.setPath("/");
	cookie2.setMaxAge(5);
	response.addCookie(cookie2);
	
	
	// 생성된 쿠키 정보
	Cookie[] cookie = request.getCookies();
		
	if (cookie != null ) {
		for (Cookie cok : cookie) {
			out.println("getName() : "+ cok.getName() + " <br> ");
			out.println("getValue() :" +cok.getValue() + " <br> ");
			out.println("URLDecoder.decode(cok.getValue() : " 
					   + URLDecoder.decode(cok.getValue(), "UTF-8")  + "<br>");
			
			out.println("getComment() :" + cok.getComment() + " <br> ");
			out.println("getDomain() :" + cok.getDomain() + " <br> ");
			out.println("getMaxAge() :" + cok.getMaxAge() + " <br> ");
			out.println("getPath() :" + cok.getPath() + " <br> ");
			out.println("getVersion() :" + cok.getVersion() + " <br> ");
			out.println("getSecure() :" + cok.getSecure() + " <br> ");
			out.println(" ===================================== <br> ");
		}
	}
		
	%>
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>