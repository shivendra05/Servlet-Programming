package radioButton;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EquipmentSelectionUseingRadioButton extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		Map<String, String[]> values= req.getParameterMap();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("<html><body bgcolor='green'>");
		out.print("<h2> Hello !!!!"+name+"<br>");
		int total=0;
		boolean found= values.containsKey("p");
		if(found==true) {
			String value = req.getParameter("p");
			if(value.equalsIgnoreCase("keyboard")) {
				out.println(value+" price is 1000");
				total=total+1000;
			}else if(value.equalsIgnoreCase("mouse")) {
				out.println(value+" price is 3000");
				total=total+3000;
			}else if(value.equalsIgnoreCase("disk")) {
				out.println(value+" price is 7000");
				total=total+3000;
			}else if(value.equalsIgnoreCase("CPU")) {
				out.println(value+" price is 16000");
				total=total+3000;
			}else if(value.equalsIgnoreCase("UPS")) {
				out.println(value+" price is 1900");
				total=total+3000;
			}
			out.println("<br>-------------------");
			out.println("<br>Total price is: "+total);
		}else {
			out.println("You havent Selection any product");
			out.println("<h2>!!!!!!please selection product</h2>");
		}
		out.println("</h2></body></html>");
	}
}