import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Principal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[][] textos = {
						{"Accion",  "Reiniciar", "Invertir",
						"Configuracion", "Valores", "Incremento", 
						"Limite superior", "Limite inferior", "Color", 
						"Idioma", "Castellano", "Euskera"},
						
						{"Akzioak", "Berrabiarazi", "Alderantzikatu", 
						"Ezarpenak", "Balioak", "Inkrementua", 
						"Goi muga", "Behe muga", "Kolorea", 
						"Hizkuntza", "Gaztelania", "Euskara"}};
	int idioma = 0;
	JMenu accion, configuracion, midioma;
	JMenuItem reiniciar, invertir, valores, color, eus, es;
	JLabel etnum;
	JButton click;
	Color clr = new Color(0, 0 ,0);
	int limsup = 100, liminf = -10, incremento = 1, num = 0;
	
	public Principal(){
		super("Cuenta clicks configurable");
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(crearPanelPrincipal());
		this.setVisible(true);
	}

	private Container crearPanelPrincipal() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(crearBarraMenu(), BorderLayout.NORTH);
		p.add(crearPanelCentral(), BorderLayout.CENTER);
		return p;
	}

	private Component crearPanelCentral() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(etnum = new JLabel("0"));
		etnum.setFont(new Font("Arial", Font.BOLD, 100));
		etnum.setHorizontalAlignment(JLabel.CENTER);
		p.add(click = new JButton("Click!"), BorderLayout.SOUTH);
		click.addActionListener(this);
		click.setActionCommand("click");
		etnum.setForeground(clr);
		return p;
	}

	private Component crearBarraMenu() {
		JMenuBar mb = new JMenuBar();
		mb.add(accion = new JMenu(textos[idioma][0]));
		mb.add(configuracion = new JMenu(textos[idioma][3]));
		crearItemsMenu();
		return mb;
	}

	private void crearItemsMenu() {
		accion.add(reiniciar = new JMenuItem(textos[idioma][1]));
		accion.add(invertir = new JMenuItem(textos[idioma][2]));
		reiniciar.addActionListener(this);
		reiniciar.setActionCommand("reiniciar");
		invertir.addActionListener(this);
		invertir.setActionCommand("invertir");
		configuracion.add(valores = new JMenuItem(textos[idioma][4]));
		configuracion.add(color = new JMenuItem(textos[idioma][8]));
		configuracion.add(midioma = new JMenu(textos[idioma][9]));
		valores.addActionListener(this);
		valores.setActionCommand("valores");
		color.addActionListener(this);
		color.setActionCommand("color");
		midioma.add(es = new JMenuItem(textos[idioma][10]));
		midioma.add(eus = new JMenuItem(textos[idioma][11]));
		es.addActionListener(this);
		es.setActionCommand("es");
		eus.addActionListener(this);
		eus.setActionCommand("eus");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()){
		case "reiniciar":
			num = 0;
			etnum.setText(String.valueOf(num));
			break;
		case "invertir":
			incremento = -incremento;
			break;
		case "valores":
			mostrarDiagVal();
			break;
		case "color":
			clr = JColorChooser.showDialog(this, "Elige color: ", clr);
			etnum.setForeground(clr);
			break;
		case "es":
			idioma = 0;
			actualizarTextos();
			break;
		case "eus":
			idioma = 1;
			actualizarTextos();
			break;
		case "click":
			if(num >= limsup){
				JOptionPane.showConfirmDialog(this,"Has llegado al limite superior de clicks" , "Limite superior alcanzado!", JOptionPane.WARNING_MESSAGE);
			}else{
				if(num <= liminf){
					JOptionPane.showConfirmDialog(this,"Has llegado al limite inferior de clicks" , "Limite inferior alcanzado!", JOptionPane.WARNING_MESSAGE);
				}else{
					num += incremento;
					etnum.setText(String.valueOf(num));
				}
			}
			break;
		}
	}
	private void actualizarTextos() {
		accion.setText(textos[idioma][0]);
		configuracion.setText(textos[idioma][3]);
		midioma.setText(textos[idioma][9]);
		reiniciar.setText(textos[idioma][1]);
		invertir.setText(textos[idioma][2]);
		valores.setText(textos[idioma][4]);
		color.setText(textos[idioma][5]);
		eus.setText(textos[idioma][11]);
		es.setText(textos[idioma][10]);
		
	}

	private void mostrarDiagVal() {
		Dialogo d = new Dialogo(this);
		limsup = d.getLsup();
		liminf = d.getLinf();
		incremento = d.getInc();
	}

	public static void main(String[] args){
		Principal p = new Principal();
	}
}
