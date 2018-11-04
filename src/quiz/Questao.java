package quiz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Classe para objetos do tipo Questao, onde serão contidos valores e métodos para o mesmo.
 * @author anglesson
 * @version 0.1
 */
public class Questao extends DBConnection{
	private Integer id;
	private String questao;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private String alternativaE;
	private String resposta;
	
	/** Método construtor realiza a limpeza dos atributos.
	 * @return void
	 */
	public Questao() {
		this.questao = "";
		this.resposta = "";
		this.alternativaA = "";
		this.alternativaB = "";
		this.alternativaC = "";
		this.alternativaD = "";
		this.alternativaE = "";
	}

	/** Método para preencher o objeto com de acordo com ID passado.
	 * @param id
	 * @return void
	 * @throws SQLException
	 */
	public Questao(Integer id) throws SQLException {
		String query = "SELECT * FROM QUESTOES WHERE IDQUESTAO = '"+id+"'" ;
		Statement stm = this.conect();
		ResultSet res = stm.executeQuery(query);
		while(res.next()) {
			this.id = res.getInt("IDQUESTAO");
			this.questao = res.getString("QUESTAO");
			this.resposta = res.getString("RESPOSTA");
			this.alternativaA = res.getString("ALT_A");
			this.alternativaB = res.getString("ALT_B");
			this.alternativaC = res.getString("ALT_C");
			this.alternativaD = res.getString("ALT_D");
			this.alternativaE = res.getString("ALT_E");
		}
	}
	
	/** Método para inser as questões no banco de dados ou para atualizar as questões.
	 * @return void
	 * @throws SQLException
	 */
	public void saveQuestion() throws SQLException {
		if(this.id == null) {
			String query = "INSERT INTO QUESTOES SET QUESTAO = '"+this.questao+"', RESPOSTA = '"+this.resposta+"', ALT_A = '"+this.alternativaA+"',ALT_B = '"+this.alternativaB+"',ALT_C = '"+this.alternativaC+"',ALT_D = '"+this.alternativaD+"',ALT_E = '"+this.alternativaE+"'";
			Statement stm = this.conect();
			stm.execute(query);
		} else {
			String query = "UPDATE QUESTOES SET QUESTAO = '"+this.questao+"', RESPOSTA = '"+this.resposta+"', ALT_A = '"+this.alternativaA+"',ALT_B = '"+this.alternativaB+"',ALT_C = '"+this.alternativaC+"',ALT_D = '"+this.alternativaD+"',ALT_E = '"+this.alternativaE+"' WHERE '" + this.id + "'";
			Statement stm = this.conect();
			stm.execute(query);
		}
	}
	
	/** Método para selecionar 10 questões de forma aleatória no banco de dados.
	 * @return ResultSet - Questões aleatórias
	 * @throws SQLException
	 */
	public ResultSet getQuestions() throws SQLException {
		String query = "SELECT * FROM QUESTOES ORDER BY RAND() LIMIT 10";
		Statement stm = this.conect();
		ResultSet res = stm.executeQuery(query);
		return res;
	}
	
	/** Método para retorno da pergunta da questão. 
	 * @return String - Questão/Pergunta
	 */
	public String getQuestao() {
		return questao;
	}
	
	/** Método para atribuir um valor à pergunta da questão.
	 * @param String questao - Pergunta de questão.
	 */
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	
	/** Método para retorno da alernativa A da questão.
	 * @return String - Alternativa A
	 */
	public String getAlternativaA() {
		return alternativaA;
	}
	
	/** Método para atribuir um valor à Alternativa A.
	 * @param String alternativaA - Alternativa A da questão.
	 */	
	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}
	
	/** Método para retorno da alernativa B da questão.
	 * @return String - Alternativa B
	 */
	public String getAlternativaB() {
		return alternativaB;
	}
	
	/** Método para atribuir um valor à Alternativa B.
	 * @param String alternativaB - Alternativa B da questão.
	 */	
	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}
	
	/** Método para retorno da alernativa C da questão.
	 * @return String - Alternativa C
	 */
	public String getAlternativaC() {
		return alternativaC;
	}
	
	/** Método para atribuir um valor à Alternativa C.
	 * @param String alternativaC - Alternativa C da questão.
	 */	
	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}
	
	/** Método para retorno da alernativa D da questão.
	 * @return String - Alternativa D
	 */
	public String getAlternativaD() {
		return alternativaD;
	}
	
	/** Método para atribuir um valor à Alternativa D.
	 * @param String alternativaD - Alternativa D da questão.
	 */	
	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}
	
	/** Método para retorno da alernativa E da questão.
	 * @return String - Alternativa E
	 */
	public String getAlternativaE() {
		return alternativaE;
	}
	
	/** Método para atribuir um valor à Alternativa E.
	 * @param String alternativaE - Alternativa E da questão.
	 */	
	public void setAlternativaE(String alternativaE) {
		this.alternativaE = alternativaE;
	}
	
	/** Método para retorno da resposta da questão.
	 * @return String - Resposta da questão
	 */
	public String getResposta() {
		return resposta;
	}
	
	/** Método para atribuir um valor à resposta da questão.
	 * @param String resposta - resposta da questão.
	 */	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	/** Método para retorno do ID da questão.
	 * @return Integer - ID da questão
	 */
	public Integer getId() {
		return id;
	}
	
}
