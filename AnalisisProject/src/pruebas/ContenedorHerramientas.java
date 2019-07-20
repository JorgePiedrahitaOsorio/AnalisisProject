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

    private int x, y, width, heigth;

    public ContenedorHerramientas(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        iniciarComponentes();
    }

    private void tamaño() {
        this.setBounds(x, y, width, heigth);
    }
    
    private void agregarLayout(){
        this.setLayout(null);
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    private void aspecto() {
        this.setBackground(Color.black);
    }
}
