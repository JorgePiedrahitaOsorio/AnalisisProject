/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import Clases.Mundo;
import Interfaces.Simulación;
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
import static Interfaces.Inicio.opcionSimulacion;

/**
 *
 * @author Thebest (William)
 * @author JORGE OSORIO
 */
public class VistaConstructor extends javax.swing.JFrame implements
        MouseMotionListener, Runnable, MouseListener {

    private boolean detener;
    private Dimension pantallaTamano;
    private ContenedorPremapa contenedorPremapa;
    private JPanel contenedorIzquierda;
    private JPanel contenedorDerecha;
    private ContenedorTools contenedorTools;
    private final Thread hilo;
    private ContenedorImagen auxContenedorImagen;
    private ContenedorPreContinente contenedorPreContinente;
    private JMenuBar barraMenu;
    private JMenu menuAñadir;
    private JMenu menuOpciones;
    private JMenuItem itemGuardar;
    private JMenuItem itemAñadirContinente;
    private JMenuItem itemAñadirIsla;
    private JMenuItem itemAñadirMar;
    private JMenuItem itemSimular;
    private JMenuItem itemAñadirMarIsla;
    private JMenuItem itemEliminar;
    private JMenuItem itemMover;
    private boolean banderaItem;
    private Mundo mundo;

    public static boolean estadoEdicionMar;
    public static ContenedorNodo referenciaContinente1;
    public static ContenedorNodo referenciaContinente2;
    public static boolean banderaDibujarMar;
    public static String urlElemento;
    public static boolean estadoEdicion;
    public static ContenedorNodo referenciaContinente;
    public static boolean continenteClickeado;
    public static ContenedorNodoIsla referenciaIsla;
    public static boolean mundoClickeado;
    public static boolean estadoEdicionIsla;
    public static boolean estadoParametrizacionIsla;
    public static boolean estadoEdicionMarIsla;
    public static ContenedorNodoIsla referenciaContinenteIsla1;
    public static ContenedorNodoIsla referenciaContinenteIsla2;
    public static boolean banderaDibujarMarIsla;
    public static boolean banderaGuardar;
    public static boolean modoMoverContinente;
    public static boolean modoOn;
    public static ContenedorNodo referenciaMoverContinente;
    public static boolean modoMoverIsla;
    public static boolean modoOnIsla;
    public static ContenedorNodoIsla referenciaMoverIsla;
    public static boolean eliminarContinente;
    public static ContenedorNodo referenciaContinenteEliminar;
    public static boolean eliminarIsla;
    public static ContenedorNodoIsla referenciaIslaEliminar;
    public static ParametrosIsla pIslaReferencia;

    static {
        urlElemento = "";
        estadoEdicion = false;
        estadoEdicionIsla = false;
        estadoParametrizacionIsla = false;
        referenciaContinente = null;
        pIslaReferencia = new ParametrosIsla();
        continenteClickeado = false;
        estadoEdicionMar = false;
        referenciaContinente1 = null;
        referenciaContinente2 = null;
        referenciaIsla = null;
        banderaDibujarMar = false;
        mundoClickeado = false;
        banderaDibujarMarIsla = false;
        estadoEdicionMarIsla = false;
        referenciaContinenteIsla1 = null;
        referenciaContinenteIsla2 = null;
        banderaGuardar = false;
        referenciaMoverContinente = null;
        modoMoverContinente = false;
        modoOn = false;
        referenciaMoverIsla = null;
        modoMoverIsla = false;
        modoOnIsla = false;
        eliminarContinente = false;
        eliminarIsla = false;
        referenciaContinenteEliminar = null;
        referenciaIslaEliminar = null;
    }

    /**
     * Constructor por defecto de VistaConstructor. Se instancian los metodos
     * principales para generar exitosamente la interfaz requerida para generar
     * un modo de edicion para el usuario, ademas de iniciarlizar algunas
     * variables privadas de la clasey el hilo principal.
     */
    public VistaConstructor() {
        iniciarComponentes();
        this.hilo = new Thread(this);
        this.contenedorDerecha.setVisible(false);
        this.banderaItem = false;
        this.detener = true;
        caracteristicasAuxContenedorImagen();
        this.CrearMenu();
        this.Start();
    }

    /**
     * Constructor parametrizado de la clase VistaConstructor. En este se
     * utilizan metodo para cargar las listas de paneles, islas y mares, a
     * partir del metodo CargarPremapa. Ademas de incializar el hilo principal.
     *
     * @param mundo variable que sera asiganada al atributo propio de la clase
     * el cual contiene las listas con continentes, islas y mares
     */
    public VistaConstructor(Mundo mundo) {
        iniciarComponentes();
        this.hilo = new Thread(this);
        this.contenedorDerecha.setVisible(false);
        this.banderaItem = false;
        this.detener = true;
        caracteristicasAuxContenedorImagen();
        this.CrearMenu();
        this.mundo = mundo;
        this.Start();
        CargarPremapa();

    }

    /**
     * Se encaraga de llenar las listas de continentes que se encuentran en
     * contenedorPremapa, este ultimo es un objeto de tipo Panel donde se pintan
     * los distintos objetos de tipo continente y mar
     */
    private void CargarPremapa() {
        this.contenedorPremapa.obtenerContinentes(mundo.getNodos(), this, this);
        this.contenedorPremapa.obtenerAristas(mundo.getAristas());
    }

    /**
     * Metodo que se encarga de inicializar la variable de clase
     * axuContenedorImagen, con sus parametros de posicion y tamaño, ademas
     * elimina el evento click de este, para evitar que al momento de que un
     * continente sea colocado su vento del click lleve al usuario a ingresar a
     * este continente
     */
    private void caracteristicasAuxContenedorImagen() {
        this.auxContenedorImagen = new ContenedorImagen("", 0, 0, 150, 150);
        this.auxContenedorImagen.eliminarEventoClick();
    }

    /**
     * Se añaden las propiedades MouseListener y MouseMotionListener al panel
     * encargado de pintar los continentes y los mares profundos
     */
    private void agregarInterfacesMapa() {
        this.contenedorPremapa.addMouseListener(this);
        this.contenedorPremapa.addMouseMotionListener(this);
    }

    /**
     * Metodo encargado de iniciar el hilo. Este metodo es directamente llamado
     * desde el constructor, para que el hilo sea inciado al momento de crear la
     * clase
     */
    private void Start() {
        this.hilo.start();
    }

    /**
     * Este metodo incializa todas las variables que corresponden al menu
     * superior de la apliacion, en este se asignan valores de texto y rutas de
     * imagenes para que cada item de dicho menu cuente con su icono de
     * identificacion. En este tambien es invocado el metodo encargado de crear
     * las acciones de dichos botones.
     */
    private void CrearMenu() {
        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);
        this.AñadirAlMenu(this.menuAñadir = new JMenu("Añadir"));
        this.AñadirAlMenu(this.menuOpciones = new JMenu("Opciones"));
        this.itemAñadirContinente = new JMenuItem("Añadir Continente", new ImageIcon(getClass().getResource("../Imagenes/IconoContinente5.png")));
        this.itemAñadirIsla = new JMenuItem("Añadir Isla", new ImageIcon(getClass().getResource("../Imagenes/IconoIsla.png")));
        this.itemAñadirMarIsla = new JMenuItem("Añadir Mar", new ImageIcon(getClass().getResource("../Imagenes/IconoMar.png")));
        this.AñadirItem(this.menuAñadir, this.itemAñadirContinente);
        this.AñadirItem(this.menuAñadir, this.itemAñadirMar = new JMenuItem("Añadir Mar Profundo", new ImageIcon(getClass().getResource("../Imagenes/IconoMar.png"))));
        this.AñadirItem(this.menuOpciones, this.itemGuardar = new JMenuItem("Guardar", new ImageIcon(getClass().getResource("../Imagenes/IconoGuardar.png"))));
        this.AñadirItem(this.menuOpciones, this.itemSimular = new JMenuItem("Run", new ImageIcon(getClass().getResource("../Imagenes/IconoSimular.png"))));
        this.itemEliminar = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource("../Imagenes/iconoEliminar.png")));
        this.itemMover = new JMenuItem("Mover", new ImageIcon(getClass().getResource("../Imagenes/iconoMover.png")));
        this.CrearAccionesMenu();
    }

    /**
     * Este metodo añade a todos los items existentes en el estado de edicion
     * una actionListener, este a su vez asocia dicho accion listener a un
     * metodo alojado dentro de la clase
     */
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
        this.itemAñadirMarIsla.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirMarIslaAction(evt);
        });
        this.itemSimular.addActionListener((java.awt.event.ActionEvent evt) -> {
            SimularAction(evt);
        });
        this.itemGuardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            GuardarAction(evt);
        });
        this.itemEliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            EliminarAction(evt);
        });
        this.itemMover.addActionListener((java.awt.event.ActionEvent evt) -> {
            EditarAction(evt);
        });
    }

    /**
     * Este metodo añade a la barra pricipal del menu todo menu que entre como
     * parametro, de este modo se lleva un orden en el modo de adicion de menu a
     * la barra
     *
     * @param menu es un objeto de JMenu que debe estar previamente creado
     * dentro de la clase, y que sera añadido a la barra menu de dicha clase
     */
    public void AñadirAlMenu(JMenu menu) {
        this.barraMenu.add(menu);
    }

    /**
     * Este metodo agrega a un menu dado un item
     *
     * @param menu el menu al cual se le piensa añadir un nuevo item
     * @param item sera añadido al menu que entra como parametro junto este
     */
    public void AñadirItem(JMenu menu, JMenuItem item) {
        menu.add(item);
    }

    /**
     * Metodo invocado por el evento que se genera al pulsar el boton eliminar,
     * ya sea eliminar continente o eliminar isla, su proposito es cambiar el
     * estado de las varibles encargadas de llevar el control de que tipo de
     * objeto sera eliminado
     *
     * @param evt este es generado por una accion del boton asociado a este
     * metodo
     */
    private void EliminarAction(java.awt.event.ActionEvent evt) {
        //Si la bandera item se encuentra en estado false, estamos en estado de eliminar o mover Continente
        if (banderaItem) {
            /**
             * Willi implementa todo codigo aca
             */
            eliminarIsla = true;
        } else {
            eliminarContinente = true;
        }
        //En el hilo esta el metodo cambiarItemAñadirEliminar() para poder realizar los cambios de txt de los botones, y la
        //adicion o eliminacion de estos si los hashmaps estan vacion

    }

    /**
     * Metodo invocado por el evento que se genera al pulsar el boton
     * Editar(Isla/Continente),su proposito es cambiar el estado de las varibles
     * encargadas de llevar el control de que tipo de objeto sera el que cambie
     * de posicion a partir del movimiento del mouse
     *
     * @param evt este es generado por una accion del boton asociado a este
     * metodo
     */
    private void EditarAction(java.awt.event.ActionEvent evt) {
        //Si la bandera item se encuentra en estado false, estamos en estado de eliminar o mover Continente
        if (banderaItem) {
            /**
             * Willi implementa todo codigo aca
             */
            modoMoverIsla = true;
        } else {
            modoMoverContinente = true;
        }
        //En el hilo esta el metodo cambiarItemAñadirEliminar() para poder realizar los cambios de txt de los botones, y la
        //adicion o eliminacion de estos si los hashmaps estan vacion
    }

    /**
     * Este metodo es el metodo asociado al action click del boton Añadir
     * continente e invoca el metodo que se encarga de cambiar el panel derecho
     *
     * @param evt evento generado por pulsar el boton Añadir continente
     */
    private void AñadirContinenteAction(java.awt.event.ActionEvent evt) {
        this.CambiarPanelHerramientasContinente();
    }

    /**
     * Este metodo se encarga de cambiar el estado de la bandera que indica que
     * se esta editando un mar, ademas de ocultar el panel de creacion de
     * continentes
     *
     * @param evt evento generado por pulsar el boron Añadir Mar Profundo
     */
    private void AñadirMarAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(false);
        estadoEdicionMar = true;
    }

    /**
     * Este metodo se encarga de instanciar la clase Serializador y almacenar la
     * informacion que se lleva hasta el momento de toda la edicion del mapa
     *
     * @param evt evento generado por pulsar el boron Añadir Guardar
     */
    private void GuardarAction(java.awt.event.ActionEvent evt) {
        /*
        Estas dos lineas siguientes son solo para pruebas de que si se puede deserializar el objeto
         */
        Serializador serializador = new Serializador();
        serializador.ReadArchivo("../mapa1.txt");
//        Serializar();
    }

    /**
     * Este metodo se encarga de invocar el metodo que se encarga de cambiar la
     * informacion del panel derecho, por la informacion necesaria para poder
     * visualizar la diversidad de islas que pueden ser agregadas a la
     * simulacion
     *
     * @param evt evento generado por pulsar el boton Añadir Isla
     */
    private void AñadirIslaAction(java.awt.event.ActionEvent evt) {
        CambiarPanelHerramientasIsla();
    }

    /**
     * Este metodo se encarga de cambiar el estado de la bandera que indica que
     * se esta editando un mar, ademas de ocultar el panel de creacion de islas
     *
     * @param evt evento generado por pulsar el boton del menu añadir Isla
     */
    private void AñadirMarIslaAction(java.awt.event.ActionEvent evt) {
        this.contenedorDerecha.setVisible(false);
        estadoEdicionMarIsla = true;
    }

    /**
     * Genera una instancia de la clase VistaSeleccionModoSimulacion, esta
     * contiene la variedad de opciones existentes con las que se puede ejecutar
     * el modo de simulacion
     *
     * @param evt evento generado por pulsar el boton del menu run
     */
    private void SimularAction(java.awt.event.ActionEvent evt) {
        VistaSeleccionModoSimulacion vSeleccion = new VistaSeleccionModoSimulacion();
        vSeleccion.setVisible(true);

    }

    /**
     * Este metodo se encarga de invocar los metodos de contenedorPremapa, estos
     * recopilan la informacion de las islas y de los mares de todos los
     * continentes, y generan una nueva estructura de tipo mundo que los
     * contiene
     *
     * @return un mundo con toda la informacion que se genero durante el modo
     * edicion
     */
    private Mundo Serializar() {
        Mundo mun = new Mundo();
        mun.setNodos(contenedorPremapa.getContinentes());
        mun.setAristas(contenedorPremapa.getMares());
        Serializador serializador = new Serializador();
        serializador.WriteJSON(mun);
        return mun;
    }

    /**
     * Este metodo se encargar de terminar el ciclo de vida de esta clase,
     * ademas de instanciar la ventana que procede luego de terminar el estado
     * de edicion, y por ultimo de cerrar esta ventana, para liberar espacio de
     * memoria
     */
    public void Simular() {
        Simulación simulacion = new Simulación(Serializar(), opcionSimulacion);
        simulacion.setVisible(true);
        this.detener = false;
        this.dispose();
    }

    /**
     * Este metodo calcula el tamaño de la pantalla del dispositivo en el cual
     * esta siendo corrida la apliacion
     *
     * @return la dimension de la pantalla
     */
    private Dimension tamañoPantalla() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Metodo que asigna el titulo y la accion que debe realizar la ventana al
     * momento de cerrarse
     */
    private void ConfiguracionesIniciales() {
        this.setTitle("MODO EDICION");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodo que invoca al metodo tamañoPantalla para retornar el maximo tamaño
     * de la ventana, y asginarselo como medidas de tamaño a esta ventana
     */
    private void iniciarComponentes() {
        pantallaTamano = tamañoPantalla();
        caracteristicasVisuales();
        agregarInterfacesMapa();
    }

    /**
     * Este metodo es el encargado de invocar una variedad de metodos, todos con
     * la finalidad de contribuir al aspecto y las restricciones de la ventana
     */
    private void caracteristicasVisuales() {
        AmpliarTamañoPantalla();
        aspecto();
        ConfiguracionesIniciales();
        agregarLayout();
        agregarPaneles();
    }

    /**
     * Este metodo agrega las funcionalidades necesarias para crear el ventana
     * en la posicion mas a la izquierda y mas arriba, es decir, la posicion
     * 0,0, y agrega la funcionlidad que evita que esta ventana cambie de tamaño
     */
    private void AmpliarTamañoPantalla() {
        this.setBounds(0, 0, pantallaTamano.width, pantallaTamano.height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }

    /**
     * Este metodo agrega un icono a la aplicacion por medio de una ruta, ademas
     * de agreagar el color por defecto de esta clase
     */
    private void aspecto() {
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Icono.png")).getImage());
    }

    /**
     * Agrega como valor null al layout de esta clase
     */
    private void agregarLayout() {
        this.getContentPane().setLayout(null);
    }

    /**
     * Este metodo instancia y agrega los paneneles que estaran presentes
     * durante el modo de edicion, el panel derecho e izquierdo. Estos dos
     * presentaran diferentes cambios dependendiendo de cual sea el objeto al
     * que quiera acceder, si quiero acceder a un continente o a una vista
     * general del mapa
     */
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

    /**
     * El metodo main es el metodo encargado de generar una nueva instancia de
     * esta clase, ademas de hacer visible dicha clase
     *
     * @param x
     */
    public static void main(String x[]) {
        VistaConstructor v = new VistaConstructor();
        v.setVisible(true);
    }

    /**
     * Metodo encargado de itercambiar los items del menu superior de la
     * pantalla, estos items son intercambiados de items de continente a items
     * de isla, indicando de esta manera que se ha generado un cambio en la
     * interfaz de simulacion, y que ya no se encuentra en el modo de crear
     * continentes
     */
    private void CambiarItemsMenuIsla() {
        this.menuAñadir.remove(this.itemAñadirContinente);
        this.menuAñadir.remove(this.itemAñadirMar);
        this.menuAñadir.add(this.itemAñadirIsla);
        this.menuAñadir.add(this.itemAñadirMarIsla);

    }

    /**
     * Metodo en el cual se cambian los items de eliminar o mover
     * (Isla/Continente), dependiendo de los valores que tomen las banderas
     * durante la ejecucion de la edicion
     */
    private void CambiarItemsAñadirEliminar() {
        if (contenedorPreContinente != null) {
            if (banderaItem) {
                if (this.contenedorPreContinente.islas.isEmpty()) {
                    this.menuOpciones.remove(this.itemEliminar);
                    this.menuOpciones.remove(this.itemMover);
                } else {
                    this.itemEliminar.setText("Eliminar Isla");
                    this.menuOpciones.add(this.itemEliminar);
                    this.itemMover.setText("Mover Isla");
                    this.menuOpciones.add(this.itemMover);
                }
            }
        }
        if (!banderaItem) {
            if (this.contenedorPremapa.islas.isEmpty()) {
                this.menuOpciones.remove(this.itemEliminar);
                this.menuOpciones.remove(this.itemMover);
            } else {
                this.itemEliminar.setText("Eliminar Continente");
                this.menuOpciones.add(this.itemEliminar);
                this.itemMover.setText("Mover Continente");
                this.menuOpciones.add(this.itemMover);
            }
        }

    }

    /**
     * Metodo encargado de itercambiar los items del menu superior de la
     * pantalla, estos items son intercambiados de items de isla a items de
     * continente, indicando de esta manera que se ha generado un cambio en la
     * interfaz de simulacion, y que ya no se encuentra en el modo de crear
     * islas
     */
    private void CambiarItemsMenuContinente() {
        this.AñadirItem(this.menuAñadir, this.itemAñadirContinente);
        this.AñadirItem(menuAñadir, this.itemAñadirMar);
        this.menuAñadir.remove(this.itemAñadirIsla);
        this.menuAñadir.remove(this.itemAñadirMarIsla);

    }

    /**
     * Este metodo cambia la vista que se presenta en la parte derecha de la
     * pantalla, inicialmente antes de este metodo ser invocado se cuenta con un
     * panel de herramientas de creacion de islas, despues de ser ejecutado este
     * metodo cambia los valores de dicho panel por valores que permiten la
     * construccion de continentes
     */
    private void CambiarPanelHerramientasContinente() {
        this.getContentPane().remove(this.contenedorDerecha);
        this.contenedorDerecha = null;
        this.contenedorTools = new ContenedorHerramientasContinentes(
                this.contenedorPremapa.getWidth(), 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
        this.contenedorDerecha.setVisible(true);
        this.getContentPane().repaint();
    }

    /**
     * Metodo que maneja el hilo, el cual es ejecutado durante la fase de
     * edicion y es destruido cuando se cambia de modo de edicion a modo de
     * simulacion. En este se encuentran gran cantidad de metodos y validaciones
     * de las banderas estaticas que son creadas al inicio de la clase. Al
     * existir un cambio en alguna variable estatica que se encuentre validada
     * dentro del metodo run del hilo este se encarga de invocar las funciones
     * contenidas en el, o de otro modo enciende o apaga una bandera, que
     * permite el correcto funcionamiento del modo edicion
     */
    @Override
    public void run() {
        while (detener) {
            try {
                CambiarItemsAñadirEliminar();
                if (estadoEdicion || estadoEdicionIsla) {
                    this.setCursor(Cursor.HAND_CURSOR);
                } else {
                    this.setCursor(Cursor.DEFAULT_CURSOR);
                }

                if (this.contenedorDerecha != null) {
                    this.contenedorDerecha.repaint();
                }
                if (this.contenedorIzquierda != null) {
                    this.contenedorIzquierda.repaint();
                }

                if (this.contenedorPreContinente != null) {
                    this.contenedorPreContinente.repaint();
                }
                /**
                 * Jorge no toque esto remk metodos abajo muy importantes
                 * calmese!!!!!!!!!!!!!!!!
                 */
                if (continenteClickeado) {
                    this.contenedorDerecha.setVisible(false);
                    continenteClickeado = false;
                    this.cambioContenedorIzq();
                    CambiarItemsMenuIsla();
                    this.banderaItem = true;
                }

                if (mundoClickeado) {
                    this.cambiarContenedorIzq();
                    this.CambiarPanelHerramientasContinente();
                    CambiarItemsMenuContinente();
                    estadoParametrizacionIsla = false;
                    mundoClickeado = false;
                    this.banderaItem = false;
                }
                if (banderaGuardar) {
                    this.contenedorPreContinente.CambiarParametrizacion(referenciaIsla, pIslaReferencia);
                }
                if (estadoParametrizacionIsla) {
                    pIslaReferencia = this.contenedorPreContinente.islas.get(referenciaIsla);
                }
                if (banderaDibujarMar) {
                    if (referenciaContinente2 != null) {
                        Arista aristaAux = new Arista(referenciaContinente1, referenciaContinente2);
                        aristaAux.setPeligrosidad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese peligrosidad")));
                        this.contenedorPremapa.marProfundo.add(aristaAux);
                    }
                    Thread.sleep(200);
                    referenciaContinente1.desDibujarBorde();
                    referenciaContinente2.desDibujarBorde();
                    banderaDibujarMar = false;
                    estadoEdicionMar = false;
                    referenciaContinente1 = null;
                    referenciaContinente2 = null;
                }

                if (banderaDibujarMarIsla) {
                    if (referenciaContinenteIsla2 != null) {
                        AristaIsla aristaAux = new AristaIsla(referenciaContinenteIsla1, referenciaContinenteIsla2);
                        aristaAux.setPeligrosidad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese peligrosidad")));
                        this.contenedorPreContinente.marProfundo.add(aristaAux);
                    }
                    Thread.sleep(200);
                    referenciaContinenteIsla1.desDibujarBorde();
                    referenciaContinenteIsla2.desDibujarBorde();
                    banderaDibujarMarIsla = false;
                    estadoEdicionMarIsla = false;
                    referenciaContinenteIsla1 = null;
                    referenciaContinenteIsla2 = null;
                }

                if (eliminarContinente) {
                    if (referenciaContinenteEliminar != null) {
                        this.contenedorPremapa.eliminarArista(referenciaContinenteEliminar);
                        this.contenedorPremapa.eliminarContinente(referenciaContinenteEliminar);
                        this.contenedorPremapa.eliminarRectanguloColision(referenciaContinenteEliminar);
                        this.contenedorPremapa.remove(referenciaContinenteEliminar);
                        eliminarContinente = false;
                        referenciaContinenteEliminar = null;
                        this.contenedorPremapa.repaint();
                    }
                }

                if (eliminarIsla) {
                    if (referenciaIslaEliminar != null) {
                        this.contenedorPreContinente.eliminarArista(referenciaIslaEliminar);
                        this.contenedorPreContinente.eliminarContinente(referenciaIslaEliminar);
                        this.contenedorPreContinente.eliminarRectanguloColision(referenciaIslaEliminar);
                        this.contenedorPreContinente.remove(referenciaIslaEliminar);
                        eliminarIsla = false;
                        referenciaIslaEliminar = null;
                        this.contenedorPreContinente.repaint();
                    }
                }
                if (opcionSimulacion != 0) {
                    Simular();
                }

            } catch (InterruptedException ex) {
                System.out.println("Todo es culpa de jorge!!!!");
            }

        }
    }

    /**
     * Este método se encarga de cambiar el panel que se aloja en la parte
     * izquierda del constructor del mapa, esta accion se ve reflejada en el
     * cambio que existe entre la visualizacion de todos los continentes creados
     * y la insercion dentro de un continente
     */
    public void cambioContenedorIzq() {
        this.getContentPane().remove(this.contenedorIzquierda);
        this.contenedorIzquierda = null;
        this.contenedorPreContinente = contenedorPremapa.islas.get(referenciaContinente);
        this.contenedorIzquierda = this.contenedorPreContinente;
        this.getContentPane().add(this.contenedorIzquierda);
        this.CambiarItemsMenuIsla();
        this.contenedorPreContinente.setVisible(true);
    }

    /**
     * Metodo que cambia el panel derecho a partir de la accion generada de
     * entrar a un continente, esto con la finalidad de presentar al usuario un
     * panel con la distintas opciones de islas con las que cuenta para realizar
     * la simulacion
     */
    private void CambiarPanelHerramientasIsla() {
        this.getContentPane().remove(this.contenedorDerecha);
        this.contenedorDerecha = null;
        this.contenedorTools = new ContenedorHerramientasIsla(
                this.contenedorPremapa.getWidth(), 0, 200, this.pantallaTamano.height);
        this.contenedorDerecha = contenedorTools;
        this.getContentPane().add(this.contenedorDerecha);
        this.contenedorDerecha.setVisible(true);
        this.getContentPane().repaint();
    }

    /**
     * Metodo que cambia el panel izquierdo a partir de la accion generada en el
     * panel de construccion de islas al momento de pulsar el boton mundo
     */
    public void cambiarContenedorIzq() {
        this.getContentPane().remove(this.contenedorIzquierda);
        this.contenedorIzquierda = null;
        this.contenedorIzquierda = contenedorPremapa;
        this.getContentPane().add(this.contenedorIzquierda);
        this.CambiarItemsMenuIsla();
        this.contenedorPremapa.setVisible(true);
    }

    /**
     * El metodo mouseMoved propio de la libreria MouseMotionListener, realiza
     * la funcion de movimiento del contenedor isla o continete que sera
     * agregado al panel de edicion, ademas de invocar los metodos encargador de
     * validar que las posiciones que estan siendo utilizadas para agregar el
     * contenedor no estan siendo utilizadas por otro contenedor
     *
     * @param e generado por el evento de movimiento del mouse
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        if (estadoEdicion) {
            this.contenedorPremapa.ColocarContinente = true;
            this.contenedorPremapa.DibujarRectanguloVerdeRojo(e.getX() + 25, e.getY() + 25);
            this.contenedorPremapa.add(this.auxContenedorImagen);
            this.auxContenedorImagen.setUrl(urlElemento);
            this.auxContenedorImagen.mover(e.getX() + 25, e.getY() + 25);
            this.contenedorPremapa.repaint();
        } else if (estadoEdicionIsla) {
            this.contenedorPreContinente.setColocarIsla(true);
            this.contenedorPreContinente.DibujarRectanguloVerdeRojo(e.getX() + 25, e.getY() + 25);
            this.contenedorPreContinente.add(this.auxContenedorImagen);
            this.auxContenedorImagen.setUrl(urlElemento);
            this.auxContenedorImagen.mover(e.getX() + 25, e.getY() + 25);
            this.contenedorPreContinente.repaint();
        } else if (modoMoverContinente && modoOn) {
            referenciaMoverContinente.setBounds(e.getX() + 25, e.getY() + 25,
                    referenciaMoverContinente.getWidth(), referenciaMoverContinente.getHeight());
            this.contenedorPremapa.repaint();
        } else if (modoMoverIsla && modoOnIsla) {
            referenciaMoverIsla.mover(e.getX() + 25, e.getY() + 25);
            this.contenedorPreContinente.repaint();
        }
    }

    /**
     * El metodo mouseClicked propio de la libreria MouseListener , realiza la
     * funcion del agreado de los paneles que contienen el continente o la isla
     * que esta siendo creada y que tomara su pocision en la misma donde el
     * evento de mouseClicked sea invocado. Ademas de invocar metodos de
     * validacion de posiciones, esto con el fin de evitar el solapamiento entre
     * los objetos de la simulacion. Si dado el caso un objeto es clickeado en
     * una posicion en la que previamente se encuentra otro objeto el sistema no
     * realiza ninguna accion de agregado y notifica al usuario de este error
     *
     * @param e generado por un evento clck del mouse
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (estadoEdicion) {
            if (this.contenedorPremapa.DibujarRectangulos(e.getX() + 25, e.getY() + 25)) {
                this.contenedorPremapa.remove(this.auxContenedorImagen);
                ContenedorNodo contenedorFijo = new ContenedorNodo(urlElemento, e.getX() + 25, e.getY() + 25, 150, 150);
                this.contenedorPremapa.islas.put(contenedorFijo, new ContenedorPreContinente(this.contenedorPremapa.getX(),
                        this.contenedorPremapa.getY(), this.contenedorPremapa.getWidth(), this.contenedorPremapa.getHeight(), this, this));
                this.contenedorPremapa.add(contenedorFijo);
                this.contenedorPremapa.repaint();
                this.ApagarBanderas();
            } else {
                JOptionPane.showMessageDialog(this, "LOS CONTINENTES NO SE PUEDEN SOLAPAR", "ERROR!!", JOptionPane.ERROR_MESSAGE, null);
            }
        } else if (estadoEdicionIsla) {
            if (this.contenedorPreContinente.DibujarRectangulos(e.getX() + 25, e.getY())) {
                this.contenedorPreContinente.remove(this.auxContenedorImagen);
                ContenedorNodoIsla contenedorFijoIsla = new ContenedorNodoIsla(urlElemento, e.getX() + 25, e.getY() + 25, 150, 150);
                this.contenedorPreContinente.islas.put(contenedorFijoIsla, new ParametrosIsla());
                this.contenedorPreContinente.add(contenedorFijoIsla);
                this.contenedorPreContinente.repaint();
                this.ApagarBanderas();
            } else {
                JOptionPane.showMessageDialog(this, "LOS ISLAS NO SE PUEDEN SOLAPAR", "ERROR!!", JOptionPane.ERROR_MESSAGE, null);
            }
        } else if (modoMoverContinente && modoOn) {
            modoOn = false;
            modoMoverContinente = false;
            this.contenedorPremapa.repaint();
        } else if (modoMoverIsla && modoOnIsla) {
            modoOnIsla = false;
            modoMoverIsla = false;
            this.contenedorPreContinente.repaint();
        }
    }

    /**
     * Este metodo realiza la funcion de apagar todas las banderas de edicion,
     * para informar al sistema que un modo de edicion ha terminado.
     */
    private void ApagarBanderas() {
        estadoEdicion = false;
        estadoEdicionIsla = false;
        estadoEdicionMar = false;
        estadoEdicionMarIsla = false;
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
