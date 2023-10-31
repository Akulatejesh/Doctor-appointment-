<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        /* Add colorful CSS */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h2 {
            font-size: 28px;
            color: #007BFF; /* Blue */
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #007BFF; /* Blue */
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #007BFF; /* Blue */
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:nth-child(odd) {
            background-color: #fff;
        }
    </style>
</head>
<body>
    <h2>Product List</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Price</th>
        </tr>
        <%
            try {
                // Establish a database connection (replace with your database details)
                java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
                java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/productlist", "root", "Tejeshakula123@");

                // Create a SQL query to retrieve product data (replace with your query)
                String query = "SELECT * FROM products";
                java.sql.PreparedStatement ps = con.prepareStatement(query);
                java.sql.ResultSet rs = ps.executeQuery();

                // Iterate through the result set and display data in the table
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("pid") %></td>
                        <td><%= rs.getString("pname") %></td>
                        <td><%= rs.getString("pprice") %></td>
                    </tr>
        <%
                }
                // Close database resources
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>
