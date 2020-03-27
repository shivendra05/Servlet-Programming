package mathCalcualtionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mathCalculation")
public class MathCalculation_URLRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		String url_Add = "http://localhost:9090/HttpServlet-SessionTracking-URLRewriting/add?n1="+num1+"&n2="+num2;
		String url_Sub = "http://localhost:9090/HttpServlet-SessionTracking-URLRewriting/sub?n1="+num1+"&n2="+num2;
		System.out.println("Add URL: "+url_Add);
		System.out.println("Add URL: "+url_Sub);
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='pink'>");
		out.println("<h2>Select Option for Operation");
		out.println("<br><a href="+url_Add+"> Click to Add Numbers</a>");
		out.println("<br><a href="+url_Sub+"> Click to Sub Numbers</a></h2>");
		out.print("</body></html>");
	}
}