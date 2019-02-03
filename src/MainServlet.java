import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/MainServlet")
public class MainServlet extends javax.servlet.http.HttpServlet implements 
  javax.servlet.Servlet {
  static final long serialVersionUID = 1L;
   
  Connection c= null;

  PreparedStatement ps = null;

  ResultSet rs = null;
  
  public MainServlet() {
    super();
  }  
  
 
  protected void doGet(HttpServletRequest request, 
    HttpServletResponse response) throws ServletException, IOException{
		String ui =request.getParameter("userid");
		
		System.out.println("The Userid: " + ui);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(
				  "jdbc:mysql://localhost/FCUofNJIT?user=root&password=root");
			PreparedStatement ps = c.prepareStatement("Select userID from accountinfo where userID=?");
			ps.setString(1, ui);
	 
			System.out.println("The connection: "+ ps.getConnection());
			
			ResultSet rs = ps.executeQuery();
			
			
			if (rs.next()) {
				request.setAttribute("uid", ui);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
				dispatcher.forward(request, response);

				//response.sendRedirect("Success.html");
			}
			else
				response.sendRedirect("Error.jsp");
			return;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
  }   	  	    
}

