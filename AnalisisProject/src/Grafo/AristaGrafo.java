
package Grafo;

/**
 * clase que representa implementacion logica de una arista para un grafo   
 * @author William Vasquez y Jorge Osorio 
 * @version 1.0
 */
public class AristaGrafo {

    Nodo origen;
    Nodo destino;
    int peso;

    /**
     * Constructor de la clase arista donde se solicitan los valores que requieren+
     * una arista, los dos nodo y su peso
     * @param origen nodo origen de la arista
     * @param destino nodo destino de la arista
     * @param peso peso de la arista 
     */
    public AristaGrafo(Nodo origen, Nodo destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
}
