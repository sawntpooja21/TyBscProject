<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>

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
   <li><a href='UpdateStudent.jsp'><span>Update </span></a></li>
   <li><a href='DeleteStudent.jsp'><span>Delete</span></a></li>
    <li><a href='LecturePresent.jsp'><span>Lecture</span></a></li>
   <li><a href='TotalPercentage.jsp'><span>Total%</span></a></li>
</ul>
    <form action='Admin_Logout' method="post" id="btn">
   <li  style="position:absolute;left: 1200px;font-size:20px;top: 13%"><input type="submit" value="Logout"  ></li>
   </form>
   <li style="position:absolute;left: 1050px;color: #330033;font-size: 20px;top: 13%" id="user"> Welcome <%=hs.getAttribute("uname")%></li>
  
   <form>
       <p style="font-weight: bold;position:absolute;left: 380px;color: #330033;font-size: 18px;top: 16%;">SELECT CLASS : <select name="clss" style="font-size: 18px;" id="clss" >
                            <option value="FYBsc">FYBsc</option>
                            <option value="SYBsc">SYBsc</option>
                            <option value="TYBsc">TYBsc</option>
                           <option value="MscCsI">MscCsI</option> 
                            <option value="MscCsII">MscCsII</option>
       </p>
           </select>
       <%-- <li >Enter Class :&nbsp;&nbsp;<input type="text" id="clss"></li> --%>

       <li style="position:absolute;left: 550px;color: #330033;top:24%"><input type="button" id="Search" value="View" onclick="sendInfo()" style="font-size: 19px;top: 26%;height: 30%;width: 100%;"></li>


        <span id="tb"></span>
           
       </form>

   <script>
   var request;

function sendInfo()
{
    var v=document.getElementById("clss").value;
    console.log(v+"");
    var url="view.jsp?val="+v;

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
        </body>
       </html>