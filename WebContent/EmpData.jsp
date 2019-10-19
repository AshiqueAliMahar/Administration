<%@page import="Beans.UsersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input,div{
		border-radius: 5px;
	}
</style>
</head>
<body>
	<%
		if(request.getAttribute("empData")!=null){
		UsersBean usersBean=(UsersBean)request.getAttribute("empData"); 
	%>
	<div style="color:white;background-color: maroon;text-align: center;width: 30%;margin: auto;padding: 20px;">
		<h1>Employee Data</h1>
		<form action="LogIn" >
			<table align="center">
				<tr>
					<td>
						<label>ID</label>
					</td>
					<td>
						<input type="text" placeholder="Enter ID" name="id" value="<%= usersBean.getId()%>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Name</label>
					</td>
					<td>
						<input type="text" placeholder="Enter Name" name="name" value="<%=usersBean.getName() %>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Enter Email</label>
					</td>
					<td>
						<input type="email" placeholder="Enter Email" name="email" value="<%=usersBean.getEmail() %>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Enter Password</label>
					</td>
					<td>
						<input type="password" placeholder="Enter Password" name="password" value="<%=usersBean.getPassword() %>" >
					</td>
				</tr>
				<tr>
					<td>
						<label>Contact</label>
					</td>
					<td>
						<input type="number" placeholder="Contact e.g:1234567890" name="contact" value="<%=usersBean.getContact() %>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Address</label>
					</td>
					<td>
						<input type="text" placeholder="Enter Address" name="address" value="<%=usersBean.getAddress() %>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Status</label>
					</td>
					<td >
						<input type="text" name="status" value="<%=usersBean.getStatus() %>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Role</label>
					</td>
					<td>
						<input list="role" name="role" value="<%=usersBean.getRole() %>">
						<datalist id="role">
								<option>Admin</option>
								<option>Employee</option>
						</datalist>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit" name="update" value="update">Update</button>
						<button type="submit" name="update" value="logout">LogOut</button>
					</td>
			</table>
		</form>
	</div>
	<%}else{
		response.sendRedirect("LogIn.jsp");
	}
	 %>
</body>
</html>