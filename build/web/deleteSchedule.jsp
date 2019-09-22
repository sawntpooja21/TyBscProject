<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    Integer Id; 
    try{
            Id = Integer.parseInt(request.getParameter("Id"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");    
            PreparedStatement ps = con.prepareStatement("Delete from schedule where Id=?");        
            ps.setInt(1,Id);
            int result = ps.executeUpdate();
            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
	catch(Exception e){
		out.println(e.toString());
	}
%>
