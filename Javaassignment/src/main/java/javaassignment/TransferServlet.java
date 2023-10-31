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
import javax.servlet.http.HttpSession;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("userId") != null) {
            String userId = (String) session.getAttribute("userId");
            String destinationAccount = request.getParameter("destinationAccount");
            double transferAmount = Double.parseDouble(request.getParameter("transferAmount"));

            Connection connection = null;

            try {
               
                Class.forName("com.mysql.cj.jdbc.Driver");

                
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "Tejeshakula123@");

               
                connection.setAutoCommit(false);

                
                String deductQuery = "UPDATE users SET balance = balance - ? WHERE user_id = ?";
                PreparedStatement deductStatement = connection.prepareStatement(deductQuery);
                deductStatement.setDouble(1, transferAmount);
                deductStatement.setString(2, userId);
                int rowsDeducted = deductStatement.executeUpdate();

                
                if (rowsDeducted > 0) {
                   
                    String addQuery = "UPDATE users SET balance = balance + ? WHERE user_id = ?";
                    PreparedStatement addStatement = connection.prepareStatement(addQuery);
                    addStatement.setDouble(1, transferAmount);
                    addStatement.setString(2, destinationAccount);
                    int rowsAdded = addStatement.executeUpdate();

               
                    connection.commit();

                    if (rowsAdded > 0) {
                        
                        response.sendRedirect("home.jsp");
                    } else {
                        
                        response.sendRedirect("home.jsp");
                    }
                } else {
                   
                    response.sendRedirect("home.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();

                
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    response.sendRedirect("home.jsp");
                }
            } finally {
                try {
                    if (connection != null) {
                        connection.setAutoCommit(true);
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
