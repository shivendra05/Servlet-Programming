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

@WebServlet("/userHomePage")
public class InboxSearchPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user = req.getParameter("UserName");
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='cyan'>");
		out.println("<h2>Hello "+user+" </h2>");
		out.println("<h2>This is your inbox</h2>");
		out.println("</html></body>");
	}
}