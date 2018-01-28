<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome to GamingDB!</title>
		<style>
			<%@ include file="/assets/css/bootstrap.min.css"%>
			<%@ include file="/assets/css/login.css"%>
		</style>
	
	</head>
	<body>
		<div class="container">
			<div class="loginForm">
				<h3 align = "center"><strong>Welcome to GamingDB!</strong></h3>
				<c:choose>
					<c:when test="${not empty error}">
			  			<div class="alert alert-danger">
			 				Your login was unsuccessful. <br /> Caused by:
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					    </div>
					</c:when>
					<c:when test="${not empty param.accCreated}">
						<div class="alert alert-success">
							Your account was created successfully. You can now log in. <br />
						</div>
					</c:when>
					<c:when test="${not empty param.accNotCreated}">
						<div class="alert alert-danger">
							Something went wrong during account creation. Try again. <br />
						</div>
					</c:when>
				</c:choose>
				<div class="credentials">
					<h4 align = "center">Login:</h4>
					<form action="login" name="f" method="POST">
						<div class="form-group">
							<label for="login">Username:</label>
							<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" >
						</div>
						<div>
							<label for="pwd">Password: </label>
							<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password"> 
						</div>
						<button type="submit" class="btn btn-success pull-right">Submit</button>
					</form>
				</div>
				<div class="create_account">
					No account yet? <br /> <a href="/gamingdb/createAccount.html">Create a new one!</a>
				</div>
			</div>
		</div>
	</body>
</html>