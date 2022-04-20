package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel 
{

	private VentanaPrincipal principal;
    private JLabel jugadasTxt;
    private JLabel jugadas;
	
	public PanelInfo(VentanaPrincipal principal, int Pjugadas)
	{
		setLayout( new GridLayout( 1, 2 ) );
		jugadasTxt = new JLabel("Jugadas");
		jugadas = new JLabel(String.valueOf(Pjugadas));
		add(jugadasTxt);
		add(jugadas);
	}
	
	
	public void actualizarJugadas(int Pjugadas) {
	    jugadas.setText(String.valueOf(Pjugadas));
	    jugadas.repaint();
	}
	
	
}
