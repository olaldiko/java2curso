
public class Bombera extends Persona {
	int puntos;

	public Bombera(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.puntos = 0;
	}
	

	public void evaluar(int resistencia, int capacidad, int velocidad){
		puntos = (resistencia+((capacidad+velocidad)/2)/2);
	}
	public String toString(){
		return nombre+" "+apellido+" Sexo: Chica Puntos: "+puntos;
	}


	@Override
	public void evaluar(int resistencia, int potencia) {
		// TODO Auto-generated method stub
		
	}
	public int getPuntos(){
		return puntos;
	}
}
