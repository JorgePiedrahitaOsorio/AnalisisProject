package Grafo;

/**
 * clase de soporte para la construccion de las listas de adyacencias
 * @author William Vasquez y Jorge Osorio
 * @version 1.0
 */
class Tupla {
    
    public Nodo adyacente;
    public int peso;
    
    /**
     * Constructor que crea una tupla 
     * @param n nodo adyacente
     * @param p peso de la arista adyacente
     */
    public Tupla (Nodo n,int p){
        this.adyacente = n;
        this.peso = p;
    }
}
