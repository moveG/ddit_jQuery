<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVO bv = (BoardVO) request.getAttribute("readAttr");
%>

{
	"board_no"      : "<%= bv.getBoard_no() %>",
	"board_title"   : "<%= bv.getBoard_title() %>",
	"board_writer"  : "<%= bv.getBoard_writer() %>",
	"board_date"    : "<%= bv.getBoard_date() %>",
	"board_content" : "<%= bv.getBoard_content() %>"
}