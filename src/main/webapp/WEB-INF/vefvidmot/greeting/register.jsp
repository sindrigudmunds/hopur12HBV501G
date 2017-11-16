<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Seinni register skrá  byggir ofan á User object
  -				 með því að búa til UserDetail object.
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
	
<title>Uppl´singar</title>
<c:url value="../css/askUser.css" var="cssURL" />

</head>

<body>
	<jsp:include page="homePage.jsp" />
	<div class="container" style="background-color: #FFFFFF">
		<div>
			<ul class="nav navbar-right" style="background-color: #FFFFFF">
				<li class="nav-item"><a class="nav-link" href="login">Cancel registration</a>
			</ul>
		</div>
		<div class="mx-auto w-40 p-3 text-center" style="background-color: #FFFFFF">
		<h3>Finish registration</h3><br>
		<form method="POST" commandName="userD" action="/greeting/registerProcess">
			<div class="form-group">
				<label for="age">Age</label>
					<input name="age" type="number" min="10" max="110" id="age" />
				</div>
				<div class="form-group">
					<label for="height">Height(cm)</label>
					<input name="height" type="number" min="130" max="230" id="height" />
				</div>
				<div class="form-group">
					<label for="weight">Weight</label>
					<input name="weight" type="number" min="35" max="180" id="weight" />
				</div>
				<fieldset class="form-group-block">
					<legend>Gender</legend>
					<div class="form-check form-check-inline">
					<label class="form-check-label" for="male">
						<input type="radio" id="male" class="form-check-input" name="gender" path="gender" value="M" label="Karl"/>Male
						</label>
					</div>
					<div class="form-check-inline">
					<label class="form-check-label" for="female">
						<input type="radio" id="female" name="gender" path="gender" value="F" label="Kona" /> Female
					</label>
					</div>
					</fieldset>
					<fieldset class="form-group">
						<legend>Workouts per week</legend>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="0-1">
							<input type="radio" id="0-1" name="workout" path="workout" value="1"/> 0-1
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="2-3">
							<input type="radio" id="2-3" name="workout" path="workout" value="2"/> 2-3
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="4-5">
							<input type="radio" id="0-1" name="workout" path="workout" value="3"/> 4-5
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="6-7">
							<input type="radio" id="6-7" name="workout" path="workout" value="4"/> 6-7
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="8">
							<input type="radio" id="8" name="workout" path="workout" value="5"/> 8+
						</label>
						</div>
					</fieldset>
					<fieldset class="form-group">
					<legend>Goal</legend>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="light">
							<input type="radio" id="light" name="goal" path="goal" value="1"/> Loose weight
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="avg">
							<input type="radio" id="avg" name="goal" path="goal" value="2"/> Contain
						</label>
						</div>
						<div class="form-check form-check-inline">
						<label class="form-check-label" for="heavy">
							<input type="radio" id="heavy" name="goal" path="goal" value="3"/> The GAINS
						</label>
						</div>
					</fieldset>
					<div class="submit-button">
						<input type="submit" value="Submit" class="btn btn-light" />
				</div>
				</form>		
				</div>

	</div>
</body>

</html>