<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" ng-app="">
<head>
<title>Login</title>
<link href="../../css/bootstrap/bootstrap.min.css" rel="stylesheet"></link>
<script src="../../js/lib/jquery/jquery.min.js"></script>
<script src="../../js/lib/bootstrap/bootstrap.min.js"></script>
<script src="../../js/lib/angular/angular.js"></script>

</head>
<body onload="document.f.username.focus();">
  <div class="container">
    <%@include file="header.jsp"%>
    <div class="content" style="margin-top: 50px; margin-left: 200px;">
      <p th:if="${param.error}" class="alert alert-warning">There was an error, please try again</p>
      <h2>Login with Username and Password</h2>
      <form name="form" th:action="@{/login}" action="/login" method="POST">
        <fieldset>
          <input type="text" name="username" value="" placeholder="Username" />
          <input type="password" name="password" placeholder="Password" />
        </fieldset>
        <input type="submit" id="login" value="Login"
          class="btn btn-primary" style="margin-top: 6px;" />
      </form>
    </div>
  </div>
</body>
</html>