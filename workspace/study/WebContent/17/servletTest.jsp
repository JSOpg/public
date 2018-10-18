<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- <jsp:include page="/inc/lib.jsp"></jsp:include> --%>
<c:import url="/inc/lib.jsp"></c:import>

</head>
<body>
<%-- 	<jsp:include page="/inc/navbar.jsp"></jsp:include> --%>
	<c:import url="/inc/navbar.jsp"></c:import>

	<div class="container">
		<br><br><br><br>
		<form action="/servletTest" method="get">
			<input type="text" name="test">
			<input type="text" name="userName">
			<button type="submit">servlet Test doGet</button>
		</form>		
		
		<form action="/servletTest" method="post">
			<input type="text" name="userTest">
			<input type="text" name="userName">
			<button type="submit">servlet Test doPost</button>
		</form>		
	</div>
</body>
</html>