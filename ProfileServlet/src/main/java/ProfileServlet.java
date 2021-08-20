
import java.io.IOException;
import java.io.PrintWriter;


import javax.sql.rowset.serial.SerialException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

public class ProfileServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		int result = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<h1>Welcome to WebCalc</h1>");
		
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		
		// get cookies
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		String name = "";
		if(cookies == null) {
			out.println("<h1>you are new user go to home page and submit your name</h1>");
			return;
		}else {
			for(Cookie c : cookies) {
				String tname =  c.getName();
				if(tname.equals("user_name")){
					flag = true;
					name = c.getValue();
				}
			}
		}
		
		if(flag) {
			out.println("<h1>Hello, "+ name +" welcome back to my website..</h1>");	
		}
		
		
		out.println("</Body>");
		out.println("</Html>");
		//String optype = request.getParameter("operation_type");
//		switch(optype) {
//		case "addition":
//			result = op1 + op2;
//			break;
//		case "subtraction":
//			result = op1 - op2;
//			break;
//		case "multiplication":
//			result = op1 * op2;
//			break;
//		case "division":
//			result = op1 / op2;
//			break;
//		default:
//			out.println("Error: invalid selection.");	
//		}
		// response.
		out.println("Your result is: " + result);
	}
}
