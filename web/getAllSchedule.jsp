<%@ page import="java.sql.*, org.json.*" %>
<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from schedule order by subject");
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