'use strict';

/**
 * SettingController
 * @constructor
 */
var AppSpaceController = function($scope, $http) {
	
	$scope.hiddenShow= true;
    $scope.mySpaces = {};
    
    $scope.change = function() {
    	$scope.hiddenShow = !$scope.hiddenShow;
  	}
    
    
    $scope.fetchAppSpaces = function() {
      	 $http.get('/setting/app/space/all').success(function(spaces){
               $scope.mySpaces = spaces;
           });
   	}
    
    $scope.save = function(app) {
    	$http.post('/setting/app/space/add', app).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.fetchAppSpaces();
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
    	
	}
    
    $scope.removeAppSpace = function(id) {
    	$http.delete('/setting/app/space/' + id).success(function() {
    		$scope.fetchAppSpaces();
        });
	}
    
    $scope.fetchAppSpaces();    
};