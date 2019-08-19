/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Clases.Isla;

/**
 *
 * @author Thebest
 */
public class Nodo {
    
    public Isla isla;
    public int idContinente;
    private boolean isDoor;
    
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
