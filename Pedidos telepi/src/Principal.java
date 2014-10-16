import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class Principal implements ItemListener, ActionListener{
	JFrame ventana;
	JComboBox<String> cb1, cb2;
	JCheckBox b1, b2, b3, b4, b5, b6;
	JRadioButton rRecoger, rEnviar;
	JButton confirmar;
	JTextField texto;
	public static void main(String[] args) {
	Principal princi = new Principal();
	princi.creaVentana();
	}
public void creaVentana(){
	ventana = new JFrame();
	ventana.setSize(600, 400);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ventana.add(crearPanelprincipal());
	ventana.setVisible(true);
}
private Component crearPanelprincipal() {
	JPanel principal = new JPanel(new BorderLayout(10, 10));
	principal.add(crearPanelOpciones(), BorderLayout.CENTER);
	principal.add(crearPanelDesplegables(), BorderLayout.NORTH);
	principal.add(crearPanelEnviar(), BorderLayout.SOUTH);
	return principal;
}
private Component crearPanelEnviar() {
	ButtonGroup grupoEnvio = new ButtonGroup();
	JPanel envio = new JPanel(new GridLayout(3,2, 10, 10));
	rRecoger = new JRadioButton("Recoger en local");
	rEnviar = new JRadioButton("Llevar a:");
	texto = new JTextField();
	confirmar = new JButton("Confirmar");
	grupoEnvio.add(rRecoger);
	grupoEnvio.add(rEnviar);
	rRecoger.addItemListener(this);
	rEnviar.addItemListener(this);
	confirmar.addItemListener(this);
	envio.add(rRecoger);
	envio.add(rEnviar);
	envio.add(texto);
	envio.add(confirmar);
	return envio;
}
private Component crearPanelDesplegables() {
	JPanel despleg = new JPanel(new GridLayout(0,2, 10 , 0));
	String[] desp1 = {"Pequena", "Mediana", "Grande"};
	String[] desp2 = {"Normal", "Extra queso", "Extra cebolla"};
	cb1 = new JComboBox<String>(desp1);
	cb2 = new JComboBox<String>(desp2);
	despleg.add(cb1);
	despleg.add(cb2);
	return despleg;
}
private Component crearPanelOpciones() {
	JPanel opciones = new JPanel(new GridLayout(2,3, 10, 10));
	opciones.setBorder(BorderFactory.createRaisedBevelBorder());
	b1 = new JCheckBox("Jamon");
	b2 = new JCheckBox("Cebolla");
	b3 = new JCheckBox("Alcaparras");
	b4 = new JCheckBox("Pimiento");
	b5 = new JCheckBox("Carne");
	b6 = new JCheckBox("Aceitunas");
	opciones.add(b1);
	opciones.add(b2);
	opciones.add(b3);
	opciones.add(b4);
	opciones.add(b5);
	opciones.add(b6);
	return opciones;
}
@Override
public void itemStateChanged(ItemEvent e) {
	if(e.getStateChange() == ItemEvent.SELECTED){
		if((JRadioButton)e.getSource() == rEnviar){
			texto.setEditable(true);
		}
		if((JRadioButton)e.getSource() == rRecoger){
			texto.setEditable(false);
			texto.setText("");
		}
		
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
