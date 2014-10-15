
public class Ascensor {	
	boolean puertaCerr = true;
	int piso = 0;
	
	public int getPiso() {
		return piso;
	}
	public void abrirPuerta(){
		puertaCerr = false;
		System.out.println("Se abre la puerta");
	}
	public void cerrarPuerta(){
		puertaCerr = true;
		System.out.println("Se cierra la puerta");
	}
	public void bajarPiso(){
		this.piso--;
	}
	public void subirPiso(){
		this.piso++;
	}
}

