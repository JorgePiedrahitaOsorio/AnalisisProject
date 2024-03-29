
package ModoEdicion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static ModoEdicion.ContenedorNodoIsla.vista;
import static ModoEdicion.VistaConstructor.pIslaReferencia;
import static ModoEdicion.ContenedorNodoIsla.abrir;
import static ModoEdicion.VistaConstructor.banderaGuardar;

/**
 * Panel que nos permite parametrizar la isla al manejar Object del tipo ParametrosIsla
 * @version 1.3
 * @author William Vasquez y Jorge Osorio
 */
public class ContenedorHerramientaPersonalizarIsla extends ContenedorTools {

    private int tamañoTesoro;
    private int esclavosJovenes;
    private int esclavosAdultos;
    private int esclavosViejos;
    private String nombreIsla;
    private ImageIcon imagenFondo;

    private JTextField[] camposTexto;
    
    /**
     * 
     * @param x posicion x sobre la venta VistaConstructor
     * @param y posicion y sobre la venta VistaConstructor
     * @param width ancho del panel
     * @param height alto del panel
     * @param p Object del tipo ParametrosIsla que trae las caracteristicas de la misma
     */
    public ContenedorHerramientaPersonalizarIsla(int x, int y, int width, int height, ParametrosIsla p) {
        super(x, y, width, height);
        this.tamañoTesoro = p.getTamañoTesoro();
        this.esclavosJovenes = p.getEsclavosJovenes();
        this.esclavosAdultos = p.getEsclavosAdultos();
        this.esclavosViejos = p.getEsclavosViejos();
        this.nombreIsla = p.getNombreIsla();
        this.camposTexto = new JTextField[5];
        this.agregarEtiquetas();
        this.agregarCajasTextos();
        this.AñadirBotonGuardar();
        this.AñadirFondo();

    }

    /**
     * Le agrega un fondo al panel
     */
    private void AñadirFondo() {
        this.imagenFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo3.jpg"));
    }
    
    /**
     * agrega las etiquetas de los parametros
     */
    private void agregarEtiquetas() {

        JLabel aux = new JLabel("Tamaño tesoro");
        aux.setBounds(15, 10, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos jovenes");
        aux.setBounds(15, 80, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos adultos");
        aux.setBounds(15, 150, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos viejos");
        aux.setBounds(15, 220, 170, 30);
        this.add(aux);
        aux = new JLabel("Nombre Isla");
        aux.setBounds(15, 290, 170, 30);
        this.add(aux);

    }

    /**
     * agrega las cajas de texto donde se va introducir el valor de los parametros
     */
    private void agregarCajasTextos() {

        JTextField aux = new JTextField();
        aux.setBounds(15, 40, 170, 30);
        aux.setText("" + this.tamañoTesoro);
        this.camposTexto[0] = aux;
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 110, 170, 30);
        aux.setText("" + this.esclavosJovenes);
        this.camposTexto[1] = aux;
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 180, 170, 30);
        aux.setText("" + this.esclavosAdultos);
        this.camposTexto[2] = aux;
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 250, 170, 30);
        aux.setText("" + this.esclavosViejos);
        this.camposTexto[3] = aux;
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 320, 170, 30);
        aux.setText(this.nombreIsla);
        this.camposTexto[4] = aux;
        this.add(aux);
    }

    /**
     * añade el boton con el que guardamos la parametrización de la isla
     */
    private void AñadirBotonGuardar() {
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setVisible(true);
        btnGuardar.setBounds(40, 390, 100, 40);
        this.add(btnGuardar);
        btnGuardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            Guardar(evt);
        });
    }

    /**
     * modifica la bandera banderaGuardar a true y abrir a true, cierra la ventana aux
     * @param evt evento por defecto de los botones al hacer click 
     */
    private void Guardar(java.awt.event.ActionEvent evt) {
        guardado();
        banderaGuardar = true;
        vista.dispose();
        abrir = true;
    }

    /**
     * Crea un nuevo Object del tipo ParametrosIslas y le pasa su valor a la bandera 
     * pIslaReferencia
     */
    public void guardado() {
        this.tamañoTesoro = Integer.parseInt(this.camposTexto[0].getText());
        this.esclavosJovenes = Integer.parseInt(this.camposTexto[1].getText());
        this.esclavosAdultos = Integer.parseInt(this.camposTexto[2].getText());
        this.esclavosViejos = Integer.parseInt(this.camposTexto[3].getText());
        this.nombreIsla = this.camposTexto[4].getText();
        pIslaReferencia = new ParametrosIsla(this.tamañoTesoro, this.esclavosJovenes,
                this.esclavosAdultos, this.esclavosViejos, this.nombreIsla);
    }

    /**
     * Define el tamaño del panel
     */
    @Override
    public void tamaño() {
        this.setBounds(x, y, width, heigth);
    }

    /**
     * define un layout para el panel
     */
    @Override
    public void agregarLayout() {
        this.setLayout(null);
    }
    
    /**
     * Carga los metodos básicos de l panel
     */
    @Override
    public void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    /**
     * Le da un color al panel
     */
    @Override
    public void aspecto() {
        this.setBackground(Color.CYAN);
    }

    /**
     * Metodo con el cual dibujamos sobre el panel
     * @param g intanciacion del object graphics con el cual podemos dibujar 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imagenFondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        repaint();
    }

}
