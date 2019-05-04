<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>eCheque</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/inlineStyle.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="<c:url value="/js/validations.js"/>"	type="text/javascript"></script>
</head>
<body>
	

	<div class="home-heading"></div>
	<div class="home-page">

		<div class="home-page-inner" style="text-align: center">
            <div ng-app="quiz-manager" ng-controller="Studentlogin">
			<form   ng-submit="submitStudentForm()">
				<fieldset>
					<label for="mobile-num">Id Number</label> 
					<input type="text" class="email" id="rollNumber" name="rollNumber" required="required" maxlength="8" autocomplete="off" ng-model="Studentform.rollNo" /> 
					<br>
					<span style="color: red; font-weight: bold" id="spanmobileNumber"></span>

					<div class="submit_btn">
						<input type="submit" id="Submitbutton" value="Submit" />
					</div>

				</fieldset>
			</form>

		</div>

	</div></div>
</body>
<script type="text/javascript">
var app = angular.module('quiz-manager', []);
app.controller('Studentlogin', function($scope, $http) {

	$scope.Studentform={
			rollNo :""
	}
	$scope.submitStudentForm = function() {
		debugger;
		$http({
			method : 'post',
			url : 'checkStudent',
			data : angular.toJson($scope.Studentform),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(result) {
			if(result.data==""){
			 window.location.href = ('/registration');

			}else{
				 window.location.href = ('/index');
			}
			
			
		});
				   
	}
});
	

</script>
</html>
