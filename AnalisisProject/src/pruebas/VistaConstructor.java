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

    /**
     * toma el tamaño de la pantalla
     */
    private Dimension pantallaTamano;
    /**
     * contenedor que contiene la informacion de los continentes y graficamente
     * a los mismos
     */
    private ContenedorPremapa contenedorPremapa;
    /**
     * contenedor que contiene los mapas según la situación
     */
    private JPanel contenedorIzquierda;
    /**
     * contenedor que se encarga de alojar las herramientas
     */
    private JPanel contenedorDerecha;
    /**
     * clase abstracta que la cual nos ayuda a construir los contenedores
     * herramientas
     */
    private ContenedorTools contenedorTools;
    /**
     * Hilo que esta pendiente de los estados de edicion
     */
    private final Thread hilo;
    /**
     * Contenedor aux que nos ayuda con la construccion de los mapas
     */
    private ContenedorImagen auxContenedorImagen;
    /**
     * Variables estaticas para la construccion de mar
     *
     * @serialField estadoEdicionMar indica que habilitado la creacion de una
     * arista ,osea mar o mar profundo, ya sea el caso
     *
     */
    public static boolean estadoEdicionMar;
    /**
     * @serialField referencia a el primer contiennete clickeado
     */
    public static ContenedorNodo referenciaContinente1;
    /**
     * @serialField referencia el segundo continente clickeado
     */
    public static ContenedorNodo referenciaContinente2;
    /**
     * @serialField banderaDibujarMar bandera que indica que los continentes ya
     * fueron seleccionados, or tal motivo, se dibuja la arista, ademas se
     * deshabilita el modo edicion
     */
    public static boolean banderaDibujarMar;

    /**
     * url para el modo de agregar continente o islas al mapa según sea el caso
     */
    public static String urlElemento;
    /**
     * bandera que indica que se esta agregando un continente al mapa
     */
    public static boolean estadoEdicion;
    /**
     * referencia hacia el boton clickeado fuera de cualquier modo de edicion
     */
    public static ContenedorNodo referenciaContinente;
    /**
     * bandera que indica que el boton fue clickeado fuera de cualquier modo de
     * edicion
     */
    public static boolean continenteClickeado;
    /**
     * Bandera creada por Jorge para indicar que en el constructor de islas se
     * pulso el boton mundo para retornar al panel de añadir continentes
     */
    public static boolean mundoClickeado;
    /**
     * Bandera creada por Jorge para indicar que se ha entrado en modo de
     * edicion de islas
     */
    public static boolean estadoEdicionIsla;

    private JMenuBar barraMenu;
    private JMenu menuAñadir;
    private JMenu menuOpciones;
    private JMenuItem itemGuardar;
    private JMenuItem itemEditar;
    private JMenuItem itemAñadirContinente;
    private JMenuItem itemAñadirIsla;
    private JMenuItem itemAñadirMar;
    private JMenuItem itemSimular;

    static {
        urlElemento = "";
        estadoEdicion = false;
        referenciaContinente = null;
        continenteClickeado = false;
        estadoEdicionMar = false;
        referenciaContinente1 = null;
        referenciaContinente2 = null;
        banderaDibujarMar = false;
        mundoClickeado = false;
    }

    public VistaConstructor() {
        iniciarComponentes();
        this.hilo = new Thread(this);
        this.contenedorDerecha.setVisible(false);
        caracteristicasAuxContenedorImagen();
        this.CrearMenu();
        this.Start();
    }

    private void caracteristicasAuxContenedorImagen() {
        this.auxContenedorImagen = new ContenedorImagen("", 0, 0, 150, 150);
        this.auxContenedorImagen.eliminarEventoClick();
    }

    private void agregarInterfacesMapa() {
        this.contenedorPremapa.addMouseListener(this);
        this.contenedorPremapa.addMouseMotionListener(this);
    }

    private void Start() {
        this.hilo.start();
    }

    private void CrearMenu() {
        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);
        this.AñadirAlMenu(this.menuAñadir = new JMenu("Añadir"));
        this.AñadirAlMenu(this.menuOpciones = new JMenu("Opciones"));
        this.itemAñadirContinente = new JMenuItem("Añadir Continente", new ImageIcon(getClass().getResource("../Imagenes/IconoContinente5.png")));
        this.itemAñadirIsla = new JMenuItem("Añadir Isla", new ImageIcon(getClass().getResource("../Imagenes/IconoIsla.png")));
        this.AñadirItem(this.menuAñadir, this.itemAñadirContinente);
        this.AñadirItem(this.menuAñadir, this.itemAñadirIsla);
        this.AñadirItem(this.menuAñadir, this.itemAñadirMar = new JMenuItem("Añadir Mar", new ImageIcon(getClass().getResource("../Imagenes/IconoMar.png"))));
        this.AñadirItem(this.menuOpciones, this.itemGuardar = new JMenuItem("Guardar", new ImageIcon(getClass().getResource("../Imagenes/IconoGuardar.png"))));
        this.AñadirItem(this.menuOpciones, this.itemEditar = new JMenuItem("Editar", new ImageIcon(getClass().getResource("../Imagenes/IconoEditar.png"))));
        this.AñadirItem(this.menuOpciones, this.itemSimular = new JMenuItem("Run", new ImageIcon(getClass().getResource("../Imagenes/IconoSimular.png"))));
        this.CrearAccionesMenu();
    }

    private void CrearAccionesMenu() {
        this.itemAñadirContinente.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirContinenteAction(evt);
        });
        this.itemAñadirMar.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirMarAction(evt);
        });
        this.itemAñadirIsla.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirIslaAction(evt);
        });
    }

    public void AñadirAlMenu(JMenu menu) {
        this.barraMenu.add(menu);
    }

    public void AñadirItem(JMenu menu, JMenuItem item) {
        menu.add(item);
    }

    private void AñadirContinenteAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(true);
    }

    private void AñadirMarAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(false);
        estadoEdicionMar = true;
    }

    private void AñadirIslaAction(java.awt.event.ActionEvent evt) {
        estadoEdicionIsla = true;
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
                this.contenedorPremapa.getWidth(), 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = this.contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
    }

    public static void main(String x[]) {
        VistaConstructor v = new VistaConstructor();
        v.setVisible(true);
    }

    private void CambiarItemsMenuIsla() {

        this.menuAñadir.remove(this.itemAñadirContinente);
        this.menuAñadir.add(this.itemAñadirIsla);
    }

    private void CambiarItemsMenuContinente() {
        this.AñadirItem(this.menuAñadir, this.itemAñadirContinente);
        this.menuAñadir.remove(this.itemAñadirIsla);
    }

    private void CambiarPanelHerramientasIsla() {
        this.getContentPane().remove(this.contenedorDerecha);
        this.contenedorTools = new ContenedorHerramientasIsla(
                this.contenedorPremapa.getWidth(), 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
        this.getContentPane().repaint();
    }

    private void CambiarPanelHerramientasContinente() {
        this.getContentPane().remove(this.contenedorDerecha);
        this.contenedorTools = new ContenedorHerramientasContinentes(
                this.contenedorPremapa.getWidth(), 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
        this.getContentPane().repaint();
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
                /**
                 * Jorge no toque esto remk metodos abajo muy importantes
                 * calmese!!!!!!!!!!!!!!!!
                 */
                if (continenteClickeado) {
                    continenteClickeado = false;
                    cambioContenedorIzq();
                   // CambiarItemsMenuIsla();
                    CambiarPanelHerramientasIsla();
                } else {
                    CambiarItemsMenuContinente();
                }
                if (mundoClickeado) {
                    this.cambiarContenedorIzq();
                    //CambiarItemsMenuContinente();
                    CambiarPanelHerramientasContinente();
                    mundoClickeado = false;
                }
                if (banderaDibujarMar) {
                    this.contenedorPremapa.marProfundo.add(new Arista(referenciaContinente1,
                            referenciaContinente2));
                    Thread.sleep(200);
                    referenciaContinente1.desDibujarBorde();
                    referenciaContinente2.desDibujarBorde();
                    banderaDibujarMar = false;
                    estadoEdicionMar = false;
                    referenciaContinente1 = null;
                    referenciaContinente2 = null;
                }
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
        this.contenedorPremapa.setVisible(false);
        this.getContentPane().remove(this.contenedorIzquierda);
        this.contenedorIzquierda = null;
        ContenedorPreContinente aux = contenedorPremapa.islas.get(referenciaContinente);
        this.contenedorIzquierda = aux;
        this.getContentPane().add(this.contenedorIzquierda);
        this.CambiarItemsMenuIsla();
    }

    public void Basura() {

    }

    /**
     * Metodo que cambia el panel izquierdo a partir de la accion generada en el
     * panel de construccion de islas al momento de pulsar el boton mundo
     */
    public void cambiarContenedorIzq() {
        this.contenedorPremapa.setVisible(true);
        this.getContentPane().remove(this.contenedorIzquierda);
        this.contenedorIzquierda = null;
        this.contenedorIzquierda = contenedorPremapa;
        this.getContentPane().add(this.contenedorIzquierda);
        this.CambiarItemsMenuIsla();
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
        if (estadoEdicionIsla) {
            ContenedorPreContinente aux = contenedorPremapa.islas.get(referenciaContinente);
            aux.setColocarIsla(true);
            aux.DibujarRectanguloVerdeRojo(e.getX() + 25, e.getY() + 25);
            aux.add(this.auxContenedorImagen);
            this.auxContenedorImagen.setUrl(urlElemento);
            this.auxContenedorImagen.mover(e.getX() + 25, e.getY() + 25);
            aux.repaint();
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
                ContenedorNodo contenedorFijo = new ContenedorNodo(urlElemento, e.getX() + 25, e.getY() + 25, 150, 150);
                this.contenedorPremapa.islas.put(contenedorFijo, new ContenedorPreContinente(this.contenedorPremapa.getX(),
                        this.contenedorPremapa.getY(), this.contenedorPremapa.getWidth(), this.contenedorPremapa.getHeight()));
                this.contenedorPremapa.add(contenedorFijo);
                estadoEdicion = false;
            } else {
                JOptionPane.showMessageDialog(this, "LOS CONTINENTES NO SE PUEDEN SOLAPAR", "ERROR!!", JOptionPane.ERROR_MESSAGE, null);
            }

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
