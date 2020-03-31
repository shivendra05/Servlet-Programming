package mailWithHttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/inbox")
public class InboxWithGetSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);//dont create new session, true create new session
		String name = (String) session.getAttribute("uname");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		
		out.print("<h2>Hello, "+name+"<h2>");
		out.print("</body></html>");
	}
}