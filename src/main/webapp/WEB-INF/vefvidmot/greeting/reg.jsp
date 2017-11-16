<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Býr til user object og vistar
  -				 eftir að UserDetail object er komið
  --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<title>Login</title>
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
<title>Nutty</title>
<body>
	<jsp:include page="homePage.jsp" />
	<div class="container" style="background-color: #FFFFFF">
	<div>
		<ul class="nav navbar-right" style="background-color: #FFFFFF">
			<li class="nav-item"><a class="nav-link" href="login">Have an account? Login</a>
		</ul>
		</div>
     		<div class="mx-auto w-40 p-3 text-center" style="background-color: #FFFFFF">
  			<form method="POST" action="/greeting/register" commandName="user">
  			<h4>Begin your registration</h4>	
			<div class="form-group">
				<label for="username">Username</label>
					<input name="name" type="text" class="form-group" id="username"  />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
					<input name="password" type="password" class="form-group" id="password"/>
			</div>
				<div class="submit-button">
					<input type="submit" value="Continue" class="btn btn-light"/>
				</div>
				</form>
				</div>
		</div>
</body>

</html>

