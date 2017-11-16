<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Útlit og virkni til þess að logga dag
  -				Ef samþykkt vistar Nutrition object í DB
  --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Check</title>
</head>
<body>
	<jsp:include page="homePage.jsp" />
	<jsp:include page="btnbar.jsp" />
	<div class="container" style="background-color: #FFFFFF">
			
		<div class="row mx-auto">

			<div class="col">
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
						<td>${nutritionInfo.fat }</td>
						<td>${nutritionInfo.pfat }</td>
						<td>${nutritionInfo.procentFat }%</td>
					</tr>
					<tr>
						<td>Carbs</td>
						<td>${nutritionInfo.carbs }</td>
						<td>${nutritionInfo.pcar }</td>
						<td>${nutritionInfo.procentCarbs }%</td>
					</tr>
					<tr>
						<td>Protein</td>
						<td>${nutritionInfo.protein }</td>
						<td>${nutritionInfo.ppro }</td>
						<td>${nutritionInfo.procentProtein }%</td>
					</tr>
					</tbody>
				</table>
			</div>
			<br><br><br>
			<div class="col card">
			
			<div class="card-block">
			<h2 style="display:none">Finished!</h2>
				<label>Protein:</label>
				<div class="progress">
					<div class="progress-bar bg-danger"
						style="width:${nutritionInfo.procentProtein }%">${nutritionInfo.procentProtein }%</div>
				</div>
				<br>

				<label>Fat:</label>
				<div class="progress">
					<div class="progress-bar bg-success"
						style="width:${nutritionInfo.procentFat }%">${nutritionInfo.procentFat }%</div>
				</div>
				<br>


				<label>Carbs:</label>
				<div class="progress">
					<div class="progress-bar bg-info"
						style="width:${nutritionInfo.procentCarbs }%">${nutritionInfo.procentCarbs }%</div>
				</div>
				<br>
			</div>
			 </div>
		</div>
		<div class="row">
		<div class="col ">
					<form class="form-inline" method="POST" name="foodVar" action="/greeting/moreInfo">
					<select name="foodVar" class="custom-select d-block my-3" required>
							<c:forEach items="${allFood}" var="foodItem">
								<option name="${foodItem.id }" value="${foodItem.id}"
									${foodItem.id == selectedRole ? 'selected' : ''}>${foodItem.name}</option>
							</c:forEach>
					</select>
					<div class="col-xs-2">
					<input name="gramVar" type="number" class="form-control" id="ex1" placeholder="Grams.." required/>
					</div>
					<input type="submit" value="Select" class="btn btn-light" />
				</form><br>
		</div><br>
		<div class="col"><br>
			<form method="POST" action="submitDiet">
			<input type="submit" class="btn btn-light"/>
		</form><br>
		</div>
		</div>

	</div>
</body>

</html>