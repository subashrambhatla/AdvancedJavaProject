<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value="/css/startExam.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/startExam.js"/>" type="text/javascript"></script>
</head>
<body>

  <div class="page-wrap" ng-app='quiz-manager'>
    <section ng-controller="startExam">
      <div class="well">
      <div style="text-align: center;">
        <div class="quiz">

              <h3 class="question">{{result.questionTitle}}</h3>
                                
            </div>
          </div>
          <div class="results fade-in-out" >
            <ul>
                    <p><input type="radio" ng-model="ans" value="A"> {{result.option1}}</p>
					<p> <input type="radio" ng-model="ans" value="B">{{result.option2}}</p>
					<p> <input type="radio" ng-model="ans" value="C">{{result.option3}}</p>
					<p> <input type="radio" ng-model="ans" value="D">{{result.option4}}</p>
            </ul>
        <input type="button" value="Next Question" ng-click="nextquestionload(ans,result.examId,result.correctAnswer);">
         <input type="button" value="Submit" ng-click="submitStudentExam()">
          </div></div>
    </section>
</div>

</body>
</html>