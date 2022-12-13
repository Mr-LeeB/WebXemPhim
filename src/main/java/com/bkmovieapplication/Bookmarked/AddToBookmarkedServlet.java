package com.bkmovieapplication.Bookmarked;

import com.bkmovieapplication.entity.User;
import com.bkmovieapplication.model.BookmarkedDB;
import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddToBookmarkedServlet", urlPatterns = {"/addbookmarked"})
public class AddToBookmarkedServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesstion = request.getSession();
        User user = (User) sesstion.getAttribute("user");

        Integer userid = user.getUserId();
        String movieid = request.getParameter("mid");
        PrintWriter out = response.getWriter();
        BookmarkedDB bookmarked = new BookmarkedDB(request, response);
        //bookmarked.addOrDelMovieToBookmarked(user.getUserId(),id);
        if (!bookmarked.checkMovieExits(userid, movieid)) {
            bookmarked.addMovieToBookmarked(userid, movieid);
            out.print("Added to bookmarked!");
        } else {
            bookmarked.delMovieToBookmarked(userid, movieid);
            out.print("Removed to bookmarked!");
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
