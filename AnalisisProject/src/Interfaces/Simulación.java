/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Mundo;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Thebest
 */
public class Simulación extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    JPanel panelIzquierda;
    JPanel panelDerecha;
    JPanel VistaMundo;
    JPanel PanelInformativo;
    Mundo mundo;
    private final int opcionSimulacion;

    public Simulación(Mundo m, int opcionSimulacion) {
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        this.opcionSimulacion = opcionSimulacion;
        this.mundo = m;
        caracteristicasVisuales();
        this.agregarPaneles();
    }

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

    private void agregarPaneles() {
        this.VistaMundo = new VistaMundo(5, 5, Toolkit.getDefaultToolkit().getScreenSize().width - 205,
                Toolkit.getDefaultToolkit().getScreenSize().height, mundo.getNodos(), mundo.getAristas());
        this.panelIzquierda = this.VistaMundo;
        this.PanelInformativo = new PanelInformativo(this.VistaMundo.getWidth() + 5, 5, 200, this.VistaMundo.getHeight());
        this.panelDerecha = this.PanelInformativo;
        this.getContentPane().add(panelIzquierda);
        this.getContentPane().add(this.panelDerecha);
    }

}
