import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestePangrama extends JPanel {

	JRadioButton[] ChecPangrama;
	ButtonGroup pan;
	String[] Pangramas = { "Um pequeno jabuti xereta viu dez cegonhas felizes",
			"Quem traz CD,LP,fax,engov e whisky jB?", "Gazeta publica hoje breve nota de faxina na quermesse",
			"Jovem craque belga prediz falhas no xote", "Bancos fúteis pagavam-lhe queijo, whisky e xadrez" };
	Box testepangrama;

	public TestePangrama() {

		testepangrama = Box.createVerticalBox(); // instanciando box do teste pangrama

		ChecPangrama = new JRadioButton[5]; // instanciando array de radio buttons
		pan = new ButtonGroup(); // instanciando grupo de botoes

		for (int i = 0; i < ChecPangrama.length; i++) { // instanciando os radio buttons e adicionando-os no grupo e no
														// box vertical
			ChecPangrama[i] = new JRadioButton(Pangramas[i]);
			pan.add(ChecPangrama[i]);
			testepangrama.add(Box.createVerticalStrut(30)); // adicionando espaços entre as opções de radio
			testepangrama.add(ChecPangrama[i]);

		}

		this.add(testepangrama, BorderLayout.CENTER);
	}

}
