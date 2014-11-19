'use strict';

/**
 * SettingController
 * @constructor
 */
var AppUploadController = function($scope, $http) {

	$scope.uploadFile = function() {
		var file = $scope.myFile;
		console.log('file is ' + JSON.stringify(file));
		var fd = new FormData();
		fd.append('file', file);
		$http.post("/upload", fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function() {
			
		}).error(function() {
			
		});
	};
	
};