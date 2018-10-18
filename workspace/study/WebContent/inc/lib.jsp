<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<%
	String url = request.getContextPath();
%>
<link rel="stylesheet" href="<%=url%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=url%>/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=url%>/css/starter-template.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="<%=url%>/js/jquery-3.3.1.js"></script>
<script src="<%=url%>/js/bootstrap.min.js"></script>









<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->