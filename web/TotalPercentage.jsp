<%-- 
    Document   : TotalPercentage
    Created on : 2 Feb, 2018, 9:59:35 AM
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
   
   <form >
 <p style="font-weight: bold;position:absolute;left: 380px;color: #330033;font-size: 18px;top: 16%;">SELECT CLASS : <select style="font-size: 18px;" name="clss" id="clss" >
                            <option value="FYBsc">FyBsc</option>
                            <option value="SYBsc">SyBsc</option>
                            <option value="TYBsc">TyBsc</option>
                            <option value="MscCsI">MscCsI</option> 
                            <option value="MscCsII">MscCsII</option>
                        </select>
                    <br></br>
                    <li style="position:absolute;left: 550px;color: #330033;top:24%"><input type="button" id="Search" value="View" onclick="sendInfo()" style="font-size: 19px;top: 26%;height: 30%;width: 100%;"></li>
                    <span id="tb"></span>
    </body>
    <script>
   var request;

function sendInfo()
{
    var v=document.getElementById("clss").value;
    console.log(v+"");
    var url="TotalView.jsp?val="+v;

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
}
}
</script>
</html>
