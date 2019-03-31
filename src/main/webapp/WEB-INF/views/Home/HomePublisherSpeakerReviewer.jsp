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
             background: white;
         }
        
        :root { --bgcol-top: #0E312A;
            --bgcol-nav: #DCFAF8;
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
            background: rgb(204, 248, 245);
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
        
            margin: 0;
            height: 92%;
            background-color: white;
            float: left;
            width: 60%;
            margin-left:10px;
        }
        .form
        {
	       		position:relative;
	       		float:left;
	       		padding:6px 12px;
       		margin-left:-1px;
       		line-height:1.42857143;
       		color:#337ab7;
       		text-decoration:none;
       		background-color:#fff;
       		border:1px solid #ddd;
        	float:left;	
        }
        .confInfo
        {
        	text-align: center;
        	border: 1px solid black;
        }
    </style>
   
</head>
<body>
    <!--Nav Bar for Conference System BIG one-->
    <div class = "Bnav">    
        <a >Conference System</a>
    </div>
    
   	
    <div class = "Snav">
    	<div class="form">
	    	<form:form action="${pageContext.request.contextPath}/profileDetails">
	    		<input type="submit" value="Profile Details" ></input>
	  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    	</form:form> 
    	</div>
    	
    	 <c:forEach items="${links}" var="link">
    	 	<div class="form">
	    		<form:form action="${pageContext.request.contextPath}${link.key}">
		    		<input type="submit" value="${link.value}" ></input>
		  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    		</form:form> 
    		</div>
    	 </c:forEach>	
	
	    
    	<div class="form">
	    	<form action="/CMS/OwnUserArticles">
	    		<input type="submit" value="Submited articles" ></input>
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
    
    <div id ="centerWrapper">
	    <div class="Lnav">
	    		Search conference:
	    	<form action="/CMS/searchConferencesByNameUser" method="post">
		        <input type="text"  name= "byName" id="byName">
		        <input type="submit" value="search">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    </form>
		 	   </div>
	   <div class="content">
	   
	     <c:forEach items="${conf}" var="con">
	     	<div class="confInfo">
		      	<c:out value="Conference: "/>
		      	<c:out value="${con.name}"/></br>
		      	<c:out value="Venue: "/>
		      	<c:out value="${con.venue}"/></br>
		      	Start day: <c:out value="${con.start}"/><tab>
		      	End Day: <c:out value="${con.end}"/>
	    	 	<form:form action="${pageContext.request.contextPath}/ConferenceDetails">
		    		<input type="submit" value="check" ></input>
		  			<input type="hidden" name="conferenceId" value="<c:out value='${con.conferenceID}'/>"/>
		  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	</form:form> 
    		</div>
    	 </c:forEach>	
	
	   </div>
	   <div style="clear:both;"/>
    </div>
</body>	
</html>
