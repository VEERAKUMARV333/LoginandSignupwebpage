package signupPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("un");
		String upwd=request.getParameter("pw");
		Connection con=null;
		HttpSession session=request.getSession();
		RequestDispatcher dis=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/3eje2?useSSL=false","root","root");
			PreparedStatement pst=con.prepareStatement("select * from users where Uname=? and Upwd=?");
			pst.setString(1, uname);
			pst.setString(2, upwd);
			
			ResultSet rs=pst.executeQuery();
			
			
			if(rs.next())
			{
				session.setAttribute("uni", rs.getString("Uname"));
				
					
				dis=request.getRequestDispatcher("index.jsp");
			}
			else
			{
				request.setAttribute("status", "no");
				dis=request.getRequestDispatcher("index.login.html");
			}
			dis.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
