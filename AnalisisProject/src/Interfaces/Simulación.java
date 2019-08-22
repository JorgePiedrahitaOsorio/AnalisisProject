package Interfaces;

import Clases.Mundo;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * clase que se encarga de crear la simulacion de un mapa previamente construido
 * @author Thebest
 */
public class Simulación extends javax.swing.JFrame {

    
    /**
     * @param args the command line arguments
     */
    JPanel panelIzquierda;
    JPanel panelDerecha;
    VistaMundo VistaMundo;
    JPanel PanelInformativo;
    VistaContinente vistaContinente;
    Mundo mundo;
    private final int opcionSimulacion;

    /**
     * constructor que crea una simulacion a partir de un mundo y de una opcion a simular
     * @param m mundo serializado
     * @param opcionSimulacion tipo de simulacion o metodologia a abordar
     */
    public Simulación(Mundo m, int opcionSimulacion) {
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        this.opcionSimulacion = opcionSimulacion;
        this.mundo = m;
        caracteristicasVisuales();
        this.agregarPaneles();
    }

    /**
     * caracteristicas visuales de la ventana simulacion
     */
    private void caracteristicasVisuales() {
        this.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.white);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Icono.png")).getImage());
        this.setTitle("MODO SIMULACION");

    }

    /**
     * agrega los paneles de derecha y de izquierda pa el inicio de la simulacion
     */
    
    private void agregarPaneles() {
        this.VistaMundo = new VistaMundo(5, 5, Toolkit.getDefaultToolkit().getScreenSize().width - 205,
                Toolkit.getDefaultToolkit().getScreenSize().height, mundo.getNodos(), mundo.getAristas());
        this.panelIzquierda = this.VistaMundo;
        this.PanelInformativo = new PanelInformativo(this.VistaMundo.getWidth() + 5, 5, 200, this.VistaMundo.getHeight());
        this.panelDerecha = this.PanelInformativo;
        this.getContentPane().add(panelIzquierda);
        this.getContentPane().add(this.panelDerecha);
        cambiarPanelIzquierda();
    }
    
    private void cambiarPanelIzquierda(){
        this.getContentPane().remove(this.panelIzquierda);
        this.panelIzquierda = null;
        this.vistaContinente = this.VistaMundo.panelesContinentes.get(this.VistaMundo.continenactual);
        this.panelIzquierda = this.vistaContinente;
        this.getContentPane().add(this.panelIzquierda);
        this.panelIzquierda.setVisible(true);
    }

}
