
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    int Id;
    Id=Integer.parseInt(request.getParameter("Id"));
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		PreparedStatement ps=con.prepareStatement("Select * from schedule where Id=?");
                ps.setInt(1, Id);
                ResultSet rs=ps.executeQuery();
		JSONArray j_list = new JSONArray();
		while(rs.next())
		{
			JSONObject obj = new JSONObject();
                        obj.put("Id",rs.getString("Id"));
			obj.put("cl",rs.getString("cl"));
			obj.put("day",rs.getString("day"));
			obj.put("subject",rs.getString("subject"));
			obj.put("time_s",rs.getString("time_s"));
			j_list.put(obj);
		}
		out.println(j_list);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
%>