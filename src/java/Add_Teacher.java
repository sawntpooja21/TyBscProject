/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREE
 */
public class Add_Teacher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String uname=request.getParameter("uname");
        String sname=request.getParameter("sname");
        String id=request.getParameter("id");
        String pass=request.getParameter("pass");
        String contact=request.getParameter("contact");
        String email=request.getParameter("email");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             try{
           Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
             PreparedStatement ps=con.prepareStatement("select uname from teacher where uname=?");
             ps.setString(1, uname);
            
             ResultSet rs=ps.executeQuery();
             
             int ab=0;
             
             
             
             while(rs.next()){
                 
                String a=rs.getString(1);
                ab=1;
                
             }
             
                if(ab == 1)
                {
                    
                    
                    out.print("'<script language=\"javascript\" type=\"text/javascript\">" +
                                    "alert('Already Registred.');" +
                                "</script>'");
                    RequestDispatcher rd=request.getRequestDispatcher("/AddTeacher.jsp");  
                    rd.include(request, response); 
                }
                
                if(ab == 0){
                    
            PreparedStatement psmt=con.prepareStatement("insert into teacher values(?,?,?,?,?,?)");
             psmt.setString(1, uname);
             psmt.setString(2, sname);
             psmt.setString(3, id);
             psmt.setString(4, pass);
             psmt.setString(5, contact);
             psmt.setString(6, email);
             psmt.executeUpdate();
              out.print("'<script language=\"javascript\" type=\"text/javascript\">" +
                                    "alert('Registred Successfully.');" +
                                "</script>'");
              RequestDispatcher rd=request.getRequestDispatcher("/AddTeacher.jsp");  
              rd.include(request, response);
                } 
             }
            catch(Exception ex){
                out.print(ex);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
