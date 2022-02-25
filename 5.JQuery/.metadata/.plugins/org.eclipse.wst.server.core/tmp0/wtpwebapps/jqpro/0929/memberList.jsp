<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 전송시 데이터를 받음(현재는 받을 데이터가 없으므로 생략됨)

	//데이터의 처리(DB의 CRUD처리)
	//1. SqlMapClient객체를 얻어오기
	SqlMapClient client = SqlMapClientFactory.getInstance();
	
	//2. Sql mapper에 기술된 sql문장을 실행함(namespace이름.id이름)
	List<MemberVO> list = client.queryForList("member.selectAllMember");
	
	//CRUD처리 이후 응답 데이터를 생성(html, xml, json, text)
	
	//json타입에서는 <!-- -->같은 주석은 사용할 수 없음(200오류 발생)
	
	//jsp주석은 사용가능
	
	//json Object에서는 꼭 쌍따옴표를 사용해야함
%>

[
	<%
	for(int i = 0; i < list.size(); i++){
		MemberVO vo = list.get(i);
		
		if(i > 0) out.print(",");
	%>	
	<%-- JSP 주석은 사용할 수 있다. --%>
		{
			"id"   : "<%= vo.getMem_id() %>",
			"name" : "<%= vo.getMem_name() %>",
			"hp"   : "<%= vo.getMem_hp() %>",
			"mail" : "<%= vo.getMem_mail() %>",
			"zip"  : "<%= vo.getMem_zip() %>",
			"add1" : "<%= vo.getMem_add1() %>",
			"add2" : "<%= vo.getMem_add2() %>",
			"bir"  : "<%= vo.getMem_bir() %>"
		}
	<%	
	}
	%>
]
