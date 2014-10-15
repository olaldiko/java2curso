
public class Persona {
	String nombre;
	String apellido;
	public Persona(){
		nombre = "No_Name";
		apellido = "No_name";
	}
	public Persona(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String toString(){
		return nombre+" "+apellido;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
}
	