/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Mundo;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Thebest
 */
public class Simulación extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    
    JPanel panelIzquierda;
    JPanel panelDerecha;
    JPanel VistaMundo;
    JPanel PanelInformativo;
    Mundo mundo;
    
    public Simulación (Mundo m ){
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        this.mundo = m;
        caracteristicasVisuales();
    }
    
    private void caracteristicasVisuales(){
        this.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 
                Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.white);
    
    }
//    public static void main(String[] args) {
//        Simulación s  = new Simulación();
//        s.setVisible(true);
//    }
//    
    private void agregarPaneles(){
        this.VistaMundo = new VistaMundo(5,5,Toolkit.getDefaultToolkit().getScreenSize().width - 205,
        Toolkit.getDefaultToolkit().getScreenSize().height,mundo.getNodos(),mundo.getAristas());
        this.panelIzquierda.add(this.VistaMundo);
        this.PanelInformativo = new PanelInformativo(this.VistaMundo.getX()+5,5,200,this.VistaMundo.getHeight());
    }
    
}
