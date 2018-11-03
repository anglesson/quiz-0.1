import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Questao extends DBConnection{
	private Integer id;
	private String questao;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private String alternativaE;
	private String resposta;
	private Boolean status;
	
	public Questao() {
		this.questao = "";
		this.resposta = "";
		this.alternativaA = "";
		this.alternativaB = "";
		this.alternativaC = "";
		this.alternativaD = "";
		this.alternativaE = "";
	}

	// Preenche Objeto com de acordo com ID passado
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
	
	// Inser as questões no banco de dados
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
	
	// Methods Getters and Setters
	public String getQuestao() {
		return questao;
	}
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	public String getAlternativaA() {
		return alternativaA;
	}
	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}
	public String getAlternativaB() {
		return alternativaB;
	}
	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}
	public String getAlternativaC() {
		return alternativaC;
	}
	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}
	public String getAlternativaD() {
		return alternativaD;
	}
	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}
	public String getAlternativaE() {
		return alternativaE;
	}
	public void setAlternativaE(String alternativaE) {
		this.alternativaE = alternativaE;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	
}
