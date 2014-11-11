'use strict';

/**
 * SettingController
 * @constructor
 */
var CrossPController = function($scope, $http) {
	
    $scope.app = {};
    $scope.allApps = {};
    $scope.myApps = {};
    
    $scope.fetchUserApps = function() {
   	 $http.get('/setting/app/user').success(function(apps){
            $scope.myApps = apps;
        });
	}
    
    $scope.fetchALLApps = function() {
    	 $http.get('/setting/app/all').success(function(apps){
             $scope.allApps = apps;
         });
	}
    
    $scope.joinCrossP = function(id) {
    	$http.post('/setting/app/cp/1/' + id).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.app = {};
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
	}
        
    $scope.breakCrossP = function(id) {
    	$http.delete('/setting/app/cp/1/' + id).success(function() {
    		$scope.fetchAll();
        });
	}
    
    $scope.fetchUserApps();
    $scope.fetchALLApps();
};