package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OperationsServlet")
public class OperationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OperationsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        int pid = Integer.parseInt(request.getParameter("partid"));
        String partname = request.getParameter("partname");
        String color = request.getParameter("color");
        Connection con = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "Tejeshakula123@");
            System.out.println("Connection Established...");

            if ("insert".equals(operation)) {
                PreparedStatement s = con.prepareStatement("INSERT INTO parts (pid, pname, color) VALUES (?, ?, ?)");
                s.setInt(1, pid);
                s.setString(2, partname);
                s.setString(3, color);
                int x = s.executeUpdate();
                if (x != 0) {
                    out.println("Record Inserted.");
                } else {
                    out.println("Error: Record not inserted.");
                }
            } else if ("update".equals(operation)) {
                PreparedStatement s = con.prepareStatement("UPDATE parts SET pname=?, color=? WHERE pid=?");
                s.setString(1, partname);
                s.setString(2, color);
                s.setInt(3, pid);
                int x = s.executeUpdate();
                if (x != 0) {
                    out.println("Record Updated.");
                } else {
                    out.println("Error: Record not updated.");
                }
            } else if ("delete".equals(operation)) {
                PreparedStatement s = con.prepareStatement("DELETE FROM parts WHERE pid=?");
                s.setInt(1, pid);
                int x = s.executeUpdate();
                if (x != 0) {
                    out.println("Record Deleted.");
                } else {
                    out.println("Error: Record not found or not deleted.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Error: Internal server error. Please try again later.");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
