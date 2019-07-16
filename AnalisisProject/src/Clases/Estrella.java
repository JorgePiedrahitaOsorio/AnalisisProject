/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.ImageIcon;

/**
 *
 * @author JORGE OSORIO
 */
public class Estrella {
    int x;
    int y;
    int ancho;
    int alto;
    String ruta;
    ImageIcon imagen;

    public Estrella() {
    }

    public Estrella(int x, int y, int ancho, int alto, String ruta) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource(ruta));
    }
    
}
