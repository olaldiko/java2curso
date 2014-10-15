import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CalcuPrincipal {
	JFrame ventana;
	JPanel panel;
	String oper1 = "";
	String oper2 = "";
	int resultado = 0;
	Boolean operacionSeleccionada = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
public void ventana(){
	ventana = new JFrame("Calculadora");
	ventana.setSize(300, 400);
	ventana.setVisible(true);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setContentPane(crearPaneles());
	ventana.
}
public JPanel crearPaneles(){
	JPanel principal = new JPanel(new BorderLayout());
	JPanel numeros;
	JPanel operaciones;
	JPanel resultado;
	principal.add(crearPnumeros(), BorderLayout.CENTER);
	principal.add(crearPOper(), BorderLayout.EAST);
	principal.add(crearPResult(), BorderLayout.NORTH);
}
private Component crearPResult() {
	JPanel presult = new JPanel(new BorderLayout());
	JLabel resultado = new JLabel();
	presult.add(resultado, BorderLayout.EAST);
	
	return presult;
}
private Component crearPOper() {
	JPanel poper = new JPanel(new GridLayout(3, 4, 5, 5));
	JButton botones[];
	for(Integer i = 1; i < 10;i++){
			poper.add(new JButton(i.toString()), i-1);
	}
	poper.add(new JButton("0"), 11);
	botones =(JButton[]) poper.getComponents();
	for(int i = 0; i < 9;i++){
		botones[i].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!operacionSeleccionada){
					oper1.concat(Integer.toString(i+1));
			}else{
				oper2.concat(Integer.toString(i+1));
			}
			
		}
		});
	}
	return null;
}
private Component crearPnumeros() {
	// TODO Auto-generated method stub
	return null;
}