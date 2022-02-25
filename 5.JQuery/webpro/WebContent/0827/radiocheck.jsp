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
				background : white;
				font-size: 20px;
			}
			td{
			 	width : 500px;
			 	height : 50px;
			 	text-align : center;
			}
		</style>
	</head>
	<body>
		<%	
			request.setCharacterEncoding("UTF-8");
			
			String sid = request.getParameter("id");
			String sname = request.getParameter("name");
			String saddr = request.getParameter("addr");
			String sgender = request.getParameter("gender");

			String[] sfood = request.getParameterValues("food");
			String str = "";
			for(int i = 0; i < sfood.length; i++){
				str += sfood[i] + "&nbsp;&nbsp;";
			}
		%>
		<table border = "1">
			<tr>
				<td>아이디</td>
				<td><%= sid %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= sname %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%= saddr %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%= sgender %></td>
			</tr>
			<tr>
				<td>좋아하는 음식</td>
				<td><%= str %></td>
			</tr>
		</table>
	</body>
</html>