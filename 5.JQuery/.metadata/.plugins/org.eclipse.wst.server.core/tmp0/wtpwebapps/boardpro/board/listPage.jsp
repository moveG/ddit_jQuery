<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 수행한 결과값을 가져온다.
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	
	int tpage = (int) request.getAttribute("tpage");
	int spage = (int) request.getAttribute("spage");
	int epage = (int) request.getAttribute("epage");
	int cpage = (int) request.getAttribute("curpage");
%>
	{
		"tpage" : <%= tpage %>,
		"spage" : <%= spage %>,
		"epage" : <%= epage %>,
		"cpage" : <%= cpage %>,
		"datas" : [
<%
			for(int i = 0; i < list.size(); i++){
				BoardVO vo = list.get(i);
				if(i > 0) out.print(",");
%>
				{
					"num"     : "<%= vo.getNum() %>",
					"writer"  : "<%= vo.getWriter() %>",
					"subject" : "<%= vo.getSubject() %>",
					"mail"    : "<%= vo.getMail() %>",
					"hit"     : "<%= vo.getHit() %>",
					"wdate"   : "<%= vo.getWdate() %>",
					"cont"    : "<%= vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>"
				}
<% 		
			}
%>
		]
	}