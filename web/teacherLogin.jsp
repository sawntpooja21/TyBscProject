<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String uname,pass;
    try{
            uname=request.getParameter("uname");
            pass=request.getParameter("pass");
            JSONObject res = new JSONObject();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement stmt = con.prepareStatement("select uname, Pass from teacher where uname=? and pass=?");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
            ResultSet result = stmt.executeQuery();
			
			if (result.next()) {
                            res.put("uname",uname);
				out.println("1");
			}
			else {
				out.println("0");
                                res.put("uname",0);
			}
                        out.println(res);
    }
	catch(Exception e){
		out.println(e.toString());
	}
%>
