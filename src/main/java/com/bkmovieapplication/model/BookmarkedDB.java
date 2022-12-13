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

import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;

public class BookmarkedDB {

    private final BookmarkedDAO bookmarkedDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public BookmarkedDB(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        bookmarkedDAO = new BookmarkedDAO();
    }

    public boolean checkMovieExits(Integer userId, String movieId)throws ServletException, IOException {
        return bookmarkedDAO.checkExit(userId, movieId) == true;
    }
    
    public void addMovieToBookmarked(Integer userId, String movieId)throws ServletException, IOException {
        bookmarkedDAO.add(userId, movieId);
    }
    public void delMovieToBookmarked(Integer userId, String movieId)throws ServletException, IOException {
        bookmarkedDAO.delete(userId, movieId);
    }

    public void getALLMovieInBookmarked() throws ServletException, IOException {
        List<Bookmarked> List = bookmarkedDAO.getALLBookmarked();
        request.setAttribute("ListAllBookmarked", List);
    }

    public void deleteMovieInBookmarked(Integer userId, String movieId) throws ServletException, IOException {
        boolean del = bookmarkedDAO.delete(userId, movieId);
//        if (del == true) {
//            forwardToPage("bookmarked", "Delete Success!", request, response);
//        }
//        forwardToPage("bookmarked", "Delete fail!", request, response);
    }

    public void getMovieInBookmarked(Integer userId) throws ServletException, IOException {
        List<Movie> List = bookmarkedDAO.getMovieInBookmarked(userId);

        request.setAttribute("ListMovieInBookmarked", List);

    }
}
