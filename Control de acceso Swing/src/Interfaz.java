import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Interfaz implements ActionListener {
	JFrame ventana;
	JTextField usuario;
	JPasswordField clave;
	JButton acceder;
	JButton salir;
	final String username = "gorka";
	char[] pass = {'a', 'r', 'a', 'i', 'a'};
	char[] pintroducida;
	String uintroducido;
	public boolean compruebadatos(){
		pintroducida = clave.getPassword();
		uintroducido = usuario.getText();
		if((username == uintroducido)&&(Arrays.equals(pintroducida, pass))){
			return true;
		}else{
			clave.setText("");
			return false;
		}
	}
	public void creaVentana(){
		ventana = new JFrame();
		ventana.setSize(300, 200);
		ventana.add(crearPanelPrincipal());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	private Component crearPanelPrincipal() {
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());
		principal.add(crearPanelLogins(), BorderLayout.CENTER);
		principal.add(crearHuecoArriba(), BorderLayout.NORTH);
		principal.add(crearPanelAbajo(), BorderLayout.SOUTH);
		return principal;
	}

	private Component crearPanelAbajo() {
		JPanel botones = new JPanel(new GridLayout(0,2));
		acceder = new JButton("Acceder");
		botones.add(acceder);
		acceder.addActionListener(this);
		acceder.setActionCommand("acceder");
		salir = new JButton("Salir");
		botones.add(salir);
		salir.addActionListener(this);
		salir.setActionCommand("salir");
		return botones;
	}

	private Component crearHuecoArriba() {
		JPanel arriba = new JPanel(new BorderLayout());
		Component hueco = Box.createVerticalStrut(14);
		arriba.add(hueco);
		return arriba;
	}

	private Component crearPanelLogins() {
		JPanel botones = new JPanel( new GridLayout(2,2));
		botones.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Identificacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		JButton btt1 = new JButton("Usuario: ");
		btt1.setEnabled(false);
		JButton btt2 = new JButton("Password: ");
		btt2.setEnabled(false);
		usuario = new JTextField();
		clave = new JPasswordField();
		botones.add(btt1);
		botones.add(usuario);
		botones.add(btt2);
		botones.add(clave);
		return botones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "salir":
			ventana.dispose();
			break;
		case "acceder":
			if(compruebadatos()){
				JOptionPane.showMessageDialog(ventana, "Bienvenido!", "Clave aceptada", JOptionPane.INFORMATION_MESSAGE);
				ventana.dispose();
			}else{
				JOptionPane.showMessageDialog(ventana, "Clave Incorrecta!!!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		
	}
}
