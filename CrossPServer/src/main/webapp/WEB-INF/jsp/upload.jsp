
<!DOCTYPE html>
<html >
<head>
<title>About Page</title>
</head>
<body ng-app="SettingModule" ng-controller="AppUploadController">
  <div class="container">
  	<%@include file="header.jsp"%>
    <div class="content">
     <div>
          <h2>Upload</h2>
          <input type="file" ng-model="myFile">
          <button ng-click="uploadFile()">Upload</button>
    </div>
    </div>
  </div>
</body>

<script src="../../../js/lib/angular/angular.js"></script>
<script src="../../../js/controllers/AppUploadController.js"></script>
<script src="../../../js/app.js"></script>
</html>