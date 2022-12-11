/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.model;

import com.bkmovieapplication.entity.*;

import com.bkmovieapplication.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class MovieDB {

    private final MovieDAO movieDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public MovieDB(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        movieDAO = new MovieDAO();
    }

    public boolean checkDuplicateID() throws ServletException, IOException {
        String mID = request.getParameter("movieID");
        return movieDAO.checkDuplicate(mID);
    }
    public void addMovie() throws ServletException, IOException, ParseException {
        String mID = request.getParameter("movieID");
        String nameEnglish = request.getParameter("nameEnglish");
        String nameVietnamese = request.getParameter("nameVietNam");
        String movieStar = request.getParameter("rating");
        String releasedate = request.getParameter("releasedate");
        // covert string to sql date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = formatter.parse(releasedate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String description = request.getParameter("description");
        String imagemax = request.getParameter("backdropPath");
        String imagemin = request.getParameter("posterPath");
        String spanlist = request.getParameter("type");
        String trailerLink = request.getParameter("trailerPath");
        String category = request.getParameter("category");

        movieDAO.add(mID, nameEnglish, nameVietnamese, movieStar,
                sqlDate, description, imagemax, imagemin, spanlist, trailerLink, category);
    }

    public void deleteMovie() throws ServletException, IOException, ParseException {
        String mID = request.getParameter("movieid");
        movieDAO.delete(mID);
    }

    public void updateMovie() throws ServletException, IOException, ParseException {
        String mID = request.getParameter("movieid");
        String nameEnglish = request.getParameter("nameEnglish");
        String nameVietnamese = request.getParameter("nameVietNam");
        String movieStar = request.getParameter("rating");
        String releasedate = request.getParameter("releasedate");
        // covert string to sql date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = formatter.parse(releasedate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String description = request.getParameter("description");
        String imagemax = request.getParameter("backdropPath");
        String imagemin = request.getParameter("posterPath");
        String spanlist = request.getParameter("type");
        String trailerLink = request.getParameter("trailerPath");
        String category = request.getParameter("category");

        movieDAO.update(mID, nameEnglish, nameVietnamese, movieStar,
                sqlDate, description, imagemax, imagemin, spanlist, trailerLink, category);
    }

    public void getAMovie(String category) throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getCategoryMovie(category);
        if (List != null) {
            request.setAttribute(category, List);
        }
    }

    public void getALLMovie() throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getALLMovie();
        if (List != null) {
            request.setAttribute("ListALLMovie", List);
        }
    }

    public void getMovieInBookmarked(Integer userId) throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getMovieInBookmarked(userId);
        if (List != null) {
            request.setAttribute("ListMovieInBookmarked", List);
        }
    }
}
