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

public class CommentDB {

    private final CommentDAO commentDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CommentDB(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        commentDAO = new CommentDAO();
    }

    public List<Comment> getComment(String movieId) {
        List<Comment> list = commentDAO.getComment(movieId);
        request.setAttribute("commentList", list);
        return list;
    }

    public void addComment(String movieId, Integer userId, String comment) {
        commentDAO.addComment(movieId, userId, comment);
    }
}
