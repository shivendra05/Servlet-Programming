package departmentDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EnployeeDetails")
public class DepartmentDetails extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='magenta'>");
		int dno =(Integer)req.getAttribute("dno");
		String dname =(String) req.getAttribute("dname");
		String empname =(String) req.getAttribute("empname");
		String location =(String) req.getAttribute("location");
		out.print("<h1 align='center'>Data found</h2>");
		out.print("<h3>"+dno+" "+dname+" "+empname+" "+location+"</h2>");
		out.print("</body></html>");
	}
}
