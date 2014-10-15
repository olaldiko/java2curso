
public class Bombero extends Persona {
	int puntos;
	
	public Bombero(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.puntos = 0;
	}
	public void evaluar(int resistencia, int potencia){
		puntos = (resistencia + potencia)/2;
	}
	public String toString(){
		return nombre+" "+apellido+" Sexo: Chico Puntos: "+puntos;
	}
	@Override
	public void evaluar(int resistencia, int capacidad, int velocidad) {
		// TODO Auto-generated method stub
		
	}
	public int getPuntos(){
		return puntos;
	}

}