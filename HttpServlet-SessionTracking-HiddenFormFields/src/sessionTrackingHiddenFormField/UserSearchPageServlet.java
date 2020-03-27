package sessionTrackingHiddenFormField;

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

@WebServlet("/validateUser")
public class UserSearchPageServlet extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String select_emp_query = "select count(*) from employee where ename=? and password=?";
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "shiv");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("passwrod");
		PrintWriter out = resp.getWriter();
		try {
			System.out.println("UserNmae: "+user+"   Password: "+password);
			out.println("<html><body bgcolor='cyan'>");
			ps = con.prepareStatement(select_emp_query);
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet count = ps.executeQuery();
			count.next();
			int match = count.getInt(1);
			System.out.println("Data result for seqrch: "+match);
			if(match==1) {
				out.println("<form action='./userHomePage'>");
				//out.println("<input type='text' name='UserName' value="+user+">");
				out.println("<input type='hidden' name='UserName' value="+user+">");
				out.println("<input type='submit' value=inbox>");
				out.println("</form>");
				out.println("</html></body>");
				System.out.println("completed");
			}else {
				RequestDispatcher reqd = req.getRequestDispatcher("home.html");
				reqd.include(req, resp);
				out.println("<h2>Invalid UserName or Password</h2>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}