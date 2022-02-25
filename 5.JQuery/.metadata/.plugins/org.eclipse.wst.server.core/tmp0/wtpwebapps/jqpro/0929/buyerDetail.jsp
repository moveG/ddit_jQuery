<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 전송시 데이터를 받음(현재는 받을 데이터가 없으므로 생략됨)
	String buyer_id = request.getParameter("id");
	//데이터의 처리(DB의 CRUD처리)
	//1. SqlMapClient객체를 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. Sql mapper에 기술된 sql문장을 실행함(namespace이름.id이름)
	BuyerVO vo = (BuyerVO) client.queryForObject("buyer.selectDetail", buyer_id);
	
	//CRUD처리 이후 응답 데이터를 생성(html, xml, json, text)
	
	//json타입에서는 <!-- -->같은 주석은 사용할 수 없음(200오류 발생)
	
	//jsp주석은 사용가능
	
	//json Object에서는 꼭 쌍따옴표를 사용해야함
%>

{
	"id"   : "<%= vo.getBuyer_id() %>",
	"name" : "<%= vo.getBuyer_name() %>",
	"lgu"  : "<%= vo.getBuyer_lgu() %>",
	"mail"  : "<%= vo.getBuyer_mail() %>",
	"bank"  : "<%= vo.getBuyer_bank() %>",
	"bname"  : "<%= vo.getBuyer_bankname() %>",
	"bno"  : "<%= vo.getBuyer_bankno() %>",
	"zip"  : "<%= vo.getBuyer_zip() %>",
	"add1"  : "<%= vo.getBuyer_add1() %>",
	"add2"  : "<%= vo.getBuyer_add2() %>"
}	
