package sendRequest1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendRequestPart1")
public class CallAnotherApplication_SendRedirect_part2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Calling Application 2");
		resp.sendRedirect("http://localhost:9090/HttpServlet-sendRedirect-part2/");
		//resp.sendRedirect("http://localhost:9090/HttpServlet-sendRedirect-part2/home.html");
	}
}
