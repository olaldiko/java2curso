import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Interfaz {
	JFrame ventana;
	Controlador c;
	JTextField cuenta;
	public void creaVentana(){
		ventana = new JFrame();
		ventana.setSize( 400, 400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(crearPanelPrincipal());
		ventana.setVisible(true);
	}

	private Component crearPanelPrincipal() {
		JPanel principal = new JPanel(new BorderLayout());
		principal.add(crearPanelBotones(), BorderLayout.CENTER);
		principal.add(crearPanelTexto(), BorderLayout.NORTH);
		return principal;
	}

	private Component crearPanelTexto() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		cuenta = new JTextField();
		cuenta.setFont(new Font("Arial", Font.BOLD, 20));
		cuenta.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.add(cuenta);
		return panel;
	}

	private Component crearPanelBotones() {
		JPanel botones = new JPanel(new GridLayout(2,2, 10, 10));
		JButton b1, b2, b3, b4;
		b1 = new JButton("Cana");
		b2 = new JButton("Pintxo");
		b3 = new JButton("Vino");
		b4 = new JButton("Total");
		b1.addActionListener(c);
		b1.setActionCommand("Cana");
		b1.setIcon(new ImageIcon("./Img/cerveza.jpg"));
		b2.addActionListener(c);
		b2.setActionCommand("Pintxo");
		b2.setIcon(new ImageIcon("./Img/pintxo.jpg"));
		b3.addActionListener(c);
		b3.setActionCommand("Vino");
		b3.setIcon(new ImageIcon("./Img/vino.jpg"));
		b4.addActionListener(c);
		b4.setActionCommand("Total");
		b4.setIcon(new ImageIcon("./Img/total.jpg"));
		botones.add(b1);
		botones.add(b2);
		botones.add(b3);
		botones.add(b4);
		return botones;
	}
	public void setTotal(Double total){
		cuenta.setText(String.valueOf(total));
	}
}
