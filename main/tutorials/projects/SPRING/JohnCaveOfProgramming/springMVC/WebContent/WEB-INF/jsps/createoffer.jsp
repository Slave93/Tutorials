<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/border.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container bordered" style="background-color: #C8C8C8">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Fill in the form and submit to create
					new Offer</h1>
			</div>
		</div>
		<div class="row">
			<ul class="nav">
				<div class="col-md-1">
					<li><a href="${pageContext.request.contextPath}/offers">Offers</a>
					</li>
				</div>
				<div class="col-md-1">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				</div>
			</ul>
		</div>
	</div>
	</div>
	<div>
		<br>
		<div class="container ">
			<sf:form action="${pageContext.request.contextPath}/doCreate"
				method="POST" commandName="offer">
				<div class='form-group'>
					<label for="inputName3" class="col-sm-1 control-label">Name</label>
					<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
						<sf:input type="text" class="form-control" path="name"
							id="inputName3" name="name" placeholder="OfferName"></sf:input>
					</div><br>
					<div class="has-error">
					 <span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
								path="name"></sf:errors></span>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-1 control-label">Email</label>
					<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
						<sf:input type="email" path="email" class="form-control"
							id="inputEmail3" name="email" placeholder="Email"></sf:input>
					</div><br>
					<div class="has-error">
					 <span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
							path="email"></sf:errors></span>
					</div>
				</div>
				<div class="form-group">
					<label for="inputText3" class="col-sm-1 control-label">Offer</label>
					<div class="col-sm-11" style="margin-left: 0; padding-left: 0">
						<sf:textarea cols="40" class="form-control" path="text"
							id="inputText3" name="text"></sf:textarea>
					</div><br>
					<div class="has-error">
					 <span id="helpBlock" class="has-error help-block col-sm-offset-1"><sf:errors
							path="text"></sf:errors></span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-10">
						<sf:button type="submit" action="submit" class="btn btn-primary">Create
							advert</sf:button>
					</div>
				</div>
			</sf:form>

		</div>
</body>
</html>