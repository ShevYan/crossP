<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html >
<head>
<title>Home Page</title>
<link href="../../css/bootstrap/bootstrap.min.css" rel="stylesheet"></link>
<script src="../../js/lib/jquery/jquery.min.js"></script>
<script src="../../js/lib/bootstrap/bootstrap.min.js"></script>
<script src="../../js/lib/angular/angular.js"></script>

</head>
<body onload="document.f.username.focus();">
  <div class="container">
  	<%@include file="header.jsp"%>
    <div>
    	<form action="/register" method="POST">
	        User Name: <input type="text" name="username" value="" placeholder="Username" />
	        Password: <input type="password" name="password" placeholder="Password" />
	        Confirm Password: <input type="password" placeholder="Confirm Password" />
	        <input type="submit" id="register" value="Submit"
	          class="btn btn-primary" style="margin-top: 6px;" />
	    </form>
    </div>
  </div>
</body>
</html>