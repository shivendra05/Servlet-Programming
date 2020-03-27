package mathCalcualtionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add_URLRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Addition Servlet called");
		int num1 = Integer.parseInt(req.getParameter("n1"));
		int num2 = Integer.parseInt(req.getParameter("n2"));
		System.out.println("Num1 value: "+num1);
		System.out.println("Num2 value: "+num2);
		int sum=num1+num2;
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='magenta'>");
		out.println("<h2>You selected Add option</h2>");
		out.println("<h2>Sum od number:"+sum+" </h2>");
		out.print("</body></html>");
	}
}