package Interfaces;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * clase que funciona para simular a los continentes y poderlos dibujar 
 * @author William Vasquez Y jorge Osorio
 * @version 1.0
 */
public class ContenedorContinente extends JLabel {

    private int x, y, width, height;
    private String url;

    /**
     * Constructor que me permite la inplementacion del continente haciendo uso 
     * de un contenedor como label
     * @param x posicion en x del continentes
     * @param y posicion en y del continente 
     * @param width ancho del continente
     * @param height alto del continente
     * @param url ruta de la imagen del continente
     */
    public ContenedorContinente(int x, int y, int width, int height, String url) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.url = url;
        caracteristicasVisuales();
    }

    /**
     * metodo que le implementa las caracteristicas visuales al contenedor
     */
    private void caracteristicasVisuales() {
        this.setBounds(x, y, width,height);
        this.setOpaque(false);
        agregarImagenFondo();
    }

    /**
     * metodo que el agregado una imagen de fondo al label
     */
    private void agregarImagenFondo() {
        try {
            ImageIcon imgIcon = new ImageIcon(getClass().getResource(this.url));
            Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                    this.getHeight(), Image.SCALE_DEFAULT));
            this.setIcon(iconoEscalado);
        } catch (Exception e) {
            System.out.println("No agrego Fondo");
        }
    }

}
