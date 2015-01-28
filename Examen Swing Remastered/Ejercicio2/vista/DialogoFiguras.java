package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Circulo;
import modelo.Figuras;
import modelo.Rectangulo;

public class DialogoFiguras extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6317945683126783011L;
	
	JRadioButton radiocir = new JRadioButton();
	JRadioButton radiorect = new JRadioButton();
	ButtonGroup gruporadios = new ButtonGroup();
	JTextField descripcion = new JTextField();
	JTextField posx = new JTextField();
	JTextField posy = new JTextField();
	JTextField tamx = new JTextField();
	JTextField tamy = new JTextField();
	JLabel tamxlabel = new JLabel("Radio");
	JLabel tamylabel = new JLabel("Lado 2");
	JButton btnok = new JButton("Ok");
	JButton btnCancel = new JButton("Cancelar");
	public DialogoFiguras(JFrame ventana){
		super(ventana, "Definicion de figura");
		this.setContentPane(crearPanelDiag());
		
	}
	private Container crearPanelDiag() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(crearPanelRadios(), BorderLayout.NORTH);
		panel.add(crearPanelGrid(), BorderLayout.CENTER);
		panel.add(crearPanelBotones(), BorderLayout.SOUTH);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		return panel;
	}
	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 40));
		btnok.addActionListener(e -> this.setVisible(false));
		btnCancel.addActionListener(e -> this.setVisible(false));
		panel.add(btnok);
		btnok.setActionCommand("ok");
		panel.add(btnCancel);
		return panel;
	}
	private Component crearPanelGrid() {
		JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
		panel.add(new JLabel("Descripcion: "));
		panel.add(descripcion);
		panel.add(new JLabel("Posicion X: "));
		panel.add(posx);
		panel.add(new JLabel("Posicion Y: "));
		panel.add(posy);
		panel.add(tamxlabel);
		panel.add(tamx);
		panel.add(tamylabel);
		panel.add(tamy);
		tamylabel.setVisible(false);
		tamy.setVisible(false);
		return panel;
	}
	private Component crearPanelRadios() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		radiocir.setText("Circulo");
		radiorect.setText("Rectangulo");
		gruporadios.add(radiocir);
		gruporadios.add(radiorect);
		radiocir.setSelected(true);
		radiocir.addActionListener(e -> setVistaCirculo());
		radiorect.addActionListener(e -> setVistaRectangulo());
		panel.add(radiocir);
		panel.add(radiorect);
		return panel;
	}
	public void setVistaCirculo(){
		tamxlabel.setText("Radio");
		tamylabel.setVisible(false);
		tamy.setVisible(false);
	}
	public void setVistaRectangulo(){
		tamxlabel.setText("Lado 1");
		tamylabel.setVisible(true);
		tamy.setVisible(true);
	}
	public Figuras getFigura(){
		if(radiocir.isSelected()){
			return new Circulo(descripcion.getText(), Integer.parseInt(posx.getText()), Integer.parseInt(posy.getText()), Double.parseDouble(tamx.getText()));
		}else{
			if(radiorect.isSelected()){
				return new Rectangulo(descripcion.getText(), Integer.parseInt(posx.getText()), Integer.parseInt(posy.getText()), Double.parseDouble(tamx.getText()), Double.parseDouble(tamy.getText()));
			}
		}
		return new Circulo("ND",0, 0, 0.0);
	}
	public void addListener(ActionListener e){
		btnok.addActionListener(e);
	}
}
