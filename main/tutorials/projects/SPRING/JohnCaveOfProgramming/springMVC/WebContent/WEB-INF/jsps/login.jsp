<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>
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
<body onload='document.f.username.focus();'>
	<h3
		style="margin: auto; width: 30%; border: 3px solid #40E0D0; padding: 10px; text-align: center">Login
		with Username and Password</h3>
	<div class="container ">
		<form name='f' action='${pageContext.request.contextPath}/login'
			method='POST'>
			<div class='form-group'>
				<label for="username" class="col-sm-1 control-label">User</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<input type="text" class="form-control" id="username"
						name="username" value=''></input>
				</div>
				<br>
			</div>
			<div class='form-group'>
				<label for="password" class="col-sm-1 control-label">Password</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<input type="password" class="form-control" id="password"
						name="password"></input>
				</div>
				<br>
			</div>
			<c:if test="${param.error != null}">
		<div class="alert alert-danger" role="alert">Username or
			password is incorrect! Please try again.</div>

	</c:if>
			<div class='form-group' style="margin: auto; width: 30%;  padding: 10px; text-align: center">
				<div class="col-sm-offset-2 col-sm-3"
					style="margin-left: 0; padding-left: 0">
					<input type="submit" class="form-control" id="submit" value="Login"
						name="submit"></input>
				</div>
				<br>
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>


	</div>
</body>
</html>