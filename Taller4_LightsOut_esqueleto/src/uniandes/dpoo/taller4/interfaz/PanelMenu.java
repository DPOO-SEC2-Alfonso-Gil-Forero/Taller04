package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.taller4.modelo.Tablero;


public class PanelMenu  extends JPanel implements ActionListener
{
    private VentanaPrincipal principal;
    
    private JButton btnNuevoJuego;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;

    private Tablero tablero;
    private int dificultad;
    
    public PanelMenu(VentanaPrincipal principal)
    {
        this.principal= principal;
		tablero = principal.darTablero();
		dificultad = principal.darDificultad();
        setLayout( new GridLayout( 6, 1 ) );
        setBorder( new TitledBorder( "Opciones" ) );
        
        btnNuevoJuego = new JButton("Nuevo");
        btnReiniciar = new JButton("Reiniciar");
        btnTop10 = new JButton( "Top-10" );
        btnCambiarJugador = new JButton("Cambiar jugador");
        
        btnNuevoJuego.addActionListener(this);
        btnReiniciar.addActionListener(this);
        btnTop10.addActionListener( this );
        btnCambiarJugador.addActionListener(this);
        
        btnNuevoJuego.setActionCommand("NUEVO");
        btnReiniciar.setActionCommand("REINICIAR");
        btnTop10.setActionCommand( "BUSCAR" );
        btnCambiarJugador.setActionCommand("CAMBIAR");
        
        btnTop10.setBackground( new Color(58,233,233) );
        
        add(btnNuevoJuego);
        add(btnReiniciar);
        add(btnTop10);
        add(btnCambiarJugador);
        
    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if(comando.equals("NUEVO"))
        {
        	tablero.reiniciar();
            tablero.desordenar(dificultad);
        }
        else if(comando.equals("REINICIAR"))
        {
            tablero.reiniciar();
        }
        else if(comando.equals( "BUSCAR" ))
        {
        	VentanaTop10 top=new VentanaTop10(principal,true);
    		top.setVisible(true);
        }
        else if(comando.equals("CAMBIAR"))
        {
            
        }
        
        
    }
    
    
   
    
    
}