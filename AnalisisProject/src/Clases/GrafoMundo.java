/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author JORGE OSORIO
 */
public class GrafoMundo {

    private LinkedList<Continente> nodos;
    private LinkedList<MarProfundo> aristas;

    public GrafoMundo() {
        this.nodos = new LinkedList<>();
        this.aristas = new LinkedList<>();
    }

    public void AñadirContinente(Continente continente) {
        this.nodos.add(continente);
    }

    public void AñadirMarProfundo(Point origen, Point destino, double distancia, int peso) {
        //this.aristas.add(new MarProfundo(origen, destino, distancia, peso));
    }

    /**
     * @return the nodos
     */
    public LinkedList<Continente> getNodos() {
        return nodos;
    }

    /**
     * @return the aristas
     */
    public LinkedList<MarProfundo> getAristas() {
        return aristas;
    }

}
