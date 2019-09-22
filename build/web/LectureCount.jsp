<%-- 
    Document   : LectureCount
    Created on : 3 Feb, 2018, 9:59:41 PM
    Author     : SHREE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.sql.*"%>
<%
   String clss=request.getParameter("val");
   String dat=request.getParameter("val1");
   String sub=request.getParameter("val2");
   
   /*if(clss==null)
   {
       out.print("<Script>Enter Valid No</script>");
   }
   else{*/
       try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
       PreparedStatement ps=con.prepareStatement("select distinct RollNo,Name from Attendance where Cls=? and subj=? and date_=? order by RollNo;");
      ps.setString(1,clss);
       ps.setString(2,sub);
       ps.setString(3,dat);
       ResultSet rs=ps.executeQuery();
      
%>
       
       <table align="center" cellspacing="0" border-collapse="collapse"  style="border: 1px solid black; width:80%;"><br><br><br><br><br><br><br><br><br>
           
           <tr>
               <th border-collapse="collapse" style="border: 1px solid black;">RollNo</th>
               <th style="border: 1px solid black;">Name</th>
                 
               
           </tr>
           <%while(rs.next())
       {
           %>
           <tr border-collapse="collapse">
               <td border-collapse="collapse" style="border: 1px solid black;text-align: center">
                   <%=rs.getString(1)%>
               </td>
               <td border-collapse="collapse" style="border: 1px solid black;text-align: center;">
                   <%=rs.getString(2)%>
               </td>
               
               
           </tr>
               

<%
       }
%>
       </table>

<%
       }
       catch(Exception Ex)
       {
        out.print(Ex);
       }
   
%>

    </body>
</html>
