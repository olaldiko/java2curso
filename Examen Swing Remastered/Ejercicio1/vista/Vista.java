package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Moneda;

public class Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5752211613049689258L;
	public JButton btncambio;
	public JComboBox<Moneda> comboOrigen;
	public JComboBox<Moneda> comboDest;
	public JTextField textOrigen;
	public JTextField textDest;
	public Vista(){
		super();
		this.setSize(400, 250);
		this.add(crearPanelPrincipal());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	private Component crearPanelPrincipal() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(crearPanelNorte());
		JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		sur.add(crearPanelSur());
		panel.add(sur, BorderLayout.SOUTH);
		return panel;
	}
	private Component crearPanelSur() {
		btncambio = new JButton("Mostrar cambio");
		btncambio.setActionCommand("btncambio");
		return btncambio;
	}
	private Component crearPanelNorte() {
		JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
		panel.add(crearPanelIzq());
		panel.add(crearPanelDer());
		return panel;
	}
	private Component crearPanelIzq(){
		JPanel izquierda = new JPanel(new GridLayout(2, 0, 10, 10));
		izquierda.setBorder(BorderFactory.createLoweredBevelBorder());
		JPanel inferior = new JPanel(new BorderLayout());
		inferior.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Cantidad"));
		inferior.add(textOrigen = new JTextField("0.0"));
		izquierda.add(comboOrigen = new JComboBox<>());
		izquierda.add(inferior);
		return izquierda;
	}
	private Component crearPanelDer(){
		JPanel derecha = new JPanel(new GridLayout(2, 0, 10, 10));
		JPanel inferior = new JPanel(new BorderLayout());
		derecha.setBorder(BorderFactory.createLoweredBevelBorder());
		inferior.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Cantidad"));
		inferior.add(textDest = new JTextField("0.0"));
		derecha.add(comboDest = new JComboBox<>());
		textDest.setEnabled(false);
		derecha.add(inferior);
		return derecha;
	}
	public void anadirListeners(ActionListener a, ItemListener i){
		btncambio.setActionCommand("cambio");
		btncambio.addActionListener(a);
		comboOrigen.addItemListener(i);
		comboDest.addItemListener(i);
	}
}
