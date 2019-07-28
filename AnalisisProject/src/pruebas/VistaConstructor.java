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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    private final Thread hilo;
    private ContenedorImagen auxContenedorImagen;

    public static boolean estadoEdicionMar;
    public static String urlElemento;
    public static boolean estadoEdicion;
    public static JButton referenciaContinente;
    public static boolean continenteClickeado;

    private boolean ponerMar;

    static {
        urlElemento = "";
        estadoEdicion = false;
        referenciaContinente = new JButton();
        continenteClickeado = false;
        estadoEdicionMar = false;
    }

    public VistaConstructor() {
        iniciarComponentes();
        this.hilo = new Thread(this);
        this.contenedorDerecha.setVisible(false);
        this.ponerMar = false;
        //this.Start();
        caracteristicasAuxContenedorImagen();
        this.AñadirMenu();
    }

    private void caracteristicasAuxContenedorImagen() {
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

    private void AñadirMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("OPCIONES");
        JMenuItem item = new JMenuItem("Añadir Continente", new ImageIcon(getClass().getResource("../Imagenes/IconoContinente1.png")));
        JMenuItem item2 = new JMenuItem("Añadir Mar", new ImageIcon(getClass().getResource("../Imagenes/IconoMar.png")));
        barra.add(menu);
        menu.add(item);
        menu.add(item2);
        setJMenuBar(barra);
        item.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirContinenteAction(evt);
        });
        item2.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirMarAction(evt);
        });
    }

    private void AñadirContinenteAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(true);
    }

    private void AñadirMarAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(false);
        System.out.println("Entra");
        this.ponerMar = true;
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
                if (estadoEdicion) {
                    this.setCursor(Cursor.HAND_CURSOR);
                } else {
                    this.setCursor(Cursor.DEFAULT_CURSOR);
                }

                if (continenteClickeado) {
                    cambioContenedorIzq();
                }
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Todo es culpa de jorge!!!!");
            }

        }
    }

    /**
     * Este método se encarga de cambiar el panel que se aloja en la parte
     * izquierda del constructor del mapa version 1.0
     */
    public void cambioContenedorIzq() {
        ContenedorPreContinente aux = contenedorPremapa.islas.get(referenciaContinente);
        this.contenedorIzquierda.remove(this.contenedorPremapa);
        this.contenedorPremapa.setVisible(false);
        this.contenedorIzquierda.add(aux);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (estadoEdicion) {
            this.contenedorPremapa.ColocarContinente = true;
            this.contenedorPremapa.DibujarRectanguloVerdeRojo(e.getX() + 25, e.getY() + 25);
            this.contenedorPremapa.add(this.auxContenedorImagen);
            this.auxContenedorImagen.setUrl(urlElemento);
            this.auxContenedorImagen.mover(e.getX() + 25, e.getY() + 25);
            this.contenedorPremapa.repaint();
        }
    }

    /*
        Metodo encargado de insertar el continente al mapa y adicionarlos a la hashMap
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (estadoEdicion) {
            //estadoEdicion = false;
            if (this.contenedorPremapa.DibujarRectangulos(e.getX() + 25, e.getY() + 25)) {
                this.contenedorPremapa.remove(this.auxContenedorImagen);
                ContenedorNodo contenedorFijo = new ContenedorNodo(urlElemento, e.getX() + 25, e.getY() + 25, 100, 100);
                this.contenedorPremapa.islas.put(contenedorFijo, new ContenedorPreContinente(this.contenedorPremapa.getX(),
                        this.contenedorPremapa.getY(), this.contenedorPremapa.getWidth(), this.contenedorPremapa.getHeight()));
                this.contenedorPremapa.add(contenedorFijo);
                estadoEdicion = false;
            } else {
                JOptionPane.showMessageDialog(this, "LOS CONTINENTES NO SE PUEDEN SOLAPAR", "ERROR!!", JOptionPane.ERROR_MESSAGE, null);
            }

        }
        if (this.ponerMar) {
            this.contenedorPremapa.DibujarLineas(e.getX(), e.getY());
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
