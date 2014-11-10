import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Dialogo extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int tipo;
	Contacto c;
	JTextField nombre, apellido, parentesco, dpto;
	public Dialogo(JFrame ventana, int tipo){
		super(ventana, "Introduce los datos de contacto: ", true);
		this.tipo = tipo;
		this.setSize(300, 400);
		this.setContentPane(crearPanelDatos());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	private Container crearPanelDatos() {
		JButton salir;
		JPanel pr = new JPanel(new BorderLayout());
		pr.add(crearPanelCampos(), BorderLayout.CENTER);
		pr.add(salir = new JButton("Aceptar"), BorderLayout.NORTH);
		salir.addActionListener(this);
		salir.setActionCommand("s");
		return pr;
	}
	private Component crearPanelCampos() {
		JPanel pcampos = new JPanel(new GridLayout(3,0));
		pcampos.add(nombre = new JTextField());
		nombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Nombre"));
		switch(tipo){
		case 1:
			pcampos.add(apellido = new JTextField());
			apellido.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Apellido"));
			break;
		case 2:
			pcampos.add(parentesco = new JTextField());
			parentesco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Parentesco"));
			break;
		case 3:
			pcampos.add(apellido = new JTextField());
			apellido.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Apellido"));
			pcampos.add(dpto = new JTextField());
			dpto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Departamento"));
			break;
		}
		return pcampos;
	}
	public void crearContacto(){
		switch(tipo){
		case 1:
			c= new Amigo();
			c.setNombre(nombre.getText());
			((Amigo) c).setApellido(apellido.getText());
			break;
		case 2:
			c = new Familiar();
			c.setNombre(nombre.getText());
			((Familiar) c).setParentesco(parentesco.getText());
			break;
		case 3:
			c = new Colega();
			c.setNombre(nombre.getText());
			((Colega) c).setDpto(dpto.getText());
			((Colega) c).setApellido(apellido.getText());
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "s":
			crearContacto();
			this.dispose();
		}
		
	}
}
