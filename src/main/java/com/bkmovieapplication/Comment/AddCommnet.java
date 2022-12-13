package com.bkmovieapplication.Comment;

import com.bkmovieapplication.entity.*;
import com.bkmovieapplication.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddCommnet", urlPatterns = {"/addcomment"})
public class AddCommnet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String movieID = request.getParameter("movieID");
        String comment = request.getParameter("comment");
        
        CommentDB cmt = new CommentDB(request, response);
        cmt.addComment(movieID, user.getUserId(), comment);

        PrintWriter out = response.getWriter();
        out.print("<div class=\"dialogbox\">\n"
                + "<div class=\"body\">\n"
                + "<span>" + user.getUserName() + "</span>\n"
                + "<span class=\"tip tip-left\"></span>\n"
                + "<div class=\"message\">\n"
                + "<span>" + comment + "</span>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>");
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
