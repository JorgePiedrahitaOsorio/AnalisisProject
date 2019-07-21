/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Thebest
 */
public class VistaConstructor extends javax.swing.JFrame implements
        MouseMotionListener, Runnable, MouseListener {

    private Dimension pantallaTamano;
    private ContenedorPremapa contenedorPremapa;
    private JPanel contenedorIzquierda;
    private JPanel contenedorDerecha;
    private ContenedorTools contenedorTools;
    private Thread hilo;
    private ContenedorImagen auxContenedorImagen;

    public static String urlElemento;
    public static boolean estadoEdicion;

    static {
        urlElemento = "";
        estadoEdicion = false;
    }

    public VistaConstructor() {
        iniciarComponentes();
        this.hilo = new Thread(this);
        this.Start();
        caracteristicasAuxContenedorImagen();
    }
    
    private void caracteristicasAuxContenedorImagen(){
        this.auxContenedorImagen = new ContenedorImagen("", 0, 0, 100, 100);
        this.auxContenedorImagen.eliminarEventoClick();
    }

    private void agregarInterfacesMapa() {
        this.contenedorPremapa.addMouseListener(this);
        this.contenedorPremapa.addMouseMotionListener(this);
    }

    private void Start() {
        this.hilo.start();
    }

    private Dimension tamañoPantalla() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    private void ConfiguracionesIniciales() {
        this.setTitle("MAPA CONTINENTES");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        pantallaTamano = tamañoPantalla();
        caracteristicasVisuales();
        agregarInterfacesMapa();
    }

    private void caracteristicasVisuales() {
        AmpliarTamañoPantalla();
        aspecto();
        ConfiguracionesIniciales();
        agregarLayout();
        agregarPaneles();
    }

    private void AmpliarTamañoPantalla() {
        this.setBounds(0, 0, pantallaTamano.width, pantallaTamano.height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }

    private void aspecto() {
        this.getContentPane().setBackground(Color.white);
    }

    private void agregarLayout() {
        this.getContentPane().setLayout(null);
    }

    private void agregarPaneles() {
        this.contenedorPremapa = new ContenedorPremapa(0, 0, pantallaTamano.width - 210,
                pantallaTamano.height);
        this.contenedorIzquierda = this.contenedorPremapa;
        this.getContentPane().add(this.contenedorIzquierda);
        this.contenedorTools = new ContenedorHerramientasContinentes(
                this.contenedorPremapa.getWidth() + 5, 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = this.contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
    }

    public static void main(String x[]) {
        VistaConstructor v = new VistaConstructor();
        v.setVisible(true);
    }

    @Override
    public void run() {
        boolean detener = true;
        while (detener) {
            try {
                System.out.println(estadoEdicion);
                if (estadoEdicion) {
                    this.setCursor(Cursor.HAND_CURSOR);
                } else {
                    this.setCursor(Cursor.DEFAULT_CURSOR);
                }
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                new Throwable("Todo es culpa de jorge ");
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (estadoEdicion) {
            this.contenedorPremapa.add(this.auxContenedorImagen);
            this.auxContenedorImagen.setUrl(urlElemento);
            this.auxContenedorImagen.mover(e.getX() + 25, e.getY() + 25);
            this.contenedorPremapa.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Entro 1");
        if (estadoEdicion) {
            System.out.println("entro");
            estadoEdicion = false;
            this.contenedorPremapa.remove(this.auxContenedorImagen);
            ContenedorNodo contenedorFijo = new ContenedorNodo
        (urlElemento, e.getX(), e.getY(), 100, 100);
            this.contenedorPremapa.add(contenedorFijo);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
