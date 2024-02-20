package signupPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/regisration")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("username");
		String uemail=request.getParameter("email");
		String pwd=request.getParameter("password");
		String mobile =request.getParameter("mobile");
		RequestDispatcher dis=null;
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/3eje2?useSSL=false","root","root");
			PreparedStatement pst=con.prepareStatement("insert into users (Uname,Upwd,Uemail,Umobile) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, pwd);
			pst.setString(3, uemail);
			pst.setString(4, mobile);
			
			int rowCount=pst.executeUpdate();
			dis=request.getRequestDispatcher("regisration.jsp");
			if(rowCount>0)
			{
				request.setAttribute("status", "yes");
			}
			else
			{
				request.setAttribute("status", "no");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
