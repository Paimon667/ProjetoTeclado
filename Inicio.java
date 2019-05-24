import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Inicio extends JPanel {

	
	private JButton[] botoes;
	private String[] palavras = { "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
			" Tab ", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "Caps", "A", "S", "D", "F", "G",
			"H", "J", "K", "L", ":", "*", "   Enter   ", "   Shift   ", "Z", "X", "C", "V", "B", "N", "M", ",", ".",
			"?", "^", "                                                                    ", "<", "v", ">" };
	private Box[] teclado;
	private JPanel baixo;
	private JTextArea cima;
	
	
	
	public Inicio() {
		setLayout(new BorderLayout());

		cima = new JTextArea(10, 60);               // Instanciando e adicionando a área de texto ao topo panel principal
		cima.setEditable(false);                    // deixando ineditável
		

		teclado = new Box[5];                       // Instanciando a array de boxes
		botoes = new JButton[57];                   // Instanciando a array de botões
		
		baixo = new JPanel(new GridLayout(5,1,6,6)); //Instanciando o panel onde serão colocados os boxes de teclas

		for (int i = 0; i < 5; i++) {
			teclado[i] = Box.createHorizontalBox(); // Instanciando cada box e atribuindo-o à sua posição da array de
													// box
		}

		for (int i = 0; i < botoes.length; i++) {  // instanciando os botões e armazenando-os na array de botões e
												   // adicionando-os aos seus respectivos boxes

			botoes[i] = new JButton(palavras[i]);  // CADA BOX É UMA LINHA DO TECLADO

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
					teclado[3].add(Box.createHorizontalStrut(24));
				}
				teclado[3].add(botoes[i]);
				teclado[3].add(Box.createHorizontalStrut(6));
			} else {                                  // A ULTIMA LINHA É DIFERENTE, ENTÃO TEM VARIOS IF
				if (i == 53) {
					teclado[4].add(Box.createHorizontalStrut(200));
				} else if (i == 54) {
					teclado[4].add(Box.createHorizontalStrut(82));
				}
				teclado[4].add(Box.createHorizontalStrut(6));
				teclado[4].add(botoes[i]);
			}

		} //////////////////// FIM DOS BOTOES
		
		for (int i = 0; i < 5; i++) {                   // Adicionando os boxes das teclas ao panel
			baixo.add(teclado[i]);
		}
		
		add(cima,BorderLayout.NORTH);         // Adicionando a area de texto ao panel principal
		add(baixo, BorderLayout.SOUTH);       // Adicionando o panel baixo ao panel principal
	}
	
	
}
