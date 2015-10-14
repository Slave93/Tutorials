<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/border.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	
	<table class="table table-bordered" style="border: black;">
		<tr class="info" style="border: black;">
			<th class="info">Name</th>
			<th class="info">Email</th>
			<th class="info">Text</th>
		</tr>

		<c:forEach var="offer" items="${offers}">
			<tr class="info">
				<td class="info">${offer.name}</td>
				<td class="info">${offer.email}</td>
				<td class="info">${offer.text}</td>
			</tr>
		</c:forEach>
</body>
</html>