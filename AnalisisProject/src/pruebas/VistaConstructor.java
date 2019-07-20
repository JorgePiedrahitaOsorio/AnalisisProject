/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.*;

/**
 *
 * @author Thebest
 */
public class VistaConstructor extends javax.swing.JFrame{
    
    private Dimension pantallaTamano;
    
    public VistaConstructor(){
        iniciarComponentes();
    }
    
    private Dimension tamañoPantalla(){
       Toolkit t = Toolkit.getDefaultToolkit();
       return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    private void iniciarComponentes(){
        pantallaTamano = tamañoPantalla(); 
        caracteristicasVisuales();
    }
    
    private void caracteristicasVisuales(){
        AmpliarTamañoPantalla();
        aspecto();
    }
    
    private void AmpliarTamañoPantalla(){
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void aspecto(){
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(new BorderLayout());
    }
}
