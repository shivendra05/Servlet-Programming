package departmentDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empDetails")
public class DataBestSetupServlet extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String select_employee_details = "select * from dept where dno=?";
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","shiv");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int dno = Integer.parseInt(req.getParameter("dno"));
			PrintWriter out = resp.getWriter();
			out.print("<html><body bgcolor='magenta'>");
			ps = con.prepareStatement(select_employee_details);
			ps.setInt(1, dno);
			ResultSet rs = ps.executeQuery();
			boolean dataFound = rs.next();
			if(dataFound==false) {
				RequestDispatcher reqs1 = req.getRequestDispatcher("home.html");
				reqs1.include(req, resp);
				out.print("<h2>Data Not found</h2>");
			}else if(dataFound==true) {
				RequestDispatcher reqs2 = req.getRequestDispatcher("EnployeeDetails");
				req.setAttribute("dno", rs.getInt(1));
				req.setAttribute("dname", rs.getString(2));
				req.setAttribute("empname", rs.getString(3));
				req.setAttribute("location", rs.getString(4));
				reqs2.forward(req, resp);
			}
			out.print("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}