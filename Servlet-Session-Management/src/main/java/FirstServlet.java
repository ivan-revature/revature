
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(description = "Logs user out of current session", urlPatterns = { "/FirstServlet" })
public class FirstServlet extends HttpServlet {
	//static final long serialVersionUID = 0;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		response.sendRedirect("http://www.google.com?name="+ name);
		out.close();
	}
}
