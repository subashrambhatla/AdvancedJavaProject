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

<base href="${pageContext.request.contextPath}">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>

</head>

<body>
  <div ng-app="quiz-manager" ng-controller="Studentindex">
	<div class="lading-page">		
		<div class="logo-section">
			<div class="logo">
				<img src="<c:url value="/images/logo.jpg" />" alt="" />
			</div>
		</div>
		<br><br><br><br>
		<div class="category">
			<div class="category-list">
				<div class="row">
				<c:if test="${student.role eq 'student'}">
					<div class="col-xs-6 col-sm-3">
						<a   href ng-click="startExam()">
							<div class="category1">
								<img src="<c:url value="/images/issue-cheq.png"/>" alt="issue-cheq">
							</div>
							<div class="title">Start Exam</div>
						</a>
					</div></c:if> 
					<c:if test="${student.role eq 'admin'}">
					<div class="col-xs-6 col-sm-3">
						<a   href ng-click="updatequestions()">
							<div class="category1">
								<img src="<c:url value="/images/issue-cheq.png"/>" alt="issue-cheq">
							</div>
							<div class="title">Update Questions</div>
						</a>
					</div>
					</c:if> 
					
					<c:if test="${student.role eq 'admin'}">
					<div class="col-xs-6 col-sm-3">
					<a   href ng-click="createExam()">
							<div class="category2">
								<img src="<c:url value="/images/deposit-cheq.png"/>" alt="deposit-cheq">
							</div>
							<div class="title deposite-title">Create Exam</div>
						</a>
					</div></c:if> 
					<div class="col-xs-6 col-sm-3">
						<a   href ng-click="history()">
							<div class="category2">
								<img src="<c:url value="/images/history.png"/>" alt="history-cheq">
							</div>
							<div class="title">My Exam's History</div>
						</a>
					</div>
					<div class="col-xs-6 col-sm-3">
							<a   href ng-click="myProfie()">
							<div class="category1">
								<img src="<c:url value="/images/user.png"/>" alt="my-account">
							</div>
							<div class="title">My Profile</div>
						</a>
					</div>

				</div>
			</div>
			
		</div>

	</div>	</div>
</body>
<script type="text/javascript">
var app = angular.module('quiz-manager', []);
app.controller('Studentindex', function($scope, $http) {
	$scope.startExam = function() {
		 window.location.href = ('/startExam');
	}
	
	$scope.updatequestions = function() {
		 window.location.href = ('/updatequestions');
	}
	
	$scope.history = function() {
		 window.location.href = ('/examHistory');
	}
	$scope.createExam = function() {
		 window.location.href = ('/createExam');	}
	$scope.myProfie = function() {
		 window.location.href = ('/myProfile');
	}
	
});
	</script>
</html>