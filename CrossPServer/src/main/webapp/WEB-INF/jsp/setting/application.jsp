
<!DOCTYPE html>
<html >
<head>
<title>Setting Home Page</title>
</head>
<body>
  <div class="container">
  	<%@include file="../header.jsp"%>
    <div class="content">
    	<div style="width: 150px;float: left;"><%@include file="setting_menu.jsp"%></div>
       	<div style="float: left;margin-left: 20px;">
       		<div>Welcome to Cross Promotion Application Management Page</div>
       		<div>Sorry! This no application!</div>
       		<div>
       			<button type="button" class="btn btn-default">Add</button>
       		</div>
       		<div>       			
       			<div>Application Name:<input type="text" name="name" value="" placeholder="Application Name" /></div>
       			<div>Location:<input type="text" name="location" value="" placeholder="Location" /></div>
       			<div>Function Name:<input type="text" name="function" value="" placeholder="Function Name" /></div>
       			<div>Platform:<input type="text" name="os" value="" placeholder="Platform" /></div>
       			<div>Platform Version:<input type="text" name="os_version" value="" placeholder="Platform Version" /></div>
       			<div><button type="button" class="btn btn-default">Submit</button></div>       			
       		</div>
       	</div>   
    </div>
  </div>
</body>

<script type="text/javascript">

</script>
</html>