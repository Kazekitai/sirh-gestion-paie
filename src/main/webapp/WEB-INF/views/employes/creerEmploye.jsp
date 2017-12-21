<%@page import="java.util.List"%>
<%@page import="dev.paie.entite.Entreprise"%>
<%@page import="dev.paie.entite.ProfilRemuneration"%>
<%@page import="dev.paie.entite.Grade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css" />' />
<link rel="stylesheet" href='<c:url value="/css/style.css" />' />

</head>
<body style="background-color: lightgray;">
	<c:url value="lister" var="employes"></c:url>
	<div id="signupbox" style="margin-top: 50px; width: 50%"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Ajouter un employé</div>
			</div>
			<div class="panel-body">
				<form:form id="signupform" class="form-horizontal" role="form"
					method="post" action="creer" modelAttribute="employe">

					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Erreur:</p>
						<span></span>
					</div>
					<div class="form-group">
						<form:label path="matricule" for="matricule"
							class="col-md-3 control-label form-label">Matricule</form:label>
						<div class="col-md-9">
							<form:input path="matricule" type="text" class="form-control"
								name="matricule" placeholder="matricule" value="${matricule}"
								readonly="true" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="entreprise" for="entreprise"
							class="col-md-3 control-label form-label">Entreprise</form:label>
						<div class="col-md-9">
							<form:select path="entreprise" id="entreprise"
								class="form-control" name="entreprise">
								<form:options items="${listeEntreprises}"
									itemValue="id" itemLabel="denomination" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<form:label path="profilRemuneration" for="profil"
							class="col-md-3 control-label form-label">Profil</form:label>
						<div class="col-md-9">
							<form:select path="profilRemuneration" id="profil"
								class="form-control" name="profilRemuneration">
								<form:options items="${listeProfils}"
									itemValue="id" itemLabel="code" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<form:label path="grade" for="grade"
							class="col-md-3 control-label form-label">Grade</form:label>
						<div class="col-md-9">
							<form:select path="grade" id="grade" class="form-control"
								name="grade">
								<c:forEach var="grade" items="${gradeObject}">
									<form:option value='${grade.get("id")}'
										label='${grade.get("label")}' />
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="btn-signup" type="submit" class="btn btn-info">
								<i class="icon-hand-right"></i> Ajouter
							</button>
							<a href="${employes}" class="btn btn-info"
								style="margin-left: 10px;">Annuler</a>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

</body>
</html>