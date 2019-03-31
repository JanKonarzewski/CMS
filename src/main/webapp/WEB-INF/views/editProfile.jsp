<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.konarzewski.domain.Conference"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>EDIT PROFILE</title>
   <style>
		body{
    margin: 0 0;
    padding: 0 0;
}
*{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; 
    color: var(--txt);
}
:root { 
    --bgcol-top: #0E312A; 
    --bgcol-nav: #DCFAF8; 
    --bgcol-list: #EFF8F7; 
    --bgcol-inac: #EBEBEB; 
    --bgcol-dark: #696969; 
    --shad: #C4C4C4; 
    --shad-dark: #696969; 
    --txt: #5A605D; 
    --txt-active: #6BB590; 
    --txt-alert: #19BAB0; 
    --txt-inac: #C6CCCE; 
    --border: #707070; 
}


.block{
    width: 300px;
    height: 75px;
    margin: 10px 5px;
    display: block;
    border: solid 1px black;
    padding: 10px 10px;
}

.test{

    background-color: blue;
    width: 100%;
    display: block;
    margin-left: 5px;
}

<!--  -->

.body{
    height: 100%;
    width: 100%;
    position: fixed;
	display: flex;
	flex-direction: column;
    z-index: 1;
}
.header{
    flex: 0 1 auto;
    position: relative;
    display: flex;
    flex-direction: column;
}
.imbody{
    flex: 1;
    position: relative;
    overflow: hidden;
}
.imbody.colour{
    background-color: var(--bgcol-list);
}

.title{
    position: static;
    display: block;
    height: 100px;
    width: 100%;
    padding-left: 22px;
    background-color: var(--bgcol-top);
}
.title span{
    line-height:100px;
    color: white;
    font-size: 44px;
    font-style: italic;
}
.navigation{
    box-sizing: border-box;
    position: static;
    display: inline-block;

    overflow-y: hidden;
    height: 60px;
    width: 100%;
    background-color: var(--bgcol-nav);
    padding-left: 30px;
}
.navigation .navleft{
    position: relative;
    display: inline-block;
    float: left;
    height: 100%;
}
.navigation .navright{
    position: relative;
    display: -webkit-flex;
    -webkit-flex-flow: row;
    float: right;
    height: 100%;
}
.navigation span{
    font-size: 24px;
    display: inline-block;
    float: left;
    margin-right: 30px;
    color: black;
    line-height: 60px;
}
.navigation a{
    text-decoration: none;
    color: black;
}

.flexible{
    position: static;
    box-sizing: border-box;
}

.flexible::-webkit-scrollbar {
  width: 12px;
}

.flexible::-webkit-scrollbar-track {
  box-shadow: inset 8px 0px 10px -7px var(--shad-dark);
}
 
.flexible::-webkit-scrollbar-thumb {
  background: var(--shad-dark);  
}

.flexible::-webkit-scrollbar-thumb:hover {
  background: var(--shad-dark); 
}

.flexible.block{
    display: block;
    height: 100%;
    width: 90%;
    background-color: none;
    padding-left: 12px;
    margin: 0 auto;
    overflow-y: scroll;
}

.flexible.list{
    display: block;
    width: 50%;
    height: 100%;
    background-color: var(--bgcol-list);
    padding-left: 12px;
    margin: 0 auto;
    overflow-y: scroll;
}

.narrow{
    position: absolute;
    display: inline-block;
    height: auto;
    width: auto;
    background-color: white;
    top: 30%;
    left: 50%;
    transform: translate(-50%, -30%);
}

.flexible.menu{
    display: block;
    position: static;
    float: left;
    height: 100%;
    left: 0px;
    width: 370px;
    overflow-y: scroll;
    background-color: white;
    box-shadow: 8px 0px 10px -7px var(--shad);
}

.fit{
    height: 100%;
    width: calc(100% - 370px);
    position: relative;
    display: block;
    float: left;
    overflow-y: scroll;
}
    
.content{
    position: static;
    display: inline-block;
    width: 100%;
}

input.input{
display: inline-block;
    outline: none;
    color: var(--txt);
    padding: 3px 4px;
}
input.inputnob{
display: inline-block;
    outline: none;
    color: black;
    padding: 3px 4px;
    border-left-width: 0px;
    border-right-width: 0px;
    border-top: solid 0.5px var(--border);
    border-bottom: solid 0.5px var(--border);
}



.ahover, .ahover:link, .ahover:visited{
    text-decoration: none;
    color: var(--txt-active);
}
.ahover:hover, .ahover:active{
    text-decoration: underline;
    color: var(--txt-active);
}

.abg, .abg:link, .abg:visited{
    display: block;
    width: cal(100% - 10px);
    padding-bottom: 10px;
    padding-top: 10px;
    padding-left: 10px;
    padding-right: 60px;
    text-decoration: none;
    color: var(--txt);
}
.abg:hover, .abg:active{
    background-color: var(--bgcol-inac);
    text-decoration: underline;
    color: var(--txt);
}

.acolor, .acolor:link, .acolor:visited{
    color: var(--txt);
}
.acolor:hover, .acolor:active{
    color: var(--txt-alert);
}

button.bhover{
    width: 100%;
    height: 100%;
    border: none;
    border-radius: 0px;
    color: var(--txt);
    background-color: transparent;
    outline: none;
}
button.bhover:hover, button.bhover:active{
    background-color: var(--bgcol-inac);
    border: none;
    color: var(--bgcol-top);
    outline: none;
}

button.bshad{
    position: relative;
    margin: -1px 0px;
    z-index: 2;
    padding: 8px 20px;
    border: solid 1px var(--border);
    border-radius: 0px;
    color: black;
    background-color: white;
    outline: none;
}
button.bshad:hover, button.bshad:active{
    background-color: white;
    color: black;
    z-index: 55;
    box-shadow: 0px 0px 8px var(--shad);
    outline: none;
}
body{
   	font-family: Arial;
}

#task6-left{
	  
	margin-left:30px; 
	 
	
	    float:left;
    width:500px;
}

#task6-right{
	text-align:left;
	margin-left:30px; 
    margin-right:5px;
    padding-right:4px;
    float:left;
}
.headerOption
{
	float: left;
}

	</style>  
</head>
<body>
    <div class="body">
    <div class="header">
        <div class="title"><span>Conference System</span></div>
        <div class="navigation">
            <div class="navleft">
                <form action="/CMS/">
                	<input type="submit" value="Back" class="headerOption">
                </form>
                        
            </div>
            <div class="navright">
             	<form action="/CMS/logout">
	    			<input type="submit" value="logout" ></input>
	  				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    		</form>
			</div>
        </div>
    </div>
        
    <div class="imbody"><div class="narrow">
    <br>
	
	
	<div id="task6-left">
		Profile Details:</br></br></br>
				First Name: ${fName}</br>
				Last Name: ${lName}</br>
				Email: ${email}
			
	</div>
	<div id="task6-right">
	
	
	</div>
        </div></div>
        
    </div>
</body>
</html>


