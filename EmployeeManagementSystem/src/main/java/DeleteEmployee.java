import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//import com.javatrain.Project0.DBConnection;

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
@WebServlet(description = "Deletes employee record from DB", urlPatterns = { "/DeleteEmployee" })
public class DeleteEmployee extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("navbar.html").include(request, response);
		try {
			int empl_id = Integer.parseInt(request.getParameter("sel_empl"));
			if( deleteEmployee(empl_id) ) {
				out.println("Delete was sucessful.");
			} else {
				out.println("Delete was unsuccessful.");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			out.println("Database error: " + e.getMessage());
			out.flush();
			out.close();
		}
	}
	
	private boolean deleteEmployee( int empID )
			throws SQLException, ClassNotFoundException {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeems", "root", "mySQL1");
			
			String sqlQry = "DELETE FROM employees "
					+ "WHERE id = " + empID;
			PreparedStatement prepStatement = conn.prepareStatement(sqlQry);
			// Get today's date for 'transactionDate' field
//			Date javaDate = new Date();
//			java.sql.Date nowDate;
//		    long timeInMilliSeconds;

			prepStatement.execute(sqlQry);
			if( prepStatement.getUpdateCount() > 0 ) {
				System.out.println("Employee removed.");
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
	}
}
