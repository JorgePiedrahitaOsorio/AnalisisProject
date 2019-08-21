package Interfaces;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *clase que se encargara de simulas los objetos islas para poderlos dibujar
 * @author William Vasquez y Jorge Osorio
 */
public class ContenedorIsla extends JLabel {

    private int x, y, width, height;
    private String url;

    /**
     * constructor con los requerimientos basicos para la construccion de la isla
     * @param x posicion en x de la isla
     * @param y posicion en y de la isla
     * @param width ancho de la isla
     * @param height alto de la isla
     * @param url ruta con la imagen de la isla
     */
    public ContenedorIsla(int x, int y, int width, int height, String url) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.url = url;
        caracteristicasVisuales();
    }

    /**
     * metodo qeu agrega caracteristicas visuales al label
     */
    private void caracteristicasVisuales() {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        agregarImagenFondo();
    }

    /**
     * metodo para agregar imagen de fondo al label
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
