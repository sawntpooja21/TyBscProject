<%-- 
    Document   : LecturePresent
    Created on : 1 Feb, 2018, 11:25:11 PM
    Author     : SHREE
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
   <li><a href='LecturePresent.jsp'><span>Lecture</span></a>
   <li><a href='TotalPercentage.jsp'><span>Total%</span></a>
      
       
   </li></ul>
    <form action='Admin_Logout' method="post" id="btn">
   <li  style="position:absolute;left: 1200px;font-size:20px;top: 13%"><input type="submit" value="Logout"  ></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px;top: 13%" id="user"> Welcome <%=hs.getAttribute("uname")%></li>
   

        <form>
                    <p style="font-weight: bold;position:absolute;left: 420px;color: #330033;font-size: 18px;top: 16%;">SELECT CLASS : <select style="font-size: 18px;" name="clss" id="clss" >
                            <option value="FYBsc">FyBsc</option>
                            <option value="SYBsc">SyBsc</option>
                            <option value="TYBsc">TyBsc</option>
                            <option value="MscCsI">MscCsI</option>
                            <option value="MscCsII">MscCsII</option>
                            
                        </select>
                    <br></br>
                    <li style="position:absolute;left: 550px;color: #330033;top:24%"><input type="button" id="Search" value="View" onclick="sendInfoClss()" style="font-size: 19px;top: 26%;height: 30%;width: 100%;"></li>
                    <span id="tb"></span>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/project";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<form action="#">
<%
Connection con = null;
PreparedStatement ps = null;
PreparedStatement ps2=null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "SELECT Distinct date_ FROM Attendance";
ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

String sql2="Select Distinct subj From Attendance";
 ps2=con.prepareStatement(sql2);
ResultSet rs2=ps2.executeQuery();
%>
<p style="font-weight: bold;position:absolute;left: 150px;color: #330033;font-size: 18px;top:16% ">SELECT DATE :
    <select name="date" id="date" style="font-size: 18px;">
<%
while(rs.next())
{
String date_ = rs.getString("date_"); 
%>
<option value="<%=date_ %>" name="date"><%=date_ %></option>
<%
}
%>
</select>
</p>
<p style="font-weight: bold;position:absolute;left: 730px;color: #330033;font-size: 18px;top:16% ">SELECT SUBJECT :
    <select name="sub" id="sub" style="font-size: 18px;">
<%
while(rs2.next())
{
String subject = rs2.getString("subj"); 
%>
<option value="<%=subject %>"><%=subject %></option>
<%
}
%>
</select>
</p>
<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>
</form>
    </body>
        <script>
   var request;

function sendInfoClss()

{
    var v2=document.getElementById("sub").value;
    var v1=document.getElementById("date").value;
    var v=document.getElementById("clss").value;
    console.log(v+"");
    var url="LectureCount.jsp?val="+v+"&val1="+v1+"&val2="+v2;
    
    
    console.log(v1+"");
    var url1="LectureCount.jsp?val1="+v1;
    
    
    console.log(v2+"");
    var url2="LectureCount.jsp?val2="+v2;

    if(window.XMLHttpRequest){
        request=new XMLHttpRequest();
    }
    else if(window.ActiveXObject){
        request=new ActiveXObject("Microsoft.XMLHTTP");
    }

    try
    {
        request.onreadystatechange=getInfo;
        request.open("GET",url,true);
        
        request.send();
    }
    catch(e)
    {
        alert("Unable to connect to server");
    }
}

function getInfo(response){
console.log(response.toString())
if(request.readyState==4){
var val=request.responseText;
console.log(val+"")
document.getElementById("tb").innerHTML=val;

var val1=request.responseText;
console.log(val1+"")
document.getElementById("tb").innerHTML=val1;

var val2=request.responseText;
console.log(val2+"")
document.getElementById("tb").innerHTML=val2;
}
}
</script>
</html>
