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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public void getMovieUpComing() throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getMovieUpComing();
        if (List != null) {
            request.setAttribute("ListMovieUpComing", List);
        }
    }

    public void getMovieHot() throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getMovieHot();
        if (List != null) {
            request.setAttribute("ListMovieHot", List);
        }
    }

    public void getMovieTopRated() throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getMovieTopRated();
        if (List != null) {
            request.setAttribute("ListMovieTopRated", List);
        }
    }

    public void getMoviePopular() throws ServletException, IOException {
        List<Movie> List = new ArrayList<>();
        List = movieDAO.getMoviePopular();
        if (List != null) {
            request.setAttribute("ListMoviePopular", List);
        }
    }

    public void searchByAjax(String txtSearch) throws ServletException, IOException {
        List<Movie> list = movieDAO.searchByName(txtSearch);
        PrintWriter out = response.getWriter();
        for (Movie o : list) {
            out.println("<li>\n"
                    + "                                <h2>\n"
                    + "                                    <img class=\"img-fluid\" src=\""+o.getImagemin()+"\" alt=\"#\">\n"
                    + "                                </h2>\n"
                    + "                                <h3>"+o.getNameEnglish()+"+</h3>\n"
                    + "                                <p>\n"
                    + "                                    "+o.getCategory()+"\n"
                    + "                                </p>\n"
                    + "                                <a href=\"dodelete?movieID="+o.getMovieId()+"\">\n"
                    + "                                    <button type=\"button\">Delete</button>\n"
                    + "                                </a>\n"
                    + "                                <a href=\"watch?moviechoosed="+o.getMovieId()+"\">\n"
                    + "                                    <button>Watch</button>\n"
                    + "                                </a>\n"
                    + "                            </li>");
        }
    }

    public void searchByName() throws ServletException, IOException {
        String txtSearch = request.getParameter("input_search");
        List<Movie> list = movieDAO.searchByName(txtSearch);
        if (list != null) {
            request.setAttribute("ListMovieSearch", list);
            request.setAttribute("CheckSearch", true);
        } else {
            request.setAttribute("CheckSearch", false);
        }
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
