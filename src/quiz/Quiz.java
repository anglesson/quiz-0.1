package quiz;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/** Classe para realizar as apresentações das telas do Quiz.
 * 
 * @author anglesson
 * @version 0.1
 */
public class Quiz {
	
	/** Método principal da classe, a partir dela que é iniciada a aplicação. 
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		inicio();
	}
	
	/** Método para montagem e exibição da tela inicial do Quiz
	 * 
	 * @throws SQLException
	 */
	public static void inicio() throws SQLException {
		String resp = JOptionPane.showInputDialog(null, "Bem vindo! \n\n1) Menu \n2) Quiz\n \n", "QUIZ", 1);
		if(resp != null) {
			switch(resp) {
				case "1":
					menu();
					break;
				case "2":
					jogar();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite uma opção válida");
					inicio();
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Até a próxima!");
		}
	}
	
	/** Método para montagem e exibição da tela de Menu do Quiz.
	 * 
	 * @throws SQLException
	 */
	public static void menu() throws SQLException {
		String resp = JOptionPane.showInputDialog(null, "Escolha: \n\n1) Cadastrar questões \n\n", "Menu", 1);
		if(resp != null) {
			switch(resp) {
				case "1":
					telaCadastro();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite uma opção válida");
					menu();
					break;
			}
		} else {
			inicio();
		}
	}
	
	/** Método para montagem e exibição da tela de cadastro das questões do Quiz.
	 * 
	 * @throws SQLException
	 */
	public static void telaCadastro() throws SQLException {
		// 0-Error 1-Info 2-Alert 3-Question
		// JOptionPane.showInputDialog(null, "Teste", "Titulo", 2);
		JOptionPane.showMessageDialog(null,"Cadastro de questão \nSerá solcitado que você preencha as informações na seguinte ordem: \n1-Pergunta \n2-Alternativas(A,B,C,D,E) \n3-Resposta");
		
		String[] form;
		form = new String[8];
		
		form[0] = "Descreva a pergunta.";
		form[1] = "Descreva a alternativa A.";
		form[2] = "Descreva a alternativa B.";
		form[3] = "Descreva a alternativa C.";
		form[4] = "Descreva a alternativa D.";
		form[5] = "Descreva a alternativa E.";
		form[6] = "Digite a resposta.";
		form[7] = "Deseja salvar este formulário?(S/N)";
		
		Questao qst = new Questao();
		
		for(int i=0; i<=7; i++) {
			String formulario = "Pergunta: " + qst.getQuestao() +  
					"\n" + 
					"A) " + qst.getAlternativaA() + "\n" +
					"B) " + qst.getAlternativaB() + "\n" +
					"C) " + qst.getAlternativaC() + "\n" +
					"D) " + qst.getAlternativaD() + "\n" +
					"E) " + qst.getAlternativaE() + "\n" +
					"Resposta: " + qst.getResposta() + "\n\n" +
					form[i];
			String perg = JOptionPane.showInputDialog(null, formulario, "Cadastro de Questões", 1);
			if(perg != null) {
				switch(i) {
					case 0:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setQuestao(perg);
						break;
					case 1:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setAlternativaA(perg);
						break;
					case 2:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setAlternativaB(perg);
						break;
					case 3:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setAlternativaC(perg);
						break;
					case 4:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setAlternativaD(perg);
						break;
					case 5:
						if(perg.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Você precisa digitar algo", "Erro", 0);
							i--;
						}
						qst.setAlternativaE(perg);
						break;
					case 6:
						// Verifica se a resposta está sendo digita corretamente entre as alternativas A,B,C,D,E.
						if(perg.length() == 1 && (perg.equalsIgnoreCase("A") || perg.equalsIgnoreCase("B") || perg.equalsIgnoreCase("C") || perg.equalsIgnoreCase("D") || perg.equalsIgnoreCase("E")) ) {
							qst.setResposta(perg);
						} else {
							i--;
							JOptionPane.showMessageDialog(null, "A resposta deve conter apenas 1 caracter. Digite apenas a letra correpondente à resposta. \nExemplo: A", "Erro", 0);
						}
						break;
					case 7:
						if(perg.equalsIgnoreCase("s")) {
							try {
								qst.saveQuestion();
								JOptionPane.showMessageDialog(null, "Os dados foram armazenados com sucesso!", "Sucesso", 1);
								menu();
							} catch(Exception e) {
								// Em caso de erro ao gravar os dados, será avisado e direcionado para o final do formulário.
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage(), "Erro", 0);
								i--;
							}
						} else if(perg.equalsIgnoreCase("n")) {
							// Gravar os dados, avisa e direciona para o menu.
							JOptionPane.showMessageDialog(null, "Os formulário não foi salvo! Você será direcionado ao menu.", "Atenção!", 2);
							menu();
						} else {
							JOptionPane.showMessageDialog(null, "Responda apenas com 's' para sim ou 'n' para não", "Atenção!", 2);
							i--;
						}
						break;
				}
			} else {
				menu();
				break;
			}
		}
	}
	
	/** Método para montagem e exibição da tela de jogo do Quiz.
	 * 
	 * @throws SQLException
	 */
	public static void jogar() throws SQLException {
		// 0-Error 1-Info 2-Alert 3-Question
		JOptionPane.showMessageDialog(null, "\nSerá solcitado que você preencha as informações na seguinte ordem: \n1-Pergunta \n2-Alternativas(A,B,C,D,E) \n3-Resposta", "REGRAS DO QUIZ", 1);
		
		// Instância da classe questão
		Questao qst = new Questao();
		
		// Receber o ResultSet
		ResultSet res = qst.getQuestions();
		
		// Declaração de variáveis
		String msg, resp = "";
		Integer pontos, i;
		pontos = 0;
		i=1;
		
		// Percorrer com laço
		while(res.next()) {
			// Montar quadro de perguntas
			msg = "Pergunta: " + res.getString("QUESTAO") + "\n" + 
					"\n" + 
					"A) " + res.getString("ALT_A") + "\n" +
					"B) " + res.getString("ALT_B") + "\n" +
					"C) " + res.getString("ALT_C") + "\n" +
					"D) " + res.getString("ALT_D") + "\n" +
					"E) " + res.getString("ALT_E");
			
			// Painel de Pergunta
			do {
				resp = JOptionPane.showInputDialog(null, msg, "Pergunta "+i+" de 10", 3);
				
				if(resp == null) {
					JOptionPane.showMessageDialog(null, "Você cancelou o quiz. Todo o progresso foi perdido. Tente novamente!", "Erro", 0);
					inicio();
				}
				// Verifica se a resposta está sendo digita corretamente entre as alternativas A,B,C,D,E.
				if( resp.length() != 1 ) {
					JOptionPane.showMessageDialog(null, "Digite uma resposta válida, com apenas um caractere. \nExemplo: D");
				} else if(!resp.equalsIgnoreCase("A") && !resp.equalsIgnoreCase("B") && !resp.equalsIgnoreCase("C") && !resp.equalsIgnoreCase("D") && !resp.equalsIgnoreCase("E")) {
					JOptionPane.showMessageDialog(null, "Somente as letras A, B, C, D e E são válidas. \nExemplo: D");
				}
			} while(!resp.equalsIgnoreCase("A") && !resp.equalsIgnoreCase("B") && !resp.equalsIgnoreCase("C") && !resp.equalsIgnoreCase("D") && !resp.equalsIgnoreCase("E"));
			
			// Compara resposta respondida
			if(res.getString("RESPOSTA").equalsIgnoreCase(resp)) {
				pontos++;
			}
			// Contador de questao
			i++;
		}
		
		// Exibe Resultado
		if(pontos <= 5) {
			JOptionPane.showMessageDialog(null, "Você acertou "+pontos+" sua pontuação foi ruim. Estude mais um pouco!");
		}
	}
	
}
