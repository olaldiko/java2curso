package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

import modelo.Figuras;
import modelo.ModeloFiguras;
import vista.DialogoFiguras;
import vista.VistaFiguras;

public class ControladorFiguras implements Observer, ActionListener{
	ModeloFiguras m;
	VistaFiguras v;
	DialogoFiguras d;
	
	public ControladorFiguras(ModeloFiguras m, VistaFiguras v) {
		this.v = v;
		this.m = m;
		m.addObserver(this);
		v.setListener(this);
		v.figPan.setFiguras(m.getFiguras());
	}
	@Override
	public void update(Observable o, Object arg) {
		v.figPan.repaint();
		v.area.setText(String.valueOf(m.getArea()));
		setModeloLista();
		
	}
	public void setModeloLista(){
		DefaultListModel<Figuras> modelo = new DefaultListModel<>();
		for(Figuras f : m.getFiguras()){
			modelo.addElement(f);
		}
		v.lista.setModel(modelo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "anadir":
			d = new DialogoFiguras(v);
			d.addListener(this);
			break;
		case "eliminar":
			m.removeFigura(v.lista.getSelectedValue());
			break;
		case "ok":
			m.addFigura(d.getFigura());
			break;
		}
		
	}
	
}
