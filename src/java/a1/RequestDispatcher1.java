/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package a1;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author hp
 */
public class RequestDispatcher1 extends HttpServlet {
   
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
        String unm=request.getParameter("un");
        String upwd=request.getParameter("pwd");
        
        try
        {
            if(unm.equals("ouat") && upwd.equals("1234"))
            {
                 RequestDispatcher rd1=request.getRequestDispatcher("RequestDispatcher2");
                 rd1.forward(request,response);
            }
            else
            {
                out.println("Wrong Userid and password.");
                RequestDispatcher rd2=request.getRequestDispatcher("RequestDispatcher.html");
                rd2.include(request, response);
            }
        } 
        catch(Exception e)
        {
            
        }
        finally 
        {
            
        } 
            out.close();
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