package httpServletAddDeprtmentDetails;

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


@WebServlet("/insert")
public class AddDapartmentDetailsPostMethod extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String depart_insert_query = "insert into dept values(?,?,?,?)";
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","shiv");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		int dno = Integer.parseInt(req.getParameter("dno"));
		String dname = req.getParameter("dname");
		String empName = req.getParameter("empName");
		String location = req.getParameter("location");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			ps=con.prepareStatement(depart_insert_query);
			ps.setInt(1, dno);
			ps.setString(2, dname);
			ps.setString(3, empName);
			ps.setString(4, location);
			boolean count = ps.execute();
			if(count==true)
				out.print("<h2>Employee Department data insered sucessfully</h2>");
			else
				out.print("<h2>Failed to insert Employee department data</h2>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<html><body bgcolor='cyan'>");
	}
}