package ModoEdicion;

import Clases.Continente;
import Clases.MarProfundo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 * clase que funciona de lienzo para la ubicación de los continentes
 * @author Thebest
 * @version 4.8
 */
public class ContenedorPremapa extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int heigth;
    private Image imgFondo;
    boolean ColocarContinente;
    LinkedList<Rectangle> rectangulos;
    Rectangle aux;
    Color color;

    protected HashMap<ContenedorNodo, ContenedorPreContinente> islas;

    protected LinkedList<Arista> marProfundo;

    /**
     * Constructor el cual recibe los 4 parametros basicos de caja que permite crear el panel
     * @param x pos en x de el panel sobre la VistaContructor
     * @param y pos en y de el panel sobre la VistaContructor
     * @param width ancho del panel
     * @param heigth alto del panel
     */
    public ContenedorPremapa(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.rectangulos = new LinkedList<>();
        this.ColocarContinente = false;
        this.color = Color.GREEN;
        this.islas = new HashMap<>();
        this.marProfundo = new LinkedList<>();
        iniciarComponentes();
    }

    /**
     * metodo para la construccion de la descerializacion 
     * @return lista de continentes 
     */
    public LinkedList<Continente> getContinentes() {
        LinkedList<Continente> continentes = new LinkedList<>();
        this.islas.keySet().forEach((contenedor) -> {
            ContenedorPreContinente cP = this.islas.get(contenedor);
            continentes.add(new Continente(contenedor.getLocation(), contenedor.getWidth(), contenedor.getHeight(),
                    contenedor.getUrl(), cP.getIslas(), cP.getMar()));
        });
        return continentes;
    }

    /**
     * metodo para la construccion de la descerializacion
     * @return lista de mares profundo  
     */
    public LinkedList<MarProfundo> getMares() {
        LinkedList<MarProfundo> mares = new LinkedList<>();
        this.marProfundo.forEach((arista) -> {
            Continente c1 = this.getContinente(arista.getContinenteOrigen().getX(), arista.getContinenteOrigen().getY());
            Continente c2 = this.getContinente(arista.getContinenteDestino().getX(), arista.getContinenteDestino().getY());
            int distancia = distancia(arista.getContinenteOrigen().getX(), arista.getContinenteOrigen().getY(), arista.getContinenteDestino().getX(), arista.getContinenteDestino().getY());
            mares.add(new MarProfundo(c1, c2, arista.getPeligrosidad(), distancia));
        });
        return mares;
    }

    /**
     * metodo para la construccion de la descerializacion
     * @param x posicion en x del continente en el mapa
     * @param y posicion en y del continente en el mapa
     * @return continente 
     */
    private Continente getContinente(int x, int y) {
        LinkedList<Continente> continentebuscar = this.getContinentes();
        for (Continente continente : continentebuscar) {
            if (continente.getUbicacion().equals(new Point(x, y))) {
                return continente;
            }
        }
        return null;
    }

    /**
     * metodo para la construccion de la descerializacion 
     * @param continentes lista de continentes 
     * @param mL intefaz mouselistener
     * @param Mml interfaz mousemotionlistener
     */
    public void obtenerContinentes(LinkedList<Continente> continentes, MouseListener mL, MouseMotionListener Mml) {
        continentes.forEach((c) -> {
            ContenedorNodo cn = new ContenedorNodo(c.getRuta(), c.getUbicacion().x, c.getUbicacion().y, c.getAncho(), c.getAlto());
            this.rectangulos.add(new Rectangle(c.getUbicacion().x, c.getUbicacion().y, 150, 150));
            ContenedorPreContinente cpC = new ContenedorPreContinente(0, 0, this.width, this.heigth, Mml, mL);
            cpC.obtenerIslas(c.getIslas());
            cpC.obtenerMares(c.getMares());
            this.islas.put(cn, cpC);
            agregarContinente(cn);
            this.repaint();
        });
    }

    /**
     * metodo que agrega ContenedoresNodo al panel
     * @param c contenedorNodo que simula un continente
     */
    private void agregarContinente(ContenedorNodo c) {
        this.add(c);
    }

    /**
     * metodo que agrega las aristas a la lista de aristas dibujables
     * @param mares lista de aristas 
     */
    public void obtenerAristas(LinkedList<MarProfundo> mares) {
        mares.forEach((m) -> {
            ContenedorNodo cnO = obtenerContenedorNodo(m.getOrigen().getUbicacion().x, m.getOrigen().getUbicacion().y);
            ContenedorNodo cnD = obtenerContenedorNodo(m.getDestino().getUbicacion().x, m.getDestino().getUbicacion().y);
            Arista arista = new Arista(cnO, cnD);
            arista.setPeligrosidad(m.getPeligrosidad());
            this.marProfundo.add(arista);
        });
    }

    /**
     * metodo usado para la descerializacion 
     * @param x posicion en x sobre el panel para comparar
     * @param y posicion en y sobre el panel para comparar
     * @return Devuelve un contenedorNodo que simula un continente sobre el lienzo
     */
    public ContenedorNodo obtenerContenedorNodo(int x, int y) {
        for (ContenedorNodo cn : this.islas.keySet()) {
            if (cn.getX() == x && cn.getY() == y) {
                return cn;
            }
        }
        return null;
    }

    /**
     * calcula la distancia entre dos continentes
     * @param x1 posiciion en x del primer continente
     * @param x2 posicion en x del segundo continente
     * @param y1 posicion en y del primer continente 
     * @param y2 posicion en y del segundo continente
     * @return representa la distancia entre los dos continentes en entero
     */
    private int distancia(int x1, int x2, int y1, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * dibuja las aristas sobre el lienzo
     * @param origen continente origen 
     * @param destino continente destino
     * @param g instacian del objeto graphics para dibujar
     */
    private void dibujarAristas(ContenedorNodo origen, ContenedorNodo destino, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(origen.getX() + origen.getWidth() / 2, origen.getY() + origen.getHeight() / 2,
                destino.getX() + destino.getWidth() / 2, destino.getY() + destino.getHeight() / 2);
    }

    /**
     * metodo que se encarga de iniciar los componentes del panel
     */
    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    /**
     * implemnetacion del metodo paintcomponents
     * @param g instacia del object graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgFondo, 0, 0, this.width, this.heigth - 45, null);

        if (ColocarContinente) {
            g.setColor(color);
            g.drawRect(aux.x, aux.y, aux.width, aux.height);
        }

        this.marProfundo.forEach((marAux) -> {
            dibujarAristas(marAux.getContinenteOrigen(), marAux.getContinenteDestino(), g);
        });
        repaint();
    }

    /**
     * metodo que cambia el fondo del lienzo 
     * @param imagen objeto que lleva la imagen del tipo imageIcon
     */
    public void cambiarFondo(ImageIcon imagen) {
        this.imgFondo = imagen.getImage();
    }

    /**
     * metodo que verifica si hay colision entre los continentes para su posterior ubicacion
     * @param aux rectangulo con el cual medimos la colision
     * @return true si hay una colision
     */
    private boolean NoColisiona(Rectangle aux) {
        return this.rectangulos.stream().noneMatch((r) -> (r.intersects(aux)));
    }

    /**
     * tamaño del panel
     */
    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }

    /**
     * agrega un layout al panel
     */
    private void agregarLayout() {
        this.setLayout(null);
    }

    /**
     * agrega un aspecto al panel
     */
    private void aspecto() {
        this.setBackground(Color.white);
        AgregarFondo();
    }

    /**
     * agrega un imagen de fondo al lienzo
     */
    private void AgregarFondo() {
        try {
            this.imgFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo1.png")).getImage();
        } catch (Exception e) {
            System.out.println("No cargo Fondo");
        }

    }

    /**
     * dibuja los rectangilos que visualmente nos indica las posibles colisiones
     * @param x posicion x del rectangulo en el lienzo
     * @param y posicion y del rectangulo en el lienzo
     * @return  true si hay colision
     */
    public boolean DibujarRectangulos(int x, int y) {
        if (ColocarContinente) {
            if (NoColisiona(new Rectangle(x, y, 150, 150))) {
                this.rectangulos.add(new Rectangle(x, y, 150, 150));
                this.ColocarContinente = false;
                return true;
            }
        }
        return false;
    }

    /**
     * identifica de que color debe ser el rectangulo d ela colision
     * @param x posicion en x sobre el lienzo
     * @param y posicion en y sobre el lienzo
     */
    public void DibujarRectanguloVerdeRojo(int x, int y) {
        if (ColocarContinente) {
            aux = new Rectangle(x, y, 150, 150);
            if (!NoColisiona(aux)) {
                this.color = Color.RED;
            } else {
                this.color = Color.GREEN;
            }
        }
    }

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * metodo que elimina la arista dado un continente eliminado
     * @param continente continente que fue eliminado
     */
    public void eliminarArista(ContenedorNodo continente) {
        for (Arista a : this.marProfundo) {
            if (a.getContinenteOrigen().equals(continente)
                    || a.getContinenteDestino().equals(continente)) {
                this.marProfundo.remove(a);
            }
        }
    }

    /**
     * metodo que elimina de la lista de rectagulos el perteneciente al continente 
     * elimnado
     * @param continente  continente que fue eliminado
     */
    public void eliminarRectanguloColision(ContenedorNodo continente) {
        for (Rectangle r : this.rectangulos) {
            if (continente.getX() == r.x && continente.getY() == r.y) {
                this.rectangulos.remove(r);
            }
        }
    }

    /**
     * metodo que se encarga de eliminar el continente de la lista de continentes
     * @param continente continente a eliminar
     */
    public void eliminarContinente(ContenedorNodo continente) {
        this.islas.remove(continente);
    }

}
