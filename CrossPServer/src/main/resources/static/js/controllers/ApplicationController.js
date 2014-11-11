'use strict';

/**
 * SettingController
 * @constructor
 */
var ApplicationController = function($scope, $http) {
	
    $scope.app = {};
    $scope.apps = {};
    
    $scope.fetchUserApps = function() {
    	 $http.get('/setting/app/user').success(function(apps){
             $scope.apps = apps;
         });
	}
    
    $scope.save = function(app) {
    	$http.post('/setting/app/add', app).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.app = {};
    		$scope.fetchAll();
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
    	
	}
    
    $scope.removeApp = function(id) {
    	$http.delete('/setting/app/' + id).success(function() {
    		$scope.fetchAll();
        });
	}
    
    $scope.fetchUserApps();
};