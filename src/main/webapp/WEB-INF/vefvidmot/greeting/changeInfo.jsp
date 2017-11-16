<!DOCTYPE html>
<%-- 
  - Author(s): Atli Haraldsson
  - HBVG501G - Háskóli Íslands
  - Description: Breyta persónuuplýsingum um virkan user
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
    <title>Food! </title>  
<title>Nutty</title>
</head>
<body>
	<jsp:include page="homePage.jsp" />
	<jsp:include page="btnbar.jsp" />
	<div class="container" style="background-color: #FFFFFF">
	<div class="mx-auto w-40 p-3 text-center" style="background-color: #FFFFFF">
	<form method="POST" action="userUpdate" commandName="userD" >
		<div class="row">
		<div class="col-4">
		<table class="table table-light table-hover">
			<tr>
				<td>Weight:</td>
				<td>${user.userDetails.getWeight()}</td>
				<td><input name="weight" type="number"
					value="${user.userDetails.getWeight()}" min="40" max="300" /></td>
			</tr>
			<tr>
				<td>Height:</td>
				<td>${user.userDetails.getHeight()}</td>
				<td><input name="height" type="number" min="100"
					value="${user.userDetails.getHeight()}" max="270" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td>${user.userDetails.getAge()}</td>
				<td><input name="age" type="number" min="10"
					value="${user.userDetails.getAge()}" max="110" /></td>
			</tr>
			</table><br>
			<input type="submit" value="Confirm" class="btn btn-light"><br>
	</div>

			<div class="col card">
				<div class="card-block"><br>
				<div>
				<p>Gender</p>
					<input type="radio"
						${user.userDetails.getGender() == 'M' ? 'checked' : ' '} id="male"
						name="gender" path="gender" value="M" label="Karl" /><label
						for="male">Male</label> <input type="radio"
						${user.userDetails.getGender() == 'F' ? 'checked' : ' '}
						id="female" name="gender" path="gender" value="F" label="Kona" /><label
						for="female">Female</label>
					</td>
				</div>
				
				<div>
				<p>Workouts this week</p>
					<input type="radio" id="0-1" name="workout" path="workout"
						value="1"
						${user.userDetails.getWorkout() == '1' ? 'checked' : ' '} /><label
						for="0-1">0-1</label> <input type="radio" id="2-3" name="workout"
						path="workout" value="2"
						${user.userDetails.getWorkout() == '2' ? 'checked' : ' '} /><label
						for="1-3">2-3</label> <input type="radio" id="4-5" name="workout"
						path="workout" value="3"
						${user.userDetails.getWorkout() == '3' ? 'checked' : ' '} /><label
						for="1-3">4-5</label> <input type="radio" id="6-7" name="workout"
						path="workout" value="4"
						${user.userDetails.getWorkout() == '4' ? 'checked' : ' '} /><label
						for="1-3">6-7</label> <input type="radio" id="8" name="workout"
						path="workout" value="5"
						${user.userDetails.getWorkout() == '5' ? 'checked' : ' '} /><label
						for="1-3">8+</label>
				</div>
				<div>
				<p>Goal</p>
					<input type="radio" id="light" name="goal" path="goal" value="1"
						${user.userDetails.getGoal() == '1' ? 'checked' : ' '} /><label
						for="light">Loose weight</label> <input type="radio" id="avg"
						name="goal" path="goal" value="2"
						${user.userDetails.getGoal() == '2' ? 'checked' : ' '} /><label
						for="avg">Contain</label> <input type="radio" id="heavy"
						name="goal" path="goal" value="3"
						${user.userDetails.getGoal() == '3' ? 'checked' : ' '} /><label
						for="heavy">GAINS</label>
				</div><br>
			</div>
			</div>
			</div>
			</form>
			</div>
			</div>
			
		
</body>

</html>