/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.LinkedList;

/**
 *
 * @author JORGE OSORIO
 */
public class Mundo {

    private LinkedList<Continente> nodos;
    private LinkedList<MarProfundo> aristas;

    public Mundo() {
        this.nodos = new LinkedList<>();
        this.aristas = new LinkedList<>();
    }
    
    public void addContinente(Continente continente){
        this.nodos.add(continente);
    }
    
    public void addArista(MarProfundo marProfundo){
        this.aristas.add(marProfundo);
    }

    /**
     * @return the nodos
     */
    public LinkedList<Continente> getNodos() {
        return nodos;
    }

    /**
     * @param nodos the nodos to set
     */
    public void setNodos(LinkedList<Continente> nodos) {
        this.nodos = nodos;
    }

    /**
     * @return the aristas
     */
    public LinkedList<MarProfundo> getAristas() {
        return aristas;
    }

    /**
     * @param aristas the aristas to set
     */
    public void setAristas(LinkedList<MarProfundo> aristas) {
        this.aristas = aristas;
    }

}
