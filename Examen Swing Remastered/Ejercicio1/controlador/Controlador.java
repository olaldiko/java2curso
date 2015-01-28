package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;

import modelo.Modelo;
import modelo.Moneda;
import vista.Vista;

public class Controlador implements ActionListener, Observer, ItemListener {
	Modelo m;
	Vista v;
	
	public Controlador(Modelo m, Vista v){
		this.m = m;
		this.v = v;
		v.anadirListeners(this, this);
		m.addObserver(this);
		v.comboOrigen.setModel(getModelosCombo());
		v.comboDest.setModel(getModelosCombo());
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "cambio":
			v.textDest.setText(String.format("%.2f", (m.getCambio()*Double.parseDouble(v.textOrigen.getText()))));
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == v.comboOrigen){
			m.setOrigen((Moneda)v.comboOrigen.getSelectedItem());
			v.textDest.setText(String.format("%.2f", Double.parseDouble(v.textOrigen.getText())*m.getCambio()));
		}else{
			if(e.getSource() == v.comboDest){
				m.setDestino((Moneda)v.comboDest.getSelectedItem());
				v.textDest.setText(String.format("%.2f", Double.parseDouble(v.textOrigen.getText())*m.getCambio()));
			}
		}
	}
	public DefaultComboBoxModel<Moneda> getModelosCombo(){
		DefaultComboBoxModel<Moneda> modelo = new DefaultComboBoxModel<>();
		Iterator<Moneda> i;
		i = m.getMonedas().values().iterator();
		while(i.hasNext()){
			modelo.addElement(i.next());
		}
		return modelo;
	}
}
