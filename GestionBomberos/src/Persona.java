
public abstract class Persona {
	String nombre;
	String apellido;
	public Persona(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Persona(){
		nombre = "S/N";
		apellido = "S/A";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String toString(){
		return nombre+" "+apellido;
	}
	public abstract void evaluar(int resistencia, int capacidad, int velocidad);
	public abstract void evaluar(int resistencia, int potencia);
	public abstract int getPuntos();
}
