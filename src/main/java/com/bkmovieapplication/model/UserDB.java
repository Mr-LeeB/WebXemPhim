package com.bkmovieapplication.model;

import com.bkmovieapplication.dao.UserDAO;
import com.bkmovieapplication.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import java.util.List;
import javax.servlet.http.HttpSession;

public class UserDB {

    private final UserDAO userDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public UserDB(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        userDAO = new UserDAO();
    }

    public void addUser() throws ServletException, IOException {
        String username = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String phonenum = request.getParameter("phoneNum");
        String role = request.getParameter("role");

        userDAO.addUser(username, email, password, phonenum, role);
    }

    public void deleteUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userID"));
        userDAO.deleteUser(userId);
    }

    public void updateUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userID"));
        String username = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String phonenum = request.getParameter("phoneNum");
        String role = request.getParameter("role");

        User user = new User(userId, username, email, password, phonenum, role);
        userDAO.updateUser(user);

    }

    public User getaUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userID"));
        User user = userDAO.getaUser(userId);
        if (user != null) {
            return user;
        }
        return null;
    }

    public void getUserAccount() throws ServletException, IOException {
        List<User> list = userDAO.getUserAccount();
        if (list != null) {
            request.setAttribute("ListUserAccount", list);
        }
    }

    public void getAdminAccount() throws ServletException, IOException {
        List<User> list = userDAO.getAdminAccount();
        if (list != null) {
            request.setAttribute("ListAdminAccount", list);
        }
    }

    public void update() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phonenum = request.getParameter("phonenum");
        String pass = request.getParameter("password");
        String newpass = request.getParameter("newpassword");
        if (!pass.equals(user.getPassWord())) {
            forwardToPage("profile", "Update failed. Please enter correct password", request, response);
        }
        if (!"".equals(newpass)) {
            userDAO.update(user.getUserId(), username, email, newpass, phonenum);
            request.getSession().removeAttribute("user");
        } else {
            userDAO.update(user.getUserId(), username, email, pass, phonenum);
            User newuser = new User(user.getUserId(), username, email, pass, phonenum, "user");
            request.getSession().setAttribute("user", newuser);
        }

        forwardToPage("profile", "Update Success", request, response);
    }

    public void login() throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User loginResult = userDAO.checkEmailAndPassword(email, password);
        if (loginResult != null) {
            // the value of the attribute in the request lives only at the time of the
            // request is active but the value stored in the session stays on the server as
            // long as the session
            request.getSession().setAttribute("user", loginResult);
            if ("admin".equals(loginResult.getRole())) {
                request.getSession().setAttribute("admin", true);
            } else {
                request.getSession().setAttribute("admin", false);
            }
            request.getSession().setMaxInactiveInterval(60 * 60 * 24);
            Cookie e = new Cookie("emailC", loginResult.getEmail());
            Cookie u = new Cookie("userC", loginResult.getUserName());
            Cookie p = new Cookie("passC", loginResult.getPassWord());

            p.setMaxAge(0);
            u.setMaxAge(60 * 60 * 24 * 365);//1 nam
            e.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(e);
            response.addCookie(u);//luu u va p len Chrome
            response.addCookie(p);

            response.sendRedirect("home");
        } else {
            forwardToPage("/page/login.jsp", "Login failed.", request, response);
        }
    }

    public void signup() throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phonenum = request.getParameter("phonenum");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");
        if(!checkCode()){
            forwardToPage("/page/login.jsp", "Verification does not match!", request, response);
        }
        if (!password.equals(confirmpassword)) {
            forwardToPage("page/login.jsp", "Password does not match!", request, response);
        } else {
            boolean a = userDAO.checkAccountExist(username, email);
            if (a == false) {
                userDAO.addUser(username, email, password, phonenum, "user");
                request.setAttribute("email", email);
                forwardToPage("/page/login.jsp", "Sign Up Success!", request, response);
            } else {
                forwardToPage("/page/login.jsp", "Email or User Name already exists!", request, response);
            }
        }
    }
    public boolean checkCode() {
        String usercode = request.getParameter("Verification");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if (!code.equals(usercode)) {
            return false;
        }
        return true;
    }

}
