<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("listAttr");
%>

[
<%
	for(int i = 0; i < list.size(); i++) {
		BoardVO bv = list.get(i);
		if(i > 0){
			out.print(",");
		}
%>
	{
		"board_no"      : "<%= bv.getBoard_no() %>",
		"board_title"   : "<%= bv.getBoard_title() %>",
		"board_writer"  : "<%= bv.getBoard_writer() %>",
		"board_date"    : "<%= bv.getBoard_date() %>",
		"board_content" : "<%= bv.getBoard_content() %>"
	}
<%
	}
%>
]