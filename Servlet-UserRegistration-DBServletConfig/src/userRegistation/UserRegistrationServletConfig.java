package userRegistation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class UserRegistrationServletConfig extends GenericServlet{
	Connection con;
	PreparedStatement ps;
	public void init(ServletConfig conf) throws ServletException{
		try {
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="system";
			String password="shiv";
			System.out.println("Driver inilization started!!! ");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Driver inilization completed!!");
		}catch(ClassNotFoundException | SQLException sql) {
			sql.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			PrintWriter out = res.getWriter();
			String inset_query="insert into employee values(?,?,?)";
			res.setContentType("text/html");
			out.print("<html><body bgcolor='cyan'>");
			String name = req.getParameter("fullname");
			String uName = req.getParameter("uname");
			String pws = req.getParameter("pws");
			System.out.println(name+" "+uName+""+ pws);
			ps = con.prepareStatement(inset_query);
			ps.setString(1, name);
			ps.setString(2, uName);
			ps.setString(3, pws);
			out.print("<h2>");
			int status = ps.executeUpdate();
			if(status==1) {
				System.out.println("User details inserted::Sucessfully");
				out.println("User details inserted");
			}else {
				System.out.println("Unable to insert details::Failed");
				out.println("Unable to insert details");
			}
			out.print("</h2>");
			out.print("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}