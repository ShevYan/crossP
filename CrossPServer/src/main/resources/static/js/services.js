'use strict';

/* Services */

var AppServices = angular.module('AngularSpringApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('logService', [ '$window', function(win) {
	var log = log4javascript.getLogger();
	var ajaxAppender = new log4javascript.AjaxAppender("log/add");
	ajaxAppender.setWaitForResponse(true);
	ajaxAppender.setLayout(new log4javascript.JsonLayout());
	ajaxAppender.addHeader("Content-Type", "application/json")
	//ajaxAppender.setBatchSize(3); // The number of log messages sent in each request, default size is 1. 
	log.addAppender(ajaxAppender);

	return {
		log : log
	}
}]);

AppServices.factory('dataServices', [ function() {
	/// For getting storage disks
	function getDisks(){
		var disks = [
                     {name:"500B83DEF", type:"System", status:"n/a", allocations:"None", unallocated:"-", total:"930.39 GB"},
                     {name:"74B83DEF", type:"Base", status:"In Use", allocations:"None", unallocated:"-", total:"454 TB"}
                     ];
		return disks;
	}
	
	/// For getting storage partitions
	function getStoragePartitions(){
		var storagePartitions = [ {name:'AdvancedDisk', total:'122880', available:'111856', used:'11024',  status:'Optimal', disk:'74B83DEF', type:'Base', color:"#4485CC" },

		                          {name:'Configuration', total:'25600', available:'23576', used:'1124',  status:'Optimal', disk:'500B83DEF', type:'Base', color:"#734E24" },

		                          {name:'MSDP', total:'2048', available:'1024', used:'1024',   status:'Optimal', disk:'74B83DEF', type:'Base', color:"#FBDB6E" },

		                          {name:'MSDPCatalog', total:'12288', available:'11264', used:'1024',  status:'Optimal', disk:'74B83DEF', type:'Base', color:"#D78036" },

		                          {name:'NetBackup', total:'307200', available:'300000', used:'7200',  status:'Optimal', disk:'500B83DEF', type:'Base', color:"#A4C84E" },

		                          {name:'Unallocated', total:'614400', available:'-', used:'-', status:'Optimal', disk:'74B83DEF', type:'Base', color:"#CCCCCC" }
		                          ];
		return storagePartitions;
	}
	
    var text_arr = [];
    var color_arr = []; 
    var data_arr = [];    
    var totalDiskSpace = 0;
    var partitions = [];
    var storagePartitions = getStoragePartitions();
    var disks = getDisks();
    
    for( var i=0; i<storagePartitions.length-1; i++){
    	var usedPercent = storagePartitions[i].used/storagePartitions[i].total; 
    	var total = storagePartitions[i].total/1024;
    	var obj = {name:storagePartitions[i].name, total:total +" GB", available:storagePartitions[i].available/1024 +" GB", used:storagePartitions[i].used/1024 +" GB", 
    		usedPercentage:usedPercent*100, status:storagePartitions[i].status, disk:storagePartitions[i].disk, 
    		type:storagePartitions[i].type, color:storagePartitions[i].color };
    	partitions.push(obj);
    	 
    	totalDiskSpace += total;
    }
    
    var obj = { name:storagePartitions[i].name, total:storagePartitions[i].total/1024 +" GB", available:"-", used:"-", 
	    		usedPercentage:"-", status:"-", disk:storagePartitions[i].disk, 
	    		type:storagePartitions[i].type, color:storagePartitions[i].color };
    partitions.push(obj);
    
    totalDiskSpace += storagePartitions[i].total/1024;
    
    for( var i=0; i<partitions.length; i++){
    	text_arr.push(partitions[i].name);
    	color_arr.push(partitions[i].color);  
    	console.info(storagePartitions[i].total);
    	data_arr.push(storagePartitions[i].total/1024/totalDiskSpace);
    }
	
	return {
		disks: disks,
		text_arr: text_arr,
		color_arr: color_arr,
		data_arr: data_arr,
		partitions:partitions
	}
}]);
 
