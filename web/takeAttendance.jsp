<%@page import="java.io.BufferedReader"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    BufferedReader brdr = request.getReader();
    String str;
    StringBuilder sb = new StringBuilder();
    while((str = brdr.readLine()) != null){
        sb.append(str);
    }
    JSONArray list = new JSONArray(sb.toString());
    int i = 0;
    while(i<list.length()){
        JSONObject obj = (JSONObject)list.get(i);
        PreparedStatement ps = con.prepareStatement("insert into Attendance(RollNo,Name,date_,hour,subj,isPresent,Cls) values(?,?,?,?,?,?,?)");
        ps.setString(1,obj.getString("RollNo"));
        ps.setString(2,obj.getString("Name"));
        ps.setString(3,obj.getString("date_"));
        ps.setString(4,obj.getString("hour"));
        ps.setString(5,obj.getString("subj"));
        ps.setString(6,obj.getString("isPresent"));
        ps.setString(7,obj.getString("Cls"));
        System.out.println(obj.toString());
        int result = ps.executeUpdate();
        System.out.println("" + result);
        JSONObject res = new JSONObject();
        res.put("result",result);
        out.println(res.get("result"));
        i++;
    }
    
    
    
    
%>
