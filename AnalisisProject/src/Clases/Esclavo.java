/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author JORGE OSORIO
 */
public class Esclavo {

    protected int horasNavegacion;

    public Esclavo() {
    }

    public Esclavo(int horasNavegacion) {
        this.horasNavegacion = horasNavegacion;
    }

    /**
     * @return the horasNavegacion
     */
    public int getHorasNavegacion() {
        return horasNavegacion;
    }

    /**
     * @param horasNavegacion the horasNavegacion to set
     */
    public void setHorasNavegacion(int horasNavegacion) {
        this.horasNavegacion = horasNavegacion;
    }

}
