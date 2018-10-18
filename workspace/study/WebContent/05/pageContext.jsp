<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.nextit.member.service.*" %>

<%
MemberVo mem = new MemberVo();
mem.setMessage("message");
mem.setUserId("master");
mem.setUserName("홍길동");

request.setAttribute("mem", mem);

%>	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pagecontext</title>

<jsp:include page="/inc/lib.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/inc/navbar.jsp" />
	<div class="container">

		<pre>
	
	당신의 IP : <%=request.getRemoteAddr()%>
	URI : <%=request.getRequestURI()%>
	<hr>
	
	

	<%
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
	%>
	당신의 IP 2 : <%=req.getRemoteAddr()%>
	URI 2 : <%=req.getRequestURI()%>
	
	당신의 IP 2 : <%=pageContext.getRequest().getRemoteAddr()%>
	<hr>
	
	
	EL 을 사용해서
	 IP 3 : ${pageContext.request.remoteAddr}
	 URI : ${pageContext.request.requestURI}
	 컨텍스트 경로 : ${pageContext.request.contextPath}
	 
	 이름 	: ${mem.userName }
	 아이디	: ${mem.userId }
	 이름 	: <%=mem.getUserName() %>
	 아이디	: <%=mem.getUserId() %>
	 
	<hr>
	
	
	<%
	int level = Integer.parseInt(application.getInitParameter("debugLevel"));
	%>
	<hr>
	디버깅 여부 : <%=application.getInitParameter("logEnabled")%>
	로그레벨 :<%=level%>
	서버정보 :<%=application.getServerInfo()%>
	버전 :<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
	<%
		if (level > 3) {
			log("로그를 기록합니다.");
			application.log("어플리케이션 로그");
		}
	%>
	<%=application.getInitParameter("love") %>
	<%=application.getRealPath("") %>
	<%=application.getRealPath("/06/") %>
	<%=application.getRealPath("/temp/") %>
	</pre>











	</div>

</body>
</html>