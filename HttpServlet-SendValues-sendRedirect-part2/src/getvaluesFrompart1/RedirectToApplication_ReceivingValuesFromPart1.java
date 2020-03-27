package getvaluesFrompart1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

@WebServlet("/power")
public class RedirectToApplication_ReceivingValuesFromPart1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("p1"));
		int num2 = Integer.parseInt(req.getParameter("p2"));
		double power =Math.pow(num1, num2);
		
		System.out.println("Power is: "+power);
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='magenta'>");
		out.print("<h2 align='center'>Hi User, Your are in Application 2</h2>");
		out.print("<h2> Below is calculation  </h2>");
		out.print("<h2>Power of numbers is:"+power+"</h2>");
		out.print("</body></html>");
	}
}