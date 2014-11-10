import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Principal extends JFrame implements ActionListener, FileFilter, ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File dir;
	JList<File> imagenes;
	ImageIcon imagen;
	JPanel pimagen;
	JButton btdir;
	JLabel etImagen;
	DefaultListModel<File>modelo = new DefaultListModel<>();	
	public Principal(){
		super("Visor de imagenes");
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(800, 600);
		this.setContentPane(crearPaneles());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private Container crearPaneles() {
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		split.add(crearPanelSelector(), JSplitPane.LEFT);
		split.add(crearPanelImagen(), JSplitPane.RIGHT);
		return split;
	}

	private Component crearPanelImagen() {
		pimagen = new JPanel();
		pimagen.add(etImagen = new JLabel());
		return pimagen;
	}

	private Component crearPanelSelector() {
		JPanel psel = new JPanel();
		psel.add(btdir = new JButton("Directorio"), BorderLayout.NORTH);
		psel.add(imagenes = new JList<File>());
		imagenes.setModel(modelo);
		imagenes.addListSelectionListener(this);
		btdir.addActionListener(this);
		btdir.setActionCommand("cd");
		return psel;
	}
	public static void main(String[] args){
		Principal p = new Principal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "cd":
			dir = mostrarDialogoSelect();
			pasarImgaLista();
			break;
		}
		
	}

	private File mostrarDialogoSelect() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.showOpenDialog(this);
		return fc.getSelectedFile();
	}
	public void pasarImgaLista(){
		File[] imgs;
		imgs = dir.listFiles(this);
		for(File i : imgs){
			modelo.addElement(i);
		}
		
	}
	@Override
	public boolean accept(File pathname) {
		if(pathname.getName().endsWith("png")||(pathname.getName().endsWith("PNG"))){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
			etImagen.setIcon(new ImageIcon(imagenes.getSelectedValue().getAbsolutePath()));
		
	}
}
