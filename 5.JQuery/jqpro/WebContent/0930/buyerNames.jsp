<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿 실행 후 결과값 가져오기
	List<BuyerVO> list = (List<BuyerVO>) request.getAttribute("listAttr");
%>

[
	<%
	for(int i = 0; i < list.size(); i++){
		BuyerVO vo = list.get(i);
		
		if(i > 0) out.print(",");
	%>
		{
			"id"   : "<%= vo.getBuyer_id()%>",
			"name" : "<%= vo.getBuyer_name()%>"
		}	
	<%	
	}
	%>
]
