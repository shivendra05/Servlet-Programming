package calculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("operation");
		if(status.equals("add")) {
			RequestDispatcher req1 = req.getRequestDispatcher("Addition");
			req1.forward(req, resp);
		}else if(status.equals("sub")) {
			RequestDispatcher req2 = req.getRequestDispatcher("Subtraction");
			req2.forward(req, resp);
		}
	}
}