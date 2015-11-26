/***
 * ModuloAdministracion.
 * 
 * JFrame que sirve como menú principal para acceder a todas las funciones del
 * módulo de administración del banco de alimentos.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import java.awt.*;
import javax.swing.*;

public class ModuloAdministracion extends javax.swing.JFrame {

    /**
     * ModuloAdministracion
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public ModuloAdministracion() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
    }

    /**
     * initComponents
     * 
     * Descripción: Método automáticamente generado por el IDE que inicializa
     * los componentes del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTituloModuloAdministracion = new javax.swing.JLabel();
        jLabelTituloMenuPrincipal = new javax.swing.JLabel();
        jButtonConsultarSaldosInstituciones = new javax.swing.JButton();
        jButtonConsultarSaldosInstituciones1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jLabelTituloModuloAdministracion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTituloModuloAdministracion.setText("Módulo de Administración");

        jLabelTituloMenuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloMenuPrincipal.setText("Menú Principal");

        jButtonConsultarSaldosInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonConsultarSaldosInstituciones.setText("Consultar Saldos de Instituciones");
        jButtonConsultarSaldosInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarSaldosInstitucionesActionPerformed(evt);
            }
        });

        jButtonConsultarSaldosInstituciones1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonConsultarSaldosInstituciones1.setText("Consultar Saldos de Instituciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabelTituloModuloAdministracion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabelTituloMenuPrincipal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonConsultarSaldosInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButtonConsultarSaldosInstituciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelTituloModuloAdministracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTituloMenuPrincipal)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultarSaldosInstituciones)
                    .addComponent(jButtonConsultarSaldosInstituciones1))
                .addContainerGap(398, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * jButtonConsultarSaldosInstitucionesActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón
     * "Consultar Saldos de Instituciones".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonConsultarSaldosInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarSaldosInstitucionesActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameListadoSaldosInstituciones = new ListadoSaldosInstituciones();
        jFrameListadoSaldosInstituciones.setVisible(true);
        
        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonConsultarSaldosInstitucionesActionPerformed

    /**
     * main
     * 
     * Descripción: Método principal que se llama si ésta es la clase inicial
     * del proyecto.
     * 
     * @param args: Los argumentos que se mandan por la línea de comandos.
     * @return N/A.
     */
    public static void main(String args[]) {
        // Establece el estilo Nimbus en el JFrame.
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
            java.util.logging.Logger.getLogger(ModuloAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // La forma se crea y se despliega.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultarSaldosInstituciones;
    private javax.swing.JButton jButtonConsultarSaldosInstituciones1;
    private javax.swing.JLabel jLabelTituloMenuPrincipal;
    private javax.swing.JLabel jLabelTituloModuloAdministracion;
    // End of variables declaration//GEN-END:variables
}
