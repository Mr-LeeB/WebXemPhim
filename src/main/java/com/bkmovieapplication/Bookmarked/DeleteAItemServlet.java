package com.bkmovieapplication.Bookmarked;

import com.bkmovieapplication.entity.*;
import com.bkmovieapplication.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteAItemServlet", urlPatterns = {"/dodelete"})
public class DeleteAItemServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesstion = request.getSession();
        User userr = (User) sesstion.getAttribute("user");
        String movieId = request.getParameter("movieID");

        BookmarkedDB bookmarked = new BookmarkedDB(request, response);
        bookmarked.deleteMovieInBookmarked(userr.getUserId(), movieId);
        response.sendRedirect("bookmarked");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
