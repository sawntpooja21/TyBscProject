
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%
   String clss=request.getParameter("val");
   
   if(clss==null)
   {
       out.print("<Script>Enter Valid No</script>");
   }
   else{
       try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
       PreparedStatement ps=con.prepareStatement("Select * from stud_register where Clss=?");
       ps.setString(1,clss);
       ResultSet rs=ps.executeQuery();%>
       
       <table align="center" cellspacing="0" border-collapse="collapse"  style="border: 1px solid black; width:80%;"><br><br><br><br><br><br><br><br><br>
           
           <tr>
               <th border-collapse="collapse" style="border: 1px solid black;">CLASS</th>
               <th style="border: 1px solid black;"> NAME </th>
               <th style="border: 1px solid black;">
                   ROLLNO
               </th>
               <th style="border: 1px solid black;"> CONTACTNO </th>
               
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
               <td border-collapse="collapse" style="border: 1px solid black;text-align: center;">
                   <%=rs.getString(3)%>
               </td>
               <td border-collapse="collapse" style="border: 1px solid black;text-align: center">
                   <%=rs.getString(4)%>
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
   }
%>