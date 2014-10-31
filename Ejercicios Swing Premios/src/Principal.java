import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Principal extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4606582221657237461L;
	Integer[] numeros = new Integer[36];
	JButton[] botones = new JButton[36];
	JTextField puntos = new JTextField();
	int puntosint = 0;
	public Principal(){
		super("Tablero de premios");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initPanel();
		setContentPane(crearPanelPrincipal());
		setVisible(true);
		
		
	}
	
	private Container crearPanelPrincipal() {
		JPanel pr = new JPanel(new BorderLayout());
		pr.add(crearPNorte(), BorderLayout.NORTH);
		pr.add(crearPanelPremios(), BorderLayout.CENTER);
		pr.add(crearPanelSalida(), BorderLayout.SOUTH);
		
		return pr;
	}

	private Component crearPNorte() {
		JPanel norte = new JPanel(new FlowLayout());
		norte.add(new JLabel("Puntos acumulados"));
		puntos.setMinimumSize(new Dimension(100, 50));
		norte.add(puntos);
		return norte;
	}

	public void initPanel(){
		for ( int i = 0; i < 36; i++){
			numeros[i] = (int) (Math.random()*35000);
			botones[i] = new JButton();
			botones[i].addActionListener(this);
		}	
	}
	public Component crearPanelPremios(){
		JPanel premios = new JPanel(new GridLayout(7 , 7));
		for(int i = 0 ; i < 36; i++){
			premios.add(botones[i]);
		}
		return premios;
	}
	public Component crearPanelSalida(){
		JPanel salida = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setActionCommand("Salir");
		salida.add(salir);
		return salida;	
	}
	public void levantaPremio(ActionEvent e){
		JButton boton;
		int index;
		boton = (JButton)e.getSource();
		for(index = 0; (index < 36)&&(boton != botones[index]);index++);
		boton.setText(String.valueOf(numeros[index]));
		boton.setEnabled(false);
		if(numeros[index] == 0){
			JOptionPane.showMessageDialog(this, "La cagaste!", "Fin del juego", ERROR);
			this.dispose();
		}else{
			puntosint += Integer.parseInt(boton.getText());
			puntos.setText(Integer.toString(puntosint));
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Salir":
			this.dispose();
			break;
		default:		
			levantaPremio(e);
		}
	}
	public static void main(String[] args){
		Principal p = new Principal();
	}
	
}
