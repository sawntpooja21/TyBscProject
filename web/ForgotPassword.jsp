<%-- 
    Document   : ForgotPassword
    Created on : 1 Feb, 2018, 10:58:53 PM
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
    body{
        margin: 0;
        padding: 0;
        background: url(backg.jpg);
        background-size: cover;
        font-family: sans-serif;
    }
    .loginBox{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 350px;
        height: 450px;
        box-sizing: border-box;
        padding: 50px;
        background: rgba(0,0,0,.5);
    }
    h2{
        margin: 0;
        padding: 0 0 20px;
        color: #efed40;
        text-align: center;
    }
    .loginBox p{
        margin: 0;
        padding: 0;
        font-weight: 200;
        color: #fff;
    }
    .loginBox input{
        width: 100%;
        margin-bottom: 20px;
    }
    .loginBox input[type="text"],
    .loginBox input[type="password"]
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
       <form action="EmailPass.jsp" method="post">
            <div class="loginBox"><h2>FORGOT PASSWORD</h2><div>
                    <%
                        HttpSession hs=request.getSession();
                        if(hs.getAttribute("uname") != null)
                        {%>
                        <script language=\"javascript\" type=\"text/javascript\">" +
                                    "alert('User Already Logged in');" +
                                "</script>
                    <%
                            response.sendRedirect("home.jsp");
                            
                        }
                    %>
                        <p> USERNAME<input type="text" name="uname" pattern="[a-zA-Z].{2,15}" title="Inappropriate Name" required="true"></p>
                        <p> EMAIL<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter valid Email ID" required="true"></p>
                    
          
                    <p><input type="submit" value="Send Mail" ></p>
                    <p style="color: #fff;"><a href="AdminLogin.jsp">Login Page</a></p>
            
        </form>
    </body>
</html>
