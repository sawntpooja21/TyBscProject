<%-- 
    Document   : ViewTeacher
    Created on : 16 Jan, 2018, 3:17:31 PM
    Author     : SHREE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
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
        <title>View Teacher</title>
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
   <li><a href='AddTeacher.jsp'><span>Add Teacher</span></a></li>
   <li><a href='ViewTeacher.jsp'><span>View Records</span></a>
   </li>
   
   <li></li>
</ul>
</div>
   <form action='Admin_Logout' method="post" id="btn">
   <p style="position:absolute;left: 1200px;font-size:20px;top: 10%"><input type="submit" value="Logout"  ></p>
   </form>
        <form>
   <p style="position:absolute;left: 1050px;color: #330033;font-size: 20px;top: 10%" id="user"> Welcome <%=hs.getAttribute("uname")%></p>
   
   <h2 align="center" style="color: #330033;font-size: 40px; top: 10%;text-decoration: underline">FACULTY</h2></form>
       <table align="center" cellspacing="0" style="border: 1px solid black; width:50%;top: 1%">
           
           <tr>
               
               <th style="border: 1px solid black;"> NAME </th>
               <th style="border: 1px solid black;">
                   SURNAME
               </th>
               <th style="border: 1px solid black;"> ID </th>
               <th style="border: 1px solid black;"> CONTACT</th>
               
           </tr>
           <%
           try {

String connectionURL = "jdbc:mysql://localhost:3306/project";

Connection connection = null;


Statement statement = null;

ResultSet rs = null;

Class.forName("com.mysql.jdbc.Driver").newInstance();

connection = DriverManager.getConnection(connectionURL, "root", "root");

statement = connection.createStatement();

String QueryString = "SELECT * from teacher";
rs = statement.executeQuery(QueryString);
%>

<%
while (rs.next()) {
%>
<tr border-collapse="collapse">
<td border-collapse="collapse" style="border: 1px solid black;text-align: center"><%=rs.getString(1)%></td>
<td border-collapse="collapse" style="border: 1px solid black;text-align: center"><%=rs.getString(2)%></td>
<td border-collapse="collapse" style="border: 1px solid black;text-align: center"><%=rs.getString(3)%></td>
<td border-collapse="collapse" style="border: 1px solid black;text-align: center"><%=rs.getString(5)%></td>
</tr>
<% } %>
<%
// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>

<%
out.println("Unable to connect to database.");
}
%>
   
</TABLE>
    </body>
</html>
