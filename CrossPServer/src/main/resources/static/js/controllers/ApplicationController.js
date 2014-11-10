'use strict';

/**
 * SettingController
 * @constructor
 */
var ApplicationController = function($scope, $http) {
	
    $scope.app = {};
    
    $scope.save = function(app) {
    	$http.post('/setting/application/add', app).success(function() {
    		$scope.msg = "Add Successful!";
    		$scope.app = {};
        }).error(function() {
            $scope.msg = 'Could not add a new application';
        });
	}
};