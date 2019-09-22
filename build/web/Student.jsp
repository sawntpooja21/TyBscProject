<%-- 
    Document   : Student
    Created on : 31 Dec, 2017, 9:44:37 PM
    Author     : SHREE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
                        HttpSession hs=request.getSession();
                        if(hs.getAttribute("uname") == null)
                        {%>
                        <script language=\"javascript\" type=\"text/javascript\">" +
                                    "alert('pls Log in');" +
                                "</script>
                    <%
                            response.sendRedirect("AdminLogin.jsp");
                            
                        }
                    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <style>
    #menu-area{
        background:#660000;
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
            background-color: #ff0033;
        }
        </style>
        <body >
                 <div id='menu-area'>
         

<ul>
    <li><a href='home.jsp'<span>Home</span></a></li>
   <li><a href='AddStudent.jsp'><span>Add</span></a></li>
   <li><a href='ViewStudent.jsp'><span>ViewAll</span></a>
   </li>
   <li><a href='UpdateStudent.jsp'><span>Update</span></a></li>
   <li><a href='DeleteStudent.jsp'><span>Delete</span></a></li>
   <li><a href='LecturePresent.jsp'><span>Lecture</span></a></li>
   <li><a href='TotalPercentage.jsp'><span>Total%</span></a></li>
   
   <p style="font-size:25px;text-align: center">STUDENT FILE</p>  
   <form action='Admin_Logout' method="post" id="btn">
  <li  style="position:absolute;left: 1200px;font-size:20px;top: 13%"><input type="submit" value="Logout"  ></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px;top: 13%" id="user"> Welcome <%=hs.getAttribute("uname")%></li>

<div style="position: absolute;left:50px;top:100px">
<table cellpadding="0" cellspacing="50">
<tr>
<td><img height="400" width="850" src="homejava.png"/></a></td>

</tr>
</table>
</div>
    </body>
</html>
