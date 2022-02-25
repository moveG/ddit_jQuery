<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String car1 = request.getParameter("car1");
			String[] car2 = request.getParameterValues("car2");
			
			String str = "선택한 값 : <br>";

			if(car1 != null){
				str += car1 + "<br>";
			}else if (car2 != null){
				//out.print(car2); 배열의 주소가 출력됨
				for(String car : car2){
					str += car + "<br>";
				}
			}
		%>
		
		<div><%= str %></div>
	</body>
</html>