package ModoEdicion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ModoEdicion.VistaConstructor.estadoEdicionMarIsla;
import static ModoEdicion.VistaConstructor.referenciaContinenteIsla1;
import static ModoEdicion.VistaConstructor.referenciaContinenteIsla2;
import static ModoEdicion.VistaConstructor.banderaDibujarMarIsla;
import static ModoEdicion.VistaConstructor.estadoEdicion;
import static ModoEdicion.VistaConstructor.estadoParametrizacionIsla;
import static ModoEdicion.VistaConstructor.modoMoverIsla;
import static ModoEdicion.VistaConstructor.modoOnIsla;
import static ModoEdicion.VistaConstructor.referenciaIsla;
import static ModoEdicion.VistaConstructor.referenciaMoverIsla;
import static ModoEdicion.VistaConstructor.eliminarIsla;
import static ModoEdicion.VistaConstructor.referenciaIslaEliminar;

/**
 * Clase que representa las islas a la hora de ser dibujadas en el lienzo
 * @author William Vasquez y Jorge Osorio
 * @version 1.9
 */
public class ContenedorNodoIsla extends javax.swing.JButton {

    private String url;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    public static VistaPersonalizarIsla vista;
    public static boolean abrir;

    /**
     * Contructor de la clase contenedortools que solicita los valore basico 
     * para la construccion del boton 
     * @param url cadena que tiene la ruta de la imagen de fondo del boton isla
     * @param x posicion en x sobre el panel contenedorprecontinente
     * @param y posicin en y sobre el panel contenedoroprecontinente
     * @param width ancho del boton
     * @param height alto del boton
     */
    public ContenedorNodoIsla(String url, int x, int y, int width, int height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        abrir = true;
        initComponents();
    }

    /**
     * metodo que llama los metodos que permiten la adecuacion del boton
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
     * metodo que le da tamaño al boton
     */
    private void tamaño() {
        this.setBounds(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * metodo que dibuja un fondo en el boton
     */
    private void dibujarFondo() {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(getUrl()));
        Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(iconoEscalado);
    }

    /**
     * metodo que implementa las acciones del boton segun las circustancias
     * @param e inatncia del objeto accionevent de java
     */
    private void accionClick(ActionEvent e) {
        estadoEdicion = false;
        
        if (estadoEdicionMarIsla) {
            dibujarBorde();
            if (referenciaContinenteIsla1 == null) {
                referenciaContinenteIsla1 = this;
            } else {
                referenciaContinenteIsla2 = this;
                banderaDibujarMarIsla = true;
            }
        }else if(modoMoverIsla){
            referenciaMoverIsla = this;
            modoOnIsla = true;
        }else if(eliminarIsla){
            referenciaIslaEliminar = this;
        }
        else {
            referenciaIsla = this;
            estadoParametrizacionIsla = true;
            if (abrir) {
                vista = new VistaPersonalizarIsla();
                vista.setVisible(true);
            }
        }
    }
    
    /**
     * metodo que nos permite cambiar la posicion del boton desde un objeto externo
     * @param x nueva posicion en x del boton
     * @param y nueva posicion en y del boton
     */
    public void mover(int x, int y){
        this.setBounds(x, y,this.width,this.height);
    }

    /**
     * metodo que dibuja el borde la boton
     */
    public void dibujarBorde() {
        this.setBorderPainted(true);
    }

    /**
     * metodo que desdibuja el borde del boton
     */
    
    public void desDibujarBorde() {
        this.setBorderPainted(false);
    }

    /**
     * metodo que limpia la decoracion del boton
     */
    private void decoracion() {
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    
}
