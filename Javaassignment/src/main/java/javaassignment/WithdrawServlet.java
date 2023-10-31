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

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("userId") != null) {
            String userId = (String) session.getAttribute("userId");
            double withdrawalAmount = Double.parseDouble(request.getParameter("withdrawalAmount"));

            Connection connection = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Tejeshakula123@");

                // Retrieve the current balance
                String getCurrentBalanceQuery = "SELECT balance FROM users WHERE user_id = ?";
                PreparedStatement getCurrentBalanceStatement = connection.prepareStatement(getCurrentBalanceQuery);
                getCurrentBalanceStatement.setString(1, userId);
                ResultSet currentBalanceResultSet = getCurrentBalanceStatement.executeQuery();

                double currentBalance = 0.0;
                if (currentBalanceResultSet.next()) {
                    currentBalance = currentBalanceResultSet.getDouble("balance");
                }

                // Update the user's balance in the database after withdrawal
                String updateBalanceQuery = "UPDATE users SET balance = ? WHERE user_id = ?";
                PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceQuery);
                updateBalanceStatement.setDouble(1, currentBalance - withdrawalAmount);
                updateBalanceStatement.setString(2, userId);
                int rows = updateBalanceStatement.executeUpdate();

                if (rows > 0) {
                    // Fetch the updated balance
                    String getBalanceQuery = "SELECT balance FROM users WHERE user_id = ?";
                    PreparedStatement getBalanceStatement = connection.prepareStatement(getBalanceQuery);
                    getBalanceStatement.setString(1, userId);
                    ResultSet resultSet = getBalanceStatement.executeQuery();

                    if (resultSet.next()) {
                        double updatedBalance = resultSet.getDouble("balance");

                        // Store the updated balance in the request attribute
                        request.setAttribute("balance", updatedBalance);

                        // Store the current balance before the withdrawal
                        request.setAttribute("currentBalance", currentBalance);

                        // Forward to the balance.jsp
                        request.getRequestDispatcher("balance.jsp").forward(request, response);
                    } else {
                        // Handle the case where balance retrieval fails
                        response.sendRedirect("home.jsp");
                    }
                } else {
                    // Handle the case where the update operation fails
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
