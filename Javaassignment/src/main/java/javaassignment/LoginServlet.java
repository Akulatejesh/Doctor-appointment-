package javaassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        Connection connection = null;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Tejeshakula123@");

            
            String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
               
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);
                response.sendRedirect("home.jsp");
            } else {
                
                response.sendRedirect("login.jsp");
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
