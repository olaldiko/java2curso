import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Principal extends JFrame implements ActionListener, ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dialogo d;
	Contacto selecccionado;
	JButton  borrar;
	JMenuItem iborrar;
	DefaultListModel<Contacto> modelo = new DefaultListModel<>();
	JList<Contacto> lista = new JList<>(modelo);
	public Principal(){
		super("Contactos");
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(crearPanelPrincipal());
		this.setVisible(true);
	}

	private Container crearPanelPrincipal() {
		JPanel pr = new JPanel(new BorderLayout());
		pr.add(crearMenu(), BorderLayout.NORTH);
		pr.add(crearPDatos());
		return pr;
	}

	private Component crearPDatos() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(crearToolbar(), BorderLayout.NORTH);
		p.add(lista, BorderLayout.CENTER);
		lista.setCellRenderer(new RenderCelda());
		lista.addListSelectionListener(this);
		return p;
	}


	private Component crearToolbar() {
		JToolBar tool = new JToolBar();
		JButton aamigo, afamiliar, acolega, salir;
		tool.add(aamigo = new JButton());
		tool.add(afamiliar = new JButton());
		tool.add(acolega = new JButton());
		tool.add(borrar = new JButton());
		aamigo.setIcon(new ImageIcon("amigo.png"));
		afamiliar.setIcon(new ImageIcon("familia.png"));
		acolega.setIcon(new ImageIcon("utilities.png"));
		borrar.setIcon(new ImageIcon("edit_remove.png"));
		borrar.setEnabled(false);
		tool.addSeparator();
		tool.add( salir = new JButton(), JToolBar.RIGHT_ALIGNMENT);
		salir.setIcon(new ImageIcon("exit.png"));
		aamigo.addActionListener(this);
		afamiliar.addActionListener(this);
		acolega.addActionListener(this);
		borrar.addActionListener(this);
		salir.addActionListener(this);
		aamigo.setActionCommand("amigo");
		afamiliar.setActionCommand("familiar");
		acolega.setActionCommand("colega");
		borrar.setActionCommand("borrar");
		salir.setActionCommand("salir");
		return tool;
	}

	private Component crearMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu anadir = new JMenu("Añadir"), borrar = new JMenu("Borrar"), salir = new JMenu("Salir");
		JMenuItem amigo, familiar, colega, isalir;
		anadir.add(amigo = new JMenuItem("Amigo"));
		amigo.addActionListener(this);
		amigo.setActionCommand("amigo");
		amigo.setIcon(new ImageIcon("amigo.png"));
		anadir.add(familiar = new JMenuItem("Familiar"));
		familiar.addActionListener(this);
		familiar.setActionCommand("familiar");
		familiar.setIcon(new ImageIcon("familia.png"));
		anadir.add(colega = new JMenuItem("Colega"));
		colega.addActionListener(this);
		colega.setActionCommand("colega");
		colega.setIcon(new ImageIcon("utilities.png"));
		borrar.add(iborrar = new JMenuItem("Borrar"));
		iborrar.setEnabled(false);
		iborrar.addActionListener(this);
		iborrar.setActionCommand("borrar");
		iborrar.setIcon(new ImageIcon("edit_remove.png"));
		salir.add(isalir = new JMenuItem("Salir"));
		isalir.addActionListener(this);
		isalir.setActionCommand("salir");
		isalir.setIcon(new ImageIcon("exit.png"));
		menu.add(anadir);
		menu.add(borrar);
		menu.add(salir);
		return menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "amigo":
			d = new Dialogo(this, 1);
			modelo.addElement(d.c);
			break;
		case "familiar":
			d = new Dialogo(this, 2);
			modelo.addElement(d.c);
			break;
		case "colega":
			d = new Dialogo(this, 3);
			modelo.addElement(d.c);
			break;
		case "borrar":
			modelo.removeElement(lista.getSelectedValue());		
			break;
		case "salir":
			this.dispose();
			break;
		}
		
	}

	public static void main(String[] args){
		Principal p = new Principal();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!lista.isSelectionEmpty()){
			iborrar.setEnabled(true);
			borrar.setEnabled(true);
		}else{
			iborrar.setEnabled(false);
			iborrar.setEnabled(false);
		}
	}
}
