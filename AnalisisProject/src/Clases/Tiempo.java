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
public class Tiempo implements Runnable {

    private int hora;
    private int minuto;
    private int minutosReales;
    private int horasReales;
    private int dias;
    private String tiempo_juego;
    private String tiempo_real;
    private Thread hilo;

    public Tiempo() {
        this.hora = 0;
        this.minuto = 0;
        this.dias = 0;
        this.hilo = new Thread(this);
        this.Start();
    }

    private void Start() {
        this.hilo.start();
    }

    public String obtenerTiempoJuego() {
        return this.getTiempo_juego();
    }

    public String obtenerTiempoReal() {
        return this.getTiempo_real();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.hilo.sleep(1000);
                this.minuto++;
                if (this.minuto == 60) {
                    this.hora++;
                    this.minutosReales++;
                    this.minuto = 0;
                }
                if (this.hora == 24) {
                    this.dias++;
                    this.hora = 0;
                }
                if (minutosReales == 60) {
                    this.horasReales++;
                    this.minutosReales = 0;
                }
                this.tiempo_real = this.horasReales + " : " + this.minutosReales;
                this.tiempo_juego = "Dia: " + this.dias + "/  " + this.hora + " : " + this.minuto;
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * @return the minutosReales
     */
    public int getMinutosReales() {
        return minutosReales;
    }

    /**
     * @param minutosReales the minutosReales to set
     */
    public void setMinutosReales(int minutosReales) {
        this.minutosReales = minutosReales;
    }

    /**
     * @return the horasReales
     */
    public int getHorasReales() {
        return horasReales;
    }

    /**
     * @param horasReales the horasReales to set
     */
    public void setHorasReales(int horasReales) {
        this.horasReales = horasReales;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * @return the tiempo_juego
     */
    public String getTiempo_juego() {
        return tiempo_juego;
    }

    /**
     * @param tiempo_juego the tiempo_juego to set
     */
    public void setTiempo_juego(String tiempo_juego) {
        this.tiempo_juego = tiempo_juego;
    }

    /**
     * @return the tiempo_real
     */
    public String getTiempo_real() {
        return tiempo_real;
    }

    /**
     * @param tiempo_real the tiempo_real to set
     */
    public void setTiempo_real(String tiempo_real) {
        this.tiempo_real = tiempo_real;
    }

    /**
     * @return the hilo
     */
    public Thread getHilo() {
        return hilo;
    }

    /**
     * @param hilo the hilo to set
     */
    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }
}
