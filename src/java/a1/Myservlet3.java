/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package a1;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Statement;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author hp
 */
public class Myservlet3 extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        String rollno=request.getParameter("un");
        String password=request.getParameter("pwd");
        
       int k=0; 
        
        try 
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select rollno,password from studentform1");
        
        
        out.println(rollno+password);
        while(rs.next())
        {
            String rn=rs.getString(1);
            String pw=rs.getString(2);
            
            if(rollno.equals(rn) && password.equals(pw))
            {
               out.println("<html> <body> <center>Login Successful.<br> Kindly provide us some time to fetch Student Information Details from our database. </center></body></html>");
               response.setHeader("Refresh", "3;url=Myservlet4");
               k=1;
               break;
            }
        } 
        if(k==0)
        {
            RequestDispatcher rd=request.getRequestDispatcher("StudentLogin.html");  
            rd.include(request, response);  
            out.println("<center>Login Unsuccessful.<br> Student credentials not found .</center>");
        }
        }
        
        catch(Exception e)
        {
            
        }
        finally 
        { 
            out.close();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
}
    // </editor-fold>
