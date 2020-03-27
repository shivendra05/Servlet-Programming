package calculation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Subtraction")
public class SubServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int sub = num1-num2;
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='cyan'>");
		out.print("<h2>Subtraction of numbers "+sub+"</h2>");
		out.print("</body></html>");
	}
}