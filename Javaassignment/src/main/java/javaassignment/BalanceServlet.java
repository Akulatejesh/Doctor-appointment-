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

@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("userId") != null) {
            String userId = (String) session.getAttribute("userId");
            
            Connection connection = null;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Tejeshakula123@");
                
                String getBalanceQuery = "SELECT balance FROM users WHERE user_id = ?";
                PreparedStatement getBalanceStatement = connection.prepareStatement(getBalanceQuery);
                getBalanceStatement.setString(1, userId);
                ResultSet resultSet = getBalanceStatement.executeQuery();
                
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    
                    // Store the balance in the request attribute
                    request.setAttribute("balance", balance);
                    
                    // Forward to the balance.jsp
                    request.getRequestDispatcher("balance.jsp").forward(request, response);
                } else {
                    // Handle the case where the user's balance is not found
                    response.sendRedirect("home.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("home.jsp");
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
