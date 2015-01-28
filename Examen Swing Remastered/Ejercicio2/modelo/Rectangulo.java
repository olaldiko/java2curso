package modelo;

public class Rectangulo extends Figuras {
	double tamx, tamy;

	@Override
	public double calcularArea() {
		return tamx * tamy;
	}

	@Override
	public String toString() {
		return "Rectangulo";
	}

	public double getTamx() {
		return tamx;
	}

	public void setTamx(double tamx) {
		this.tamx = tamx;
	}

	public double getTamy() {
		return tamy;
	}

	public void setTamy(double tamy) {
		this.tamy = tamy;
	}
	public Rectangulo(String desc, int posx, int posy, double tamx, double tamy){
		this.descripcion = desc;
		this.posx = posx;
		this.posy = posy;
		 this.tamx = tamx;
		 this.tamy = tamy;
	}
}
