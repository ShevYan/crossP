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
      	 $http.get('/setting/app/space' + $scope.sltApp.id).success(function(spaces){
               $scope.mySpaces = spaces;
           });
   	}
    
    $scope.fetchCPApps = function() {
   	 $http.get('/setting/app/cp/' + $scope.sltApp.id).success(function(apps){
            $scope.cpApps = apps;
        });
	}
    
    $scope.fetchUserApps();
    
};