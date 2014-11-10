
public class Colega extends Contacto{
	String apellido;
	String dpto;
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String toString(){
		return nombre+" "+apellido+" Dpto. "+dpto;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}



}
