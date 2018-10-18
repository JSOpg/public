<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<c:import url="/inc/lib.jsp"></c:import>

</head>
<body>

	<c:import url="/inc/navbar.jsp"></c:import>

	<div class="container">
		<form action="<c:url value="/board/boardUpdateProc.do"></c:url>" method="post">
		<input type="hidden" name="seqNo" value="${boardItem.seqNo }">
		
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boardItem.title }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="40" name="contents">${boardItem.contents }</textarea> </td>
				</tr>
				<tr>
					<th><button type="submit">수정</button></th>
				</tr>
			</tbody>
		</table>
	</form>		
	</div>
</body>
</html>