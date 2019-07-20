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
public class Esclavo {

    protected Point ubicacion;
    protected int ancho;
    protected int alto;
    protected ImageIcon imagen;
    protected int velocidad_navegacion;
    protected int nivel_ataque;
    protected int vida;

    public Esclavo() {
    }

    public Esclavo(Point ubicacion, int ancho, int alto, String ruta, int velocidad_navegacion, int nivel_ataque) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource(ruta));
        this.velocidad_navegacion = velocidad_navegacion;
        this.nivel_ataque = nivel_ataque;
        this.vida = 100;
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

    /**
     * @return the velocidad_navegacion
     */
    public int getVelocidad_navegacion() {
        return velocidad_navegacion;
    }

    /**
     * @param velocidad_navegacion the velocidad_navegacion to set
     */
    public void setVelocidad_navegacion(int velocidad_navegacion) {
        this.velocidad_navegacion = velocidad_navegacion;
    }

    /**
     * @return the nivel_ataque
     */
    public int getNivel_ataque() {
        return nivel_ataque;
    }

    /**
     * @param nivel_ataque the nivel_ataque to set
     */
    public void setNivel_ataque(int nivel_ataque) {
        this.nivel_ataque = nivel_ataque;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    
    

}
