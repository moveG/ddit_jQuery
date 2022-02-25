<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 수행결과 가져오기
	String mem_id = (String) request.getAttribute("mem_idAttr");

	if(mem_id != null){
%>
		{
			"flag" : "회원가입을 완료했습니다."
		}
<%
	}else{
%>
		{
			"flag" : "회원가입에 실패했습니다."
		}
<%
	}
%>