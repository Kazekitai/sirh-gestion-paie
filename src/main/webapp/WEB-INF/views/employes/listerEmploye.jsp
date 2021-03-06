<%@page import="java.util.List"%>
<%@page import="dev.paie.entite.Entreprise"%>
<%@page import="dev.paie.entite.ProfilRemuneration"%>
<%@page import="dev.paie.entite.Grade"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css" />' />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body style="background-color: lightgray;">
	<div class="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="logo">
				<a class="navbar-brand" href="home.html"> <img
					src="https://bootdey.com/img/Content/user_1.jpg" alt="logo"
					width="50" height="50" class="img-circle">
				</a>
			</div>
			 
			<div class="container-fluid">
				<c:url value="lister" var="employes"></c:url>
				<c:url value="bulletins/lister" var="bulletin"></c:url>
				<c:url value="creer" var="add"></c:url>

				   
				<div class="navbar-header">
					 <a class="navbar-brand" href="${employes}">SGP - App</a>
				</div>
				<ul id="randoNavbar" class="nav navbar-nav">
					<li><a href="${employes}">Employés</a></li>       
					<li><a href="${bulletin}">Bulletins</a></li>      
				</ul>
				     
			</div>
		</nav>
	</div>
	<h1 style="margin-left: 20px; text-align: center; margin-top: 90px;">Liste
		des employés</h1>
	<div class="container bootstrap snippet" style="width: 100%;">
		<div class="row">
			<span class="input-group-btn text-right"> <a href="${add}" class="btn btn-effect-ripple btn-primary" 
			style="margin-right:10px; margin-bottom:20px;background-color: black;color: white">Ajouter un employé</a>
			</span>
		</div>
	</div>
	<div class="row"
		style="width: 100%; margin-left: auto; margin-right: auto;">
		<div class="col-md-12">
			<table class="table table-bordered">
				<thead class="thead-light">
					<tr style="background-color: black;color: white;">
						<th scope="col">Date / heure de création</th>
						<th scope="col">Matricule</th>
						<th scope="col">Grade</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listEmployes}" var="employe">
						<tr class="active">
							<td>${employe.get("creation")}</td>
							<td>${employe.get("matricule")}</td>
							<td>${employe.get("gradeCode")}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


	</div>
	</div>

</body>
</html>