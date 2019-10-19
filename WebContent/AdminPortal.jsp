<%@page import="Beans.UsersBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		if (request.getAttribute("email") != null && session.getAttribute("email") != null
				&& request.getAttribute("password") != null && session.getAttribute("password") != null) {
			if (request.getAttribute("email").equals(session.getAttribute("email"))
					&& request.getAttribute("password").equals(session.getAttribute("password"))) {
	%>
	<div class="container">
		<form action="LogIn">
			<button class="btn btn-primary" type="submit" name="update" value="logout">LogOut</button>
		</form>
		<form action="LogIn">
			<button class="btn btn-primary" type="submit" name="profile" value="profile">MyProfile</button>
		</form>
		<h1>Pending Employees</h1>
		<table class="table table-striped table-success">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Status</th>
				<th>Role</th>
				<th>Active</th>
				<th>Block</th>
			</tr>
			<tbody>
				<%
					ArrayList<UsersBean> arr = (ArrayList<UsersBean>) request.getAttribute("fresh");
							for (UsersBean usersBean : arr) {
				%>
				<tr>
					<td><%=usersBean.getId()%></td>
					<td><%=usersBean.getName()%></td>
					<td><%=usersBean.getEmail()%></td>
					<td><%=usersBean.getPassword()%></td>
					<td><%=usersBean.getContact()%></td>
					<td><%=usersBean.getAddress()%></td>
					<td><%=usersBean.getStatus()%></td>
					<td><%=usersBean.getRole()%></td>
					<td><form action="AdminOperation">
							<input type="hidden" value=<%=usersBean.getId() %> name="id">
							<input type="submit" value="active" name="btnAP">
						</form></td>
					<td><form action="AdminOperation">
							<input type="hidden" value=<%=usersBean.getId() %> name="id">
							<input type="submit" value="block" name="btnAP">
						</form></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<h1>Blocked Employees</h1>
		<table class="table table-striped table-success">
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Status</th>
				<th>Role</th>
				<th>Active</th>
			</thead>
			<tbody>
<%
					arr = (ArrayList<UsersBean>) request.getAttribute("block");
							for (UsersBean usersBean : arr) {
				%>
				<tr>
					<td><%=usersBean.getId()%></td>
					<td><%=usersBean.getName()%></td>
					<td><%=usersBean.getEmail()%></td>
					<td><%=usersBean.getPassword()%></td>
					<td><%=usersBean.getContact()%></td>
					<td><%=usersBean.getAddress()%></td>
					<td><%=usersBean.getStatus()%></td>
					<td><%=usersBean.getRole()%></td>
					<td>
						<form action="AdminOperation">
							<input type="hidden" value=<%=usersBean.getId() %> name="id">
							<input type="submit" value="active" name="btnAP">
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<h1>Active Employees</h1>
		<table class="table table-striped table-success">
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Status</th>
				<th>Role</th>
				<th>Block</th>
			</thead>
			<tbody>
				<%
					arr = (ArrayList<UsersBean>) request.getAttribute("active");
							for (UsersBean usersBean : arr) {
				%>
				<tr>
					<td><%=usersBean.getId()%></td>
					<td><%=usersBean.getName()%></td>
					<td><%=usersBean.getEmail()%></td>
					<td><%=usersBean.getPassword()%></td>
					<td><%=usersBean.getContact()%></td>
					<td><%=usersBean.getAddress()%></td>
					<td><%=usersBean.getStatus()%></td>
					<td><%=usersBean.getRole()%></td>
					<td>
						<form action="AdminOperation">
							<input type="hidden" value=<%=usersBean.getId() %> name="id">
							<input type="submit" value="block" name="btnAP">
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<%
		}
		} else {
			//request.setAttribute("warning","incorrect Email ")
			response.sendRedirect("LogIn.jsp");
		}
	%>
</body>
</html>