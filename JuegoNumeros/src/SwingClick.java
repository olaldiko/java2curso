import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingClick {
	static JFrame ventana;
	static JLabel texto;
	static JButton botonInc;
	static JButton botonDec;
	static int numero = 0;
	public static void main(String[] args) {
		crearVentanas();
		

	}
	public static void crearVentanas(){
		ventana = new JFrame("CuentaClicks!");
		ventana.setSize(400, 400);
		ventana.setVisible(true);
		ventana.setLocation(100, 100);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(crearPanelVentana());
	}
	public static Container crearPanelVentana(){
		JPanel panel = new JPanel(new BorderLayout());
		
		texto = new JLabel("0");
		texto.setHorizontalAlignment(JLabel.CENTER);
		panel.add(texto);
		panel.add(crearPanelBotones(), JPanel.BOTTOM_ALIGNMENT);
		return panel;
	}
	public static Container crearPanelBotones(){
		JPanel pBotones = new JPanel(new FlowLayout());
		botonInc = new JButton("Incrementar");
		botonDec = new JButton("Decrementar");
		pBotones.add(botonInc);
		pBotones.add(botonDec);
		botonInc.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(String.valueOf(++numero));
				
			}
			
		});
		botonDec.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText(String.valueOf(--numero));
				
			}
			
		});
		return pBotones;
	}

}
