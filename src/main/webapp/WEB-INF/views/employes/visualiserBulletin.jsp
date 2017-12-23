<%@page import="java.util.List"%>
<%@page import="dev.paie.entite.Entreprise"%>
<%@page import="dev.paie.entite.ProfilRemuneration"%>
<%@page import="dev.paie.entite.RemunerationEmploye"%>
<%@page import="dev.paie.entite.BulletinSalaire"%>
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
				<c:url value="../lister" var="employes"></c:url>
				<c:url value="/lister" var="bulletin"></c:url>
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
	<h1 style="margin-left: 20px; text-align: center; margin-top: 90px;">Bulletin
		de salaire</h1>
	<div style="width: 70%; margin-left: auto; margin-right: auto;">
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12" style="padding-left:0px;">
				<div class="col-md-9"></div>
				<div class="col-md-3"><strong>${periode}</strong></div>
			</div>
		</div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12" style="padding-left:0px;">
				<div class="col-md-9"></div>
				<div class="col-md-3"><strong>Période</strong></div>
			</div>
		</div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<div class="col">
					<strong>Entreprise</strong>
				</div>
				<div class="col-6"></div>
				<div class="col"></div>
			</div>
		</div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<div class="col">${nomEntreprise}</div>
				<div class="col-6"></div>
				<div class="col"></div>
			</div>
		</div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto; margin-bottom:10px;">
			<div class="col-md-12" style="padding-left:0px;">
				<div class="col-md-9">SIRET : ${siretEntreprise}</div>
				<div class="col-md-3"><Strong>Matricule</Strong> ${matricule}</div>
			</div>
		</div>
		
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<div class="col">
					<Strong>Salaire </Strong>
				</div>
				<div class="col-6"></div>
				<div class="col"></div>
			</div>
		</div>
		<div class="row"
			style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead class="thead-light">
						<tr style="background-color: black; color: white;">
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux Salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cot. Patronal</th>
						</tr>
					</thead>
					<tbody>
						<tr class="active">
							<td>Salaire de base</td>
							<td>${nbHeuresBase}</td>
							<td>${tauxBase}</td>
							<td>${remuneration.salaireDeBase}</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="active">
							<td>Prime Except.</td>
							<td></td>
							<td></td>
							<td>${primeExceptionnelle}</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="active">
							<td>Salaire Brut</td>
							<td></td>
							<td></td>
							<td>${remuneration.salaireBrut}</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row"></div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<div class="col">
					<Strong>Cotisations </Strong>
				</div>
				<div class="col-6"></div>
				<div class="col"></div>
			</div>
		</div>
		<div class="row"
			style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead class="thead-light">
						<tr style="background-color: black; color: white;">
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux Salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cot. Patronal</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach
							items="${cotisationNonImposable}"
							var="cotisationsNonImposable">
							<tr class="active">
								<td>${cotisationsNonImposable.libelle}</td>
								<td>${remuneration.salaireBrut}</td>
								<td>${cotisationsNonImposable.tauxSalarial}</td>
								<td>${empty cotisationsNonImposable.tauxSalarial ? '' : cotisationsNonImposable.tauxSalarial*remuneration.salaireBrut}</td>
								<td>${cotisationsNonImposable.tauxPatronal}</td>
								<td>${empty cotisationsNonImposable.tauxPatronal ? '' : cotisationsNonImposable.tauxPatronal*remuneration.salaireBrut}</td>
							</tr>
						</c:forEach>
						<tr class="active">
							<td>Total Retenue</td>
							<td></td>
							<td></td>
							<td>${remuneration.totalRetenueSalarial}</td>
							<td></td>
							<td>${remuneration.totalCotisationsPatronales}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row" style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<div class="col">
					<Strong>NET Imposable: ${remuneration.netImposable} </Strong>
				</div>
				<div class="col-6"></div>
				<div class="col"></div>
			</div>
		</div>
		<div class="row"
			style="width: 100%; margin-left: auto; margin-right: auto;">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead class="thead-light">
						<tr style="background-color: black; color: white;">
							<th scope="col">Rubriques</th>
							<th scope="col">Base</th>
							<th scope="col">Taux Salarial</th>
							<th scope="col">Montant Salarial</th>
							<th scope="col">Taux Patronal</th>
							<th scope="col">Cot. Patronal</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach
							items="${cotisationImposable}"	var="cotisationsImposable">
							<tr class="active">
								<td>${cotisationsImposable.libelle}</td>
								<td>${remuneration.salaireBrut}</td>
								<td>${cotisationsImposable.tauxSalarial}</td>
								<td>${empty cotisationsImposable.tauxSalarial ? '' : cotisationsImposable.tauxSalarial*remuneration.salaireBrut}</td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-offset-9 col-md-3" style="margin-bottom:10px;">
			<Strong>NET A PAYER : ${remuneration.netAPayer}</Strong>
		</div>
	</div>

</body>
</html>