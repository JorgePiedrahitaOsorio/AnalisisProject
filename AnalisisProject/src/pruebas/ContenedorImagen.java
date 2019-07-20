/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Thebest
 */
public class ContenedorImagen extends javax.swing.JButton {

    private String url;

    public ContenedorImagen(String url) {
        this.url = url;
        contenido();
    }

    private void contenido() {
        Image img = new ImageIcon(url).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
        this.setIcon(img2);
    }
}
