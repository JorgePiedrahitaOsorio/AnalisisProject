package ModoEdicion;

import static ModoEdicion.VistaConstructor.estadoEdicionIsla;

import java.awt.Color;

/**
 * clase que se encarga de disponer la seleccion de la isla a insertar en el panel 
 * contenedorprecontinente
 * @author William Vasquez Y Jorge Osorio
 */
public final class ContenedorHerramientasIsla extends ContenedorTools {

    /**
     * constructor que tiene como parametros lo basico para la construccion del lienzo
     * @param x posicion en x del lienzo sobre vistaconstructor
     * @param y posicion en y del lienzo sobre vistaconstructor
     * @param width ancho del lienzo
     * @param heigth alto del lienzo
     */
    public ContenedorHerramientasIsla(int x, int y, int width, int heigth) {
        super(x, y, width, heigth);
        iniciarComponentes();
    }

    /**
     * metodo que se encarga de definir el tamaño del boton
     */
    @Override
    public void tamaño() {
        this.setBounds(x, y, width, heigth);
    }

    /**
     * metodo que se encarga de disponer de un layout para el lienzo
     */
    @Override
    public void agregarLayout() {
        this.setLayout(null);
    }

    /**
     * metodo qeu hace los llamados para disponer de las caracteristicas de aspecto
     * del lienzo
     */
    @Override
    public final void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        crearIsla();
    }

    /**
     * metodo qeu se encarga de crear las rutas para cada imagen que tendra los 
     * botones de isla que soportara el lienzo
     */
    private void crearIsla() {
        agregarIsla("../Imagenes/isla1.png", 50, 20, 100, 100);
        agregarIsla("../Imagenes/isla2.gif", 50, 140, 100, 100);
        agregarIsla("../Imagenes/isla4.png", 50, 260, 100, 100);
    }

    /**
     * metodo que se encarga de agregar islas al lienzo
     * @param url cadena que representa la ruta de la imagen de cada boton isla 
     * que sportara el lienzo
     * @param x posicion en x del boton que tendra sobre el lienzo
     * @param y posicion en y del boton que tendra sobre el lienzo
     * @param width ancho del boton que se dispondra sobre el lienzo
     * @param height alto del boton que se dispondra sobre el lienzo
     */
    private void agregarIsla(String url, int x, int y, int width, int height) {
        ContenedorImagen contenedorImagen = new ContenedorImagen(url, x, y, width, height);
        contenedorImagen.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirBotonAction(evt);
        });
        this.add(contenedorImagen);
    }

    /**
     * metodo que se encarga de disponer de un aspecto al lienzo
     */
    @Override
    public void aspecto() {
        this.setBackground(Color.BLACK);
    }

    /**
     * metodo que se encarga de activar el evento de los botones islas que se 
     * dispondran sobre el lienzo
     * @param evt instacia del object actionevent
     */
    public void AñadirBotonAction(java.awt.event.ActionEvent evt) {
        estadoEdicionIsla = true;
    }

}
