package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaTop10 extends JDialog implements ActionListener{
	private int tamanio;
	private JList<String> lista;
	private Top10 top;
	File file=new File("data/top10.csv");
	public VentanaTop10(JFrame jframe, boolean modal) {
		super(jframe, modal);
		top=new Top10();
		setTitle ("Top 10");
		setBounds(400,300,400,300);
		lista=new JList<String>();
		this.getContentPane().setLayout(new FlowLayout());
		top.cargarRecords(file);		
		DefaultListModel modelo = new DefaultListModel();
		int i=0;
		for (RegistroTop10 e:top.darRegistros()) {
			i++;
			e.toString();
		    modelo.addElement(String.valueOf(i)+".    "+e);
		}
		lista.setModel(modelo);
		add (lista);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
