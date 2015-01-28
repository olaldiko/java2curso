package modelo;

public class Moneda {
	public Moneda(String nombre, double cambio) {
		this.nombre = nombre;
		this.cambio = cambio;
	}
	String nombre;
	Double cambio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCambio() {
		return cambio;
	}
	public void setCambio(Double cambio) {
		this.cambio = cambio;
	}
	public String toString(){
		return nombre;
	}
}
