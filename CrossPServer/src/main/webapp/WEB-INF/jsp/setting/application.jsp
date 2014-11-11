
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
       		       		
       		<table class="table table-bordered table-striped ng-table"
			        ng-show="apps.length > 0">
			        <thead>
			          <tr>
			            <th>Name</th>
			            <th>Type</th>
			            <th>ID</th>
			            <th>Allocations</th>
			            <th>Unallocated</th>
			            <th>Total</th>
			            <th>CP</th>
			          </tr>
			        </thead>
			        <tbody>
			          <tr ng-repeat="app in apps">
			            <td>{{app.name}}</td>
			            <td>{{app.location}}</td>
			            <td>{{app.id}}</td>
			            <td>{{app.name}}</td>
			            <td>{{app.name}}</td>
			            <td>{{app.name}}</td>
			            <th>
			               <button type="button" class="btn btn-default" ng-click="joinCrossP(app.id)">Join</button>
			               <button type="button" class="btn btn-default" ng-click="breakCrossP(app.id)">Break</button>
			            </th>
			          </tr>
			        </tbody>
			   </table>
       		
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