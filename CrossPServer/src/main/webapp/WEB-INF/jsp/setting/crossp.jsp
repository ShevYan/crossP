
<!DOCTYPE html>
<html >
<head>
<title>Setting Home Page</title>
</head>
<body ng-app="SettingModule" ng-controller="CrossPController">
  <div class="container">
  	<%@include file="../header.jsp"%>
    <div class="content">
    	<div style="width: 150px;float: left;"><%@include file="setting_menu.jsp"%></div>
       	<div style="float: left;margin-left: 20px;">
       		<div>Welcome to Cross Promotion Application Management Page</div>
       		<div ng-show="apps.length == 0">Sorry! This no application!</div>
       		<div>       		       		
	       		<table class="table table-bordered table-striped ng-table"
				        ng-show="apps.length > 0">
				        <thead>
				          <tr>
				            <th>ID</th>
				            <th>Name</th>
				            <th>Location</th>
				            <th>OS</th>
				            <th>OS Version</th>
				            <th>Policy</th>
				            <th>Content</th>
				            <th>My Apps</th>
				            <th>Operate</th>
				          </tr>
				        </thead>
				        <tbody>
				          <tr ng-repeat="app in apps">
				            <td>{{app.id}}</td>
				            <td>{{app.name}}</td>
				            <td>{{app.location}}</td>				            
				            <td>{{app.os}}</td>
				            <td>{{app.osVersion}}</td>
				            <td>{{app.policy}}</td>
				            <td>{{app.content}}</td>
				            <td>
                        <label class="checkbox"> <input type="checkbox" ng-model="fgas">App1</label>
                        <label class="checkbox"> <input type="checkbox" ng-model="asdfa">App2</label>   	
                        <label class="checkbox"> <input type="checkbox" ng-model="sdf">App3</label> 			            
				            </td>
				            <th>
				               <button type="button" class="btn btn-default" ng-click="joinCrossP(app.id)">Join</button>
				               <button type="button" class="btn btn-default" ng-click="breakCrossP(app.id)">Break</button>
				            </th>
				          </tr>
				        </tbody>
				   </table>
			   </div>
       	</div>   
    </div>
  </div>
</body>

<script src="../../../js/lib/angular/angular.js"></script>
<script src="../../../js/controllers/CrossPController.js"></script>
<script src="../../../js/app.js"></script>
</html>