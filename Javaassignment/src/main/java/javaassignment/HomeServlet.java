package javaassignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is logged in
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = (String) session.getAttribute("userId");

            // You can add your code here to display the home page for the logged-in user

            // For example:
            response.getWriter().write("<h1>Welcome, " + userId + "!</h1>");
        } else {
            // User is not logged in, redirect to the login page
            response.sendRedirect("login.jsp");
        }
    }
}
