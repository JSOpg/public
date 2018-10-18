<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.or.nextit.function.MemberUtil"%>


<%!public String displayAge(int age) {
		String result = null;

		if (age <= 18) {
			result = String.format(" 미성년자 (%d) ", age);
		} else {
			result = String.format(" 성인 (%d) ", age);
		}

		return result;
	}

	public String displaySex(String sex) {

		String result = null;

		if ("M".equals(sex)) {
			result = String.format("남성 (%s)", sex);
		} else if ("W".equals(sex)) {
			result = String.format("여성 (%s)", sex);
		} else {
			result = String.format("중성 (%s)", sex);
		}

		return result;
	}%>

<%
//response.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");



String name = "입력되지 않았습니다.";
String sex = "입력되지 않았습니다.";
int age = -1;

try{
	
	 name = request.getParameter("name");
	 sex = request.getParameter("sex");
	 age = Integer.parseInt(request.getParameter("age"));
	
} catch (Exception ex){
	String error;
	error = String.format("에러가 발생 : %s <br><br><br>", ex.getMessage());
	out.print(error);
	
}

	
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>

취미 1 : <%=request.getParameter("hobby") %>

취미 (name 값이 1개 이상일 경우 배열로 넘어옴) :<br> <% 
String[] hobby = request.getParameterValues("hobby");
for(String item : hobby){
	out.print(item + "<br>");
}





// List<HashMap<String, Object>> hobbyItems = MemberUtil.getDisplayHobbyList();
// for(String ho : hobby){
// 	for(HashMap<String, Object> item : hobbyItems){
// 		String key = (String) item.get("key");
// 		if (ho.equals(key)){
// 			String di = null;
// 			di = String.format("당신의 취미는 : %s (%s) <br>", 
// 								item.get("display"), item.get("key"));
// 			out.print(di);
// 			break;
// 		}
// 	}
	
// }
		 %>
============================================================
<%
	List<String> hobbyDisplay = MemberUtil.getHobby(hobby);
	for(String item : hobbyDisplay){
		out.print(item);
	}
	
%>

</pre>
	이름 :
	<%=name%> <br>

	성별  : <%=displaySex(sex)%><br>

	나이 1: <%out.print(displayAge(age));%><br>
	나이 2 : <%=MemberUtil.getDisplayAge(age) %><br>
<br>

	<pre>
<%
	Enumeration<String> params = request.getParameterNames();

	while (params.hasMoreElements()) {
		String key = params.nextElement();

		String result = "";
		String value = request.getParameter(key);
		result = String.format("parameter Key = %s : value = %s", key, value);
		out.println(result);
	}
%>
</pre>
</body>
</html>




