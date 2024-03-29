/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import javax.swing.ImageIcon;
import static ModoEdicion.ContenedorNodoIsla.abrir;
import static ModoEdicion.VistaConstructor.pIslaReferencia;

/**
 * @author TheBest (William)
 * @author JORGE OSORIO
 */
public class VistaPersonalizarIsla extends javax.swing.JFrame {

    private ContenedorHerramientaPersonalizarIsla contenedor;

    /**
     * Crea un nuevo formulario VistaPersonalizarIsla
     */
    public VistaPersonalizarIsla() {
        initComponents();
        Configuraciones();
        AñadirPanel();

    }

    /**
     * Agrega un panel de tipo ContenedorHerramientaPersonalizarIsla, este me
     * permite tener acceso a una lista de campos que se deben llenar al momento
     * de parametrizar una isla, es decir, agregar los atributos que esa isla
     * debe tener
     */
    private void AñadirPanel() {
        this.contenedor = new ContenedorHerramientaPersonalizarIsla(0, 0, this.getWidth(), this.getHeight(), pIslaReferencia);
        this.add(this.contenedor);
    }

    /**
     * Se encarga de añadir algunas configuraciones visuakes y logicas, tales
     * como el nombre, posicion o la accion a realizar al momento de colapsar la
     * ventana
     */
    private void Configuraciones() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Datos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Icono2x.png")).getImage());
        abrir = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalizarIsla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalizarIsla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalizarIsla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPersonalizarIsla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPersonalizarIsla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
