package facelookCopyServeltContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserLogin extends GenericServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String Select_query="select count(*) from employee where ename=? and password=?"; 
	public void init() {
		ServletContext ctx = getServletContext();
		//ServletContext ctx = getServletConfig().getServletContext();
		try {
			
			Class.forName(ctx.getInitParameter("driver"));
			con = DriverManager.getConnection(ctx.getInitParameter("url"),ctx.getInitParameter("user"),ctx.getInitParameter("password"));
			System.out.println("Connection Stablised Sucessfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//ServletContext ctx = getServletConfig().getServletContext();
		String uname = req.getParameter("uname");
		String password = req.getParameter("pwd");
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor='cyan'>");
		try {
			ps= con.prepareStatement(Select_query);
			ps.setString(1, uname);
			ps.setString(2, password);
			boolean status = ps.execute();
			if(status==true)
				out.print("<h2>Sucessfulyy LoggedIn</h2>");
			else
				out.print("<h2>Failed to LogIn</h2>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</body></html>");
	}
}
