package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
 
/**
* Servlet implementation class HomeServlet
*/
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String user=null;
		response.setContentType("text/html");
		out.println("<h2>Home Page</h2><br/>");
		HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect("/SessionDemo/Login.html");
		}
		else if(session.getAttribute("user")==null) {
				out.println("Not logged in <a href='/SessionDemo/Login.html'> Login</a>");
				out.println("<p align='right'><a href='/SessionDemo/LogoutServlet'>Logout</a></p>");
		}
		else {
			user=session.getAttribute("user").toString();
			out.println("currently logged in as " +user);}
		}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 
}