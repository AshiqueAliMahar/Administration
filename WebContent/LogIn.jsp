<%@page import="mainHead.Main"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input,div{
		border-radius: 5px
	}
	
</style>
</head>
<body>
	<div style="color:white;background-color: maroon;text-align: center;width: 300px;height: 300px;margin: auto;">
		<h1 style="padding-top: 90px;">Log In Form</h1>
		<form action="LogIn" >
			<table align="center">
				<tr>
					<td>
						<label>Enter Email</label>
					</td>
					<td>
						<input type="text" placeholder="Enter Email" name="email">
					</td>
				</tr>
				<tr>
					<td>
						<label>Enter Password</label>
					</td>
					<td>
						<input type="password" placeholder="Enter Password" name="password">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
							<button type="submit" value="logIn" name="update">LogIn</button>
							<button type="button" ><a href="SignUp.html">SingUp</a></button>
							
					</td>
			</table>
			<%if(request.getAttribute("warning")!=null){%>
			<%= request.getAttribute("warning")%>
			<%} %>
		</form>
	</div>
	
</body>
</html>