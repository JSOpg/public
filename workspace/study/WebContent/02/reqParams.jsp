<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<pre>
	<%
	Enumeration<String> params = request.getParameterNames();
	
	while(params.hasMoreElements()){
		String key = params.nextElement();

		String result  = "";
		String value = request.getParameter(key);
		result = String.format("parameter Key = %s : value = %s", key, value);
		out.println(result);
	}
	
	%>
</pre>

</body>
</html>