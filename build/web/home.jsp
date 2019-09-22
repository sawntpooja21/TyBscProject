<%-- 
    Document   : home
    Created on : 3 Jan, 2018, 12:27:24 PM
    Author     : SHREE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
    <body>
  <div id='menu-area'>
         <%
                        HttpSession hs=request.getSession();
                        if(hs.getAttribute("uname") == null)
                        {%>
                        <script >"alert('pls Log in');"</script>
                    <%
                            response.sendRedirect("AdminLogin.jsp");
                            
                        }
                    %>
<ul>
    <li><a href='home.jsp'<span>Home</span></a></li>
   
   <li><a href='Teacher.jsp'><span>Teacher File</span></a>
   </li>
   <li><a href='Student.jsp'><span>Student File</span></a></li>
  
   
   <li></li>  
   <form action='Admin_Logout' method="post" id="btn">
   <li  style="position:absolute;left: 1200px;font-size:20px"><input type="submit" value="Logout"  ></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px" id="user"> Welcome <%=hs.getAttribute("uname")%></li>
</ul>
</div>
 
<div style="position: absolute;left:50px;top:100px" >
   
    <table cellpadding="0" cellspacing="50">
<tr>
<td><img height="400" width="850" src="homejava.png"/></td>

</tr>
</table> 
    
</div>
       
    </body>
</html>
