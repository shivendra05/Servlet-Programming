package mailWithHttpSession;

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
import javax.servlet.http.HttpSession;

@WebServlet("/HemailInbox")
public class LoginToMailHttpSession extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	String select_query = "select count(*) from employee where ename=? and password=?";
	public void init() {
		try {
			System.out.println("JDBC Conntion started");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","shiv");
			System.out.println("JDBC Conntion esablised");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uName = req.getParameter("uName");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		try {
			ps = con.prepareStatement(select_query);
			ps.setString(1, uName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count==1) {
				out.print("<html><body>");
				HttpSession session = req.getSession();
				session.setAttribute("uname", uName);
				String url = "http://localhost:9090/HttpServlet-SessionTracking-HttpSession/inbox";
				out.print("<h2><a href="+url+">Inbox</a><h2>");
				out.print("</body></html>");
			}else {
				RequestDispatcher reqd = req.getRequestDispatcher("home.html");
				reqd.include(req, resp);
				out.print("<h2>Invalid User Name or Password<h2>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}