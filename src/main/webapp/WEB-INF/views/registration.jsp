<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >
<script src="<c:url value="/js/validations.js"/>"	type="text/javascript"></script>
<title>Registration</title>
</head>
<body>
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Your Details Here
			</div>
			<div class="panel-body">
			 <div ng-app="quiz-manager" ng-controller="Studentregstration">
				<form name="myform" ng-submit="submitStudentForm()">
					<div class="form-group">
						<label for="myName"> Name *</label>
						<input id="myName" name="myName" class="form-control" type="text" data-validation="required" ng-model="Studentreg.name">
						<span id="error_name" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="lastname">Id No *</label>
						<input id="lastname" name="rollNo" class="form-control" type="text" data-validation="email" ng-model="Studentreg.rollNo">
						<span id="error_lastname" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="age">Age *</label>
						<input id="age" name="age"  class="form-control" type="number" min="1"  ng-model="Studentreg.age">
						<span id="error_age" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="dob">Date Of Birth *</label>
						<input type="date" name="dob" id="dob" class="form-control"  ng-model="Studentreg.dob">
						<span id="error_dob" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="gender">Gender</label>
						<select name="gender" id="gender" class="form-control"  ng-model="Studentreg.gender">
							<option selected>Male</option>
							<option>Female</option>
							<option>Other</option>
						</select>
						<span id="error_gender" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="phone">Phone Number *</label>
						<input type="text" id="phone" name="phone" class="form-control"  ng-model="Studentreg.phone">
						<span id="error_phone" class="text-danger"></span>
					</div>
					
					
					<button id="submit" type="submit" value="submit" class="btn btn-primary center">Submit</button>
			
				</form>
</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
var app = angular.module('quiz-manager', []);
app.controller('Studentregstration', function($scope, $http) {
	debugger;
	$scope.Studentreg={
			name :"",
			rollNo :"",
			age :"",
			dob :"",
			gender :"",
			phone :""
	}
	
	$scope.submitStudentForm = function() {
		
			$http({
				method : 'post',
				url : 'saveStudent',
				data : angular.toJson($scope.Studentreg),
				headers : {
					'Content-Type' : 'application/json'
				}
			
	}).then(function(result) {
				if (result.data.sid != '') {
					window.location.href = ('/');
				} else {

				}

			});
		}
	});
</script>
</html>