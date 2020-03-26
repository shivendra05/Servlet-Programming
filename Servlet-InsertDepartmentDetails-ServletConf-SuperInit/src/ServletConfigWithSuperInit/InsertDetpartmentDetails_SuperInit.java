package ServletConfigWithSuperInit;

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

public class InsertDetpartmentDetails_SuperInit extends GenericServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String inser_details ="insert into dept values(?,?,?,?)";
	public void init(ServletConfig config) throws ServletException {
		String driver;
		String url;
		String userName;
		String password;
		try {
			super.init(config);
			driver = config.getInitParameter("driver");
			url = config.getInitParameter("url");
			userName = config.getInitParameter("username");
			password = config.getInitParameter("password");
			Class.forName(driver);
			con=DriverManager.getConnection(url,userName,password);
			System.out.println("DB Connection stablished");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Data getting ready for insertion");
		int dno = Integer.parseInt(req.getParameter("dno"));
		String dname = req.getParameter("dname");
		String empName= req.getParameter("ename");
		String location =req.getParameter("location");
		res.setContentType("text/html");;
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor='çyan'>");
		try {
			ps=con.prepareStatement(inser_details);
			ps.setInt(1, dno);
			ps.setString(2, dname);
			ps.setString(3, empName);
			ps.setString(4, location);
			int status = ps.executeUpdate();
			if(status==1) {
				out.print("<h2> Department Data inserted sucessfully </h2>");
			}else {
				out.print("<h2> Unable to insert data !! FAILED </h2>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("</body></html>");
	}
}