import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(description = "Creates a form with an invisible text field", urlPatterns = { "/Servlet1" })
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.print("Welcome "+ name);
		
		// creating a form that have invisible text field
		out.println("<form action='Servlet2'>");
		out.println("<input type='hidden' name='uname' value='"+name+"'/>");
		out.println("<input type='submit' value='send'>");
		out.println("</form>");
		out.close();
	}
}
