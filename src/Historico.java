import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Historico extends JPanel implements Serializable {

	public JTextArea texto;
	private ObjectOutputStream escrever;
	private ObjectInputStream ler;
	private JButton carregar;

	public Historico() {

		
		setLayout(new BorderLayout());
		texto = new JTextArea(50, 50);
		texto.setEditable(false);
		add(texto,BorderLayout.NORTH);
		try {
			escrever = new ObjectOutputStream(new FileOutputStream("arquivo.ser"));
		} catch (FileNotFoundException Erro) {

		}
		catch(IOException errin) {
			
		}
	}

	public void Escrever(String a) {
		try {
		escrever.writeObject(a);
		Ler();
		}
		catch(IOException errin) {
			
		}
	}
	public void Ler() {
		try {
		ler = new ObjectInputStream(new FileInputStream("arquivo.ser"));
		texto.setText("");
		while(true) {
			texto.setText(texto.getText()+"\n"+ler.readObject());
		}
		}
		catch(IOException erro) {
			
		}
		catch(ClassNotFoundException erro) {
			
		}
		
	}
	

}
