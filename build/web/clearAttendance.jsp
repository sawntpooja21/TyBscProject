
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
  
	try{
            
                
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		PreparedStatement ps=con.prepareStatement("Delete From attendance");
                PreparedStatement ps2=con.prepareStatement("Delete from LectureCount");
                
                int result = ps.executeUpdate();
                int result1=ps2.executeUpdate();
            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
            JSONObject res2 = new JSONObject();
            res2.put("result",result1);
            out.println(res2.get("result"));
               
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>