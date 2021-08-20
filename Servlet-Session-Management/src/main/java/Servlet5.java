import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(description = "get val from qry string", urlPatterns = { "/Servlet5" })
public class Servlet5 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// getting the value from query string
		String name = request.getParameter("name");
		out.print("Welcome "+ name);
		
		HttpSession session = request.getSession();
		session.setAttribute("uname", name);
		
		
		out.println("<a href='Servlet6'>Click Here</a>");
		
		out.close();
	}
}