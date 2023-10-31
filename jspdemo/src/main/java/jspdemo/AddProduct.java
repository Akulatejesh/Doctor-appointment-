package jspdemo;

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
 
/**
* Servlet implementation class AddProduct
*/
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Connection con = null;
			 try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productlist", "root", "Tejeshakula123@");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into products (pid,pname,pprice) values(?,?,?) ");
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3,pprice);
			int x=ps.executeUpdate();
			if(x!=0) {
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				out.println("Record Inserted...");
				out.println("<div class=\"form-group\">\r\n"
						+ "    	<a href=\"Login.html\" ><button>Re-Login</button></a>\r\n"
						+ "    </div>");
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		System.out.println("Connection Established....");
	}
 
}
