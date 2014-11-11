'use strict';

/**
 * SettingController
 * @constructor
 */
var ApplicationController = function($scope, $http) {
	
    $scope.app = {};
    $scope.apps = {};
    
    $scope.fetchAll = function() {
    	 $http.get('/setting/application/all').success(function(apps){
             $scope.apps = apps;
         });
	}
    
    $scope.save = function(app) {
    	$http.post('/setting/application/add', app).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.app = {};
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
	}
    
    $scope.joinCrossP = function(id) {
    	$http.post('/setting/application/cp/1/' + id).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.app = {};
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
	}
    
    $scope.breakCrossP = function(id) {
    	$http.delete('/setting/application/cp/1/' + id).success(function() {
    		$scope.fetchAll();
        });
	}
    
    $scope.fetchAll();
};