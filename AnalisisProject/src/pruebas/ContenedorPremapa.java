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
public class ContenedorPremapa extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int heigth;

    public ContenedorPremapa(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }
    
    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }
    
    private void agregarLayout(){
        this.setLayout(null);
    }
    
    private void aspecto() {
        this.setBackground(Color.white);
    }

    private void AgregarFondo() {
    }
    
       /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

}
