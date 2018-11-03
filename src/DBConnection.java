import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DBConnection {
	// Attributes
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet res = null;
	
	// function for connection
	public Statement conect() {
		String server = "jdbc:mysql://localhost:3306/QUIZ";
		String user = "root";
		String pass = "";
		try {
			//Class.forName(driver);
			this.conn = DriverManager.getConnection(server, user, pass);
			this.stm = this.conn.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return stm;
	}
	
	// Function for verify connection
	public boolean isConnected() {
		if(this.conn != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
