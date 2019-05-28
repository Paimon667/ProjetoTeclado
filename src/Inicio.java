import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Inicio extends JPanel {

	JButton[] botoes;
	String[] palavras = { "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace", " Tab ", "Q",
			"W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "Caps", "A", "S", "D", "F", "G", "H", "J", "K",
			"L", ":", "*", "   Enter   ", "   Shift   ", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^",
			"                                                                 ", "<", "v", ">" };
	Box[] teclado;
	JPanel baixo;
	JTextArea cima;
	JPanel meio;		//UMA ARRAY COM AS TECLAS ESPECIAIS, TEM O CODIGO DELA PRA PROCURAR E A POSICAOO DELA PRA RETORNAR
	String[][] especiais = {{"131","0"},{"45","11"},{"107","12"},{"91","25"},{"93","26"},{"92","27"},{"20","28"},
			{"59","38"},{"106","39"},{"10","40"},{"16","41"},{"44","49"},{"46","50"},{"47","51"},{"38","52"},{"32","53"},{"37","54"},{"40","55"},{"39","56"}};
	public Inicio() {
		setLayout(new BorderLayout());

		cima = new JTextArea(10, 60); // Instanciando e adicionando a area de texto ao topo do panel principal
		cima.setEditable(false); // deixando ineditavel

		teclado = new Box[5]; // Instanciando a array de boxes (onde cada um e uma linha do teclado)
		botoes = new JButton[57]; // Instanciando a array de botoes

		baixo = new JPanel(new GridLayout(5, 1, 6, 6)); // Instanciando o panel onde serao colocados os boxes de teclas

		for (int i = 0; i < 5; i++) {
			teclado[i] = Box.createHorizontalBox(); // Instanciando cada box e atribuindo-o a sua posicao da array de
													// box
		}

		for (int i = 0; i < botoes.length; i++) { // instanciando os botoes e armazenando-os na array de botoes e
													// adicionando-os aos seus respectivos boxes

			botoes[i] = new JButton(palavras[i]); // CADA BOX E UMA LINHA DO TECLADO

			if (i < 14) {
				teclado[0].add(botoes[i]);
				teclado[0].add(Box.createHorizontalStrut(6));
			} else if (i < 28) {
				teclado[1].add(botoes[i]);
				teclado[1].add(Box.createHorizontalStrut(6));
			} else if (i < 41) {
				teclado[2].add(botoes[i]);
				teclado[2].add(Box.createHorizontalStrut(6));
			} else if (i < 53) {
				if (i == 52) {
					teclado[3].add(Box.createHorizontalStrut(17));
				}
				teclado[3].add(botoes[i]);
				teclado[3].add(Box.createHorizontalStrut(6));
			} else {  // A ultima linha do teclado possui caracteristicas diferentes das demais
				if (i == 53) {
					teclado[4].add(Box.createHorizontalStrut(200));
				} else if (i == 54) {
					teclado[4].add(Box.createHorizontalStrut(82));
				}
				teclado[4].add(Box.createHorizontalStrut(6));
				teclado[4].add(botoes[i]);
			}

		} //////////////////// FIM DOS BOTOES

		for (int i = 0; i < 5; i++) { // Adicionando os boxes das teclas ao panel baixo, onde fica o teclado
			baixo.add(teclado[i]);
		}

		add(cima, BorderLayout.NORTH); // Adicionando a area de texto ao panel principal
		add(baixo, BorderLayout.SOUTH); // Adicionando o panel baixo ao panel principal (teclado)
		meio = new JPanel(new BorderLayout()); // Panel onde vai ficar o resultado e tambem o pangrama a ser digitado
						
		add(meio, BorderLayout.CENTER);
	}

	public int ProcurarBotao(KeyEvent a) {       // PROCURA NOS BOTOES NORMALMENTE, DEPOIS SE N ACHAR OLHA NOS ESPECIAIS
		boolean achei = false;
		int i = 0;		
		for (JButton b : botoes) {
			if (b.getText().equalsIgnoreCase(a.getKeyText(a.getKeyCode()))) {
				achei=true;
				break;
			}
			i++;
		}
		if(achei==false) {
			for(i=0;i<especiais.length;i++) {
				if(a.getKeyCode()==Integer.parseInt(especiais[i][0])) {	//COLUNA 0 TEM O CODIGO DO BOTAO PRA COMPARAR
					i=Integer.parseInt(especiais[i][1]);				// COLUNA 1 TEM A POSICAO NA ARRAY DE BOTOES
					achei=true;
					break;
				}
			}
		}
		else if(achei==false) {
			if(a.getKeyCode()==KeyEvent.VK_TAB) {
				i=14;
				achei=true;
			}
		}
		return achei? i:-1;
	}

}
