package addNumbersServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddTwoNumbers extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		ServletConfig conf = getServletConfig();
		int num1 = Integer.parseInt(conf.getInitParameter("num1"));
		int num2 =  Integer.parseInt(conf.getInitParameter("num2"));
		int sum = num1+num2;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body style=\"background-image: url('thumb.jpg');\">");
		out.print("<h2>sum of "+num1+" and "+num2+ " is "+sum+ "</h2>");
		out.print("</body></html>");
	}
}