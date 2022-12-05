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

public class BookmarkedDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dbquery = "oj3bOO0Agn";

    public boolean delete(Integer userId, String movieId) {
        String query = "delete from " + dbquery + ".bookmarked \n"
                + "where userid = ? and movieid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, movieId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public List<Bookmarked> getALLBookmarked() {
        List<Bookmarked> List = new ArrayList<>();
        String query = "select * from oj3bOO0Agn.bookmarked";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new Bookmarked(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3)
                ));
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }
    public List<Movie> getMovieInBookmarked(Integer userid) {
        List<Movie> List = new ArrayList<>();
        String query = "select movie.movieId, movieName, movieStar, category, description, movieLink, imageLink\n"
                + "                from oj3bOO0Agn.movie, oj3bOO0Agn.bookmarked\n"
                + "                where movie.movieId = bookmarked.movieid and userid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new Movie(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new BookmarkedDAO().getMovieInBookmarked(3));
        } catch (Exception e) {
        }
    }
}
