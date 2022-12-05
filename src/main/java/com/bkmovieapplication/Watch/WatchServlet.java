package com.bkmovieapplication.Watch;

import com.bkmovieapplication.entity.*;
import com.bkmovieapplication.model.MovieDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import javax.servlet.http.HttpSession;

@WebServlet("/watch")
public class WatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesstion = request.getSession();
        String movie = (String) sesstion.getAttribute("moviechoosed");

        MovieDB amovie = new MovieDB(request, response);
        amovie.getAMovie(movie);
        
        forwardToPage("page/watch.jsp", request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
