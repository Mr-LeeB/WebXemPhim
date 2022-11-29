package com.bkmovieapplication.User;

import com.bkmovieapplication.business.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import javax.servlet.http.Cookie;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = new User(email,password,password);
        //DAO dao = new DAO();
        //Account a = dao.login(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        session.setMaxInactiveInterval(60 * 60 * 24);
        //luu account len tren cookie
        Cookie u = new Cookie("email", email);
        Cookie p = new Cookie("password", password);
        if (remember != null) {
            p.setMaxAge(60 * 60 * 24);
        } else {
            p.setMaxAge(0);
        }

        u.setMaxAge(60 * 60 * 24 * 365);//1 nam

        response.addCookie(u);//luu u va p len Chrome
        response.addCookie(p);

        response.sendRedirect("home");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("emailC")) {
                    request.setAttribute("email", o.getValue());
                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("password", o.getValue());
                }
            }
        }
        //b2: set user,pass to login form
        forwardToPage("page/login.jsp", request, response);
    }
}
