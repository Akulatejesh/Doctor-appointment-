package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class OrderServlet
*/
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecondServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username = (String) request.getSession().getAttribute("username");
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"ISO-8859-1\">\r\n"
				+ "	<title>Confirm Page</title>\r\n"
				+ "	\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "	<center>\r\n"
				+ "		<h2>Order Placed Successfully</h2>\r\n"
				+ "		<p>Thank you, + username + , for your purchase!</p>\r\n"
				+ "	</center>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
		doGet(request, response);
	}
 
}