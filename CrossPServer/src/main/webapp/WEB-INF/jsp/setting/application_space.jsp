
<!DOCTYPE html>
<html >
<head>
<title>Setting Home Page</title>
</head>
<body ng-app="SettingModule" ng-controller="AppSpaceController">
  <div class="container">
  	<%@include file="../header.jsp"%>
    <div class="content">
    	<div style="width: 150px;float: left;"><%@include file="setting_menu.jsp"%></div>
       	<div style="float: left;margin-left: 20px;">
       		<div><h4>Welcome to Cross Promotion Application Management Page</h4></div>
       		<div ng-show="mySpaces.length == 0">Sorry! This no application space!</div>
       		<div style="width: 965px;">       		       		
	       		<table class="table table-bordered table-striped ng-table"
				        ng-show="mySpaces.length > 0">
				        <thead>
				          <tr>
				            <th>ID</th>
				            <th>Name</th>
				            <th>Position</th>
				            <th>Display Mode</th>
				            <th>Display Action</th>
				            <th>Display Time</th>
				            <th>Operate</th>
				          </tr>
				        </thead>
				        <tbody>
				          <tr ng-repeat="space in mySpaces">
				            <td>{{space.id}}</td>
				            <td>{{space.name}}</td>
				            <td>{{space.position}}</td>				            
				            <td>{{space.displayMode}}</td>
				            <td>{{space.displayAction}}</td>
				            <td>{{space.displayTime}}</td>
				            <th>
				               <button type="button" class="btn btn-default" ng-click="change()">Edit</button>
				               <button type="button" class="btn btn-default" ng-click="removeAppSpace(space.id)">Remove</button>
				            </th>
				          </tr>
				        </tbody>
				   </table>
			   </div>
       		
       		<div>
       			<button type="button" class="btn btn-default" ng-click="hiddenShow=!hiddenShow">Add</button>       			
       		</div>  
       		<div ng-show="hiddenShow">       			
       			<div>AppSpace Name:<input type="text" ng-model="appSpace.name" value="" placeholder="AppSpace Name" /></div>
       			<div>Position:<input type="text" ng-model="appSpace.position" value="" placeholder="x, y, width, height" /></div>
       			<div>Display Mode:<input type="text" ng-model="appSpace.displayMode" value="" placeholder="Web/UI" /></div>
       			<div>Display Action:<input type="text" ng-model="appSpace.displayAction" value="" placeholder="Event Trigger/Login" /></div>
       			<div>Display Time:<input type="text" ng-model="appSpace.displayTime" value="" placeholder="How long will be display" /></div>
       			<div><button type="button" class="btn btn-default" ng-click="save(appSpace)">Submit</button></div>       			
       		</div>
       	</div>   
    </div>
  </div>
</body>

<script src="../../../js/lib/angular/angular.js"></script>
<script src="../../../js/controllers/AppSpaceController.js"></script>
<script src="../../../js/app.js"></script>
</html>