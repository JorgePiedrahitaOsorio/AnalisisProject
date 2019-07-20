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
//        pack();
    }
    
    private Dimension tamañoPantalla(){
       Toolkit t = Toolkit.getDefaultToolkit();
       return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    private void ConfiguracionesIniciales(){
        this.setTitle("MAPA CONTINENTES");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes(){
        pantallaTamano = tamañoPantalla(); 
        caracteristicasVisuales();
    }
    
    private void caracteristicasVisuales(){
        AmpliarTamañoPantalla();
        aspecto();
        ConfiguracionesIniciales();
    }
    
    private void AmpliarTamañoPantalla(){
        this.setBounds(0,0,pantallaTamano.width,pantallaTamano.height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }
    
    private void aspecto(){
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().setLayout(new BorderLayout());
    }
    
    public static void main(String x[]){
        VistaConstructor v = new VistaConstructor();
        v.setVisible(true);
    }
}
