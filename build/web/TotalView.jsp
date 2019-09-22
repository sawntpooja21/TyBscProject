<%-- 
    Document   : TotalView
    Created on : 2 Feb, 2018, 10:47:06 AM
    Author     : SHREE
--%>

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
       PreparedStatement ps=con.prepareStatement("Select distinct Name,RollNo from Attendance where Cls=? order by rollno");
       ps.setString(1,clss);
       ResultSet rs=ps.executeQuery();
       PreparedStatement ps2=con.prepareStatement("Select count(lect_date) as c1 from LectureCount where Clss=?");
             ps2.setString(1,clss); 
             int a=0;
              ResultSet rs3 = ps2.executeQuery();
              
             while (rs3.next()){
                    a=Integer.parseInt(rs3.getString("c1"));
                    //out.print("count "+a);
             }
%>
       
       <table align="center" cellspacing="0" border-collapse="collapse"  style="border: 1px solid black; width:80%;"><br><br><br><br><br><br><br><br><br>
           
           <tr>
               <th border-collapse="collapse" style="border: 1px solid black;">Name</th>
               <th style="border: 1px solid black;"> RollNo</th>
               <th style="border: 1px solid black;"> Percentage</th>
                   
               
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
               
               <% String roll=rs.getString(2);
               PreparedStatement psmt1=con.prepareStatement("select count(isPresent) as c2 from Attendance where RollNo=? and Cls=?");
              psmt1.setString(1, roll);
              psmt1.setString(2,clss);
               Double b=0.0;
               
               ResultSet rs1 = psmt1.executeQuery();
             while (rs1.next()){
                    b=Double.parseDouble(rs1.getString("c2"));
             }%>
               <td border-collapse="collapse" style="border: 1px solid black;text-align: center">
                   <%=((b/a)*100)+""%>
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
