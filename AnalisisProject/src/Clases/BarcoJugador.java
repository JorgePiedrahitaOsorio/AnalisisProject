package Clases;

import Grafo.Nodo;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * clase que tiene el barco que dibujaremos y navegara durante la simulacion
 * @author william Vasquez y Jorge Osorio
 * @version 1.1
 */
public class BarcoJugador implements Runnable{

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int horasNavegacion;
    private ImageIcon imagen;
    private LinkedList<Esclavo> esclavos;
    

    /**
     * constructor que instancia un barco 
     * @param x posicion x del barco en algun lienzo
     * @param y posicion y del barco en algun lienzo
     * @param ancho ancho del barco
     * @param alto alto del barco
     */
    public BarcoJugador(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getResource("../Imagenes/barco-pirata.gif"));
        this.calcularHorasNavegacion();
    }

    /**
     * metodo que calcula las horas de navegacion que tiene actualmente el barco
     */
    private void calcularHorasNavegacion() {
        this.esclavos.forEach((esclavo) -> {
            this.horasNavegacion += esclavo.getHorasNavegacion();
        });
    }
    
   

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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
     * @return the horasNavegacion
     */
    public int getHorasNavegacion() {
        return horasNavegacion;
    }

    /**
     * @param horasNavegacion the horasNavegacion to set
     */
    public void setHorasNavegacion(int horasNavegacion) {
        this.horasNavegacion = horasNavegacion;
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
     * @return the esclavos
     */
    public LinkedList<Esclavo> getEsclavos() {
        return esclavos;
    }

    /**
     * @param esclavos the esclavos to set
     */
    public void setEsclavos(LinkedList<Esclavo> esclavos) {
        this.esclavos = esclavos;
    }

    @Override
    public void run() {
        while(this.horasNavegacion >= 0){
            
        }
    }

}
