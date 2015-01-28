package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import modelo.Figuras;

public class VistaFiguras extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001171188115440601L;
	public JMenuItem anadir = new JMenuItem("Anadir");
	public JMenuItem eliminar = new JMenuItem("Eliminar");
	public JMenu editar = new JMenu("Editar");
	public JMenuItem salir = new JMenuItem("Salir");
	public JButton btnanadir = new JButton();
	public JButton btneliminar = new JButton();
	public JButton btnsalir = new JButton();
	public JList<Figuras> lista = new JList<>();
	public JTextField area = new JTextField("0.0");
	public PanelFiguras figPan = new PanelFiguras();
	public VistaFiguras(){
		super("Figuras");
		this.setContentPane(crearPanelPrincipal());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 800);
		this.setVisible(true);
	}
	private Container crearPanelPrincipal() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(crearMenu(), BorderLayout.NORTH);
		panel.add(crearSplit());
		return panel;
	}
	private Component crearSplit() {
		JSplitPane panel = new JSplitPane();
		panel.add(crearPanIzquierdo(), JSplitPane.LEFT);
		panel.setDividerLocation(400);
		panel.add(crearPanDerecho(), JSplitPane.RIGHT);
		return panel;
	}
	private Component crearPanDerecho() {
		return figPan;
	}
	private Component crearPanIzquierdo() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		JToolBar toolbar = new JToolBar();
		btnanadir.setIcon(new ImageIcon("edit_add.png"));
		btneliminar.setIcon(new ImageIcon("edit_remove.png"));
		btnsalir.setIcon(new ImageIcon("exit.png"));
		btnanadir.setActionCommand("anadir");
		btneliminar.setActionCommand("eliminar");
		toolbar.add(btnanadir);
		toolbar.add(btneliminar);
		toolbar.addSeparator();
		toolbar.add(btnsalir, JToolBar.RIGHT_ALIGNMENT);
		panel.add(toolbar, BorderLayout.NORTH);
		panel.add(lista, BorderLayout.CENTER);
		panel.add(crearPanelInferior(), BorderLayout.SOUTH);
		return panel;
	}
	private Component crearPanelInferior() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.add(new JLabel("Superficie total: "));
		panel.add(area);
		return panel;
	}
	private Component crearMenu() {
		JMenuBar menu = new JMenuBar();
		menu.add(editar);
		menu.add(salir);
		editar.add(anadir);
		editar.add(eliminar);
		anadir.setActionCommand("anadir");
		eliminar.setActionCommand("eliminar");
		salir.addActionListener(e -> this.dispose());
		return menu;
	}
	public void setListener(ActionListener e){
		this.btnanadir.addActionListener(e);
		this.btneliminar.addActionListener(e);
	}
}
