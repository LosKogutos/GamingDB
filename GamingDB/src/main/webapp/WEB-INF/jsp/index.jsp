<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>GamingDB.com</title>
		<style>
			<%@ include file="/assets/css/bootstrap.min.css"%>						
			<%@ include file="/assets/css/games.css"%>	
			<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css" />" rel="stylesheet">			
		</style>
		<script src="<c:url value="/assets/js/jquery-3.3.1.js"/>"></script>
		<script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>		
		<script src="<c:url value="/assets/js/searchBar.js"/>"></script>
		<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"/>"></script>
		<script src="<c:url value="/assets/js/main.js"/>"></script>
	</head>
	<body>
		<div class="container">			
			<br/><br/>
			<div class="panel panel-success">
				<div class="panel-heading"><h6 align="center">Help us to gather opinion about all games worldwide!</h6></div>
				<div class="panel-body">
					<div class="searchBox">
						<input id="searchBox" type="text" placeholder="Search...">
					</div>
					<div class="table-responsive" id="tableWithBg">
						<table class = "table-hover">
							<thead>
								<tr>
									<th class="col-md-2">TITLE</th>
									<th class="col-md-2">TYPE</th>
									<th class="col-md-2">MODE</th>
									<th class="col-md-2">PRODUCER</th>
									<th class="col-md-3">RATING</th>
									<th class="col-md-1">ADDED</th>
								</tr>
							</thead>
							<tbody id="tableBody">
								<c:forEach items="${games}" var="game" varStatus="loop">
									<tr>
										<td>${game.title}</td>
										<td>${game.type}</td>	
										<td>${game.mode}</td>
										<td>${game.producent}</td>
										<td>
											${game.averageRating}  
											<a href="#" id="${games[loop.index].id}" data-pk="${games[loop.index].id}" data-url="/gamingdb/postRating/${games[loop.index].id}" class="addYours">Add yours</a>
										</td>
										<td>${game.user.username}</td>
									</tr>
								</c:forEach>							
								<form:form modelAttribute="game" class="form-inline">
									<tr>
										<td><form:input path="title" class="form-control" maxlength="22" placeholder="Title"/></td>
										<td><form:input path="type" class="form-control" maxlength="22" placeholder="Type"/></td>
										<td><form:input path="mode" class="form-control" maxlength="22" placeholder="Mode"/></td>
										<td><form:input path="producent" class="form-control" maxlength="22" placeholder="Producent"/></td>
										<td></td>
										<td><button type="submit" class="btn btn-success">Add Game</button></td>
									</tr>	
								</form:form>										
							</tbody>
						</table>				
					</div>
				</div>
			</div>	
			<br/>
			<form action="/gamingdb/deleteGame.html">
				<button type="submit" class="btn btn-danger">Want to delete your game?</button>
			</form>
			<br/>
			<form action="logout" name="f" method="POST">
				<button type="submit"class="btn btn-danger">Logout</button>
			</form>
		</div>
	</body>
</html>