<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Tekur inn upplýsingar og bætir
  -				 við Food object í DB
  --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<title>Nutty</title>
</head>
<body>
<jsp:include page="homePage.jsp" />
<jsp:include page="btnbar.jsp" />
<div class="container" style="background-color: #FFFFFF">
	<form method="POST" commandName="foodInfo" action="/greeting/declareFood">
		
		<div class="mx-auto w-40 p-3 text-center" style="background-color: #FFFFFF">
		<h4>Submit nutrition</h4>
		<div class="row">
		<div class="col">
		<table class="table table-light table-hover">
			<thead>Nutritional values</thead>
			<tbody>
			<tr>
				<td>Product</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Portein/100g</td>
				<td><input name="protein" type="number" /></td>
			</tr>
			<tr>
				<td>Fat/100g</td>
				<td><input name="fat" type="number" /></td>
			</tr>
			<tr>
				<td>Carbs/100g</td>
				<td><input name="carb" type="number" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add values" class="btn btn-light" /></td>
			</tr>
			</tbody>
		</table>
		</div>
			<div class="col card"><br>
	<div class="card-block"><br>
	<p><strong>Help us!</strong></p>
		<p><small>By taking your time to</small></p>
		<p><small>give some nutritional values,</small></p>
		<p><small>you're helping yourself</small></p>
		<p><small>and rest of our users!</small></p>
		<p><strong>WHAMMY!</strong></p>
	</div>
	</div>
		</div>
		</div>
	</form>
	</div>

</body>

</html>