

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "Logs user out of current session", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	static final long serialVersionUID = 0;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		Cookie cookie = new Cookie("username", "");
		response.addCookie(cookie);
		
		out.print("you are logged out successfully!");
		
	}
}
