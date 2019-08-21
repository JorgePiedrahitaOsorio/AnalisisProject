
package ModoEdicion;

import java.awt.Color;


/**
 * Esta clase nos dispone de un panel con los continentes que arrastraremos en 
 * el panel premapa, funcionalidad de crear continentes
 * @author William Vasquez, Jorge Osorio
 * @version 1.6
 */
public class ContenedorHerramientasContinentes extends ContenedorTools {

    /**
     * 
     * @param x posición en x del panel sobre la ventana VistaConstructor 
     * @param y posición en y del panel sobre la ventana VistaConstructor
     * @param width ancho del panel
     * @param heigth alto del panel
     */
    public ContenedorHerramientasContinentes(int x, int y, int width, int heigth) {
        super(x, y, width, heigth);
        iniciarComponentes();
    }

    /**
     * Le da el tamaño al  panel
     */
    @Override
    public void tamaño() {
        this.setBounds(x, y, width, heigth);
    }

    /**
     * Le da un layout al panel
     */
    @Override
    public void agregarLayout() {
        this.setLayout(null);
    }

    /**
     * Llama a varios métodos encargados de la construccion gráfica del panel
     */
    @Override
    public final void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        crearContinentes();
    }

    /**
     * Crea los continentes del tipo ContenedorImagen sobre el panel
     */
    private void crearContinentes() {
        for (int i = 1; i < 7; i++) {
            agregarContinente("../Imagenes/continente" + String.valueOf(i) + ".png", String.valueOf(i) + ".png", 50, 20 * i
                    + (100 * (i - 1)), 100, 100);
            //agregarContinente(String.valueOf(i) + ".png", 50, 20 * i + (100 * (i - 1)), 100, 100);
        }
    }

    /**
     * Agrega los continentes del tipo ContenedorImagen al panel 
     * @param url cadena que representa la ruta de la imagen de color
     * @param url2 cadena que representa la ruta de la imagen en sepia
     * @param x posicion en x del Object ContenedorImagen sobre el panel
     * @param y posicion en y del Object ContenedorImagen sobre el panel
     * @param width ancho del Object ContenedorImagen
     * @param height alto del Object ContenedorImagen
     */
    private void agregarContinente(String url, String url2, int x, int y, int width, int height) {
        ContenedorImagen contenedorImagen = new ContenedorImagen(url, x, y, width, height);
        contenedorImagen.setUrl2(url2);
        this.add(contenedorImagen);
    }

    /**
     * Entrega color al panel
     */
    @Override
    public void aspecto() {
        this.setBackground(Color.black);
    }
}
