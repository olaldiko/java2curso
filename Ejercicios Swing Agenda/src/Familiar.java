
public class Familiar extends Contacto{
	String parentesco;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return parentesco+": "+nombre;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
}
