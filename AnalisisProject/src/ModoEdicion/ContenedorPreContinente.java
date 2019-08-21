package ModoEdicion;

import Clases.Isla;
import Clases.Mar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static ModoEdicion.VistaConstructor.mundoClickeado;
import static ModoEdicion.VistaConstructor.banderaGuardar;
import java.awt.Point;

/**
 *Clase que sirve de lienzo para la ubicacion de las islas 
 * @author Wiliam Vasquez y Jorge Osorio
 * @version 4.7
 */
public class ContenedorPreContinente extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int heigth;
    private ImageIcon imagenFondo;
    private JButton mundo;
    private boolean colocarIsla;
    private LinkedList<Rectangle> rectangulos;
    private Rectangle aux;
    private Color color;

    protected HashMap<ContenedorNodoIsla, ParametrosIsla> islas;

    protected LinkedList<AristaIsla> marProfundo;

    /**
     * constructor para la instanciacion del panel ContenedorPreContinente
     * @param x posicion en x sobre la Vnetana VistaContrsuctor
     * @param y Posicion en y sobre la ventana vistaconstructor
     * @param width ancho del lienzo
     * @param heigth alto del lienzo
     * @param MouseMotion implementacion d ela interfaz mousemotion
     * @param MouseListener implementacion d ela interfaz mousemotionlistener
     */
    public ContenedorPreContinente(int x, int y, int width, int heigth, MouseMotionListener MouseMotion, MouseListener MouseListener) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.colocarIsla = false;
        this.rectangulos = new LinkedList<>();
        this.marProfundo = new LinkedList<>();
        this.aux = new Rectangle();
        this.color = Color.GREEN;
        this.islas = new HashMap<>();
        this.addMouseListener(MouseListener);
        this.addMouseMotionListener(MouseMotion);
        iniciarComponentes();
    }

    /**
     * Metodo que carga los componentes basicos del lienzo
     */
    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        AgregarFondo();
        AñadirBotonMundo();
    }

    /**
     * metodo para la descerializacion 
     * @return una lista de islas
     */
    public LinkedList<Isla> getIslas() {
        LinkedList<Isla> isla = new LinkedList<>();
        this.islas.keySet().forEach((contenedor) -> {
            ParametrosIsla parametros = this.islas.get(contenedor);
            isla.add(new Isla(new Point(contenedor.getX(), contenedor.getY()), contenedor.getWidth(), contenedor.getHeight(),
                    contenedor.getUrl(), parametros.getTamañoTesoro(), parametros.getEsclavosJovenes(),
                    parametros.getEsclavosAdultos(), parametros.getEsclavosViejos(), parametros.getNombreIsla()));
        });
        return isla;
    }

    /**
     * metodo para la descerializacion 
     * @return una lista de mares o aristas entre islas
     */
    public LinkedList<Mar> getMar() {
        LinkedList<Mar> mares = new LinkedList<>();
        this.marProfundo.forEach((arista) -> {
            Isla isla1 = getIsla(arista.getOrigen().getX(), arista.getOrigen().getY());
            Isla isla2 = getIsla(arista.getDestino().getX(), arista.getDestino().getY());
            int distancia = distancia(arista.getOrigen().getX(), arista.getOrigen().getY(), arista.getDestino().getX(), arista.getDestino().getY());
            mares.add(new Mar(isla1, isla2, arista.getPeligrosidad(), distancia));
        });
        return mares;
    }

    /**
     * metodo que calcula la distancia entre una isla y otra, osea la arista
     * @param x1 posicion en x  de la primera isla
     * @param x2 posicion en x de la segunda isla
     * @param y1 posicion en y d ela primera isla
     * @param y2 posicion en y de la segunda isla
     * @return el valor correspondiente a la distancia entre las dos islas
     */
    private int distancia(int x1, int x2, int y1, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * metodo usado para la descerializacion 
     * @param islas lista de islas 
     */
    public void obtenerIslas(LinkedList<Isla> islas) {
        islas.forEach((isla) -> {
            ContenedorNodoIsla cnI = new ContenedorNodoIsla(isla.getRuta(), isla.getUbicacion().x, isla.getUbicacion().y, isla.getAncho(), isla.getAncho());
            this.rectangulos.add(new Rectangle(isla.getUbicacion().x, isla.getUbicacion().y, isla.getAncho(), isla.getAncho()));
            agregarIsla(cnI);
            ParametrosIsla pI = new ParametrosIsla(isla.getTamañoTesoro(), isla.getEsclavosJovenes(), isla.getEsclavosAdultos(),
                    isla.getEsclavosViejos(), isla.getNombreIsla());
            this.islas.put(cnI, pI);
            this.repaint();
        });

    }

    /**
     * metodo usado para la descerializacion
     * @param mares lista de mares o aristas entre islas
     */
    public void obtenerMares(LinkedList<Mar> mares) {
        mares.stream().map((mar) -> {
            ContenedorNodoIsla cO = obtenerContenedorIsla(mar.getOrigen().getUbicacion().x, mar.getOrigen().getUbicacion().y);
            ContenedorNodoIsla cD = obtenerContenedorIsla(mar.getDestino().getUbicacion().x, mar.getDestino().getUbicacion().y);
            AristaIsla arista = new AristaIsla(cO, cD);
            arista.setPeligrosidad(mar.getPeligrosidad());
            return arista;
        }).forEachOrdered((arista) -> {
            this.marProfundo.add(arista);
        });
    }

    /**
     * metodo usado para la descerializacion
     * @param x posicion en x de la isla
     * @param y posicion en y de la isla
     * @return un obejto de ContenedorNodoIsla que simula una isla
     */
    public ContenedorNodoIsla obtenerContenedorIsla(int x, int y) {
        for (ContenedorNodoIsla cnI : this.islas.keySet()) {
            if (cnI.getX() == x && cnI.getY() == y) {
                return cnI;
            }
        }
        return null;
    }

    /**
     * agrega una isla al lienzo 
     * @param cnI objeto contenedornodoisla que simula una isla
     */
    private void agregarIsla(ContenedorNodoIsla cnI) {
        this.add(cnI);
    }

    /**
     * metodo usado para la descerializacion, devuelve una isla
     * @param x posicion en x de la isla
     * @param y posicion en y de la isla
     * @return una isla
     */
    private Isla getIsla(int x, int y) {
        LinkedList<Isla> islasbuscar = this.getIslas();
        for (Isla isla : islasbuscar) {
            if (isla.getUbicacion().equals(new Point(x, y))) {
                return isla;
            }
        }
        return null;
    }

    /**
     * metodo que le da el tamaño al lienzo
     */
    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }

    /**
     * metodo que le agrega un layout al lienzo
     */
    private void agregarLayout() {
        this.setLayout(null);
    }

    /**
     * metodo que le agrega un color al lienzo
     */
    private void aspecto() {
        this.setBackground(Color.BLACK);
    }

    /**
     * metodo que le agrega una imagen de fondo al lienzo
     */
    private void AgregarFondo() {
        try {
            this.imagenFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo3.jpg"));
        } catch (Exception e) {
            System.out.println("No Cargo Fondo, Error: " + e);
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
     * metodo que se encarga de dibujar las aristas de las islas
     * @param origen isla origen 
     * @param destino isla destino
     * @param g implementacion del object graphics para dibujar
     */
    private void dibujarAristas(ContenedorNodoIsla origen, ContenedorNodoIsla destino, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(origen.getX() + origen.getWidth() / 2, origen.getY() + origen.getHeight() / 2,
                destino.getX() + destino.getWidth() / 2, destino.getY() + destino.getHeight() / 2);
    }

    /**
     * metodo implementado de paintcomponent
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(this.imagenFondo.getImage(), 0, 0, this.width, this.heigth, null);
        if (this.colocarIsla) {
            g.setColor(this.color);
            g.drawRect(this.aux.x, this.aux.y, this.aux.width, this.aux.height);
        }
        this.marProfundo.forEach((marAux) -> {
            dibujarAristas(marAux.getOrigen(), marAux.getDestino(), g);
        });

        repaint();
    }

    /**
     * añadimos un boton que nos ayuda a navegar entre los paneles de continentes
     * e islas
     */
    private void AñadirBotonMundo() {
        ImageIcon icono = new ImageIcon(getClass().getResource("../Imagenes/IconoMundo.png"));
        Icon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(80,
                80, Image.SCALE_DEFAULT));
        this.mundo = new JButton(iconoEscalado);
        this.mundo.setBounds(1050, 600, 80, 80);
        this.mundo.setContentAreaFilled(false);
        this.mundo.setBorder(null);
        this.mundo.setVisible(true);
        this.add(mundo);
        this.mundo.addActionListener((java.awt.event.ActionEvent evt) -> {
            AccionBotonMundo(evt);
        });
    }

    /**
     * accion que realiza en boton del mundo que nos permite navegar entre los paneles
     * de continentes e islas
     * @param evt instancia accion event 
     */
    private void AccionBotonMundo(java.awt.event.ActionEvent evt) {
        mundoClickeado = true;
    }

    /**
     * Dibuja los rectangulos para saber si la isla a coocar va a colisionar o no
     * @param x pisicion en x de la isla
     * @param y posicion en y de la isla
     * @return true si el objeto colisiona
     */
    public boolean DibujarRectangulos(int x, int y) {
        if (this.colocarIsla) {
            if (NoColisiona(new Rectangle(x, y, 150, 150))) {
                this.rectangulos.add(new Rectangle(x, y, 150, 150));
                this.setColocarIsla(false);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo que nos devuelve si la isla a ubicar va a colisionar
     * @param aux rectangulo que va a ser comparado
     * @return retorna true si colisiona la isla
     */
    private boolean NoColisiona(Rectangle aux) {
        return this.rectangulos.stream().noneMatch((r) -> r.intersects(aux));
    }

    /**
     * metodo que dibuja el rectangulo en el lienzo segun si colisiona o no
     * @param x posicion en x del rectangulo
     * @param y posicion en y del rectagulo
     */
    public void DibujarRectanguloVerdeRojo(int x, int y) {
        if (this.colocarIsla) {
            this.aux = new Rectangle(x, y, 150, 150);
            if (!this.NoColisiona(this.aux)) {
                this.color = Color.RED;
            } else {
                this.color = Color.GREEN;
            }
        }
    }

    /**
     * @param colocarIsla the colocarIsla to set
     */
    public void setColocarIsla(boolean colocarIsla) {
        this.colocarIsla = colocarIsla;
    }

    /**
     * Cambia la parametrizacion de la isla dado que se guardaron cambios nuevos
     * @param contenedor isla que ha sido modificada que es la llave
     * @param parametros objeto que va a cambiar los parametros viejos
     */
    public void CambiarParametrizacion(ContenedorNodoIsla contenedor, ParametrosIsla parametros) {
        this.islas.remove(contenedor);
        this.islas.put(contenedor, parametros);
        banderaGuardar = false;
    }

    /**
     * metodo que elimina las aristas relacionadas con la isla eliminada
     * @param isla isla que ha sido eliminada
     */
    public void eliminarArista(ContenedorNodoIsla isla) {
        for (AristaIsla a : this.marProfundo) {
            if (a.getOrigen().equals(isla)
                    || a.getDestino().equals(isla)) {
                this.marProfundo.remove(a);
            }
        }
    }

    /**
     * Elimina el rectangulo que verificaba la colision de la isla a insertar sobre 
     * la isla existente
     * @param isla isla que ha sido eliminada
     */
    public void eliminarRectanguloColision(ContenedorNodoIsla isla) {
        for (Rectangle r : this.rectangulos) {
            if (isla.getX() == r.x && isla.getY() == r.y) {
                this.rectangulos.remove(r);
            }
        }
    }

    /**
     * Elimina la referencia de la isla guardada en el lienzo
     * @param isla isla que a sido eliminada 
     */
    public void eliminarContinente(ContenedorNodoIsla isla) {
        this.islas.remove(isla);
    }

}
