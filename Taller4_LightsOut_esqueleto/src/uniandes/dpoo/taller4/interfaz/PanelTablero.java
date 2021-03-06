package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class PanelTablero  extends JPanel implements MouseListener
{

	
	private Tablero principal; 
	private Top10 top10;
	private VentanaPrincipal frame;
	private boolean[][] tablero;
	private int[][] cantidades;
	private int ultima_fila;
	private int ultima_columna;

	
	public PanelTablero(VentanaPrincipal frame,int tamanio, Tablero Pprincipal, Top10 top)
	{
		principal = Pprincipal;
		this.frame = frame;
		top10=top;
		tablero = principal.darTablero();
		cantidades = new int[tamanio][tamanio];
		setSize(350, 350);
		setVisible(true);
		setBackground(Color.black);
		setOpaque(true);
		addMouseListener(this);
		
	}
	
	
	
	

	public void paint(Graphics g)
	{
	Graphics2D g2d = (Graphics2D) g;
	int trozo = 350/tablero.length;
	for (int i = 0; i < tablero.length; i++)
		for (int ii = 0; ii < tablero.length; ii++)
		{
			if (tablero[i][ii])
			{
				g2d.setColor(new Color(255,223,64));
			}
			else
			{
				g2d.setColor(new Color(34,16,89));
			}
			g2d.fillRoundRect(i*trozo,ii*trozo,trozo-5,trozo-5,30,30);
			g2d.setColor(Color.white);
			g2d.drawString(String.valueOf(cantidades[i][ii]),(i*trozo)+(trozo/2),(ii*trozo)+(trozo/2));
		}
	repaint();
	}
	
	
	public void mousePressed(MouseEvent e)
	{
	int click_x = e.getX();
	int click_y = e.getY();
	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	cantidades[casilla[0]][casilla[1]]++;
	principal.jugar(casilla[0], casilla[1]);
	this.ultima_fila = casilla[0];
	this.ultima_columna = casilla[1];
	repaint();
	if(principal.tableroIluminado()) 
	{
		String name = JOptionPane.showInputDialog("Ingrese sus iniciales (ej: MAR) por favor");
		int puntaje=principal.calcularPuntaje();
		if (top10.esTop10(puntaje)) {
			top10.agregarRegistro(name, puntaje);
		}
	}
	SwingUtilities.updateComponentTreeUI(frame);
	frame.actualizarInfo();
	}
	
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.length;
	int altoPanelTablero = 350;
	int anchoPanelTablero = 350;
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] {columna, fila};
	}




	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
