<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

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
	<pre>
	  <%
	  	List<String> hello = new ArrayList();
	  	hello.add("안녕하세요~~");
	  	hello.add("방가워요 ?");
	  	hello.add("이름이 뭐에용?? 전화 번호 뭐에용???");
	  	
		String blood = request.getParameter("userBlood");
	  	switch (blood) {
	  	case "A":
	  		hello.add("A형입니다.");
	  		break;
	  	case "B":
	  		hello.add("B형입니다.");
	  		break;
	  	case "O":
	  		hello.add("O형입니다.");
	  		break;
	  	case "AB":
	  		hello.add("AB형입니다.");
	  	default:
	  		hello.add("모르는 혈액형");
	  	}

	  	request.setAttribute("hello", hello);

	  	StringBuilder path = new StringBuilder();
	  	path.append(request.getContextPath());
	  	path.append("/07/");
	  	path.append(request.getParameter("userBlood"));
	  	path.append(".jsp");

	  	out.println(path.toString());

	  	// 	  					response.sendRedirect(path.toString());
	  %>
			<jsp:forward page="<%=path.toString()%>"></jsp:forward>
			

			
</pre>
</body>
</html>