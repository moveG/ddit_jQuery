<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 전송시 데이터를 받음(현재는 받을 데이터가 없으므로 생략됨)

	//데이터의 처리(DB의 CRUD처리)

	//CRUD처리 이후 응답 데이터를 생성(html, xml, json, text)
	
	//json타입에서는 <!-- -->같은 주석은 사용할 수 없음(200오류 발생)
	
	//json Object에서는 꼭 쌍따옴표를 사용해야함
%>

[
	{
	"이름" : "일지매",
	"연락처" : "010-1111-1111",
	"주소" : "대전광역시 중구 대흥동"
	},

	{
	"이름" : "이지매",
	"연락처" : "010-2222-2222",
	"주소" : "대전광역시 중구 대흥동"
	},

	{
	"이름" : "삼지매",
	"연락처" : "010-3333-3333",
	"주소" : "대전광역시 중구 대흥동"
	},

	{
	"이름" : "사지매",
	"연락처" : "010-4444-4444",
	"주소" : "대전광역시 중구 대흥동"
	},

	{
	"이름" : "오지매",
	"연락처" : "010-5555-5555",
	"주소" : "대전광역시 중구 대흥동"
	}
]