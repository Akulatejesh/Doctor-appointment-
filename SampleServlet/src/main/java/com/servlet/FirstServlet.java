package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		if ("tester".equals(username) && "tester".equals(password) ) {
			request.getSession().setAttribute("username", username);
 
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Product Page</title>\r\n"
					+ " \r\n"
					+ "<body>\r\n"
					+ "	 <center>\r\n"
					+ "        <h2>Welcome \" + username + \" </h2>\r\n"
					+ "        <h3>Product Details</h3>\r\n"
					+ "		<h4> Choose Your Favourite Product </h4>\r\n"
					+ "		\r\n"
					+ "        <p>Product Name: Product name 1</p>\r\n"
					+ "        <p>Price: Rs.50000/-</p>\r\n"
					+ "        <form action='/OnlineShopping/OrderServlet' method='post'>\r\n"
					+ "            <input type='submit' value='Buy'>\r\n"
					+ "        </form>\r\n"
					+ "\r\n"
					+ "        <p>Product Name: Product name 2</p>\r\n"
					+ "        <p>Price: Rs.20000/-</p>\r\n"
					+ "        <form action='/OnlineShopping/OrderServlet' method='post'>\r\n"
					+ "            <input type='submit' value='Buy'>\r\n"
					+ "        </form>\r\n"
					+ "\r\n"
					+ "        <p>Product Name: Product name 3</p>\r\n"
					+ "        <p>Price: Rs.40000/-</p>\r\n"
					+ "        <form action='/OnlineShopping/OrderServlet' method='post'>\r\n"
					+ "            <input type='submit' value='Buy'>\r\n"
					+ "        </form>\r\n"
					+ "\r\n"
					+ "        <p>Product Name: Product name 4</p>\r\n"
					+ "        <p>Price: Rs.60000/-</p>\r\n"
					+ "        <form action='/OnlineShopping/OrderServlet' method='post'>\r\n"
					+ "            <input type='submit' value='Buy'>\r\n"
					+ "        </form>\r\n"
					+ "    </center>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");
 
		} else {
			response.sendRedirect("Error.html");
		}
 
		doGet(request, response);
	}
}