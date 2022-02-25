<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 수행결과 가져오기
	String selectId = (String) request.getAttribute("idAttr");
	
	if(selectId == null){
%>
		{
			"sw" : "사용할 수 있는 아이디입니다."
		}
<%		
	}else{
%>
		{
			"sw" : "중복된 아이디입니다."
		}
<%		
	}
%>