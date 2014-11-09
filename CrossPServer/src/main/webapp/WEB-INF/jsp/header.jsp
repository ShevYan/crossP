<%@include file="resources.jsp"%>
<%@include file="taglib.jsp"%>
 
<nav class="navbar navbar-default" role="navigation">
     <div class="navbar-header">
        <a class="navbar-brand" href="/">Home</a>
     </div>
     <div>
        <ul class="nav navbar-nav">
           <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                   Users 
                   <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                   <li><a href="/user/index">Index</a></li>
                   <li><a href="/user/access">Access</a></li>
                </ul>
           </li>
           <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                   API 
                   <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                   <li><a href="/api/greeting">Greeting</a></li>
                </ul>
           </li>
           <sec:authorize access="hasRole('ROLE_ADMIN')">  
           <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                 Admin 
                 <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                 <li><a href="/admin/user">Users</a></li>
              </ul>
            </li>
            </sec:authorize>
            <li><a href="/about.html">About</a></li>
            <li style="margin-left: 600px;"><a href="/login">Sign In</a></li>
            <sec:authorize var="authorized" url="/logout"><li><a href="/logout">Logout</a></li></sec:authorize>
           	<c:if test="${not authorized}">
			    <li><a href="/register">Sign Up</a></li>
			</c:if>  
      </ul>
   </div>
</nav>