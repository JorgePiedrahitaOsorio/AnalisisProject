package Clases;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * clase que tiene el barco que dibujaremos y navegara durante la simulacion
 *
 * @author william Vasquez y Jorge Osorio
 * @version 1.1
 */
public class BarcoJugador implements Runnable {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int horasNavegacion;
    private ImageIcon imagen;
    private LinkedList<Esclavo> esclavos;
    private Continente origen;
    private Continente destino;
    private final Thread hilo;

    /**
     * constructor que instancia un barco
     *
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
        this.esclavos = new LinkedList<>();
        this.calcularHorasNavegacion();
        this.hilo = new Thread(this);
    }

    public void Start() {
        this.hilo.start();
    }

    /**
     * metodo que calcula las horas de navegacion que tiene actualmente el barco
     */
    private void calcularHorasNavegacion() {
        this.horasNavegacion = 6;
        this.esclavos.forEach((esclavo) -> {
            this.horasNavegacion += esclavo.getHorasNavegacion();
        });
    }

    public void Ruta(Continente origen, Continente destino) {
        this.origen = origen;
        this.destino = destino;
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

    private double pendienteRecta(int x1, int x2, int y1, int y2) {
        return ((double) (y2 - y1) / (double) (x2 - x1));
    }

    @Override
    public void run() {
        while (this.horasNavegacion >= 0) {
            try {
                if (this.origen.getUbicacion().x < this.destino.getUbicacion().x) {
                    double m = pendienteRecta(origen.getUbicacion().x, destino.getUbicacion().x, origen.getUbicacion().y, destino.getUbicacion().y);
                    for (int i = this.origen.getUbicacion().x; i < this.destino.getUbicacion().x; i++) {
                        double b = (-1) * (m * this.origen.getUbicacion().x) + origen.getUbicacion().y;
                        this.y = (int) ((m * i) + b);
                        this.x = i;
                        Thread.sleep(20);
                    }
                } else {
                    double m = pendienteRecta(origen.getUbicacion().x, destino.getUbicacion().x, origen.getUbicacion().y, destino.getUbicacion().y);
                    for (int i = this.origen.getUbicacion().x; i > this.destino.getUbicacion().x; i--) {
                        double b = (-1) * (m * origen.getUbicacion().x) + origen.getUbicacion().y;
                        this.y = (int) ((m * i) + b);
                        this.x = i;
                        Thread.sleep(20);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(BarcoJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("No hay mas combustible");
    }

}
