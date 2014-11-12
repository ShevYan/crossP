'use strict';

/**
 * SettingController
 * @constructor
 */
var ApplicationController = function($scope, $http) {
	
    $scope.myApps = {};
    $scope.mySpaces = {};
    $scope.sltApp = {};
    
    //TO BE REMOVE    
    $scope.cpApps = {};
    
    
    $scope.fetchUserApps = function() {
   	 $http.get('/setting/app/user').success(function(apps){
            $scope.myApps = apps;
            if (apps.length > 0) {
           	 $scope.sltApp = apps[0];
           	 $scope.fetchAppSpaces();
			 }
        });
	}
    
    $scope.fetchAppSpaces = function() {
      	 $http.get('/setting/app/space/' + $scope.sltApp.id).success(function(spaces){
               $scope.mySpaces = spaces;
           });
   	}
    
    $scope.save = function(app) {
    	$http.post('/setting/app/space/' + $scope.sltApp.id + '/add', app).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.fetchAppSpaces();
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
    	
	}
    
    $scope.fetchUserApps();    
};