<%-- 
    Document   : AddTeacher
    Created on : 1 Jan, 2018, 1:27:51 PM
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
        <title>Add Teacher</title>
    </head>
    <style>
        
    #menu-area{
        background: #660000;
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
        
    body{
        margin: 0;
        padding: 0;
        background: url(backg.jpg);
        background-size: cover;
        font-family: sans-serif;
    }
    .Add{
        position: absolute;
        top: 65%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 450px;
        height: 620px;
        box-sizing: border-box;
        padding: 50px;
        background: rgba(0,0,0,.5);
    }
    .Add h2{
        margin: 0;
        padding: 0 0 20px;
        color: #efed40;
        text-align: center;
    }
    .Add p{
        margin: 0;
        padding: 0;
        font-weight: 200;
        color: #fff;
    }
    .Add input{
        width: 100%;
        margin-bottom: 20px;
    }
    .Add input[type="text"]
    
    {
        border: none;
        border-bottom: 1px solid #fff;
        background: transparent;
        outline: none;
        height: 40px;
        font-size: 16px;
        
    }
    
    
        </style>
    <body>
   <div id='menu-area'>
<ul>
    <li><a href='home.jsp'<span>Home</span></a></li>
   <li><a href='AddTeacher.jsp'><span>Add Teacher</span></a></li>
   <li><a href='ViewTeacher.jsp'><span>View Records</span></a>
   </li>
   
 <form action='Admin_Logout' method="post" id="btn">
   <li  style="position:absolute;left: 1200px;font-size:20px"><input type="submit" value="Logout"></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px" id="user"> Welcome <%=hs.getAttribute("uname")%></li>
    
        
        <form action="Add_Teacher" method="post">
            <div class="Add"><h2>ADD TEACHER</h2><div>
                   
                    <p> NAME<input type="text" name="uname" pattern="[a-zA-Z].{2,15}" title="Inappropriate Name" required="true"></p>
                    <p>SURNAME<input type= "text" name="sname" pattern="[a-zA-Z].{2,15}" title="Inappropriate Name" required="true"></p>
                    <p> ID NUMBER<input type="text" name="id" pattern="[0-9].{3}" title="Enter Valid ID of Size 4" required="true"></p>
                    <p> PASSWORD<input type="text" name="pass" pattern="[0-9].{3}" title="Enter Valid ID of Size 4" required="true"></p>
                    <p>CONTACT NO<input type="text" name="contact" pattern="[789][0-9]\d{8}$" title="Enter Valid Contact No" required="true"></p>
                    <p>EMAIL ID<input type="text"  name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" Title="Enter Valid Email Id" required="true"></p>
                    <p><input type="submit" value="Add"></p>
                    
            
        </form>
  
   
    </body>
</html>
