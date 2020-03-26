package employeeRegistration;

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

public class EmployeeRegisdtartion_SeverletCofigTags extends GenericServlet{
	String driver=null;
	String url=null;
	String user=null;
	String password=null;
	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public void init(ServletConfig conf) throws ServletException{
		try {
			driver = conf.getInitParameter("driver");
			url = conf.getInitParameter("url");
			user = conf.getInitParameter("user");
			password = conf.getInitParameter("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			String insert_query="insert into employee values(?,?,?)";
		
			String fullname = req.getParameter("fullname");
			String username = req.getParameter("uname");
			String password = req.getParameter("pws");
			
			PrintWriter out=res.getWriter();
			out.print("<html><body bgcolor='cyan'>");
			ps = con.prepareCall(insert_query);
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, password);
			int status = ps.executeUpdate();
			if(status==1) {
				out.print("<h2 align='enter'>Data inserted sucessfully</h2>");
			}else {
				out.print("<h2>Failed to to insert data</h2>");
			}
			out.print("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}