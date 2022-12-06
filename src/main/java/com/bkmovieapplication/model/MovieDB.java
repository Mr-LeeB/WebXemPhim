/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.model;

import com.bkmovieapplication.entity.*;

import com.bkmovieapplication.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    
    public void getAMovie(String movieid) throws ServletException, IOException {
        Movie movie = movieDAO.getAMovieByID(movieid);
        if(movie != null){
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
