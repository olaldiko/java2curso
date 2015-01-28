package modelo;

public class Circulo extends Figuras {
	double radio;

	@Override
	public double calcularArea() {		
		return Math.pow(radio, 2)*Math.PI;
	}

	@Override
	public String toString() {
		return "Circulo";
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	public Circulo(String desc, int posx, int posy, double radio){
		this.descripcion = desc;
		this.posx = posx;
		this.posy = posy;
		this.radio = radio;
	}
}
