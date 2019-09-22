<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*,java.util.Date" %>
<%
    String subject,Clss ;
    Date lect_date;
    
 
    try{
            subject = request.getParameter("subject");
            lect_date = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("lect_date"));
            Clss = request.getParameter("Clss");
            java.sql.Date sqlDate=new java.sql.Date(lect_date.getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement ps = con.prepareStatement("insert into LectureCount(subject,lect_date,Clss) values(?,?,?)");
            ps.setString(1,subject);
            ps.setDate(2,sqlDate);
            ps.setString(3,Clss);
            int result = ps.executeUpdate();

            JSONObject res = new JSONObject();
            res.put("result",result);
            out.println(res.get("result"));
    }
	catch(Exception e){
		out.println(e.toString());
	}
%>
