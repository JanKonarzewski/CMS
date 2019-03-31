<!DOCTYPE html>	
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>INDEX</title>
    <link href="style.css?version=6.0" rel="stylesheet">
	<style>
body{
    margin: 0 0;
    padding: 0 0;
}
*{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; 
}
:root { --bgcol-top: #0E312A; --bgcol-nav: #DCFAF8; --bgcol-list: #EFF8F7; --bgcol-inac: #EBEBEB; --bgcol-dark: #696969; --shad: #C4C4C4; --shad-dark: #696969; --txt: #5A605D; --txt-active: #6BB590; --txt-alert: #19BAB0; --txt-inac: #C6CCCE; --border: #707070; }

.test{
    background-color: blue;
    width: 20px;
    display: block;
    margin-left: 5px;
}

<!--  -->

.body{
	background-color: #EFF8F7;
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
    overflow-x: scroll;
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
    overflow: scroll;
}
    
.content{
    position: static;
    display: inline-block;
    width: 100%;
}
	#loginbox{
	width: 500px;
	height: 400px;
	background-color: white	;
	margin-left: auto;
	margin-right: auto;
	margin-top: 110px;
	
	}
	#box{
		margin-top: 20px;
		background-color: whites;
		height: 300px;
		width:300px;
		margin-left:auto;
		margin-right:auto;
	}
	loginIn.{
		float: left;
		
	}
	
	.register{
		border-radius: 2px;
		margin-top: 20px;
	}
	#login
	{
		float:right;
		width:40%;
		height:30px;
		margin-top:30px;
		margin-right: 5%;
		
	}
	#cs
	{
		float:left;
	}
	
	.loginIn input[type=text]{
		  width: 30%;
		  padding: 6px 10px;
		  margin: 8px 4px;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
	}	
	
	.loginIn input[type=password]{
		  width: 30%;
		  padding: 6px 10px;
		  margin: 8px 4px;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
	}	
	
	

	.loginIn input[type=submit] {
		background-color: "white";
		padding: 6px 10px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin: 16px 4px;
		width: 15%;
}

	input[type=submit] {
		background-color: "white";
		padding: 6px 10px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin: 16px 4px;
		width: 60%;
}

	input[type=password]{
		  width: 80%;
		  padding: 6px 10px;
		  margin: 8px 4px;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
	}	
	
	
	input[type=text]{
		  width: 80%;
		  padding: 6px 10px;
		  margin: 8px 4px;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
	}	
	
	</style>
</head>
<body>
    <div class="body">
    <div class="header">
        <div class="title"><div id="cs"><span>Conference System</span></div>
		   	<div id ="login">
				<form action="/CMS/" method="post" class="loginIn">
					<input type="text" name="username" id="H1" class="loginIn" placeholder="Email"/>
					<input type="password" name="password" id="H1"placeholder="Password"/>
					<input type="submit" value="Login"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div style="clear:both;"></div>
				</form>
			</div>
			<div style="clear: both"></div>
        </div>
   
    </div>
    <div id="loginbox">    
		<div id="box">
				Create an account </br>
				<form action="/CMS/register" method="post">
					<input type="text" name="fname" id="fname" class="register" placeholder="First name" />
					<input type="text" name="lname" id="lname" class="register" placeholder="Last name" />
					<input type="text" name="username" id="usernamer" class="register" placeholder="Username" />
					<input type="text" name="email" id="email" class="register" placeholder="E-mail" />
					<input type="password" name="password1" id="password1" class = "register" placeholder="Password"/>
					<input type="password" name="password2" id="passwor2" class = "register" placeholder="Repeat password"/>
					<input type="submit" class="registers" value="Register"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
		</form>		
			</div>	
		
	</div>
	</div>
</body>
</html>