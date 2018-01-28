<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<style>
			<%@include file="/assets/css/bootstrap.min.css"%>
			<%@include file="/assets/css/createaccount.css"%>
		</style>

		<title>GamingDB new account</title>
	</head>
	
	<body background="assets/jpg/mario.jpg">
		<div class="container">
			<div class="createForm">
				<h3 align="center"><strong>Create Account</strong></h3>
				<div>
					<form:form modelAttribute="userProfile">
						<table>
							<tr>
								<td>User name: </td>
								<td><form:input path="username" class="form-control" id="username" placeholder="Enter username"/></td>
								<td><form:errors path="username" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Password: </td>
								<td><form:input type="password"  path="password" class="form-control" id="password" placeholder="Enter password"/></td>
								<td><form:errors path="password" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Email: </td>
								<td><form:input type="email" path="email" class="form-control" id="email" placeholder="Enter email"/></td>
								<td><form:errors path="email" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Name: </td>
								<td><form:input path="name" class="form-control" id="name" placeholder="Enter name"/></td>
								<td><form:errors path="name" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Surname: </td>
								<td><form:input path="surname" class="form-control" id="surname" placeholder="Enter last name"/></td>
								<td><form:errors path="surname" cssClass="error" /></td>
							</tr>
						</table>
						<button type="submit"class="btn btn-success pull-right">Submit</button>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>