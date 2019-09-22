<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String RollNo,Name,Contact;
 
    try{
            RollNo=request.getParameter("RollNo");
            Contact = request.getParameter("Contact");
            Name =request.getParameter("Name");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement ps = con.prepareStatement("update stud_register set Contact=? where RollNo=? and Name=?");
            ps.setString(1,Contact);
            ps.setString(2,RollNo);
            ps.setString(3,Name);
            int result = ps.executeUpdate();

            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
    catch(Exception e){
		out.println(e.toString());
	}
%>

