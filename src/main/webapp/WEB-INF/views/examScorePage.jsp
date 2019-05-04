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
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h1 class="text-center">Congrats!</h1>
  <div>
    <br />
    <br />
    <br />
    <div class="panel panel-primary text-center">
      <div class="panel-heading">
        <h3>Your score was</h3>
      </div>
     <div class="panel-body">
        <h1>${result}/ ${totalquestions}
         or <br>
          ${getpecentage}%</h1>
      </div> 
    </div>
  </div>
  
  
</div>
</body>
</html>