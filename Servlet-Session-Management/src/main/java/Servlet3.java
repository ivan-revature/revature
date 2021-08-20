import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(description = "append the user name in the query string", urlPatterns = { "/Servlet3" })
public class Servlet3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.println("Welcome " + name);
		
		// append the user name in the query string
		out.println("<h1><a href='Servlet4?name="+ name+ "'>Click Here</a></h1>");
		out.close();
	}
}
