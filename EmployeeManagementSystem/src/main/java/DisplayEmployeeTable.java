import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

@SuppressWarnings("serial")
@WebServlet(description = "Displays employee table", urlPatterns = { "/DisplayEmployeeTable" })
public class DisplayEmployeeTable extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		String formCommand = request.getParameter("formSubmit");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		// read fromCommand with switch statement
		
		try {
			ResultSet resultSet = getResultSet();
			displayEmployeeTable(resultSet, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			out.println("Database error: " + e.getMessage());
			out.flush();
			out.close();
		}
	}
	
	private void displayEmployeeTable(ResultSet resSet, PrintWriter out) 
		throws SQLException {
		out.println("<div class='wrapper'>");

		out.println("<form action='DeleteEmployee' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>id</td>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Gender</th>");
		out.println("<th>City</th>");
		out.println("</tr>");
		
		while( resSet.next() ) {
			out.println("<tr>");
			out.println("<td>"); // style='display:none;'
			out.println("<input type='radio' name='sel_empl' "
					+ "value=" + "'" + resSet.getInt(1)
					+ "'" + "/> id"); // &nbsp;&nbsp
			out.println("</td>");
			out.println("<td>");
			out.println(resSet.getString(2));
			out.println("</td>");
			out.println("<td>");
			out.println(resSet.getString(3));
			out.println("</td>");
			out.println("<td>");
			out.println(resSet.getString(4));
			out.println("</td>");
			out.println("<td>");
			out.println(resSet.getString(5));
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='submit' value='Delete' name='formSubmit'/>");
		out.println("<td colspan='2'>");
		out.println("<input type='submit' value='Update' name='formSubmit'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
		return;
	}
	
	private ResultSet getResultSet() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeems", "root", "mySQL1");
		
		//long timeInMilliSeconds;
		Statement statement = conn.createStatement();
		String sqlQry = "SELECT * FROM employees ";
		ResultSet resultSet = statement.executeQuery(sqlQry);
		
		return resultSet;
	}
}