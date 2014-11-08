'use strict';

/**
 * StoragePartitionController
 * @constructor
 * 
 */
var StoragePartitionController = function($scope, $http, $filter, logService, dataServices, version) {
	logService.log.info("StoragePartitionController.js: ");
	
	/**** Initial default filter used variables.****/
    $scope.predicate = 'name';	// For Partition table column sort filter.
    $scope.diskName = "500B83DEF";	// For Disk table row hide or show filter.
    $scope.partitionSelected = 'AdvancedDisk';	// For Partition table mark which row is selected
    
    /// For Disk table
    $scope.disks = dataServices.disks; 
    
    /// For storage partitions
    $scope.storagePartitions = dataServices.partitions;
	
    /// For Partitions tables
    $scope.storagePartition = {};
    $scope.editMode = false;
 
    $scope.fetchData = function() {
    	$scope.canvasId = "canvas_circle";
	    $scope.text_arr = dataServices.text_arr;
	    $scope.color_arr = dataServices.color_arr; 
	    $scope.data_arr = dataServices.data_arr;  
        /*$http.get('storagePartition/storagePartitionlist.json').success(function(storagePartitionlist){
            //$scope.storagePartitions = storagePartitionlist;
        });*/
    };
        
    $scope.addStoragePartition = function(storagePartition) {
        $scope.resetError();

        $http.post('storagePartition/addStoragePartition', storagePartition).success(function() {
        	$scope.fetchStoragePartitionList(); 
            $scope.storagePartition.name = '';
            $scope.storagePartition.total = '';
            $scope.storagePartition.available = '';
            $scope.storagePartition.used = '';
            $scope.storagePartition.usedPercentage = '';        
            $scope.storagePartition.status = '';
            $scope.storagePartition.disk = '';
            $scope.storagePartition.type = '';      
          
        }).error(function() {
            $scope.setError('Could not add a new storage partition!');
            logService.log.error("Could not add a new storage partition! ");
        });         
    };

    $scope.updateStoragePartition = function(storagePartition) {
        $scope.resetError();

        $http.put('storagePartition/updateStoragePartition', storagePartition).success(function() {
            $scope.fetchStoragePartitionList(); 
            $scope.storagePartition.name = '';
            $scope.storagePartition.total = '';
            $scope.storagePartition.available = '';
            $scope.storagePartition.used = '';
            $scope.storagePartition.usedPercentage = '';        
            $scope.storagePartition.status = '';
            $scope.storagePartition.disk = '';
            $scope.storagePartition.type = '';   
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the storage partition!');
            logService.log.error('Could not update the storage partition!');
        });
    };

    $scope.editStoragePartition = function(storagePartition) {
        $scope.resetError();
        $scope.storagePartition = storagePartition;
        $scope.editMode = true;
    };

    $scope.removeStoragePartition = function(id) {
        $scope.resetError();

        $http.delete('storagePartition/removeStoragePartition/' + id).success(function() {
            $scope.fetchStoragePartitionList();
        }).error(function() {
            $scope.setError('Could not remove the storage partition!');
            logService.log.error('Could not remove the storage partition!');
        });
         
        $scope.storagePartition.name = '';
        $scope.storagePartition.total = '';
        $scope.storagePartition.available = '';
        $scope.storagePartition.used = '';
        $scope.storagePartition.usedPercentage = '';        
        $scope.storagePartition.status = '';
        $scope.storagePartition.disk = '';
        $scope.storagePartition.type = '';    
    };

    $scope.removeAllStoragePartitions = function() {
        $scope.resetError();

        $http.delete('storagePartition/removeAllStoragePartitions').success(function() {
            $scope.fetchStoragePartitionList();
        }).error(function() {
            $scope.setError('Could not remove all storage partitions!');
            logService.log.error('Could not remove all storage partitions!');
        });

    };

    $scope.resetStoragePartitionForm = function() {
        $scope.resetError();
        $scope.storagePartition = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.tableSelected = function( name, disk ){
    	$scope.partitionSelected = name;
    	$scope.diskName = disk;
    }
    
	$scope.drawCircle = function (canvasId, data_arr, color_arr, text_arr){
	    var c = document.getElementById(canvasId);
	    var ctx = c.getContext("2d");
	    var radius = c.height / 2 - 20;  
	    var ox = radius + 20, oy = radius + 20;  
	    var width = 30, height = 10; 
	    var posX = ox * 2 + 20, posY = 30;    
	    var textX = posX + width + 5, textY = posY + 10;
	    var startAngle = 0;  
	    var endAngle = 0;    
	     
	    for (var i = 0; i < data_arr.length; i++){         
	        endAngle = endAngle + data_arr[i] * Math.PI * 2; 
	        ctx.fillStyle = color_arr[i];
	        ctx.beginPath();
	        ctx.moveTo(ox, oy);  
	        ctx.arc(ox, oy, radius, startAngle, endAngle, false);
	        ctx.closePath();
	        ctx.fill();
	        startAngle = endAngle;  
	     }
	}

    $scope.fetchData();
    
    // Canvas draw pie
    $scope.drawCircle( $scope.canvasId, $scope.data_arr , $scope.color_arr, $scope.text_arr ); 
};