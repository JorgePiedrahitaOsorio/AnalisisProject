package Clases;

import java.util.LinkedList;

/**
 * clase que almacena la informacion logica del mundo
 * @author JORGE OSORIO
 */
public class Mundo {

    private LinkedList<Continente> nodos;
    private LinkedList<MarProfundo> aristas;

    /**
     * instacia un objeto del tipo mundo
     */
    public Mundo() {
        this.nodos = new LinkedList<>();
        this.aristas = new LinkedList<>();
    }
    
    /**
     * metodo para agregar continente a la lista nodos
     * @param continente continente a agregar
     */
    
    public void addContinente(Continente continente){
        this.nodos.add(continente);
    }
    
    /**
     * metodo para agregar aristas de continentes a la lista de aristas
     * @param marProfundo arista a  agregar
     */
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
