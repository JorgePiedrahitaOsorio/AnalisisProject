/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.*;
import javax.swing.JScrollPane;

/**
 *
 * @author Thebest
 */
public class VistaConstructor extends javax.swing.JFrame{
    
    private Dimension pantallaTamano;
    private ContenedorPremapa contenedorPremapa;
    private ContenedorHerramientas contenedorHerramientas;
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
        agregarLayout();
        agregarPaneles();
    }
    
    private void AmpliarTamañoPantalla(){
        this.setBounds(0,0,pantallaTamano.width,pantallaTamano.height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }
    
    private void aspecto(){
        this.getContentPane().setBackground(Color.white);
    }
    
    private void agregarLayout(){
        this.getContentPane().setLayout(null);
    }
    
    private void agregarPaneles(){
        this.contenedorPremapa = new ContenedorPremapa(0,0,pantallaTamano.width-260,
                pantallaTamano.height);
        this.getContentPane().add(this.contenedorPremapa);
        this.contenedorHerramientas = new ContenedorHerramientas(
                this.contenedorPremapa.getWidth() + 5,0,250,this.pantallaTamano.height);
        this.getContentPane().add(this.contenedorHerramientas);
    }
    
    public static void main(String x[]){
        VistaConstructor v = new VistaConstructor();
        v.setVisible(true);
    }
}
