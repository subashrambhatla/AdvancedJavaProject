<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
<title>Create Exam</title>
</head>
<body>
	<div class="row">
		<div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">Enter Questions Here</div>
				<div class="panel-body">
					<div ng-app="quiz-manager" ng-controller="Studentregstration">
						<form name="myform" ng-submit="submitQuestionsForm()">
							<div class="form-group">
								<label for="myName"> Question *</label> <input id="myName"
									name="myName" class="form-control" type="text"
									data-validation="required" ng-model="exam.questionTitle"
									required="required"> <span id="error_name"
									class="text-danger"></span>
							</div>
							<div class="form-group">
								<label for="lastname">Option 1</label> <input id="lastname"
									name="option1" class="form-control" type="text"
									data-validation="email" ng-model="exam.option1"
									required="required"> <span id="error_lastname"
									class="text-danger"></span>
							</div>
							<div class="form-group">
								<label for="age">Option 2</label> <input id="age" name="option2"
									class="form-control" type="text" min="1"
									ng-model="exam.option2" required="required"> <span
									id="error_age" class="text-danger"></span>
							</div>
							<div class="form-group">
								<label for="age">Option 3</label> <input id="age" name="option3"
									class="form-control" type="text" min="1"
									ng-model="exam.option3" required="required"> <span
									id="error_age" class="text-danger"></span>
							</div>

							<div class="form-group">
								<label for="phone">Option 4 *</label> <input type="text"
									id="phone" name="option4" class="form-control"
									ng-model="exam.option4" required="required"> <span
									id="error_phone" class="text-danger"></span>
							</div>


							<div class="form-group">
								<label for="gender">Correct Answer</label> <select name="gender"
									id="gender" class="form-control" ng-model="exam.correctAnswer"
									required="required">
									<option selected>A</option>
									<option>B</option>
									<option>C</option>
									<option>D</option>
								</select> <span id="error_gender" class="text-danger"></span>
							</div>


							<button id="submit" type="submit" value="submit"
								class="btn btn-primary center" ng-click="submitquestion()">Submit</button>

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
		$scope.exam = {
			questionTitle : "",
			option1 : "",
			option2 : "",
			option3 : "",
			option4 : "",
			correctAnswer : "A"
		}

		submitQuestionsForm();
		function submitQuestionsForm() {
			
			$http({
				method : 'post',
				url : './getExamById1',
				headers : {
					'Content-Type' : 'application/json'
				}

			}).then(function(result) {
				$scope.exam = result.data;
				  $scope.exam.option1= result.data.myoptions[0].option1;
				  $scope.exam.option2= result.data.myoptions[0].option2;
				  $scope.exam.option3= result.data.myoptions[0].option3;
				  $scope.exam.option4= result.data.myoptions[0].option4;
				  $scope.exam.correctAnswer= result.data.myoptions[0].correctAnswer;

			});
		}
		
			$scope.submitquestion = function (){
				debugger;
			$http({
				method : 'post',
				url : '../saveStudentExam',
				data : angular.toJson($scope.exam),
				headers : {
					'Content-Type' : 'application/json'
				}
			
	}).then(function(result) {
					window.location.href = ('/updatequestions');

			});
		}
		
	});
</script>
</html>