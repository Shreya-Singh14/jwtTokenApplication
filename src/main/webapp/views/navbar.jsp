<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation_bar</title>
</head>

<style>

li{
			list-style: none; 
			display: inline-block;
			
			
			}
			
			#logo{
			/* text-decoration:none; */
			
			font-weight:600;
			color:white;
			position: relative;
    		
			
			
			
			}
			
			.navdiv{
			display: flex; 
			 align-items: center; 
			justify-content: space-between;
			
			}
			
			.navbar{
			background: darkblue; padding-right: 15px;padding-left: 15px;
		}
			a{
		
				/* text-decoration:none; */
				color:white;
				font-weight:400;
		}
			button{
		
		
		
		 background-color:beige; 
		  border: none;
		  color: black;
		  padding: 15px 32px;
		  text-align: center;
		 
		  
		}
			
</style>
<body>

<body>
	<nav class="navbar">
	<div class="navdiv">
	<div id="logo">
		<p >ENROLLMENT</p>
	
		</div>
		<ul>
		<li> <a href="/homee"><button>HOME</button></a></li>
		<li> <a href="/about"><button>ABOUT</button></a></li>
		<li> <a href="/login"><button>LOGOUT</button></a></li>
		</ul>
		</div>
		</nav>

</body>
</html>