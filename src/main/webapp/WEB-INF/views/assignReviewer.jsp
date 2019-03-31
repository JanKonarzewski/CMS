<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.konarzewski.domain.Conference"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Conference System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    
    <style>
        body{
        
             margin: 0 ;
             padding: 0 ;
          	background-color: #EFF8F7;
       }
        
        :root { --bgcol-top: #0E312A;
            --bgcol-nav: #EEF8F7;
            --bgcol-list: #EFF8F7;
            --bgcol-inac: #EBEBEB;
            --bgcol-dark: #696969;
            --shad: #C4C4C4;
            --txt: #5A605D;
            --txt-active: #6BB590;
            --txt-alert: #19BAB0;
            --txt-inac: #C6CCCE;
            --border: #707070; 
         }
        
        .Bnav{
 
            margin: 0;
            padding: 7;
            color:white;

            background: rgb(10, 46, 46);
            font-family: Arial, Helvetica, sans-serif;
            font-size: 22px;
        
         }
        
        .Snav{
            padding: 10;
            background: #DCFAF8;
        }

        .Title {
  
            font-size: 40px;
            font-family: Arial, Helvetica, sans-serif;
        } 

        .content {
        
            margin: 0;
            background-color: white;
            width: 60%;
            margin-left:10px;
        }
        .form
        {
        	float:left;	
        }
        .confInfo
        {
        	border: 5px solid black;
        }
        #centerWrapper
        {
			position: relative;
        	background-color: #EFF8F7;
        }
        #content
        {
			text-align: center;
			position: absolute;
			margin-top: 50px;
			margin-right: auto;
			margin-left: 300px;
			width: 600px;
			height: 500px;
			background-color: white;
        }
        #wraper
        {
        	
        }
        .loop
        {
        	margin-top: 1px;
        	border: 1px solid black;
        }
        
    </style>
   
</head>
<body>
<div id="wraper">
    <!--Nav Bar for Conference System BIG one-->
    <div class = "Bnav">    
        <a >Conference System</a>
    </div>
    
    <!--Nav Bar for thin one-->
    <div class = "Snav">
    		<div class="form">
    			<form:form action="${pageContext.request.contextPath}/homeManager">
		    		<input type="submit" value="Home" ></input>
		  			<input type="hidden" name="conferenceId" value="<c:out value='${conferenceID}'/>"/>
		  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	</form:form> 
    		</div>
    		<div class="form">   
         		<form action="/CMS/logout">
	    			<input type="submit" value="logout" >
	  				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    		</form>
			</div>
         	<div style="clear:both;"/>
    </div>     
    <div id ="centerWrapper">
	   <div id="content">  
		 <c:forEach items="${users}" var="user">
	 		<div class="loop">
	     	  	<c:out value="First name: "/>
		      	<c:out value="${user.fName}"/><br>
		      	<c:out value="Last Name: "/>
		      	<c:out value="${user.lName}"/></br>
		      	<form:form action="/CMS/assignReviewerArticles">
		      		<input type="submit" value="Select">
					<input type="hidden" name="userID" value="${user.profileId}"/>      	
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>      	
		      	</form:form>
		    </div>
	     </c:forEach>	
	
	   </div>

    </div>
</div>
</body>	
</html>
