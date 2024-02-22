/**
 * @author Sivasankar C(EXPLEO)
 * @since 16 FEB 2024
 * Create a JDBC code to execute following queries with HR Database schema: 
	a) Delete the employee whose department_id is 80 and job_id is ‘AD_VP’   
	b) Display the firstname, lastname, job_id, department_id and salary for the employees      
	job_id = ‘ST_CLERK’
 */
package Assessment5.DATA_ACCESS_WITH_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hr_Database {

	public static void main(String[] args) throws ClassNotFoundException {
		
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final  String username = "SYSTEM";
		final String password = "oracle";
		final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		Class.forName(DRIVER);
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully");
			System.out.println("a. Deleting the employee whose department_id is 80 and job_id is 'AD_VP'");
			PreparedStatement ps = con.prepareStatement("delete from DATABASEQUIZ.Employees where department_id = 80 and job_id = 'AD_VP'");
			ps.executeUpdate();
			System.out.println("Employee deleted successfully");
			
			System.out.println("b. Employee details whose job_id is ST_CLERK");
			PreparedStatement ps1 = con.prepareStatement(
					"select first_name, last_name, job_id, department_id, salary from DATABASEQUIZ. employees where job_id = 'ST_CLERK'");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + " "+rs.getString(2) + " " +" "+ rs.getString(3) + " "
						+ " "+ rs.getString(4) + " " +" "+ rs.getInt(5));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
