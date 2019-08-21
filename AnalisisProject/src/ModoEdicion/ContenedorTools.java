/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

/**
 *
 * @author Thebest (William)
 * @author JORGE OSORIO
 */
public abstract class ContenedorTools extends javax.swing.JPanel {

    public int x, y, width, heigth;

    /**
     * Constructor de la interfaz ContenedorTools. Esta interfaz sera
     * implementada por los paneles que se encuentran en la parte derecha de la
     * ventana, es decir, los panales encargados de contener las estructuras de
     * islas o continentes, durante la fase de diseño y edicion del mapa
     *
     * @param x indica la posicion en x en la cual se encuentra el contenedor
     * @param y indica la posicion en y en la cual se encuentra el contenedor
     * @param width indica el ancho del contenedor
     * @param heigth indica el alto del contenedor
     */
    public ContenedorTools(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        iniciarComponentes();
    }

    /**
     * En este metodo se editan los bounds del panel que implementen la
     * interfaz, estos bounds son las variables de posicion en x, posicion en y,
     * ancho y alto de este
     */
    public abstract void tamaño();

    /**
     * En este metodo se modifica el Layout de los paneles, para la
     * implementacion de dichos paneles el valor del Layout sera null
     */
    public abstract void agregarLayout();

    /**
     * En este metodo se instancian todos aquellos metodos propios del panel que
     * implementa la interfaz. Dichos metodos seran en su mayoria metodos de
     * instancia requeridos para la construccion del panel
     *
     */
    public abstract void iniciarComponentes();

    /**
     * En este metodo se cambia el fondo del panel que implementa la interfaz
     */
    public abstract void aspecto();
}
