

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Authenticates user, adds him to current session", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		String username = request.getParameter("user_name");
		String userpassword = request.getParameter("user_password");
		
		if(username.equals("admin") && userpassword.equals("123")) {
			out.println("You are successfully logged in!");
			out.println("<br>Welcome "+ username);
			
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie);
		}else {
			out.println("Sorry! Invalid credentials");
			RequestDispatcher rd =  request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.close();		
	}

}
