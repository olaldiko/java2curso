import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Principal implements ActionListener{
	JFrame ventana;
	JLabel resultado;
	String num1 = "";
	String num2 = "";
	String operacion = "+";
	Boolean signopulsado = false;
	int resInt = 0;
	public static void main(String[] args) {
		Principal princi = new Principal();
		princi.crearVentana();

	}

	public void crearVentana() {
		ventana= new JFrame();
		ventana.setLocation(100, 100);
		ventana.setSize(300, 300);
		ventana.setResizable(false);
		ventana.setContentPane(crearPanelVentana());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	private Container crearPanelVentana() {
		JPanel panel= new JPanel(new BorderLayout()); //BorderLayout separar en partes la ventana
		panel.add(crearPanelOperacion(), BorderLayout.NORTH);
		panel.add(crearPanelSignos(),BorderLayout.EAST);
		panel.add(crearPanelNumeros(),BorderLayout.CENTER);	
		return panel;
	}

	private Component crearPanelOperacion() {
		JPanel panelresultado = new JPanel(new BorderLayout());
		resultado = new JLabel("0");
		resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		resultado.setSize(new Dimension(30,30));
		panelresultado.add(resultado);
		return panelresultado;
	}

	private Component crearPanelNumeros() {
		JPanel panel= new JPanel(new GridLayout(4,3,10,10));
		for (int i=1; i<=9;i++){
			panel.add(crearBotonNumero(i));
		}
		panel.add(crearBotonNumero(0));
		return panel;
	}
	
	private Component crearBotonNumero(int i) {
		JButton boton= new JButton(String.valueOf(i));
		boton.setActionCommand(String.valueOf(i));
		boton.addActionListener(this);
		return boton;
	}

	private Component crearPanelSignos() {
		JPanel panel= new JPanel (new GridLayout(5,1,0,10)); //fila,columna,separacion lateral,separacion vertical
		panel.add(crearBotonSigno("+"));
		panel.add(crearBotonSigno("-"));
		panel.add(crearBotonSigno("*"));
		panel.add(crearBotonSigno("/"));
		panel.add(crearBotonSigno("="));
		return panel;
	}

	private Component crearBotonSigno(String signo) {
		JButton boton= new JButton(signo);
		boton.setActionCommand(signo);
		boton.addActionListener(this);
		return boton;
	}
public void calculaResultado(){
	"0".concat(num1);
	"0".concat(num2);
	switch(operacion){
		case "+":
			resInt = Integer.parseInt(num1)+Integer.parseInt(num2);
			break;
		case "-":
			resInt = Integer.parseInt(num1)-Integer.parseInt(num2);
			break;
		case "*":
			resInt = Integer.parseInt(num1)*Integer.parseInt(num2);
			break;
		case "/":
			if(Integer.parseInt(num2) != 0){
			resInt = Integer.parseInt(num1)/Integer.parseInt(num2);
			}else{
				resInt = 0;
			}
			break;
	}
	resultado.setText(String.valueOf(resInt));
	num1 = "0";
	num2 = "0";
	signopulsado = false;
}
public void muestraNumPulsados(){
	if(!signopulsado){
		resultado.setText(num1);
	}else{
		resultado.setText(num2);
	}
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "+"){
			operacion = "+";
			signopulsado = true;
		}else{
			if(e.getActionCommand() == "-"){
				operacion = "-";
				signopulsado = true;
			}else{
				if(e.getActionCommand() == "*"){
					operacion = "*";
					signopulsado = true;
				}else{
					if(e.getActionCommand() == "/"){
						operacion = "/";
						signopulsado = true;
					}else{
						if(e.getActionCommand() == "="){
							calculaResultado();
						}else{
							if((0 <= Integer.parseInt(e.getActionCommand()))&&(Integer.parseInt(e.getActionCommand())) <= 9){
								if(!signopulsado){
									num1+= e.getActionCommand();
									muestraNumPulsados();
								}else{
									num2+= e.getActionCommand();
									muestraNumPulsados();
								}
							}
						}
					}
				}
			}
		}
	}
}
