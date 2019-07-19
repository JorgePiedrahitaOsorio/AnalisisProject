/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author JORGE OSORIO
 */
public class Isla {
    
    private Point ubicacion;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    String nombre;
    LinkedList<Estrella> estrellas;
    

    public Isla() {
    }

    public Isla(Point ubicacion, int ancho, int alto, String ruta) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource(ruta));
    }
    
    public void CambiarSprite(String ruta){
        this.imagen = new ImageIcon(getClass().getResource(ruta));
    }

    /**
     * @return the ubicacion
     */
    public Point getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the imagen
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
}
