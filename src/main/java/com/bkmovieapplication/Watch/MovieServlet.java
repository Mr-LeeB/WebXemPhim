package com.bkmovieapplication.Watch;

import com.bkmovieapplication.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;

@WebServlet("/movie")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movie = request.getParameter("mID");
        String link = "https://2embed.org/embed/movie?tmdb=" + movie;
        request.setAttribute("movieLink", link);

        MovieDB amovie = new MovieDB(request, response);
        amovie.getAMovie(movie);

        forwardToPage("page/movie.jsp", request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
