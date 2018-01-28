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
		</style>		
		<script src="<c:url value="/assets/js/jquery-3.3.1.js"/>"></script>
		<script src="<c:url value="/assets/js/searchBar.js"/>"></script>
	</head>
	<body>
		<div class="container">			
			<br/><br/>
			<div class="panel panel-success">
				<div class="panel-heading"><h6 align="center">Are you sure you want to reduce our games amount?</h6></div>
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
									<th class="col-md-3">OPINION</th>
									<th class="col-md-1">DELETE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${games}" var="game" varStatus="loop">
									<tr>
										
										<td>${game.title}</td>
										<td>${game.type}</td>	
										<td>${game.mode}</td>
										<td>${game.producent}</td>
										<td>${game.opinion}</td>
										<td>
										<form:form>										
											<button id="delete" action="submit" name="delete" value="${games[loop.index].id}" class="btn btn-danger">
												<strong>X</strong>
											</button>
										</form:form>											
										</td>
									</tr>
								</c:forEach>															
							</tbody>
						</table>				
					</div>
				</div>
			</div>				
			<form action="/gamingdb/">
				<button type="submit" class="btn btn-danger">You don't want to delete anything?</button>
			</form>
			<br/>
			<form action="logout" name="f" method="POST">
				<button type="submit" class="btn btn-danger">Logout</button>
			</form>
		</div>
	</body>
</html>