
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, org.json.*" %>
<%
    String uname,pass;
 
    try{
            uname=request.getParameter("uname");
            pass = request.getParameter("pass");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement ps = con.prepareStatement("update teacher set pass=? where uname=?");
            ps.setString(1,pass);
            ps.setString(2,uname);
            
            int result = ps.executeUpdate();

            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
    catch(Exception e){
		out.println(e.toString());
	}
%>