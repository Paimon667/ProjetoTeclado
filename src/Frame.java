import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class Frame extends JFrame {

	private Inicio inicio;
	private JTabbedPane abas;
	private TestePangrama testepangrama;
	private JLabel panDigitar; // LABEL COMPARTILHAVEL, TIVE QUE COLOCAR NO FRAME E ADICIONA-LO SEPARADAMENTE
						// AO INICIO
	private JLabel acertos; // LABEL COMPARTILHAVEL, TIVE QUE COLOCAR NO FRAME E ADICIONA-LO SEPARADAMENTE
					// AO INICIO
	private int TeclaAtual = 0;
	private int Acertos=0;
	private int Erros=0;
	private String panPadrao=("Teste sua habilidade escolhendo um pangrama");
	private Historico historico;


	public Frame() {
		super("Titulo");
		inicio = new Inicio();
		panDigitar = new JLabel(); // LABEL COMPARTILHADO

		panDigitar.setText(panPadrao);
		
		historico = new Historico();

		acertos = new JLabel("");
		inicio.meio.add(panDigitar, BorderLayout.SOUTH); // adicionando os labels compartilhaveis no panel meio do
															// inicio
		inicio.meio.add(acertos, BorderLayout.NORTH);

		testepangrama = new TestePangrama();
		AcaoRadio aaa = new AcaoRadio(); // TIVE QUE CRIAR A A��O AQUI PARA PODER ALTERAR O LABEL COMPARTILHAVEL ENTRE
											// AS DUAS CLASSES INICIO E TESTEPAN
		for (int i = 0; i < testepangrama.ChecPangrama.length; i++) {
			testepangrama.ChecPangrama[i].addItemListener(aaa);
		}

		AcaoBotoes b = new AcaoBotoes();
		inicio.cima.addKeyListener(b);

		abas = new JTabbedPane();
		abas.addTab("Principal", inicio);
		abas.addTab("Teste Pangrama", testepangrama);
		abas.addTab("Histórico", historico);
		this.add(abas);
	}

	public class AcaoRadio implements ItemListener { // ACAO Q MUDA O LABEL DO PAN DIGITAR

		public void itemStateChanged(ItemEvent e) {

			String texto = "";

			for (int i = 0; i < 5; i++) {
				if (testepangrama.ChecPangrama[i].isSelected()) {
					texto = testepangrama.Pangramas[i];
					inicio.cima.setText("");
					TeclaAtual = 0;
					acertos.setText("");
					break;
				}
			}

			panDigitar.setText("" + texto);

		}

	}

	public class AcaoBotoes implements KeyListener { // ACAO DOS BOTOES DO TECLADO

		Color padrao = inicio.botoes[0].getBackground();

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {  // primeiro checa se encontrou o botão, caso não, lança uma exceção e da erro
			try {							  // ARMAZENA A POSIÇÃO DO BOTAO NA VARIAVEL VARIAVEL	
				int variavel = inicio.ProcurarBotao(e);
				
				
				
				if (variavel < 0) {			//CHECA SE O PANGRAMA TERMINOU (SE A TECLA ATUAL FOR MAIOR QUE O TAMANHO DELE)
					throw new Exception();	//MUDA A COR DE PRETO CASO ACERTE, VERMELHO CASO ERRE
				}				// DESCONSIDERA CAPS LOCK E SHIFT NA CONTAGEM DE ACERTOS E ERROS E TECLA ATUAL
				
				
				
				
				if(variavel==40) {          // SE EU APERTEI ENTER
					if(panDigitar.getText()!=panPadrao) {
					TeclaAtual=999;
					}
					
				}   // SE A TECLA NÃO FOR ENTER
				
				
				if (TeclaAtual < panDigitar.getText().length() && panDigitar.getText()!=panPadrao) { 
					if (e.getKeyChar() == panDigitar.getText().charAt(TeclaAtual)) {//INCREMENTA A TECLA ATUAL A CADA TENTATIVA
						inicio.botoes[variavel].setBackground(Color.BLACK);
						inicio.cima.setText(inicio.cima.getText()+e.getKeyChar());
						TeclaAtual++;
						Acertos++;
						}
			

					 else {
						if (variavel == 28 || variavel == 41 || variavel == 13) {
							inicio.botoes[variavel].setBackground(Color.black);
							if(variavel==13) {
								inicio.cima.setText(inicio.cima.getText().substring(0, inicio.cima.getText().length()-1));
								TeclaAtual--;
							}
						} else {
							inicio.botoes[variavel].setBackground(Color.RED);
							inicio.cima.setText(inicio.cima.getText()+e.getKeyChar());
							TeclaAtual++;
							Erros++;
						}
					 }
				}
					
				
				
				else {
					
					if(TeclaAtual>0) {
						acertos.setText("Acertos: "+Acertos+" Erros: "+Erros);
						String extra=(Erros==0 && TeclaAtual==panDigitar.getText().length())? " A frase foi digitada corretamente":" A frase não foi digitada corretamente";
						acertos.setText(acertos.getText()+extra);
						historico.Escrever(inicio.cima.getText());
						
					}
					panDigitar.setText(panPadrao);
					TeclaAtual = 0;
					inicio.cima.setText("");
					Acertos=0;
					Erros=0;
					
				}

			}

			catch (Exception x) {
				JOptionPane.showMessageDialog(null, "Tecla Inválida !!!", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		public void keyReleased(KeyEvent e) {

			try {
				int variavel = inicio.ProcurarBotao(e);
				if (variavel < 0) {
					throw new Exception();
				}
				inicio.botoes[variavel].setBackground(padrao);
			} catch (Exception x) {

			}

		}

	}

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setVisible(true);
		f.setSize(750, 380);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setResizable(true);
	}

}
