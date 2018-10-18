<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/lib.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/inc/navbar.jsp"></jsp:include>

	<table class="table">
		<c:forEach var="i" begin="1" end="10">
			<tr>
				<c:forEach var="j" begin="1" end="10">
					<td>${j }* ${i } = ${i * j } <br></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<table class="table">
	<tbody>
		<tr>
			<c:forEach var="i" begin="1" end="10">
				<td>
					<table class="table">
						<tbody>
							<c:forEach var="j" begin="1" end="10">
								<tr>
									<td>${i } * ${j } = ${i*j }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

</body>
</html>