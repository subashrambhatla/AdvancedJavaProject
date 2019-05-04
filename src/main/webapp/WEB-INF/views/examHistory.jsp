<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Exam History</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">

</head>
<body>

	<div class="mdl-grid" style="width: 1000px; margin-top: 100px;">
		<div id="products" class="mdl-data-tabledynamic mdl-shadow--2dp">
			<div class="mdl-data-tabledynamic__title">
				<h2 class="mdl-data-tabledynamic__title-text">Exam History</h2>
			</div>
			<div ng-app="quiz-manager" ng-controller="examHistroy">
				<table style="width: 100%">

					<tr>
						<th>Roll Number</th>
						<th>Date</th>
						<th>Obtained Score</th>
						<th>Total Questions</th>
					</tr>

				 <tr ng-repeat="x in history">
					 <td>{{x.userId}}</td>
					<td>{{x.createdOn}}</td>
					<td>{{x.examresult}}</td>
					<td>{{x.totalQuestions}}</td>
				  </tr>

				</table>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var app = angular.module('quiz-manager', []);
	app.controller('examHistroy', function($scope, $http) {

		$scope.history={
				myExamHistoryId :"",
				examresult :"",
				totalQuestions :"",
				createdOn :"",
				userId :""
		}
		getExamHistroy();

		function getExamHistroy() {
			$http({
				method : 'post',
				url : 'getExamHistroy',
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(function(result) {
				$scope.history=result.data;
			});
		}
	});
</script>



</html>