package quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/** Classe para conexão com o banco de dados Mysql.
 * @author anglesson
 * @version 0.1
 */

public class DBConnection {
	// Atributos
	private Connection conn = null;
	private Statement stm = null;
	
	/** Método para conectar ao banco de dados. 
	 * @return Statement - Conexão
	 */
	public Statement conect() {
		String server = "jdbc:mysql://localhost:3306/QUIZ";
		String user = "insira_seu_usuário";
		String pass = "insira_sua_senha";
		try {
			//Class.forName(driver);
			this.conn = DriverManager.getConnection(server, user, pass);
			this.stm = this.conn.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return stm;
	}
	
	/** Método para testar a conexão com o banco de dados.
	 * @return Boolean
	 */
	public boolean isConnected() {
		if(this.conn != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
