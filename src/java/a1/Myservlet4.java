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
public class Myservlet4 extends HttpServlet {
   
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
        
        Cookie ck[]=request.getCookies();
        String s=ck[0].getValue();
            
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from studentform1");
            
            while (rs.next())
            {
                if(s.equals(rs.getString(1)))
                {
                    out.println("<h1 align='center'><u>Student Information Details are here. </u></h1>");
                    out.println("<table border='1' cellspacing='5' cellpadding='5x' align='center'> <tr><td align='right'>RollNo:</td><td> " + rs.getString(1) + "</td></tr> ");
                    out.println(" <tr><td align='right'>Password:</td><td> " + rs.getString(2) + "</td></tr>");
                    out.println(" <tr><td align='right'>Name:</td><td> " + rs.getString(3) + "</td></tr>");
                    out.println(" <tr><td align='right'>Father's Name:</td><td> " + rs.getString(4) + "</td></tr>");
                    out.println(" <tr><td align='right'>Mother's Name:</td><td> " + rs.getString(5) + "</td></tr>");
                    out.println(" <tr><td align='right'>Email:</td><td> " + rs.getString(6) + "</td></tr>");
                    out.println(" <tr><td align='right'>Address:</td><td> " + rs.getString(7) + "</td></tr>");
                    out.println(" <tr><td align='right'>Country:</td><td> " + rs.getString(8) + "</td></tr>");
                    out.println(" <tr><td align='right'>Gender:</td><td> " + rs.getString(9) + "</td></tr></table>");
                    out.println(" <tr><td align='right'>Qualification:</td><td> " + rs.getString(10) + "</td></tr></table>");
                }
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
    // </editor-fold>
}
