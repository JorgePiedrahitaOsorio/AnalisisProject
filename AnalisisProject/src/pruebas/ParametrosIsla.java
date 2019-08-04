/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Thebest
 */
public class ParametrosIsla {

    /**
     * @return the tamañoTesoro
     */
    public int getTamañoTesoro() {
        return tamañoTesoro;
    }

    /**
     * @param tamañoTesoro the tamañoTesoro to set
     */
    public void setTamañoTesoro(int tamañoTesoro) {
        this.tamañoTesoro = tamañoTesoro;
    }

    /**
     * @return the esclavosJovenes
     */
    public int getEsclavosJovenes() {
        return esclavosJovenes;
    }

    /**
     * @param esclavosJovenes the esclavosJovenes to set
     */
    public void setEsclavosJovenes(int esclavosJovenes) {
        this.esclavosJovenes = esclavosJovenes;
    }

    /**
     * @return the esclavosAdultos
     */
    public int getEsclavosAdultos() {
        return esclavosAdultos;
    }

    /**
     * @param esclavosAdultos the esclavosAdultos to set
     */
    public void setEsclavosAdultos(int esclavosAdultos) {
        this.esclavosAdultos = esclavosAdultos;
    }

    /**
     * @return the esclavosViejos
     */
    public int getEsclavosViejos() {
        return esclavosViejos;
    }

    /**
     * @param esclavosViejos the esclavosViejos to set
     */
    public void setEsclavosViejos(int esclavosViejos) {
        this.esclavosViejos = esclavosViejos;
    }

    /**
     * @return the nombreIsla
     */
    public String getNombreIsla() {
        return nombreIsla;
    }

    /**
     * @param nombreIsla the nombreIsla to set
     */
    public void setNombreIsla(String nombreIsla) {
        this.nombreIsla = nombreIsla;
    }

    private int tamañoTesoro;
    private int esclavosJovenes;
    private int esclavosAdultos;
    private int esclavosViejos;
    private String nombreIsla;

    public ParametrosIsla(int tamañoTesoro, int esclavosJovenes, int esclavosAdultos,
            int esclavosViejos, String nombreIsla) {

        this.tamañoTesoro = tamañoTesoro;
        this.esclavosJovenes = esclavosJovenes;
        this.esclavosAdultos = esclavosAdultos;
        this.esclavosViejos = esclavosViejos;
        this.nombreIsla = nombreIsla;
    }

    public ParametrosIsla() {
        this.tamañoTesoro = 0;
        this.esclavosJovenes = 0;
        this.esclavosViejos = 0;
        this.esclavosAdultos = 0;
        this.nombreIsla = "";
    }
}
