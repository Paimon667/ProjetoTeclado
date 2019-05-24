import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Frame extends JFrame {

	Inicio inicio;
	JTabbedPane abas;
	TestePangrama testepangrama;  
	JLabel panDigitar;  // LABEL COMPARTILHAVEL, TIVE QUE COLOCAR NO FRAME E ADICIONA-LO SEPARADAMENTE AO INICIO

	public Frame() {
		super("Titulo");
		inicio = new Inicio();
		panDigitar = new JLabel();                              //LABEL COMPARTILHADO
		
		panDigitar.setText(
				"                                                                      Teste sua habilidade escolhendo um pangrama");
		
		inicio.add(panDigitar, BorderLayout.CENTER);
		
		testepangrama = new TestePangrama();
		AcaoRadio aaa = new AcaoRadio();                                //TIVE QUE CRIAR A AÇÃO AQUI PARA PODER ALTERAR O LABEL COMPARTILHAVEL ENTRE AS DUAS CLASSES INICIO E TESTEPAN
		for (int i = 0; i < testepangrama.ChecPangrama.length; i++) {
			testepangrama.ChecPangrama[i].addItemListener(aaa);
		}
		
		
		
		abas = new JTabbedPane();
		abas.addTab("Principal", inicio);
		abas.addTab("Teste Pangrama", testepangrama);
		this.add(abas);
	}
	
	
	

	public class AcaoRadio implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			String texto="";

			for (int i = 0; i < 5; i++) {
				if (testepangrama.ChecPangrama[i].isSelected()) {
					texto = testepangrama.Pangramas[i];
					break;
				}
			}
			
			panDigitar.setText("                                                                   "+texto);

		}

	}
	
	
	

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setVisible(true);
		f.setSize(730, 400);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setResizable(false);
	}

}
