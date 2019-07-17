/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.applet.AudioClip;

/**
 *
 * @author JORGE OSORIO
 */
public class Sonido {
    AudioClip sonido;

    public Sonido(String ruta) {
        this.sonido =  java.applet.Applet.newAudioClip(getClass().getResource(ruta));
    }
    
    public void Play(){
        this.sonido.play();
    }
    
    public void Stop(){
        this.sonido.stop();
    }
    
    public void Loop(){
        this.sonido.loop();
    }
    
    
}
