import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Compruebafecha {
	SimpleDateFormat fechastring = new SimpleDateFormat("dd MM yyyy");
	Date fecha;
	boolean fechaok;
	
	public Date validaFecha(String fecha){
		try {
			this.fecha = fechastring.parse(fecha);
			fechaok = true;
			System.out.println("Fecha correcta");
			return this.fecha;
		} catch (ParseException e) {
			fechaok = false;
			System.out.println("Fecha incorrecta");
		}
		return this.fecha;
	}
}
