/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Color;

/**
 *
 * @author Thebest
 */
public class ContenedorHerramientas extends javax.swing.JPanel {
    
    public ContenedorHerramientas(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        aspecto();
    }
    
    private void aspecto(){
        this.setBackground(Color.white);
        this.setLayout(null);
    }
}
