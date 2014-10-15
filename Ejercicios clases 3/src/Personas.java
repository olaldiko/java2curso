
public class Personas {
	String nombre;
	String apellido;
	Cumpleaños cumple;
	public String getNombre() {
		return nombre;
	}
	public void setCumple(){
		cumple = new Cumpleaños();
		cumple.selectCumple();
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
	public Cumpleaños getCumple() {
		return cumple;
	}
	public void setCumple(Cumpleaños cumple) {
		cumple = new Cumpleaños();
		this.cumple.selectCumple();
	}
	public String toString(){
		return "Nombre: "+nombre+" Apellido: "+apellido+" "+cumple;
	}
	
}
	