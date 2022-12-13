/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.dao;

import com.bkmovieapplication.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bkmovieapplication.context.DBContext;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dbquery = "quanlyphimdb";//oj3bOO0Agn";

    public List<Comment> getComment(String movieId) {
        List<Comment> list = new ArrayList<>();
        String query = "select cmtID, movieID, comment.userID, comment, userName from "
                + dbquery + ".comment, " + dbquery + ".user\n"
                + "where comment.userID = user.userId and movieID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, movieId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void addComment(String movieId, Integer userId, String comment) {
        String query = "insert " + dbquery + ".comment\n"
                + "(movieID,userID,comment)\n"
                + "values(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, movieId);
            ps.setInt(2, userId);
            ps.setString(3, comment);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(new CommentDAO().getComment("436270"));
        } catch (Exception e) {
        }
    }
}
