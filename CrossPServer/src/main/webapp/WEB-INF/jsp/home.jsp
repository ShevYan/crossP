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
  	<jsp:include page="header.jsp" flush="true"/> 
    <div class="content">
       This is home page. <sec:authentication property="name"/>   
       <sec:authorize><a href="/logout">Logout</a></sec:authorize>        
    </div>
  </div>
</body>
</html>