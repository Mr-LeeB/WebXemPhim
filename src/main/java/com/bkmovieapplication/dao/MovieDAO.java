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
import java.sql.Date;

public class MovieDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dbquery = "moviedb";// oj3bOO0Agn

    public boolean checkDuplicate(String mID) {
        String query = "select * from " + dbquery + ".movie\n"
                + "where movieId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void add(String mID, String nameEnglish, String nameVietnamese, String movieStar,
            Date releasedate, String description, String imagemax, String imagemin, String spanlist,
            String trailerLink, String category) {
        String query = "insert into " + dbquery + ".movie\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mID);
            ps.setString(2, nameEnglish);
            ps.setString(3, nameVietnamese);
            ps.setString(4, movieStar);
            ps.setDate(5, releasedate);
            ps.setString(6, description);
            ps.setString(7, imagemax);
            ps.setString(8, imagemin);
            ps.setString(9, spanlist);
            ps.setString(10, trailerLink);
            ps.setString(11, category);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void delete(String mID) {
        String query = "delete from " + dbquery + ".movie\n"
                + "where movieId = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mID);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public boolean update(String mID, String nameEnglish, String nameVietnamese, String movieStar,
            Date releasedate, String description, String imagemax, String imagemin, String spanlist,
            String trailerLink, String category) {
        String query = "update " + dbquery + ".movie\n"
                + "set nameEnglish = ?, nameVietnamese = ?, movieStar = ?, release_date = ?, description = ?, imagemax = ?, imagemin = ?, span_list = ?, trailerLink = ?, category = ?\n"
                + "where movieId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nameEnglish);
            ps.setString(2, nameVietnamese);
            ps.setString(3, movieStar);
            ps.setDate(4, releasedate);
            ps.setString(5, description);
            ps.setString(6, imagemax);
            ps.setString(7, imagemin);
            ps.setString(8, spanlist);
            ps.setString(9, trailerLink);
            ps.setString(10, category);
            ps.setString(11, mID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public List<Movie> getCategoryMovie(String category) {
        List<Movie> List = new ArrayList<>();
        String query = "select * from " + dbquery + ".movie\n"
                + "where category = ?";
        try {
            conn = new DBContext().getConnection();// mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, category);
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
                        rs.getString(11)));
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Movie> getALLMovie() {
        List<Movie> List = new ArrayList<>();
        String query = "select * from " + dbquery + ".movie";
        try {
            conn = new DBContext().getConnection();// mo ket noi voi sql
            ps = conn.prepareStatement(query);
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
                        rs.getString(11)));
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Movie> getMovieInBookmarked(Integer userid) {
        List<Movie> List = new ArrayList<>();
        String query = "select movie.movieId, movieName, movieStar, category, description, movieLink, imageLink\n"
                + "                from " + dbquery + ".movie, " + dbquery + ".bookmarked\n"
                + "                where movie.movieId = bookmarked.movieid and userid = ?";
        try {
            conn = new DBContext().getConnection();// mo ket noi voi sql
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
                        rs.getString(11)));
            }
            return List;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            new MovieDAO().delete("361743");
        } catch (Exception e) {
        }
    }
}
