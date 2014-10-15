import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainApp implements ActionListener{
	static JFrame ventana;
	static JTextField field1;
	static JTextField field2;
	static JButton bot1;
	static JButton bot2;
	static JButton bot3;
	static JButton bot4;
	static JButton bot5;
	static JButton bot6;
	static JButton bot7;
	public void creaVentanas(){
		ventana = new JFrame("Prueba Dialogos");
		ventana.setSize(600, 400);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public Container creaPaneles(){
		JPanel pgeneral = new JPanel();
		pgeneral.setLayout(new BorderLayout());
		pgeneral.add(creaPanelBotones(), BorderLayout.SOUTH);
		pgeneral.add(creaPanelTexto(), BorderLayout.NORTH);		
		
		return pgeneral;
	}
	private Component creaPanelTexto() {
		JPanel ptexto = new JPanel();
		field1 = new JTextField();
		field2 = new JTextField();
		ptexto.setLayout(new GridLayout(2,1,0,20));
		ptexto.add(field1, 1,1);
		ptexto.add(field2, 2,1);
		
		
		
		return ptexto;
	}
	private Component creaPanelBotones() {
		JPanel pbotones = new JPanel();
		pbotones.setLayout(new GridLayout(1, 7, 10, 10));
		bot1 = new JButton();
		bot2 = new JButton();
		bot3 = new JButton();
		bot4 = new JButton();
		bot5 = new JButton();
		bot6 = new JButton();
		bot7 = new JButton();
		bot1.setActionCommand("b1");
		bot2.setActionCommand("b2");
		bot3.setActionCommand("b3");
		bot4.setActionCommand("b4");
		bot5.setActionCommand("b5");
		bot6.setActionCommand("b6");
		bot7.setActionCommand("b7");
		return null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "b1":
			break;
		case "b2":
			break;
		case "b3":
			break;
		case "b4":
			break;
		case "b5":
			break;
		case "b6":
			break;
		case "b7":
			break;
		default:
			break;
		}
	}
}
