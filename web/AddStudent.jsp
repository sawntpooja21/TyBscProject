<%-- 
    Document   : AddStudent
    Created on : 4 Jan, 2018, 2:28:30 PM
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
        top: 55%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 450px;
        height: 500px;
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
   <li><a href='AddStudent.jsp'><span>Add</span></a></li>
   <li><a href='ViewStudent.jsp'><span>ViewAll</span></a>
   </li>
   <li><a href='UpdateStudent.jsp'><span>Update</span></a></li>
   <li><a href='DeleteStudent.jsp'><span>Delete</span></a></li>
   <li><a href='LecturePresent.jsp'><span>Lecture</span></a></li>
   <li><a href='TotalPercentage.jsp'><span>Total%</span></a></li>
   
    <form action='Admin_Logout' method="post" id="btn">
   <li  style="position:absolute;left: 1200px;font-size:20px;top: 13%"><input type="submit" value="Logout"  ></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px;top: 13%" id="user"> Welcome <%=hs.getAttribute("uname")%></li>
   
   <form action="Add_Student" method="post">
            <div class="Add"><h2>ADD STUDENT</h2><div>
                    
                    <p>SELECT CLASS : <select style="width: 150px;height: 30px;padding-left: 10px" name="clss" >
                            <option value="FYBsc">FyBsc</option>
                            <option value="SYBsc">SyBsc</option>
                            <option value="TYBsc">TyBsc</option>
                            <option value="MscCsI">MscCsI</option> 
                            <option value="MscCsII">MscCsII</option>
                        </select>
                    <br></br>
                    <p> NAME<input type="text" name="uname" pattern="[A-Za-z].{2,15}" title="Inappropriate Name" required="true"></p>               
                    <p> ROLL NUMBER<input type="text" name="rollno" name="rollno" pattern="[0-9].{3}" title="Enter Valid RollNo of Size 4" required="true"></p>
                    <%--<p>CONTACT NO<input type="text" name="contact" pattern="[0-9].{9}" title="Enter Valid Contact No" required="true">
                    --%><p>CONTACT NO<input type="text" name="contact" pattern="[789][0-9]\d{8}$" title="Enter Valid Contact No" required="true">
                    <p><input type="submit" value="Add" style="height:30px"></p>
                    
        </form>
      </body>
</html>
