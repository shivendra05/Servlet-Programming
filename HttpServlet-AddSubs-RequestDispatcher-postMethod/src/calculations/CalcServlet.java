package calculations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet("/calculate")
public class CalcServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("cal");
		if(operation.equalsIgnoreCase("add")) {
			RequestDispatcher reqd1 = req.getRequestDispatcher("addition");
			reqd1.forward(req, resp);
		} else if(operation.equalsIgnoreCase("sub")){
			RequestDispatcher reqd2 = req.getRequestDispatcher("subtraction");
			reqd2.forward(req, resp);
		}
	}
}