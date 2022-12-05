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

public class MovieDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dbquery = "oj3bOO0Agn";

    public Movie getAMovieByID(String movieId) {
        String query = "select * from " + dbquery + ".movie\n"
                + "where movieId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, movieId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Movie(rs.getString(1),
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
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Movie> getCategoryMovie(String category) {
        List<Movie> List = new ArrayList<>();
        String query = "select * from " + dbquery + ".movie\n"
                + "where category = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
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
                        rs.getString(11)
                ));
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
            conn = new DBContext().getConnection();//mo ket noi voi sql
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
            System.out.println(new MovieDAO().getAMovieByID("361743").getNameEnglish());
        } catch (Exception e) {
        }
    }
}
