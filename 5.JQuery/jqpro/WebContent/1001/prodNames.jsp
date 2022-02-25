<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 수행한 결과값을 가져온다.
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("lguAttr");

	//대괄호('[', ']')는 배열이 필요할 때만 사용
	if(list != null && list.size() > 0) {
		
%>
{
	"flag" : "ok",
	"datas" :
	[
<%
		for(int i = 0; i < list.size(); i++){
			ProdVO vo = list.get(i);
			if(i > 0) out.print(",");
%>
			{	
				"id"   : "<%= vo.getProd_id() %>",
				"name" : "<%= vo.getProd_name() %>"
			}
<%
		}
%>	
	]
}
<%
	}else {
%>
		{
			"flag" : "no"
		}
<%		
	}
%>













