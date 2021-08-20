
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// import com.javatrain.Project0.DBConnection;

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


//import jakarta.annotation.

@SuppressWarnings("serial")
@WebServlet(description = "Writes new employee record to DB", urlPatterns = { "/AddNewEmployee" })
public class AddNewEmployee extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("navbar.html").include(request, response);
		List<String> employee = new ArrayList<String>();
		
		String emplName = request.getParameter("empl_name");
		employee.add(emplName);
		String emplEmail = request.getParameter("empl_email");
		employee.add(emplEmail);
		String gender = request.getParameter("empl_gender");
		employee.add(gender);
		String city = request.getParameter("empl_city");
		employee.add(city);
		
		try {
			if( addToDB( employee, out ) ) {
				request.getRequestDispatcher("index.html").
					include(request, response);
				out.println("Save was successful.");
			} else {
				out.println("Save was unsuccessful.");
			}
			out.close();
		} catch(Exception e) {
			out.println("Database error: " + e.getMessage());
			out.close();
		}
	}
	
	private boolean addToDB( List<String> empl, PrintWriter pw ) throws SQLException {
		try {
			Connection conn;
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeems", "root", "mySQL1");
			System.out.println("3");
			long timeInMilliSeconds;
			String sqlQry = "INSERT INTO employees "
					+ "(name, email, "
					+ "gender, city) "
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement prepStatement = conn.prepareStatement(sqlQry);
			// Get today's date for 'transactionDate' field
			Date javaDate = new Date();
		    timeInMilliSeconds = javaDate.getTime();
		    java.sql.Date nowDate = new
		    		java.sql.Date(timeInMilliSeconds);
		    prepStatement.setString(1, empl.get(0));
		    prepStatement.setString(2, empl.get(1));
			prepStatement.setString(3, empl.get(2));
			prepStatement.setString(4, empl.get(3));
			prepStatement.execute();
			
			if( prepStatement.getUpdateCount() > 0 ) {
				return true;
			} else {
				return false;
			}
		} catch ( Exception e ) {
			pw.println( "Database error: " + e.getMessage() );
			return false;
		}
	}
}
