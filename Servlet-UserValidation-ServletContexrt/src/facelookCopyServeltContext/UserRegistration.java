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

public class UserRegistration extends GenericServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String Select_query="insert into employee values(?,?,?)"; 
	public void init() {
		ServletContext ctx = getServletConfig().getServletContext();
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
		String fullName = req.getParameter("fullName");
		String uname = req.getParameter("uname");
		String password = req.getParameter("pwd");
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor='magenta'>");
		try {
			ps= con.prepareStatement(Select_query);
			ps.setString(1, fullName);
			ps.setString(2, uname);
			ps.setString(3, password);
			int status = ps.executeUpdate();
			if(status==1)
				out.print("<h2>Hi "+fullName+", Sucessfulyy Registered</h2>");
			else
				out.print("<h2>Failed to Registed</h2>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</body></html>");
	}
}
