<%@page import="kr.or.nextit.function.service.CommCodeVo"%>
<%@page import="kr.or.nextit.function.MemberUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.nextit.mber.service.MberVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
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
<title>forEach</title>
<jsp:include page="/inc/lib.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/inc/navbar.jsp"></jsp:include>

	<div class="container">
		<%
			HashMap<String,Object> map = new HashMap<>();
			map.put("memId", "master");
			map.put("memName", "홍길동");
		%>
		<c:set var="item" value="<%=map %>"/>
		
		<c:forEach var="m" items="${item }">
			key : ${m.key } , value : ${m.value } <br>
		</c:forEach>
		
		<%
			List<MberVo> items = new ArrayList<>();
			MberVo item = new MberVo();
			
			item.setMemId("master");
			item.setMemName("홍길동");
			items.add(item);
			
			item = new MberVo();
			item.setMemId("admin");
			item.setMemName("말자");
			items.add(item);
			
			item = new MberVo();
			item.setMemId("test");
			item.setMemName("철수");
			items.add(item);
			
			request.setAttribute("ds", items);
		%>
		<c:set var="rs" value="<%=items %>"/>
		
		<c:forEach var="item" items="${rs }">
			${item.memId }
			${item.memName }<br>
		</c:forEach>

		<table class="table">
			<tr>
				<td>status.first</td>
				<td>status.count</td>
				<td>mber.memId</td>
				<td>mber.memName</td>
				<td>status.last</td>
			</tr>
			<c:forEach var="mber" items="${ds }" varStatus="status">
				<tr>
					<td>${status.first ? '시작' : ''}</td>
					<td>${status.count}</td>
					<td>${mber.memId }</td>
					<td>${mber.memName }</td>
					<td>${status.last ? '마지막' : ''}</td>
				</tr>
			</c:forEach>
		</table>
		
		<% 
			List<CommCodeVo> hobby = MemberUtil.getHobbyItems();
		%>
		
		<c:set var="hobbys" value="<%=hobby %>"/>
		
		취미(select) : 
		<select name="hobby">
			<c:forEach var="rs" items="${hobbys }">
				<option value="${rs.key }">${rs.value }</option>
			</c:forEach>
		</select>
		<br>
		<hr>
		
		취미(radio) :
		<c:forEach var="rs" items="${hobbys }">
			<input type="radio" name="hobbyRadio" value="${rs.key }"> ${rs.value }
		</c:forEach>
		<br>
		
		취미(checkbox) : 
		<c:forEach var="rs" items="${hobbys }">
			<input type="checkbox" name="hobbyCheckBox" value="${rs.key }"> ${rs.value }	
		</c:forEach>
		
	</div>

</body>
</html>