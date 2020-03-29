package AmaconShopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Orderr")
public class ShoppingCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String choice = req.getParameter("b");
		PrintWriter out= resp.getWriter();
		RequestDispatcher reqd = req.getRequestDispatcher("home.html");
		reqd.include(req, resp);
		if(choice.equalsIgnoreCase("Add To Card")) {
			String pName = req.getParameter("pName");
			String quantity = req.getParameter("quantity");
			Cookie cookie = new Cookie(pName, quantity);
			resp.addCookie(cookie);
			out.print("Product added to the Cart");
		}else if(choice.equalsIgnoreCase("Update Card")) {
			String pName = req.getParameter("pName");
			String quantity = req.getParameter("quantity");
			Cookie cookie = new Cookie(pName, quantity);
			out.print("Product updated in the Cart");
		}else if(choice.equalsIgnoreCase("Remove From Card")) {
			String pName = req.getParameter("pName");
			String quantity = req.getParameter("quantity");
			Cookie cookie = new Cookie(pName, quantity);
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			out.print("Product Removed from the Cart");
		}else if(choice.equalsIgnoreCase("View Card")) {
			Cookie cookies[] = req.getCookies();
			for(Cookie cookie:cookies) {
				out.print("<h2>");
				out.print(cookie.getName()+" "+cookie.getValue());
				out.print("</h2>");
			}
		}
	}
}