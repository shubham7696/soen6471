<%@page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
hr {
	margin-top: 100px;
}

body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}

input[type=submit] {
	background-color: #C6C9C4;
	border: none;
	color: white;
	padding: 12px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
}

th {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>


</head>
<body>
	<table>
		<tr>
			<th>
				<form action="/CustomerRepresentativePortal/backtomain" method="get">
					<input type="submit" value="Main Page">
				</form>
			</th>
			<th>
				<form action="/CustomerRepresentativePortal/logout" method="get">
					<input type="submit" value="Logout">
				</form>
			</th>
		</tr>
	</table>
	<hr>
	<br>
	<br>
	<center>
		<div class="main">
			<div class="heading">
				<h3>Available Tickets</h3>
			</div>
			<div class="bs-example">
				<table class="table table-stripe">
					<thead>
						<tr>
							<th>Ticket</th>
							<th>Representative</th>
							<th>User</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tickettech}" var="user">
							<tr>
								<td><a href="ticketdetails/${user.ticketId}">${user.ticketId}</a></td>
								<td>${user.raisedBy}</td>
								<td>${user.raisedFor}</td>
								<td>${user.status}
								<td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</center>
	<hr>
</body>
</html>
