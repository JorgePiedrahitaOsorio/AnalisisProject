package Interfaces;

import Clases.Continente;
import Clases.Isla;
import Clases.Mar;
import Clases.MarProfundo;
import Grafo.Grafo;
import Grafo.Nodo;
import Grafo.AristaGrafo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.border.BevelBorder.RAISED;

/**
 * Clase que se encarga de proporcionar una vista global del mapa, mediante una
 * vista de continentes, además de que permite tener un buen control de la
 * simulacion
 *
 * @author William Vasquez y Jorge Osorio
 * @version 1.9
 */
public class VistaMundo extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final LinkedList<Continente> continentes;
    private final LinkedList<MarProfundo> maresProfundos;
    private Image imgFondo;
    private JButton barcoSearch;
    private final HashMap<String, String> rutasImagenes;

    private Grafo grafo;
    private HashMap<Integer, LinkedList<Nodo>> gruposContinentes;
    private int idContinente;

    public HashMap<Integer, VistaContinente> panelesContinentes;
    public Isla islaActual;
    public int continenactual;

    /**
     * Constructor que instancia un objeto de la clase VistaMundo, requeriendo
     * los valores basico para una construccion de l lienzo, sino que ademas
     * solicita valores de los continentes de y de los mares profundos(aristas)
     * obtenidos por el proceso de serializacion
     *
     * @param x posicion en x del panel sobre la ventana simulacion
     * @param y posicion en y del panel sobre la ventana simulacion
     * @param width ancho del panel
     * @param height alto del panel
     * @param continentes lista de continentes obtenidas del proceso de
     * serializacion
     * @param maresProfundos lista de aristas obtenidas del proceso de
     * serializacion
     */
    public VistaMundo(int x, int y, int width, int height, LinkedList<Continente> continentes, LinkedList<MarProfundo> maresProfundos) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.continentes = continentes;
        this.maresProfundos = maresProfundos;
        this.rutasImagenes = new HashMap<>();
        this.gruposContinentes = new HashMap<>();
        this.idContinente = 1;
        this.grafo = new Grafo();
        this.gruposContinentes = new HashMap<>();
        this.panelesContinentes = new HashMap<>();
        llenarRutasHashMap();
        caracteristicasVisuales();
        colocarContinentes();
        AñadirBotonSearchBarco();
        CrearPanelesVistaContinente();
        seleccionarPrimerIslaYcontinente();
    }

    /**
     * Metodo que se encarga de disponer de unas caracteristicas visuales al
     * panel
     */
    private void caracteristicasVisuales() {
        this.setBounds(getX(), getY(), getWidth(), getHeight());
        this.setLayout(null);
        this.setBackground(new Color(0, 205, 199));
    }

    /**
     * metodo que se encarga de tomar la lista serializada de continentes y
     * agregar los continentes al lienzo
     */
    private void colocarContinentes() {
        corregirReferenciasMaresProfundos();
        corregirReferenciasMares();
        continentes.forEach((c) -> {
            this.add(new ContenedorContinente(c.getUbicacion().x, c.getUbicacion().y, c.getAncho(),
                    c.getAlto(), rutaImagencontinente(c.getRuta())));
            c.setId(idContinente);
            idContinente++;
            crearNodos(c);
        });
        //idContinente = 0;
        crearAristasDesdeMaresProfundo();
        grafo.traerNodos(enviarListNodos());
        grafo.llenarAdyacencias();
    }

    /**
     * Metodo que se encarga de enviar la lista de nodos al grafo obtenidos tras
     * el proceso de reconstruccion
     *
     * @return lista de nodos
     */
    private LinkedList<Nodo> enviarListNodos() {
        LinkedList<Nodo> aux = new LinkedList<>();
        for (int i : this.gruposContinentes.keySet()) {
            for (Nodo j : this.gruposContinentes.get(i)) {
                aux.add(j);
            }
        }
        return aux;
    }

    /**
     * metodo que se encarga de crear nuevos nodos y agregarlos a las listas que
     * manejan y guardan las referencias de los mismos
     *
     * @param c continente serializado con la informacion del nodo a crear
     */
    private void crearNodos(Continente c) {
        LinkedList<Nodo> aux = new LinkedList<>();
        for (Isla i : c.getIslas()) {
            aux.add(new Nodo(i, c.getId()));
        }
        this.gruposContinentes.put(c.getId(), aux);
        crearAristas(aux, c);
        generarNodoPuerta(aux);
        crearAristas(aux, c);

    }

    /**
     * metodo que se encarga de crear las aristas entre las islas y enviar a la
     * lista de aristas del grafo
     *
     * @param nodos lista de nodos que se han obtenido hasta el momento
     * @param c continente al cual estamos detallando las aristas
     */
    private void crearAristas(LinkedList<Nodo> nodos, Continente c) {
        for (Mar m : c.getMares()) {
            Nodo[] aux = buscarNodos(m.getOrigen(), m.getDestino(), nodos);
            this.grafo.addAristaGrafo(new AristaGrafo(aux[0], aux[1], m.getPeso()));
        }
    }

    /**
     * metodo que se encarga de corregir las referncias de los objetos aristas
     * buscando que los datos tengan un alto de grado de integridad
     */
    private void corregirReferenciasMaresProfundos() {
        for (Continente c : this.continentes) {
            for (MarProfundo m : this.maresProfundos) {
                if (m.getOrigen().getUbicacion().x == c.getUbicacion().x
                        && m.getOrigen().getUbicacion().y == c.getUbicacion().y) {
                    m.setOrigen(c);
                } else if (m.getDestino().getUbicacion().x == c.getUbicacion().x
                        && m.getDestino().getUbicacion().y == c.getUbicacion().y) {
                    m.setDestino(c);
                }
            }
        }
    }

    /**
     * metodo que se encarga de corregir las referencias de los objetos aristas
     * buscando que los datos tengan un alto grado de integridad
     */
    private void corregirReferenciasMares() {
        for (Continente c : this.continentes) {
            for (Isla i : c.getIslas()) {
                for (Mar m : c.getMares()) {
                    if (m.getOrigen().getUbicacion().x == i.getUbicacion().x
                            && m.getOrigen().getUbicacion().y == i.getUbicacion().y) {
                        m.setOrigen(i);
                    } else if (m.getDestino().getUbicacion().x == i.getUbicacion().x
                            && m.getDestino().getUbicacion().y == i.getUbicacion().y) {
                        m.setDestino(i);
                    }
                }
            }
        }
    }

    /**
     * crear las aristas que faltan qeu hacen referencia a las conexiones entre
     * los continentes, por lo tanto es una conexion entre nodos puerta
     */
    private void crearAristasDesdeMaresProfundo() {
        for (int i : this.gruposContinentes.keySet()) {
        }
        for (MarProfundo m : this.maresProfundos) {
            grafo.addAristaGrafo(new AristaGrafo(BuscarNodoPuerta(m.getOrigen().getId()),
                    BuscarNodoPuerta(m.getDestino().getId()), m.getPeso()));
        }
    }

    /**
     * Metodo que se encarga de buscar aquellos nodos que conforman la arista
     *
     * @param i1 isla origen
     * @param i2 isla destino
     * @param nodos lista de nodos que se tienen hasta el momento
     * @return un vector de dos posiciones con la informacin de los dos nodos
     * que haran parte de la arista
     */
    private Nodo[] buscarNodos(Isla i1, Isla i2, LinkedList<Nodo> nodos) {
        Nodo[] aux = new Nodo[2];
        for (Nodo i : nodos) {
            if (i.isla.equals(i1)) {
                aux[0] = i;
            } else if (i.isla.equals(i2)) {
                aux[1] = i;
            }
        }
        return aux;
    }

    /**
     * metodo que se encarga de buscar los nodos puerta dado un continente
     *
     * @param c continente del cual se hallara al nodo puerta
     * @return retorna al que ha sido elegido como nodo puerta
     */
    private Nodo BuscarNodoPuerta(int c) {
        //Si se cambia este valor de c a 1 ya funciona, no entiendo porque sigue existiendo el valor de 0, igual nunca entra al ciclo
        for (Nodo i : this.gruposContinentes.get(c)) {
            if (i.getIsDoor()) {
                return i;
            }
        }
        return null;
    }

    /**
     * metodo que se encarga de elegir quien sera el nodo puerta en cada
     * continente
     *
     * @param nodos lista de nodos de un continente
     */
    private void generarNodoPuerta(LinkedList<Nodo> nodos) {
        int num = -100;
        try {
            num = (int) (Math.random() * nodos.size());
            nodos.get(num).trueIsDoor();
        } catch (Exception e) {
        }

    }

    /**
     * metodo que devuelve la ruta de la imagen en color tras llegar en sepia
     *
     * @param rutaSepia ruta de la imagen en sepia
     * @return ruta de la imagen a color
     */
    private String rutaImagencontinente(String rutaSepia) {
        return this.rutasImagenes.get(rutaSepia);
    }

    /**
     * metodo que se encarga de llenar las hashmap con las rutas de sepia a color
     */
    private void llenarRutasHashMap() {
        for (int i = 1; i <= 6; i++) {
            this.rutasImagenes.put("../Imagenes/Sepiacontinente" + String.valueOf(i) + ".png", "../Imagenes/continente" + String.valueOf(i) + ".png");
        }
    }

    /**
     * sobreescritura del metodo por defecto paintcomponent de java para dibujar
     * @param g instancia del objeto graphics de java
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.maresProfundos.forEach((m) -> {
            colocarMaresProfundos(g, m.getOrigen(), m.getDestino());
        });
        repaint();
    }

    /**
     * metodo que se encarga de dibujar los mares profundos en el lienzo
     * @param g instancia de la clase graphics de java
     * @param ori continente origen 
     * @param dest continente destino
     */
    private void colocarMaresProfundos(Graphics g, Continente ori, Continente dest) {
        if (ori.getUbicacion().x < dest.getUbicacion().x) {
            g.drawLine(ori.getUbicacion().x + ori.getAncho() / 2,
                    ori.getUbicacion().y + ori.getAlto() / 2, dest.getUbicacion().x
                    + dest.getAncho() / 2, dest.getUbicacion().y + dest.getAlto() / 2);
        } else {
            g.drawLine(dest.getUbicacion().x + dest.getAncho() / 2,
                    dest.getUbicacion().y + dest.getAlto() / 2, ori.getUbicacion().x
                    + ori.getAncho() / 2, ori.getUbicacion().y + ori.getAlto() / 2);
        }
    }

    /**
     * metodo que se encarga de buscar un continente en la lista de continentes 
     * @param x posicion en x del continente 
     * @param y posicion en y del continente
     * @return el continente que cumpla con la condicion
     */
    private Continente buscarContinente(int x, int y) {
        for (Continente c : this.continentes) {
            if (c.getUbicacion().x == x && c.getUbicacion().y == y) {
                return c;
            }
        }
        return null;
    }

    /**
     * metodo que se encarga de añadir el boton que nos permite tener una vista del
     * continente donde se encuentra el barco en este preciso momento
     */
    private void AñadirBotonSearchBarco() {
        ImageIcon icono = new ImageIcon(getClass().getResource("../Imagenes/barcoSearch.png"));
        Icon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(110,
                110, Image.SCALE_DEFAULT));
        this.barcoSearch = new JButton(iconoEscalado);
        this.barcoSearch.setBounds(1050, 600, 100, 100);
        this.barcoSearch.setContentAreaFilled(false);
        this.barcoSearch.setBorder(BorderFactory.createBevelBorder(RAISED));
        this.barcoSearch.setVisible(true);
        this.add(barcoSearch);
        this.barcoSearch.addActionListener((java.awt.event.ActionEvent evt) -> {
            barcoSearchAction(evt);
        });
    }

    /**
     * metodo con el evento para el boton de buscar el barco o ampliar vista
     * @param evt instancia del objeto actionevent d ejava
     */
    private void barcoSearchAction(java.awt.event.ActionEvent evt) {
        System.out.println("No estoy Implementado, IMPLEMENTAME!!!");
    }

    /**
     * metodo que se encarga de crear los paneles que se referenciaran con la 
     * variable hashmap panelescontinentes para retornar el panel segun el continen
     * te donde se encuentre
     */
    private void CrearPanelesVistaContinente() {
        for (Continente c : this.continentes) {
            this.panelesContinentes.put(c.getId(), new VistaContinente(this.x, this.y,
                    this.width, this.height, c.getIslas(), c.getMares()));
        }
    }

    /**
     * selecciona la primer isla y el primer continente del los tableros
     */
    private void seleccionarPrimerIslaYcontinente() {
        Continente aux = continenteMasIzquierda();
        this.continenactual = aux.getId();
        this.islaActual = islaMasIzquierda(aux);
    }

    /**
     * selecciona la isla mas a la izquierda del tablero de continentes
     * @param c continente al que pertenecen las islas
     * @return la isla por la que comenzara la simulacion
     */
    private Isla islaMasIzquierda(Continente c) {
        int x = Integer.MAX_VALUE;
        Isla r = null;
        for (Isla i : c.getIslas()) {
            if (i.getUbicacion().x < x) {
                x = i.getUbicacion().x;
                r = i;
            }
        }
        return r;
    }

    /**
     * seleccona al continente alojado mas a la izquierda del panel
     * @return el continente que esta mas a la izquierda
     */
    private Continente continenteMasIzquierda() {
        int x = Integer.MAX_VALUE;
        Continente r = null;
        for (Continente c : this.continentes) {
            if (c.getUbicacion().x < x) {
                x = c.getUbicacion().x;
                r = c;
            }
        }
        return r;
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
    public int getHeight() {
        return height;
    }

}
