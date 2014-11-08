'use strict';

var AngularSpringApp = {};
var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);
   
// Declare app level module which depends on filters, and services
App.config( ['$routeProvider', function ($routeProvider) {
	
    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    
    $routeProvider.when('/storagePartition', {
        templateUrl: 'storagePartition/layout',
        controller: StoragePartitionController
    });

    $routeProvider.otherwise({redirectTo: '/storagePartition'});
 
    /*	// 直接调用service
    	var injector = angular.injector(['AngularSpringApp.services', 'ng']);
    	var g = injector.get("logService");
    	g.log.info("Log text");*/
    	
}]);
 

//initAngularJSConfig();
//initJ4log();
/*var	log = log4javascript.getLogger();  
function initJ4log(){
	var ajaxAppender = new log4javascript.AjaxAppender("log/add");
	ajaxAppender.setWaitForResponse(true);
	ajaxAppender.setLayout(new log4javascript.JsonLayout());
	ajaxAppender.addHeader("Content-Type",  "application/json")
	//ajaxAppender.setBatchSize(3); // The number of log messages sent in each request, default size is 1. 
	log.addAppender(ajaxAppender);
}*/ 

