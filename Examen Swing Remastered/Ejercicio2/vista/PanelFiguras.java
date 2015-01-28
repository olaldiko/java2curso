package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.Circulo;
import modelo.Figuras;
import modelo.Rectangulo;

public class PanelFiguras extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5812952538861844398L;
	ArrayList<Figuras> figuras = new ArrayList<Figuras>();

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Figuras f: figuras){
			this.setBackground(Color.WHITE);
			if(f instanceof Circulo){
				g.setColor(Color.RED);
				g.fillOval(f.getPosx(), f.getPosy(), (int)((Circulo)f).getRadio(), (int)((Circulo)f).getRadio());
			}else{
				if(f instanceof Rectangulo){
					g.setColor(Color.GREEN);
					g.fillRect(f.getPosx(), f.getPosy(), (int)((Rectangulo)f).getTamx(), (int)((Rectangulo)f).getTamx());
				}
			}
		}
		
	}
	public void setFiguras(ArrayList<Figuras> f){
		figuras = f;
	}
}
