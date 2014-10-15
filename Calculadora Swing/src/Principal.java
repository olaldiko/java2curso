import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal implements ActionListener{
	JFrame ventana;
	
	
	public static void main(String[] args) {
		Principal ejercicio= new Principal();
		ejercicio.ejecutar();

	}

	private void ejecutar() {
		ventana= new JFrame();
		ventana.setLocation(100, 100);
		ventana.setSize(300, 300);
		ventana.setResizable(false);
		ventana.setContentPane(crearPanelVentana());
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventana.repaint();
	}

	private Container crearPanelVentana() {
		JPanel panel= new JPanel(new BorderLayout()); //BorderLayout separar en partes la ventana
		//panel.add(crearPanelOperacion(), BorderLayout.NORTH);
		panel.add(crearPanelSignos(),BorderLayout.EAST);
		panel.add(crearPanelNumeros(),BorderLayout.CENTER);	
		return panel;
	}

	private Component crearPanelNumeros() {
		JPanel panel= new JPanel(new GridLayout(4,3,10,10));
		for (int i=1; i<=9;i++){
			panel.add(crearBotonNumero(i));
		}
		panel.add(crearBotonSigno(" "));
		panel.add(crearBotonNumero(0));
		panel.add(crearBotonSigno(" "));
		return panel;
	}
	
	private Component crearBotonNumero(int i) {
		JButton boton= new JButton(String.valueOf(i));
		//boton.setActionCommand(String.valueOf(i));
		//boton.addActionListener(this);
		return boton;
	}

	private Component crearPanelSignos() {
		JPanel panel= new JPanel (new GridLayout(5,1,0,10)); //fila,columna,separacion lateral,separacion vertical
		panel.add(crearBotonSigno("+"));
		panel.add(crearBotonSigno("-"));
		panel.add(crearBotonSigno("*"));
		panel.add(crearBotonSigno("/"));
		panel.add(crearBotonSigno("="));
		return panel;
	}

	private Component crearBotonSigno(String signo) {
		JButton boton= new JButton(signo);
		//boton.setActionCommand(signo);
		//boton.addActionListener(this);
		return boton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
