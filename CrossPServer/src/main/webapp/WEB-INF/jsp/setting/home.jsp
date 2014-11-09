
<!DOCTYPE html>
<html >
<head>
<title>Setting Home Page</title>
</head>
<body onload="document.f.username.focus();">
  <div class="container">
  	<%@include file="../header.jsp"%>
    <div class="content">
    	<div style="width: 150px;float: left;"><%@include file="setting_menu.jsp"%></div>
       	<div>This is setting home page. <sec:authentication property="name"/></div>   
    </div>
  </div>
</body>
</html>