import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/DepositServlet")
public class DepositServlet extends javax.servlet.http.HttpServlet implements 
  javax.servlet.Servlet {
  static final long serialVersionUID = 1L;
   
  Connection c= null;

  PreparedStatement ps = null;

  ResultSet rs = null;
  
  public DepositServlet() {
    super();
  }  
  
 
  protected void doGet(HttpServletRequest request, 
    HttpServletResponse response) throws ServletException, IOException{
		String addBal =request.getParameter("deposit");
		String uid = request.getParameter("uid");
		System.out.println(uid);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(
				  "jdbc:mysql://localhost/FCUOfNJIT?user=root&password=root");
			PreparedStatement ps = c.prepareStatement("Select Balance from accountinfo where userID=?");
			ps.setString(1,uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Double balance = Double.parseDouble(rs.getString(1)) + Double.parseDouble(addBal);
			
			
			ps = c.prepareStatement("Update accountinfo set Balance=? where userID=?");
			ps.setString(1,String.valueOf(balance));
			ps.setString(2,uid);
			boolean b = ps.execute();
			//if(b==true)
				//System.out.println("Database is updated");
			
			ps = c.prepareStatement("Select Balance from accountinfo where userID=?");
			ps.setString(1,uid);
			rs = ps.executeQuery();
			rs.next();
			String newBal = rs.getString(1);
			System.out.println(newBal);
			
			request.setAttribute("newBal", newBal);
			request.setAttribute("addBal", addBal);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Deposit.jsp");
			dispatcher.forward(request, response);


			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
  }   	  	    
}

