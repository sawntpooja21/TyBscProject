<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
  
	try{
            
                
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		PreparedStatement ps=con.prepareStatement("Delete From schedule");
                
                int result = ps.executeUpdate();
            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
               
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>