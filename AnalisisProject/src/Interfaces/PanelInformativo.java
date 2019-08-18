/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JPanel;

/**
 *
 * @author Thebest
 */
public class PanelInformativo extends JPanel{
    
    private int x,y,width, height;
    
    public PanelInformativo (int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        caractisticasVisuales();
    }
    
    private void caractisticasVisuales(){
        this.setBounds(x, y,width,height);
        this.setLayout(null);
    }
}
