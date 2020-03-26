package coursesOffered;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CourseSelection extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Date date = new Date();
		int hours = date.getHours();
		String msg;
		if (hours<12)
			msg="Good Morning";
		else if (hours<16)
			msg="Good AfterNoon";
		else if (hours<18)
			msg="Good Evening";
		else
			msg="Good Night";
		String stuName = req.getParameter("name");
		String []allCourses = req.getParameterValues("c");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int total =0;
		out.println("<html><head>");
		out.println("<body bgcolor='#9999ff'>");
		out.println("<h2> Hello "+stuName + "  !!! "+msg+"</h2>");
		out.println("<h3> You have selected below courses </h3>");
		for(String course:allCourses) {
			if(course.equalsIgnoreCase("Java")) {
				out.println(course+"= 1000<br>");
				total=total+1000;
			} else if(course.equalsIgnoreCase("oracle")) {
				out.println(course+"= 1500<br>");
				total=total+1500;
			}else if(course.equalsIgnoreCase(".net")) {
				out.println(course+"= 1600<br>");
				total=total+1600;
			}
		}
		out.print("<h3>");
		out.println("<h3> ------------------------- </h3>");
		out.print("Total Amount to be paid: "+total);
		out.println("</h3></body>");
		out.println("</head></html>");
	}

}
