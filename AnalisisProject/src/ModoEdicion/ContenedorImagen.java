package ModoEdicion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ModoEdicion.VistaConstructor.urlElemento;
import static ModoEdicion.VistaConstructor.estadoEdicion;
import static ModoEdicion.VistaConstructor.estadoEdicionIsla;

/**
 * Clase que es un boton auxiliar para la ubicacion de los continentes como 
 * de las islas como para su respectiva seleccion
 * @author Thebest
 */
public class ContenedorImagen extends javax.swing.JButton {

    private String url;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private String url2;

    /**
     * Constructor con los parametros basicos para la construccion del boton
     * @param url cadena que representa la ruta donde se encuentra la imagen de 
     * fondo del boton
     * @param x posicion en x del boton sobre cualquier lienzo
     * @param y posicion en y del boton sobre el lienzo
     * @param width ancho del boton
     * @param height alto del boton
     */
    public ContenedorImagen(String url, int x, int y, int width, int height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initComponents();
    }

    /**
     * metodo que hace los llamados que representan el aspecto del boton
     */
    private void initComponents() {
        tamaño();
        dibujarFondo();
        this.addActionListener((ActionEvent e) -> {
            accionClick(e);
        });
        decoracion();
    }

    /**
     * metodo qeu define el tamaño del boton
     */
    private void tamaño() {
        this.setBounds(x, y, width, height);
    }
    
    /**
     * metodo que dibuja el fondo del boton
     */
    private void dibujarFondo() {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(url));
        Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(iconoEscalado);
    }

    /**
     * metodo que realiza las acciones de boton tras el evento click segun las 
     * circustancias
     * @param e instancia del object actionevent de java
     */
    private void accionClick(ActionEvent e) {
        if (estadoEdicionIsla) {
            estadoEdicion = false;
            urlElemento = this.url;
        } else {
            urlElemento = "../Imagenes/Sepiacontinente" + this.url2;
            estadoEdicionIsla = false;
            estadoEdicion = true;
        }
    }

    /**
     * metodo que permite mover el boton en el lienzo desde un objeto externo
     * @param x nueva posicion en x  del boton
     * @param y nueva posicion en y del boton
     */
    public void mover(int x, int y) {
        this.setBounds(x, y, this.width, this.height);
    }

    /**
     * metodo que permite cambiar la url que representa la ruta del fondo del boton
     * @param url cadena que representa la ruta de la imagen del fondo
     */
    public void setUrl(String url) {
        this.url = url;
        dibujarFondo();
    }

    /**
     * metodo que elimina el evento click del boton
     */
    public void eliminarEventoClick() {
        this.removeActionListener(actionListener);
    }

    /**
     * metodo que hace una limpieza de la decoracion del boton por defecto
     */
    private void decoracion() {
        this.setBorder(null);
        this.setContentAreaFilled(false);
    }

    /**
     * @param url2 the url2 to set
     */
    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
