package jdbcExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	Connection con;
	PreparedStatement pstmt;
	
	String url ="jdbc:mysql://localhost:3306/trialdb";
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String pwd = "";

	public DBConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("The connection is created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		String query = "create table employee (name varchar(10), salary int, designation varchar(10))";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.execute();
			System.out.println("Created table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertData(String name, int salary, String desig) {
		String query = "insert into employee(name, salary,designation) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setInt(2,salary);
			pstmt.setString(3,desig);
			int rows = pstmt.executeUpdate();
			System.out.println("Inserted"+ rows + "rows");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getAllEmployees() {
		ResultSet rs = null;
		String query = "select * from employee";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getEmployee(String name) {
		ResultSet rs = null;
		String query = "select  name, designation from employee where name=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int updateEmployee(String name) {
		int rs = 0;
		String query = "UPDATE employee SET name = 'Peter1' WHERE name=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,name);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int deleteEmployee(String name) {
		int rs = 0;
		String query = "DELETE FROM employee WHERE name=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,name);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
