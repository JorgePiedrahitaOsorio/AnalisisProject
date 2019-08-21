package Grafo;

import Clases.Isla;

/**
 * clase celula del grafo 
 * @author William Vasquez y Jorge Osorio
 * @version 1.0
 */
public class Nodo {
    
    public Isla isla;
    public int idContinente;
    private boolean isDoor;
    
    /**
     * Cosntructor de la clase que crea un nuevo nodo
     * @param i isla que referencia 
     * @param id referencia del continente al que pertenece
     */
    public Nodo(Isla i, int id){
        this.isla = i;
        this.idContinente = id;
        this.isDoor = false;
    }
    
    public void trueIsDoor(){
        this.isDoor = true; 
    }
    
    public boolean getIsDoor(){
        return this.isDoor;
    }
    
}
