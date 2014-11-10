import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Dialogo extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Principal vp;
	JTextField lsup, linf, incrm;
	JButton salir;
	public Dialogo(Principal ventana){
		super(ventana, true);
		vp = ventana;
		this.setTitle("Config");
		this.setSize(200, 300);
		this.setContentPane(creaPanelCampos());
		this.setVisible(true);
	}
	private Container creaPanelCampos() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel gr = new JPanel(new GridLayout(3, 0));
		p.add(gr, BorderLayout.CENTER);
		gr.add(lsup = new JTextField(String.valueOf(vp.limsup)));
		lsup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Limite superior"));
		gr.add(linf = new JTextField(String.valueOf(vp.liminf)));
		linf.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Limite inferior"));
		gr.add(incrm = new JTextField(String.valueOf(vp.incremento)));
		incrm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Incremento"));
		p.add(salir = new JButton("Salir"), BorderLayout.SOUTH);
		salir.addActionListener(this);
		salir.setActionCommand("salir");
		return p;
	}
	public int getLsup(){
		return Integer.valueOf(lsup.getText());
	}
	public int getLinf(){
		return Integer.valueOf(linf.getText());
	}
	public int getInc(){
		return Integer.valueOf(incrm.getText());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "salir"){
			this.dispose();
		}
	}	
}


