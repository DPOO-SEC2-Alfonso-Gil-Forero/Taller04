package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;


import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaTop10 extends JDialog {
	private int tamanio;
	private JList<String> lista;
	private Top10 top;
	File file=new File("data/top10.csv");
	public VentanaTop10(JFrame jframe, boolean modal) {
		super(jframe, modal);
		top=new Top10();
		setTitle ("Top 10");
		setLocationRelativeTo( null );
		setBounds(200,150,200,150);
		lista=new JList<String>();

		setLayout( new BorderLayout( ) );
		
		top.cargarRecords(file);		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		int i=0;
		for (RegistroTop10 e:top.darRegistros()) {
			i++;
			e.toString();
		    modelo.addElement(String.valueOf(i)+".    "+e);
		}
		lista.setModel(modelo);
		lista.setBackground(new Color(250,250,250));
		lista.setVisibleRowCount(4);
		JScrollPane desplazar=new JScrollPane(lista);
		r=new JPanel();
		t=new JPanel();
		r.add(desplazar);
	    rotulo=new JLabel("#  Nombre");
	    t.setBackground(new Color(58,233,233));
	    add(r, BorderLayout.CENTER);
	    t.add(rotulo);
		add(t, BorderLayout.NORTH);

		add(desplazar);
	}

	private JLabel rotulo;
	private JPanel r;
	private JPanel t;
	
	
	

}
