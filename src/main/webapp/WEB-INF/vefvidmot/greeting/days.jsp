<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Prentar út alla Nutrition objecta
  - 			Tengda við virkan user. Prentar töflu og graf
  --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
    <title>Food! </title>  
</head>
<body>
	<jsp:include page="homePage.jsp" />
	<jsp:include page="btnbar.jsp" />
	<div class="container" style="background-color: #FFFFFF">
    	<c:forEach items="${myDays}" var="myDay">
    		<div class="row">
			<div class="col"><br><br>
				<table class="table table-light table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Need</th>
							<th>Consumed</th>
							<th>%</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>Fat</td>
						<td>${myDay.fat }</td>
						<td>${myDay.pfat }</td>
						<td>${myDay.procentFat }%</td>
					</tr>
					<tr>
						<td>Carbs</td>
						<td>${myDay.carbs }</td>
						<td>${myDay.pcar }</td>
						<td>${myDay.procentCarbs }%</td>
					</tr>
					<tr>
						<td>Protein</td>
						<td>${myDay.protein }</td>
						<td>${myDay.ppro }</td>
						<td>${myDay.procentProtein }%</td>
					</tr>
					</tbody>
				</table>
			</div>
			<div class="col">
			<h2>DATE</h2>
			
				<label>Protein:</label>
				<div class="progress">
					<div class="progress-bar bg-danger"
						style="width:${myDay.procentProtein }%">${myDay.procentProtein }%</div>
				</div>
				<br>

				<label>Fat:</label>
				<div class="progress">
					<div class="progress-bar bg-success"
						style="width:${myDay.procentFat }%">${myDay.procentFat }%</div>
				</div>
				<br>


				<label>Carbs:</label>
				<div class="progress">
					<div class="progress-bar bg-info"
						style="width:${myDay.procentCarbs }%">${myDay.procentCarbs }%</div>
				</div>
				<br>
			</div>
		</div><br>
        </c:forEach>
	</div>
</body>
</html>