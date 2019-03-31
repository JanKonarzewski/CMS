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
             background: #EFF8F7;
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
        	background: rgb(204, 248, 245);
            height: 40px;
        }

        .Lnav{
            font-family: Arial, Helvetica, sans-serif;
            z-index: 1000;
            width: 370px;
            height: 100%;
            padding: 26px;
            font-size: 22px;
            overflow: scroll;
            background-color: white;
            float: left;
            text-align:start;
        }
        .Title {
  
            font-size: 40px;
            font-family: Arial, Helvetica, sans-serif;
        } 

        .content {
       		box-shadow: 3px 3px 2px 0px #0E312A;
            margin: 0;
            height: 300px;
            background-color: white;
            float: left;
            width: 600px;
            margin-left: 100px;
            text-align: center;
            margin-left: 300px;
            margin-top: 100px;
        }
        .form
        {
        	float:left;	
        }
        .confInfo
    </style>
   
</head>
<body>
    <!--Nav Bar for Conference System BIG one-->
    <div class = "Bnav">    
        <a >Conference System</a>
    </div>
    
    <!--Nav Bar for thin one-->
    <div class = "Snav">
    	<div class="form">
	    	<form:form action="${pageContext.request.contextPath}/profileDetails">
	    		<input type="submit" value="Profile Details" ></input>
	  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    	</form:form> 
    	</div>
    	<div class="form">
	    	<form action="/CMS/AdminManageConference">
	    		<input type="submit" value="Manage Conferences" ></input>
	  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    	</form>
    	</div>
    	<div class="form">
	    	<form action="/CMS/logout">
	    		<input type="submit" value="logout" ></input>
	  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    	</form>
    	</div>
    		<div style="clear:both;"/>
    </div>     
    
    <!--Nav Bar for Left filters-->
    <div id ="centerWrapper">
	   <div class="content">
	   	<h1>Admin Account </h1>
	   </div>
	   <div style="clear:both;"/>
    </div>
</body>	
</html>
