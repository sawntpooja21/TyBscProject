<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String Clss ;
	try{
            
                Clss=request.getParameter("Clss");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		PreparedStatement ps=con.prepareStatement("Select * from stud_register where Clss=? order by RollNo");
                ps.setString(1, Clss);
                ResultSet rs=ps.executeQuery();
                
                
		JSONArray j_list = new JSONArray();
                
		while(rs.next())
		{
			JSONObject obj = new JSONObject();
			
			obj.put("Name",rs.getString("Name"));
			obj.put("RollNo",rs.getString("RollNo"));
			
			j_list.put(obj);
		}
		out.println(j_list);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>
