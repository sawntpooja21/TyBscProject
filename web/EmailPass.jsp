<%-- 
    Document   : EmailPass
    Created on : 2 Feb, 2018, 3:28:25 PM
    Author     : SHREE
--%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.MimeMessage"%>

<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <body>
        <%
       String uname=request.getParameter("uname");
       String emailid = request.getParameter("email");
       final String from = "attendance77@gmail.com";		
       final String pass = "01234567abc";              
       String pwd="",name="";
       if(emailid != null && uname!=null)
       {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
        PreparedStatement ps = con.prepareStatement("select uname,pass from admin where email=? and uname=?");
        ps.setString(1,emailid);
        ps.setString(2,uname);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            pwd = rs.getString(2);
            name=rs.getString(1);
        } 
            if(pwd.equals("") && name.equals("")){
                out.println("<script>alert('Enter a Registered Username and Email-ID')</script>");
            
                RequestDispatcher rd=request.getRequestDispatcher("/AdminLogin.jsp");
                rd.include(request, response);
            }
            else{
            String host = "smtp.gmail.com";
            String port = "465";
          Properties properties = System.getProperties();
              properties.put("mail.smtp.host",host);
              properties.put("mail.smtp.socketFactory.port",port);
              properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
              properties.put("mail.smtp.auth","true");
              properties.put("mail.smtp.port",port);
              properties.put("mail.smtp.starttls.enable","true");
          Session sess = Session.getInstance(properties,new javax.mail.Authenticator(){
                      protected PasswordAuthentication getPasswordAuthentication(){
                              return new PasswordAuthentication(from,pass);
                      }
              });
          try{
             MimeMessage message = new MimeMessage(sess);
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailid));
             message.setSubject("Reset Password");
             message.setText("Request accepted Successfully \n Username: "+uname+" " 
                     + "\n EmailID : "+emailid+" ,"
                     + "\n Password : ' "+pwd+" '."
                     + "\n You Can Now Login Your Account.");
             Transport.send(message);
             out.println("<script>alert('MAIL SEND SUCCESSFULLY!!!')</script>");
              RequestDispatcher rd=request.getRequestDispatcher("/AdminLogin.jsp");
              rd.include(request, response);

          }catch (Exception ex) {
              out.print(ex);}
            }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    
       }
    %>
    </body>
</html>