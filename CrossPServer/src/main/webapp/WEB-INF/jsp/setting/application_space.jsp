
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
       		<div><h4>Welcome to Cross Promotion Application Management Page</h4></div>
       		<div ng-show="apps.length == 0">Sorry! This no application!</div>
       		<div style="margin: 9px 9px 9px 815px;"> My Apps:
             <select ng-model="sltApp" ng-change="fetchCPApps()" ng-options="m.name for m in myApps">
            </select>
          </div>
       		<div style="width: 965px;">       		       		
	       		<table class="table table-bordered table-striped ng-table"
				        ng-show="apps.length > 0">
				        <thead>
				          <tr>
				            <th>ID</th>
				            <th>Name</th>
				            <th>Location</th>
				            <th>OS</th>
				            <th>OS Version</th>
				            <th>Position</th>
				            <th>Policy</th>
				            <th>Content</th>
				            <th>CpSpace</th>
				            <th>CpItem</th>
				            <th>CP</th>
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
				            <td>0,0,150,20</td>
				            <td>{{app.policy}}</td>
				            <td>{{app.content}}</td>
				            <td>1</td>
				            <td>3</td>
				            <td>0</td>
				            <th>
				               <button type="button" class="btn btn-default" ng-click="removeApp(app.id)">Remove</button>
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