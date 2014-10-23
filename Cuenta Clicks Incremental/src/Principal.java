import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Principal implements ActionListener{
	JButton bInc, bDec, bSalir, b1, b2, b3;
	JLabel resultado;
	JFrame ventana;
	int cant = 0;
	int incremento = 1;
	public static void main(String[] args) {
		Principal princi = new Principal();
		princi.creaVentana();
	}
	public void creaVentana(){
		ventana = new JFrame();
		ventana.setSize(500, 200);
		ventana.add(creaPanelPrincipal(), BorderLayout.WEST);
		ventana.add(creaBotonesEste(), BorderLayout.EAST);
		ventana.add(creaBotonesSur(), BorderLayout.SOUTH);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	private Component creaBotonesSur() {
		JPanel psur = new JPanel(new GridLayout(0,3));
		
		bInc = new JButton("Incrementar");
		bInc.addActionListener(this);
		bInc.setActionCommand("Inc");
		psur.add(bInc);
		
		bDec = new JButton("Decrementar");
		bDec.addActionListener(this);
		bDec.setActionCommand("Dec");
		psur.add(bDec);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		bSalir.setActionCommand("Salir");
		psur.add(bSalir);
		
		return psur;
	}
	private Component creaBotonesEste() {
		JPanel peste = new JPanel(new GridLayout(3,0));
		b1 = new JButton("1");
		b1.addActionListener(this);
		b1.setActionCommand("1");
		peste.add(b1);
		
		b2 = new JButton("3");
		b2.addActionListener(this);
		b2.setActionCommand("3");
		peste.add(b2);
		
		b3 = new JButton("5");
		b3.addActionListener(this);
		b3.setActionCommand("5");
		peste.add(b3);
		
		return peste;
	}
	private Component creaPanelPrincipal() {
		JPanel principal = new JPanel(new BorderLayout());
		resultado = new JLabel("0");
		principal.add(resultado, BorderLayout.CENTER);
		return principal;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "1":
			incremento = 1;
			break;
		case "3":
			incremento = 3;
			break;
		case "5":
			incremento = 5;
			break;
		case "Inc":
			cant += incremento;
			resultado.setText(String.valueOf(cant));
			break;
		case "Dec":
			cant -= incremento;
			resultado.setText(String.valueOf(cant));
			break;
		case "Salir":
			//ventana.dispose();
			java.lang.Runtime.getRuntime().exit(0);
			break;
		}
		
	}
}
