<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plans</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}

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
	padding: 4px 28px;
	text-decoration: none;
	margin: 3px 1px;
	cursor: pointer;
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
		<h2>Plans Available</h2>

		<table>
			<tr>
				<td>ID</td>
				<td>Plan Type</td>
				<td>Name</td>
				<td>Amount</td>
				<td>Duration</td>
			</tr>
			<c:forEach items="${exploreplans}" var="pl">
				<tr>
					<td>${pl.planID}</td>
					<td>${pl.planType}</td>
					<td>${pl.planName}</td>
					<td>${pl.planAmount}</td>
					<td>${pl.planDuration}</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
	</center>
</body>
</html>