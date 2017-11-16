<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: navbar ef notandi er skráður inn
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
	
</head>
<body>	
	<div>
		<ul class="nav navbar" style="background-color: #FFFFFF">
			<li class="nav-item"><a class="nav-link" href="userPage">Home</a>
			<li class="nav-item"><a class="nav-link" href="foodList">Log day</a>
			<li class="nav-item"><a class="nav-link" href="daysBefore">Days logged</a>
			<li class="nav-item"><a class="nav-link" href="changeInfo">Change Information</a>
			<li class="nav-item"><a class="nav-link" href="addFood">Contribute Info</a>
			<li class="nav-item"><a class="nav-link" href="login">Logout</a>
		</ul>
	</div>
</body>

</html>