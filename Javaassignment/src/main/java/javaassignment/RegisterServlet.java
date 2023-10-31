package javaassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract user data from the request
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Tejeshakula123@");

           
            String sql = "INSERT INTO users (user_id, password, balance) VALUES (?, ?, ?)";

            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            preparedStatement.setDouble(3, initialBalance);

            
            int rows = preparedStatement.executeUpdate();

            // Close the database connection
            preparedStatement.close();

            if (rows > 0) {
                // Registration successful, print a message
            	response.setContentType("text/html");
                response.getWriter().write("Registration Successful! User ID: " + userId);
                response.getWriter().write("<div class=\"form-group\">");
                response.getWriter().write("<a href=\"login.jsp\"><button>Login</button></a>");
                response.getWriter().write("</div>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
