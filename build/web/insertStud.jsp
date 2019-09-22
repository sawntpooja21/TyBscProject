<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String Clss,RollNo,Name,Contact ;
 
    try{
            Clss=request.getParameter("Clss");
            Name=request.getParameter("Name");
            RollNo=request.getParameter("RollNo");
            Contact = request.getParameter("Contact");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement ps = con.prepareStatement("insert into stud_register(Clss,Name,RollNo,Contact ) values(\""+Clss+"\",\""+Name+"\",\""+RollNo+"\","+Contact+")");
            
            int result = ps.executeUpdate();

            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
	catch(Exception e){
		out.println(e.toString());
	}
%>
