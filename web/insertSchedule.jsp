<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String cl,day,subject,time_s ;
 
    try{
            cl=request.getParameter("cl");
            day=request.getParameter("day");
            subject=request.getParameter("subject");
            time_s = request.getParameter("time_s");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
           
            PreparedStatement ps = con.prepareStatement("insert into schedule(cl,day,subject,time_s ) values(?,?,?,?);");
            ps.setString(1, cl);
            ps.setString(2,day);
            ps.setString(3,subject);
            ps.setString(4,time_s);
            int result = ps.executeUpdate();

            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
	catch(Exception e){
		out.println(e.toString());
	}
%>

