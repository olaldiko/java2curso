import controlador.ControladorFiguras;
import modelo.ModeloFiguras;
import vista.VistaFiguras;


public class PrincipalFiguras {
	VistaFiguras v = new VistaFiguras();
	ModeloFiguras m = new ModeloFiguras();
	ControladorFiguras c = new ControladorFiguras(m, v);
	public static void main(String[] args){
		PrincipalFiguras p = new PrincipalFiguras();
	}
}
