import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Validate user</Title>");
			out.println("</Head>");
			out.println("<Body>");
			
			String userName = request.getParameter("user_name");
			String userPassword = request.getParameter("user_password");
			if( userName.equals("sundevil") && userPassword.equals("ASU") {
				out.println("<h1>Hello, "+ userName +" welcome to my profile website..</h1>");
				out.println("<h3>You are now logged in!");
				out.println("<h1><a href='profile'>View profile</a></h1>");
				
				
				// create a cookie
				Cookie c = new Cookie("user_name", userName);
				response.addCookie(c);
				c = new Cookie(userName, userPassword);
			}
			
			
			
			out.println("</Body>");
			out.println("</Html>");
		}

	}
}
