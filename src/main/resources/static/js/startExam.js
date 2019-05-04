var app = angular.module('quiz-manager', []);
app.controller('startExam', function($scope, $http) {
	
	
	$scope.result={
			questionTitle :"",
			option1 :"",
			option2 :"",
			option3 :"",
			option4 :"",
			correctAnswer :""
	}
	
	
	loadExam();
	function loadExam() {
		$http({
		     method: 'POST',
		     url: 'getQuestions/'+0+'/'+0,
		     data : angular.toJson(0,0),
			 'Content-Type' : 'application/json'
		  }).then(function(result) {
			  $scope.result = result.data;
			  $scope.result.option1= result.data.myoptions[0].option1;
			  $scope.result.option2= result.data.myoptions[0].option2;
			  $scope.result.option3= result.data.myoptions[0].option3;
			  $scope.result.option4= result.data.myoptions[0].option4;
			  
			});
		   
	}
	
	
	$scope.nextquestionload = function (ans,examId){
		$http({
		     method: 'POST',
		     url: 'getQuestions/'+examId+'/'+ans,
		     data : angular.toJson(examId,ans),
			 'Content-Type' : 'application/json'
		  })
		  .then(function(result) {
			  if(result.data!=''){
			  $scope.result = result.data;
			  $scope.result.option1= result.data.myoptions[0].option1;
			  $scope.result.option2= result.data.myoptions[0].option2;
			  $scope.result.option3= result.data.myoptions[0].option3;
			  $scope.result.option4= result.data.myoptions[0].option4;
			  }else{
				  window.location.href = ('/examSubmit');
			  }
			});
		
	};
	
	
	$scope.submitStudentExam = function (){
		window.location.href = ('/examSubmit');
	};
	});