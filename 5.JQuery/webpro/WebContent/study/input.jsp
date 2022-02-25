<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style>
			table{
				border : 2px solid black;
				margin : 50px;
				background : gray;
				color : white;
				font-size: 20px;
			}
			td{
			 	width : 300px;
			 	height : 50px;
			 	text-align : center;
			}
		</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		Server 내에서 실행되는 자바 프로그램을 포함한 스크립트 언어<br>
		
		클라이언트 요청시 데이터를 받는다 : request.getParameter("name")<br>
		<%
			String inputmail = request.getParameter("email");
			String inputurl = request.getParameter("url");
			String inputcolor = request.getParameter("color");
			String inputdate = request.getParameter("date");
			String inputtel = request.getParameter("tel");
			String inputpass = request.getParameter("pass");
			String inputfile = request.getParameter("file");
			int num = Integer.parseInt(request.getParameter("number"));
			num += 100;
		%>
	
		<table border = "1">
			<tr>
				<td>항목</td>
				<td>값</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= inputmail %></td>
			</tr>
			<tr>
				<td>URL</td>
				<td><%= inputurl %></td>
			</tr>
			<tr>
				<td>COLOR</td>
				<td><%= inputcolor %></td>
			</tr>
			<tr>
				<td>DATE</td>
				<td><%= inputdate %></td>
			</tr>
			<tr>
				<td>TEL</td>
				<td><%= inputtel %></td>
			</tr>
			<tr>
				<td>숫자</td>
				<td><%= num %></td>
			</tr>
			<tr>
				<td>PASS</td>
				<td><%= inputpass %></td>
			</tr>
			<tr>
				<td>FILE</td>
				<td><%= inputfile %></td>
			</tr>
		</table>
	</body>
</html>