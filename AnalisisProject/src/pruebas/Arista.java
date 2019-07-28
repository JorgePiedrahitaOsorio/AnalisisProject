/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import javax.swing.JButton;

/**
 *
 * @author Thebest
 */
public class Arista {

    /**
     * @return the continenteOrigen
     */
    public ContenedorNodo getContinenteOrigen() {
        return continenteOrigen;
    }

    /**
     * @param continenteOrigen the continenteOrigen to set
     */
    public void setContinenteOrigen(ContenedorNodo continenteOrigen) {
        this.continenteOrigen = continenteOrigen;
    }

    /**
     * @return the continenteDestino
     */
    public ContenedorNodo getContinenteDestino() {
        return continenteDestino;
    }

    /**
     * @param continenteDestino the continenteDestino to set
     */
    public void setContinenteDestino(ContenedorNodo continenteDestino) {
        this.continenteDestino = continenteDestino;
    }
    
    private ContenedorNodo continenteOrigen;
    private ContenedorNodo continenteDestino;

    public Arista(ContenedorNodo continenteOrigen,ContenedorNodo continenteDestino ) {
        this.continenteOrigen =  continenteOrigen;
        this.continenteDestino = continenteDestino;
    }
    
    
}
