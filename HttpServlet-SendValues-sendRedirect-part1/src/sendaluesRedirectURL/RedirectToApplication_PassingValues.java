package sendaluesRedirectURL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendDataWithgetRedirectRequestPart1")
public class RedirectToApplication_PassingValues extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		String url = "http://localhost:9090/HttpServlet-SendValues-sendRedirect-part2/power?p1="+num1+"&p2="+num2;
		System.out.println("Calling Application 2 with url:  "+url);
		resp.sendRedirect(url);
	}
}
