
public class Amigo extends Contacto{
	String apellido;
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String toString(){
		return nombre+" "+apellido;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
}
