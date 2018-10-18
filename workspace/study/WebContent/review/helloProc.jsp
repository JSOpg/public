<%@page import="kr.or.nextit.review.service.ReViewVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.nextit.review.service.ReviewService" %>
<%@ page import="kr.or.nextit.function.service.*" %>

<% 
request.setCharacterEncoding("UTF-8"); 
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<pre>
<%
	ReviewService paramService = new ReviewService();
	HashMap<String, Object> hashMap = paramService.getRequstParamsTest(request);
	String[] selectHobby = request.getParameterValues("userHobby");
	String[] selectItem = paramService.selectHobby(selectHobby);
	
	for(String value : selectItem){
		out.println(value);
	}
	out.println("=================================");
	
	
	out.println(hashMap.get("uName"));
	out.println(hashMap.get("uAge"));
	
	out.println(request.getParameter("userName"));
	out.println(request.getParameter("userAge"));

	List<CommCodeVo> hobby = (List<CommCodeVo>) hashMap.get("hobbyList");
	String[] uHobby = request.getParameterValues("userHobby");
	
	for(String item : uHobby){
		for(CommCodeVo hitem : hobby){
			if(item.equals(hitem.getKey())){
				out.println(String.format(" %s (%s) : 당신이 선택한 취미 ",
										 hitem.getValue(), 
										 hitem.getKey()));
				break;
			}  else {
				//out.println(String.format(" %s (%s)", 
				//					hitem.getValue(), 
				//					hitem.getKey()));
			}
		}
		out.println("=================================");
	}
	
	
	
	
	
	for(String item : uHobby){
		out.println(item);
	}
	
	out.println(uHobby);
	
	for(CommCodeVo item : hobby){
	
		if(uHobby.equals(item.getKey())){
			out.println(String.format(" %s (%s) : 당신이 선택한 취미 ",
									 item.getValue(), 
									 item.getKey()));
		} else {
			out.println(String.format(" %s (%s)", 
									item.getValue(), 
									item.getKey()));
		}
		
		
		
	}
	
%>





================================================================

코드 목록

<%
ReviewService.getRequestCodeTest(request);

List<ReViewVo> cList = (List<ReViewVo>) request.getAttribute("codeList");

for (ReViewVo value : cList) {
	out.println(String.format("%s (%s)", value.getName(), value.getCode()));
}
%>

================================================================

회원 목록 : 
	<%
		ReviewService service = new ReviewService();
		service.getRequestTest(request);
		
		List<String> mList = (List<String>) request.getAttribute("memberList");
		
		for(String value : mList){
			out.println(value);
		}
	%>
	





================================================================

나이 3 인 녀석이 넘어오면 "이벤트 당첨 !!" 문구 출력
<%
int age = Integer.parseInt(request.getParameter("userAge"));
if (age == 3){
	out.println(String.format("%s 이빈트 당첨 !!", age));
} else {
	out.println(String.format("%s 이빈트 다음 기회에 !!", age));
}


String result = (age==3 ? "축하" : "다음에");
out.println(result);	
%>

표현식 :  <%=(age==3 ? "축하" : "다음에") %>
el == ${param.userAge == 3 ? "경축~~" : "꽝~~" }


================================================================
이름
request.getParameter :  <%=request.getParameter("userName") %>

el param :  ${param.userName }
================================================================
나이
request.getParameter :  <%=request.getParameter("userAge") %>

el param :  ${param.userAge }
================================================================
<%
request.setAttribute("testName", "멋진 녀석들~~");
request.setAttribute("testAge", 50);


%>
request.setAttribute : <%=request.getAttribute("testName") %>
el request.setAttribute : ${testName }
el request.setAttribute : ${testAge }




</pre>

</body>
</html>