<%@page import="kr.or.nextit.common.error.BizException"%>
<%@page import="kr.or.nextit.function.service.impl.ComCodeServiceImpl"%>
<%@page import="kr.or.nextit.function.service.ComCodeService"%>
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
		<%
		
			ComCodeService codeService = new ComCodeServiceImpl();
			
			 //try {
				// String value = "맙소사~~";
				// int num = Integer.parseInt(value);
				// codeService.getErrorTest("하영111");
				// codeService.getErrorTest2("이름2");
				codeService.getBizErrorTest("이름3");
				// codeService.getBizErrorTest2("이름4");
				 
			//} catch(Exception ex) {
				// out.println(ex.getMessage());
				//throw new BizException(ex.getMessage());
				
			//}
		
		%>
	</div>
</body>
</html>