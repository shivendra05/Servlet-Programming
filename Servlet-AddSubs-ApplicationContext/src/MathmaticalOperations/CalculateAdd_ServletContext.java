package MathmaticalOperations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CalculateAdd_ServletContext extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletConfig conf = getServletConfig();
		ServletContext ctx = conf.getServletContext();
		int num1 = Integer.parseInt(ctx.getInitParameter("num1"));
		int num2 = Integer.parseInt(ctx.getInitParameter("num2"));
		System.out.println(num1+" and "+num2);
		int sum=num1+num2;
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor='cyan'>");
		out.print("Sum is "+sum+">");
		out.print("</body></html>");
	}
}