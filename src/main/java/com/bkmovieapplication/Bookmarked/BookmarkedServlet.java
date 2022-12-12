package com.bkmovieapplication.Bookmarked;

import com.bkmovieapplication.model.*;
import com.bkmovieapplication.entity.*;
import static com.bkmovieapplication.utility.CommonUtility.forwardToPage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bookmarked")
public class BookmarkedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesstion = request.getSession();
        User user = (User) sesstion.getAttribute("user");
        if(user == null) {
        	response.sendRedirect("login");
        	return;
        }
        BookmarkedDB bookmarked = new BookmarkedDB(request, response);
        bookmarked.getMovieInBookmarked(user.getUserId());

        forwardToPage("page/bookmarked.jsp", request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
