package com.bkmovieapplication.User;

import com.bkmovieapplication.model.UserDB;
import com.bkmovieapplication.entity.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import javax.servlet.http.Cookie;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDB login = new UserDB(request, response);
        login.login();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("emailC")) {
                    request.setAttribute("email", o.getValue());
                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("password", o.getValue());
                }
            }
        }*/
        //b2: set user,pass to login form
        forwardToPage("page/login.jsp", request, response);
    }
}
