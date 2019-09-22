<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String RollNo ;
	try{
            
                RollNo=request.getParameter("RollNo");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		PreparedStatement ps=con.prepareStatement("Select * from stud_register where RollNo=?");
                ps.setString(1, RollNo);
                ResultSet rs=ps.executeQuery();
                
                
		JSONArray j_list = new JSONArray();
                
		while(rs.next())
		{
			JSONObject obj = new JSONObject();
			obj.put("Clss",rs.getString("Clss"));
			obj.put("Name",rs.getString("Name"));
			obj.put("RollNo",rs.getString("RollNo"));
                        obj.put("Contact",rs.getString("Contact"));
			
			j_list.put(obj);
		}
		out.println(j_list);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>

