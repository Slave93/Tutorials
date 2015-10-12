<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create Offer</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {

		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);

		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password != confirmpass) {
			alert("<fmt:message key='UnmatchedPassword.user.password'/>")
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpassSpan").text("<fmt:message key='MatchedPassword.user.password'/>");
				$("#matchpassDiv").removeClass("has-error");
				$("#matchpassSpan").removeClass("has-error");
				$("#matchpassSpan").addClass("bg-success");				
				
			} else {
				$("#matchpassSpan").text("<fmt:message key='UnmatchedPassword.user.password'/>");				
				$("#matchpassSpan").removeClass("bg-success");
				$("#matchpassDiv").addClass("has-error");
				$("#matchpassSpan").addClass("has-error");				
			}
		}
	}

	$(document).ready(onLoad);
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container bordered" style="background-color: #C8C8C8">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Fill in the form and submit to create
					new Account</h1>
			</div>
		</div>
		<div class="row">
			<ul class="nav">
				<div class="col-md-1">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				</div>
			</ul>
		</div>
	</div>


	<br>
	<div class="container ">
		<sf:form id="details" action="${pageContext.request.contextPath}/createaccount"
			method="POST" commandName="user">
			<div class='form-group'>
				<label for="username" class="col-sm-1 control-label">UserName</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<sf:input type="text" class="form-control" path="username"
						id="username" name="username" placeholder="username"></sf:input>
				</div>
				<br>
				<div class="has-error">
					<span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
							path="username"></sf:errors></span>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-1 control-label">Email</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<sf:input type="text" path="email" class="form-control" id="email"
						name="email" placeholder="email"></sf:input>
				</div>
				<br>
				<div class="has-error">
					<span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
							path="email"></sf:errors></span>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-1 control-label">Password</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<sf:input type="password" path="password" class="form-control"
						id="password" name="password"></sf:input>
				</div>
				<br>
				<div class="has-error">
					<span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
							path="password"></sf:errors></span>
				</div>
			</div>
			<div class="form-group">
				<label for="confirmpass" class="col-sm-1 control-label">Confirm
					Password</label>
				<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
					<input type="password" class="form-control" id="confirmpass"
						name="confirmpass"></input>
				</div>
				<div id="matchpassDiv">
					<span id="matchpassSpan" class="help-block col-sm-offset-1"></span>
				</div>
			</div>




			<div class="form-group">
				<div class="col-md-10">
					<sf:button type="submit" action="submit" class="btn btn-primary">Create
							Account</sf:button>
				</div>
			</div>
		</sf:form>
	</div>





</body>
</html>

