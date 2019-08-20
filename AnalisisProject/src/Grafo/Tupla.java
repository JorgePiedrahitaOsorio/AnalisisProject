/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author Thebest
 */
class Tupla {
    
    public Nodo adyacente;
    public int peso;
    
    public Tupla (Nodo n,int p){
        this.adyacente = n;
        this.peso = p;
    }
}
