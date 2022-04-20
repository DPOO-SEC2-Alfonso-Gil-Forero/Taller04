package uniandes.dpoo.taller4.interfaz;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame implements ActionListener
{

    
	private int tamanio;
	private int dificultad;
	private File archivo=new File("data/top10.csv");
	
    private PanelTablero panelCentro;
    private PanelConfiguracion panelArriba;
    private PanelMenu panelDerecha;
    private PanelInfo panelAbajo;
    


	private Tablero tablero; 
	private Top10 top;
	
	
    
    public VentanaPrincipal()
    {
        
        
        setSize( 700, 500 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "LightsOut" );
        top=new Top10();
		top.cargarRecords(file);
        

        setLayout( new BorderLayout( ) );
        
        //Tamaño generico, el usuario debería ingresar el valor
        tamanio = 5;
        dificultad = 5;
        
        
        tablero = new Tablero(tamanio);
        panelCentro = new PanelTablero(tamanio, tablero,top);
        add(panelCentro, BorderLayout.CENTER);
        
        panelDerecha = new PanelMenu( this );
        add(panelDerecha, BorderLayout.EAST );
        

        
        //panelArriba = new PanelConfiguracion( );
        //add(panelAbajo, BorderLayout.NORTH);
        
        
        //panelAbajo = new PanelInfo( );
        //add(panelAbajo, BorderLayout.SOUTH);
        // Esto se usa para que al cerrar la ventana se salven los resultados
        addWindowListener(new WindowAdapter()
        {
                    public void windowClosing(WindowEvent e)
                   {
					 try {
						top.salvarRecords(archivo);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                   }
        });
        
        
    }File file=new File("data/top10.csv");
    
    
    
    public static void main (String[] args)
    {
        VentanaPrincipal  ventana = new  VentanaPrincipal( );
        ventana.setVisible( true );
        FlatLightLaf.install();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
    
	public Tablero darTablero()
	{
		return tablero;
	}
	
	public int darDificultad()
	{
		return dificultad;
	}
	
}
