import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
	Bar b;
	Interfaz i;
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cana": b.sumaCana(); break;
		case "Pintxo": b.sumaPintxo(); break;
		case "Vino": b.sumaVino(); break;
		case "Total":
			i.cuenta.setText(b.getCuenta().toString());
			b.resetCuenta();
			break;
		}
	}
}
