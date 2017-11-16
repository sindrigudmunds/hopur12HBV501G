<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Miðstöð. Sýnir persónuuplýsingar og
  -				 og möguleika.
  --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
	<div class="mx-auto w-40 p-3 text-center" style="background-color: #FFFFFF">
	<h4>Logged in as, ${user.getName()}</h4>
	<div class="row">
	<div class="col-4">
	<table class="table table-light table-hover">
		<tr>
			<td>Weight:</td>
			<td>${user.userDetails.getWeight()}</td>
		</tr>
		<tr>
			<td>Height:</td>
			<td>${user.userDetails.getHeight()}</td>
		</tr>
		<tr>
			<td>Age:</td>
			<td>${user.userDetails.getAge()}</td>
		</tr>
		<tr>
			<td>BMR:</td>
			<td>${user.userDetails.getBmr()}</td>
		</tr>
	</table>
	</div>
	<div class="col card">
	<div class="card-block">
	<p></p>
	<h5>What can i do?</h5>
		<p><small>Log a day to see your eating habits</small></p>
		<p><small>Look up your eating habits the past days</small></p>
		<p><small>Change your information accordingly</small></p>
		<p><small>Help us grow by adding nutritional value</small></p>
	</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>