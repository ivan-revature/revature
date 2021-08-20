
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

public class WebCalc extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		int result = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to WebCalc</h1>");
		
		int op1 = Integer.parseInt(request.getParameter("first_operand"));
		int op2 = Integer.parseInt(request.getParameter("second_operand"));
		String optype = request.getParameter("operation_type");
		switch(optype) {
		case "addition":
			result = op1 + op2;
			break;
		case "subtraction":
			result = op1 - op2;
			break;
		case "multiplication":
			result = op1 * op2;
			break;
		case "division":
			result = op1 / op2;
			break;
		default:
			out.println("Error: invalid selection.");	
		}
		// response.
		out.println("Your result is: " + result);
	}
}
