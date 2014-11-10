
<!DOCTYPE html>
<html >
<head>
<title>Setting Home Page</title>
</head>
<body ng-app="SettingModule" ng-controller="ApplicationController">
  <div class="container">
  	<%@include file="../header.jsp"%>
    <div class="content">
    	<div style="width: 150px;float: left;"><%@include file="setting_menu.jsp"%></div>
       	<div style="float: left;margin-left: 20px;">
       		<div>Welcome to Cross Promotion Application Management Page</div>
       		<div>Sorry! This no application!</div>
       		<div>
       			<button type="button" class="btn btn-default">Add</button>
       		</div>
       		<div>       			
       			<div>Application Name:<input type="text" ng-model="app.name" value="" placeholder="Application Name" /></div>
       			<div>Location:<input type="text" ng-model="app.location" value="" placeholder="Location" /></div>
       			<div>Function Name:<input type="text" ng-model="app.function" value="" placeholder="Function Name" /></div>
       			<div>Platform:<input type="text" ng-model="app.os" value="" placeholder="Platform" /></div>
       			<div>Platform Version:<input type="text" ng-model="app.osVersion" value="" placeholder="Platform Version" /></div>
       			<div><button type="button" class="btn btn-default" ng-click="save(app)">Submit</button></div>       			
       		</div>
       	</div>   
    </div>
  </div>
</body>

<script src="../../../js/lib/angular/angular.js"></script>
<script src="../../../js/controllers/ApplicationController.js"></script>
<script src="../../../js/app.js"></script>
</html>