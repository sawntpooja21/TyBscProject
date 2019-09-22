<%-- 
    Document   : home.jsp
    Created on : 31 Dec, 2017, 1:25:38 PM
    Author     : SHREE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN</title>
    </head>
    

<style>
    #menu-area{
            background: #000000;
            height: 60px;
            margin-top: 20px;
        }
        #menu-area ul{
           
            float:left;
            list-style: none;
            margin: 0;
            padding: 0;
            width:80%;
        }
        #menu-area li{
            display: inline-block; 
            
        }
        
        #menu-area a{
            color:#ffffff;
            line-height: 40px;
            display: inline-block;
            padding: 10px 45px;
            text-decoration: none;
            text-transform: uppercase;
        }
        #menu-area a:hover{
            background-color: #999999;
        }
        </style>
    <body >
        
    <div id='menu-area'>
          

<ul>
    <li><a href='AdminLogin.jsp'<span>Home</span></a></li>
   <li><a href='AdminLogin.jsp'><span>Login</span></a></li>
   <li><a href='AdminLogin.jsp'><span>Teacher File</span></a>
   </li>
   <li><a href='AdminLogin.jsp'><span>Student File</span></a></li>
   
   
   <li></li>
   
   
</ul>
</div>
 
<div style="position: absolute;left:50px;top:100px">
    
<table cellpadding="0" cellspacing="50">
<tr>
<td><img height="400" width="850" src="homejava.png"/></a></td>

</tr>
</table>
</div>
        
</body>
</html>
