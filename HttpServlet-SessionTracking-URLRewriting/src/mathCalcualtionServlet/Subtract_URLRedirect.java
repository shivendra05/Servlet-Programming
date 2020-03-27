package mathCalcualtionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sub")
public class Subtract_URLRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Subtract Servlet called");
		int num1 = Integer.parseInt(req.getParameter("n1"));
		int num2 = Integer.parseInt(req.getParameter("n2"));
		int sub=num1-num2;
		System.out.println("Num1 value: "+num1);
		System.out.println("Num2 value: "+num2);
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='cyan'>");
		out.println("<h2>You selected Subtraction option</h2>");
		out.println("<h2>Sum od number:"+sub+" </h2>");
		out.print("</body></html>");}
}