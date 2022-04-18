package uniandes.dpoo.taller4.interfaz;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame
{

    
	private int tamanio;
	private String dificultad;
	
	
    private PanelTablero panelCentro;
    private PanelConfiguracion panelArriba;
    private PanelMenu panelDerecha;
    private PanelInfo panelAbajo;
    


	private Tablero tablero; 
	
	
    
    public VentanaPrincipal()
    {
        
        
        setSize( 700, 500 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "LightsOut" );
        

        setLayout( new BorderLayout( ) );
        
        tablero = new Tablero(tamanio);
        panelCentro = new PanelTablero(tamanio, tablero);
        add(panelCentro, BorderLayout.CENTER);
        
        //panelArriba = new PanelConfiguracion( );
        //add(panelAbajo, BorderLayout.NORTH);
        
        //panelDerecha = new PanelMenu( );
        //add(panelAbajo, BorderLayout.EAST);
        
        //panelAbajo = new PanelInfo( );
        //add(panelAbajo, BorderLayout.SOUTH);
        
        
    }
    
    
    
    
    public static void main (String[] args)
    {
        VentanaPrincipal  ventana = new  VentanaPrincipal( );
        ventana.setVisible( true );
    }
}
