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
public class AristaGrafo {

    Nodo origen;
    Nodo destino;
    int peso;

    public AristaGrafo(Nodo origen, Nodo destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
}
