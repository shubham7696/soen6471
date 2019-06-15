<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
<style type="text/css">
body {
	background-image: url("/CRP/images/back.jpg");
	background-size: 1400px 700px;
	background-repeat: no-repeat;
}

hr {
	margin-top: 100px;
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

		<form action="searchdeletecustomer" method="post">
			<label for="phoneno">Phone No: </label> <input name="phoneno"
				id="phoneno" required> <input type="submit" value="Search" />
		</form>

		<c:choose>
			<c:when test="${not empty searchdeletecustomer}">
				<c:choose>
					<c:when test="${searchdeletecustomer eq 'RESULT_FOUND'}">
						<table>
							<tr>
								<td>FirstName</td>
								<td>LastName</td>
								<td>Email</td>
								<td>Phone</td>
							</tr>
							<c:forEach items="${searchdeleteResult}" var="customers">
								<tr>
									<td><a
										href="/CustomerRepresentativePortal/deletecustomerconfirmation/${customers.custId}">${customers.custId}</a></td>
									<td>${customers.custFirstName}</td>
									<td>${customers.custLastName}</td>
									<td>${customers.custEmail}</td>
									<td>${customers.phoneNumber}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>

					<c:otherwise>
						<p>No user found in search</p>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>

	</center>
	<hr>
</body>
</html>