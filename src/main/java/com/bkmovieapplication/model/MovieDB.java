/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.model;

import com.bkmovieapplication.entity.*;

import com.bkmovieapplication.dao.*;
import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MovieDB {

    private final MovieDAO movieDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public MovieDB(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        movieDAO = new MovieDAO();
    }

    public void searchByAjax(String txtSearch) throws ServletException, IOException {
        List<Movie> list = movieDAO.searchByName(txtSearch);
        PrintWriter out = response.getWriter();
        for(Movie o : list){
            out.println("<div class=\"item item__tag\">\n"
            +"                        <a href=\"watch?moviechoosed="+o.getMovieId()+">\n"
            +"                            <div class=\"item__content\">\n"
            +"                                <img class=\"img-fluid\" src=\""+o.getImagemin()+"\" alt=\"#\">\n"
            +"                                <span class=\"vote\">\n"
            +"                                    <span class=\"star\">"+o.getMovieStar()+"</span>\n"
            +"                                    <svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\"\n"
            +"                                        viewBox=\"0 0 1024 1024\" height=\"15\" width=\"15\"\n"
            +"                                        xmlns=\"http://www.w3.org/2000/svg \">\n"
            +"                                        <path\n"
            +"                                            d=\"M908.1 353.1l-253.9-36.9L540.7 86.1c-3.1-6.3-8.2-11.4-14.5-14.5-15.8-7.8-35-1.3-42.9 14.5L369.8 316.2l-253.9 36.9c-7 1-13.4 4.3-18.3 9.3a32.05 32.05 0 0 0 .6 45.3l183.7 179.1-43.4 252.9a31.95 31.95 0 0 0 46.4 33.7L512 754l227.1 119.4c6.2 3.3 13.4 4.4 20.3 3.2 17.4-3 29.1-19.5 26.1-36.9l-43.4-252.9 183.7-179.1c5-4.9 8.3-11.3 9.3-18.3 2.7-17.5-9.5-33.7-27-36.3z\">\n"
            +"                                        </path>\n"
            +"                                    </svg>\n"
            +"                                </span>\n"
            +"                                <div class=\"name\">"+o.getNameEnglish()+"</div>\n"
            +"                            </div>\n"
            +"                        </a>\n"
            +"                    </div>\n");
        }
    }

    public void searchByName() throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        List<Movie> list = movieDAO.searchByName(txtSearch);
        request.setAttribute("ListMovieSearch", list);
        forwardToPage("page/index.jsp", request, response);
    }

    public void getAMovie(String movieid) throws ServletException, IOException {
        Movie movie = movieDAO.getAMovieByID(movieid);
        if (movie != null) {
            request.setAttribute("movieWatchPage", movie);
        }
    }

    public void getListCategoryMovie(String category) throws ServletException, IOException {
        List<Movie> List = movieDAO.getCategoryMovie(category);
        if (List != null) {
            request.setAttribute(category, List);
        }
    }

    public void getALLMovie() throws ServletException, IOException {
        List<Movie> List = movieDAO.getALLMovie();
        if (List != null) {
            request.setAttribute("ListALLMovie", List);
        }
    }
}
