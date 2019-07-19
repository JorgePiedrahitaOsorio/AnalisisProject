/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author JORGE OSORIO
 */
public class Tesoro {
    private Point ubicacion;
    private int ancho;
    private int alto;
    private int cantidad_monedas;
    private ImageIcon imagen;

    public Tesoro() {
    }

    public Tesoro(Point ubicacion, int ancho, int alto, int cantidad_monedas) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.cantidad_monedas = cantidad_monedas;
        this.imagen = new ImageIcon(getClass().getResource("../Imagenes/tesoro.png"));
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
     * @return the cantidad_monedas
     */
    public int getCantidad_monedas() {
        return cantidad_monedas;
    }

    /**
     * @param cantidad_monedas the cantidad_monedas to set
     */
    public void setCantidad_monedas(int cantidad_monedas) {
        this.cantidad_monedas = cantidad_monedas;
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
