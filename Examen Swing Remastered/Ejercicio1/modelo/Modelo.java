package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Modelo extends java.util.Observable {

	HashMap<String, Moneda> monedas;
	CargadorFicheros cargador = new CargadorFicheros();
	Moneda origen;
	Moneda destino;
	
	public Modelo(){
		monedas = cargador.cargaMonedas();
		origen = monedas.getOrDefault("Euros", new Moneda("NC", 0.0));
		destino = monedas.getOrDefault("Euros", new Moneda("NC", 0.0));
	}
	public double getCambio(){
		return  destino.getCambio()/origen.getCambio();
	}
	public void setOrigen(Moneda origen){
		this.origen = origen;
	}
	public Moneda getDestino() {
		return destino;
	}
	public void setDestino(Moneda destino) {
		this.destino = destino;
	}
	public Moneda getOrigen() {
		return origen;
	}
	public HashMap<String, Moneda> getMonedas(){
		return monedas;
	}
}
