package jdbcExample;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String [] args) {
		DBConnection dbCon = new DBConnection();
		//dbCon.createTable();
		/*
		 * dbCon.insertData("Peter", 30000, "Worker"); dbCon.insertData("David", 30000,
		 * "Secretary"); dbCon.insertData("Daniel", 30000, "Operator");
		 * dbCon.insertData("Joe", 30000, "CEO"); dbCon.insertData("Kevin", 30000,
		 * "Service");
		 */
		
		/*
		 * ResultSet rs = dbCon.getAllEmployees();
		 * 
		 * try { while(rs.next()) {
		 * System.out.println(rs.getString("name")+"\t"+rs.getInt("salary")+"\t"+rs.
		 * getString("designation")); } } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		/*
		 * ResultSet rs = dbCon.getEmployee("Peter"); try { while(rs.next()){
		 * System.out.println(rs.getString("name")+"\t"+rs.getString("designation")); }
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		/*
		 * int rows = dbCon.updateEmployee("Peter");
		 * System.out.println("number of rows updated: " + rows);
		 */
		
		int rows = dbCon.deleteEmployee("Peter1");
		System.out.println("number of rows deleted: " + rows);
		
	}
}
