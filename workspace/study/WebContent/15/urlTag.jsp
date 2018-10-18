<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/inc/lib.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/inc/navbar.jsp"></jsp:include>

	<div class="container">
		<pre>
			<!-- 직접 호출  -->
			request.getContextPath() = c:url
			request.getContextPath() : <%=request.getContextPath() %>
			c:url : <c:url value="/"></c:url>
			
			request.getContextPath() : <%=request.getContextPath()+"/15/urlTag.jsp?key=value" %>
			c:url : <c:url value="/15/urlTag.jsp"></c:url>
			
			<!-- 변수로 호출  -->
			<c:url var="testUrl" value="/15/urlTag.jsp">
				<c:param name="key" value="test"></c:param>
				<c:param name="name" value="홍길동"></c:param>
			</c:url>
			
			${testUrl }
			<a href="${testurl }">test Url</a>
		</pre>
	</div>
</body>
</html>