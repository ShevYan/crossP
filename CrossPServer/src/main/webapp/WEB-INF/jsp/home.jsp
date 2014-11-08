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
    <div class="content">
       This is home page. <sec:authentication property="name"/>   
               
    </div>
  </div>
</body>
</html>