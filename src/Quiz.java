import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Quiz {
	
	public static void main(String[] args) throws SQLException {
		inicio();
	}
	
	public static void inicio() throws SQLException {
		String resp = JOptionPane.showInputDialog(null, "Bem vindo! \n \n Escolha: \n 1) Menu \n 2) Quiz");
		if(resp != null) {
			switch(resp) {
				case "1":
					menu();
					break;
				case "2":
					System.out.println("Jogar");
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
	
	// Menu de opções
	public static void menu() throws SQLException {
		String resp = JOptionPane.showInputDialog(null, "Menu \n \n Escolha: \n 1) Cadastrar questões");
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
	
	// Tela cadastro
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
		form[7] = "Deseja salvar este formulário?";
		
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
						qst.setQuestao(perg);
						break;
					case 1:
						qst.setAlternativaA(perg);
						break;
					case 2:
						qst.setAlternativaB(perg);
						break;
					case 3:
						qst.setAlternativaC(perg);
						break;
					case 4:
						qst.setAlternativaD(perg);
						break;
					case 5:
						qst.setAlternativaE(perg);
						break;
					case 6:
						if(perg.length() > 1) {
							i--;
							JOptionPane.showMessageDialog(null, "A resposta deve conter apenas 1 caracter. \nExemplo: A", "Erro", 0);
						} else {
							qst.setResposta(perg);
						}
						break;
					case 7:
						if(perg.equalsIgnoreCase("s")) {
							qst.saveQuestion();
						} else {
							JOptionPane.showMessageDialog(null, "Os formulário não foi salvo! Você será direcionado ao menu.1", "Atenção", 2);
							menu();
							break;
						}
				}
			} else {
				menu();
				break;
			}
		}
	}
	
}
