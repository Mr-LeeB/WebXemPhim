package com.bkmovieapplication.dao;

import com.bkmovieapplication.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bkmovieapplication.context.DBContext;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String dbquery = "oj3bOO0Agn";

    public List<User> getAdminAccount() {
        String query = "select * from " + dbquery + ".user\n"
                + "where role = 'admin'";
        List<User> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<User> getUserAccount() {
        String query = "select * from " + dbquery + ".user\n"
                + "where role = 'user'";
        List<User> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public User getaUser(int id) {
        String query = "select * from " + dbquery + ".user\n"
                + "where userId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteUser(int id) {
        String query = "delete from " + dbquery + ".user\n"
                + "where userId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update(Integer userid, String username, String email, String password, String phonenum) {
        String query = "update  " + dbquery + ".user \n"
                + "set\n"
                + "userName = ?,\n"
                + "email = ?,\n"
                + "passWord = ?,\n"
                + "phoneNum = ?\n"
                + "where userid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phonenum);
            ps.setInt(5, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(User user) {
        String query = "update " + dbquery + ".user\n"
                + "set userName = ?,\n"
                + "email = ?,\n"
                + "passWord = ?,\n"
                + "phoneNum = ?,\n"
                + "role = ?\n"
                + "where userId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassWord());
            ps.setString(4, user.getPhoneNum());
            ps.setString(5, user.getRole());
            ps.setInt(6, user.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addUser(String username, String email, String password, String phonenum, String role) {
        String query = "insert into " + dbquery + ".user\n"
                + "(userName, email, passWord, phoneNum, role)\n"
                + "values(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phonenum);
            ps.setString(5, role);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User checkEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM " + dbquery + ".user\n"
                + "where email = ? and passWord = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkAccountExist(String username, String email) {
        String query = "select * from " + dbquery + ".user\n"
                + "where userName = ? or email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getString(2),
                        rs.getString(3)) != null;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            UserDAO dao = new UserDAO();
            System.out.println(dao.checkAccountExist("tranchikien", "tranchikien@gmail.com"));
        } catch (Exception e) {
        }
    }
}
