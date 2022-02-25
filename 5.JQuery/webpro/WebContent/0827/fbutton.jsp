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
			#info{
				height : 400px;
			}
		</style>
	</head>
	<body>
		<p>JSP : 클라이언트에서 전송시 데이터를 전달받는다.</p>
		<%	
			request.setCharacterEncoding("UTF-8");
			
			String sid = request.getParameter("id");
			String sname = request.getParameter("name");
			String saddr = request.getParameter("addr");
			String sgender = request.getParameter("gender");

			String[] sfood = request.getParameterValues("food");
			String str = "";
			if(sfood != null){
				for(int i = 0; i < sfood.length; i++){
					str += sfood[i] + "&nbsp;&nbsp;";
				}
			}else{
				str = "선택된 음식이 없습니다.";
			}
			
			
			String sarea = request.getParameter("area");
			//sarea에는 enter기호(\r\n)를 이미 포함하고 있다.
			//enter기호를 <br>태그로 변경해줘야 줄바꿈이 된다.
			//브라우저에서는 \r은 아무 기능을 하지 않는다.
			//\n을 <br>태그로 바꿔주면 enter에 맞게 줄이 바뀌게 된다.
			sarea = sarea.replaceAll("\r", "").replaceAll("\n", "<br>");
			//replaceAll은 해당하는 값 모두를 변경함
			
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
			<tr>
				<td id = "info" colspan = "2"><%= sarea %></td>
			</tr>
		</table>
	</body>
</html>