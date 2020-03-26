package addTwoNums;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionOfTwoNumbers extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(req.getParameter("a"));
		int num2 = Integer.parseInt(req.getParameter("b"));
		
		PrintWriter out= res.getWriter();
		int sum=num1+num2;
		
		out.println("<html><body bgcolor='cyan'>");
		out.println("<h2>sum of two numers: "+sum+"</h2>");
		out.println("</html></body>");
	}
}