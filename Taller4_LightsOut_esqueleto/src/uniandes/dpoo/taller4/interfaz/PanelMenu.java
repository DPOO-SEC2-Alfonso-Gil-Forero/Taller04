package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class PanelMenu  extends JPanel implements ActionListener
{
    private VentanaPrincipal principal;
    
    private JButton btnTop10;
    private JButton btnOpc1;
    private JButton btnOpc2;
    
    
    public PanelMenu(VentanaPrincipal principal)
    {
        this.principal= principal;
        setLayout( new GridLayout( 6, 1 ) );
        setBorder( new TitledBorder( "Opciones" ) );
        
        btnTop10 = new JButton( "Top-10" );
        btnOpc1 = new JButton( "Opción 1" );
        btnOpc2 = new JButton( "Opción 2" );
        

        btnTop10.addActionListener( this );
        btnOpc1.addActionListener( this ); 
        btnOpc2.addActionListener( this );
        
        btnTop10.setActionCommand( "BUSCAR" );
        btnOpc1.setActionCommand( "OPC1" );
        btnOpc2.setActionCommand( "OPC2" );
        
        btnTop10.setBackground( new Color(58,233,233) );
        
        add(btnTop10);
        add(btnOpc1);
        add(btnOpc2);
        
    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if(comando.equals( "BUSCAR" ))
        {
        	VentanaTop10 top=new VentanaTop10(principal,true);
    		top.setVisible(true);
        }
        else if(comando.equals( "OPC1" ))
        {
            btnOpc1.setBackground(Color.RED );
        }
        else if(comando.equals( "OPC2" ))
        {
            JOptionPane.showMessageDialog( this, "presiono opcion 2" );
        }
        
        
    }
    
    
   
    
    
}

