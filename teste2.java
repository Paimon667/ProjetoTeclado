
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class teste2 extends JFrame {
	
/////////////////////////////////////////////////////////TUDO DA ABA INICIO////////////////////////////////////////////////////////

	private JButton[] botoes;
	private String[] palavras = { "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
			"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "Caps Lock", "A", "S", "D", "F", "G",
			"H", "J", "K", "L", ":", "*", "Enter", "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".",
			"?", "^", "                                                                    ", "<", "v", ">" };
	private Box[] teclado;
	private JPanel baixo;
	private JTextArea cima;
	private JLabel panDigitar;
	private String[] especiais = {"Caps Lock","Shift","Espaço","Esquerda","Direita","Abaixo","Acima","Ponto-e-Vírgula","Vírgula","Ponto Final",
			"Desconhecido keyCode: 0x0","Teclado Numérico *,","Enter,","Parêntese de Abertura","Parêntese de Fechamento","Teclado Numérico +","Teclado Numérico -","Barra Invertida"};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////TUDO DA ABA PANGRAMA///////////////////////////////////////////////////
	private JRadioButton[] ChecPangrama;
	private ButtonGroup pan;
	private String[] Pangramas = {"Um pequeno jabuti xereta viu dez cegonhas felizes","Quem traz CD,LP,fax,engov e whisky jB?",
			"Gazeta publica hoje breve nota de faxina na quermesse","Jovem craque belga prediz falhas no xote","Bancos fúteis pagavam-lhe queijo, whisky e xadrez"};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//////////////////////////////////////////////////////////////TUDO DO FRAME/////////////////////////////////////////////////////////
	private JPanel Inicio;
	private Box TestePangrama;
	private JTabbedPane abas;
	private Color padrao=new JButton("a").getBackground();
	private int BotaoAtual=0;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	public teste2() {
		super("aaaa");
		setLayout(new FlowLayout());                // Layout do Frame
		getContentPane().setBackground(Color.cyan); // COR DO BACKGROUND

		abas = new JTabbedPane();                   // INSTANCIANDO AS ABAS
	
///////////////////////////////////////////*INICIO DA ABA PRINCIPAL*////////////////////////////////////////////////////////////////////////

		Inicio = new JPanel(new BorderLayout());    // PAINEL PRINCIPAL PARA SER ALOCADO ÀS ABAS

		cima = new JTextArea(10, 60);               // Instanciando e adicionando a área de texto ao topo panel principal
		cima.setEditable(false);                    // deixando ineditável
		
		panDigitar = new JLabel();               // Instanciando o label com o pangrama a ser digitado		
		panDigitar.setText("                                                                      Teste sua habilidade escolhendo um pangrama");

		teclado = new Box[5];                       // Instanciando a array de boxes
		botoes = new JButton[57];                   // Instanciando a array de botões

		for (int i = 0; i < 5; i++) {
			teclado[i] = Box.createHorizontalBox(); // Instanciando cada box e atribuindo-o à sua posição da array de
													// box
		}
		AcoesBotoes acaobotao = new AcoesBotoes();
		cima.addKeyListener(acaobotao);

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
					teclado[3].add(Box.createHorizontalStrut(25));
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

		baixo = new JPanel(new GridLayout(5, 1, 6, 6)); // Instanciando o panel do teclado onde serão colocados os boxes

		for (int i = 0; i < 5; i++) {                   // Adicionando os boxes das teclas ao panel
			baixo.add(teclado[i]);
		}
		
		Inicio.add(cima,BorderLayout.NORTH);         // Adicionando a area de texto ao panel principal
		Inicio.add(panDigitar,BorderLayout.CENTER);  // adicionando o label ao meio do panel principal
		Inicio.add(baixo, BorderLayout.SOUTH);       // Adicionando o panel baixo ao panel principal
		
		abas.addTab("Inicio", Inicio);               // Adicionando o panel principal à uma das abas
		
///////////////////////////////////////////*FIM DA ABA PRINCIPAL*/////////////////////////////////////////////////////////////////
		
///////////////////////////////////////////* INICIO DA ABA PANGRAMA*//////////////////////////////////////////////////////////////
		
		TestePangrama = Box.createVerticalBox() ;     // instanciando box do teste pangrama
		
		ChecPangrama = new JRadioButton[5];           // instanciando array de radio buttons
		pan = new ButtonGroup();                      // instanciando grupo de botoes
		
		for(int i=0;i<ChecPangrama.length;i++) {           // instanciando os radio buttons e adicionando-os no grupo e no box vertical
			ChecPangrama[i]= new JRadioButton(Pangramas[i]);
			pan.add(ChecPangrama[i]);
			TestePangrama.add(Box.createVerticalStrut(25));    // adicionando espaços entre as opções de radio
			TestePangrama.add(ChecPangrama[i]);
		}
		
		abas.addTab("Teste Pangrama", TestePangrama);     // ADicionando o box vertical nas abas
		
//////////////////////////////////////////////*FIM DA ABA PANGRAMA*//////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(abas,BorderLayout.CENTER);			 // Adicionando as abas ao frame

	} // Fim construtor
	
	
	public class AcoesBotoes implements KeyListener{

		public void keyPressed(KeyEvent x) {
			
			boolean achei=false;
			
			System.out.println(x.getKeyText(x.getKeyCode()));
			
			for(int i=0;i<botoes.length;i++) { 
				if(botoes[i].getText().equalsIgnoreCase(x.getKeyText(x.getKeyCode()))) {
					botoes[i].setBackground(Color.black);
					achei=true;
					BotaoAtual=i;
					break;
				}
			}
			
			
			
			
			
		}


		public void keyReleased(KeyEvent x) {
			
			botoes[BotaoAtual].setBackground(padrao);
			
		}


		public void keyTyped(KeyEvent x) {

			
		}
		
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		teste2 t = new teste2();
		t.setSize(800, 400);
		t.setVisible(true);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setResizable(false);
	}

}
