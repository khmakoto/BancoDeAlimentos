/***
 * ModuloAdministracion
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
        jButtonRelacionDineroCaptadoInstituciones = new javax.swing.JButton();
        jButtonRelacionDineroNoCaptadoInstituciones = new javax.swing.JButton();
        jButtonRelacionMovimientosPorInstituciones = new javax.swing.JButton();
        jButtonAbonosInstituciones = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de Administración");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

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

        jButtonRelacionDineroCaptadoInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRelacionDineroCaptadoInstituciones.setText("Dinero Captado de Instituciones");
        jButtonRelacionDineroCaptadoInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionDineroCaptadoInstitucionesActionPerformed(evt);
            }
        });

        jButtonRelacionDineroNoCaptadoInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRelacionDineroNoCaptadoInstituciones.setText("Dinero No Captado de Instituciones");
        jButtonRelacionDineroNoCaptadoInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionDineroNoCaptadoInstitucionesActionPerformed(evt);
            }
        });

        jButtonRelacionMovimientosPorInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRelacionMovimientosPorInstituciones.setText("Movimientos por Instituciones");
        jButtonRelacionMovimientosPorInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionMovimientosPorInstitucionesActionPerformed(evt);
            }
        });

        jButtonAbonosInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAbonosInstituciones.setText("Abonos de instituciones");
        jButtonAbonosInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbonosInstitucionesActionPerformed(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(295, 295, 295)
                                .addComponent(jLabelTituloMenuPrincipal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabelTituloModuloAdministracion)))
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonConsultarSaldosInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRelacionDineroNoCaptadoInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRelacionDineroCaptadoInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRelacionMovimientosPorInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAbonosInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addGap(29, 29, 29)
                .addComponent(jLabelTituloModuloAdministracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTituloMenuPrincipal)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultarSaldosInstituciones)
                    .addComponent(jButtonRelacionDineroCaptadoInstituciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRelacionDineroNoCaptadoInstituciones)
                    .addComponent(jButtonRelacionMovimientosPorInstituciones))
                .addGap(82, 82, 82)
                .addComponent(jButtonAbonosInstituciones)
                .addGap(81, 81, 81))
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
     * jButtonRelacionDineroCaptadoInstitucionesActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón
     * "Dinero Captado de Instituciones".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonRelacionDineroCaptadoInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionDineroCaptadoInstitucionesActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameDineroCaptadoPorPeriodo = new DineroCaptadoPorPeriodo();
        jFrameDineroCaptadoPorPeriodo.setVisible(true);
        
        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonRelacionDineroCaptadoInstitucionesActionPerformed

    /**
     * jButtonRelacionDineroNoCaptadoInstitucionesActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón
     * "Dinero No Captado de Instituciones".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonRelacionDineroNoCaptadoInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionDineroNoCaptadoInstitucionesActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameDineroNoCaptadoPorPeriodo = new DineroNoCaptadoPorPeriodo();
        jFrameDineroNoCaptadoPorPeriodo.setVisible(true);
        
        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonRelacionDineroNoCaptadoInstitucionesActionPerformed

    /**
     * jButtonRelacionMovimientosPorInstitucionesActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón
     * "Movimientos por Instituciones".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonRelacionMovimientosPorInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionMovimientosPorInstitucionesActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameMovimientosPorInstituciones = new MovimientosPorInstituciones();
        jFrameMovimientosPorInstituciones.setVisible(true);
        
        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonRelacionMovimientosPorInstitucionesActionPerformed

    /**
     * jButtonRelacionAbonosInstitucionesActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón
     * "Abonos de Instituciones".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonAbonosInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbonosInstitucionesActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameAbonosInstituciones = new AbonosInstituciones();
        jFrameAbonosInstituciones.setVisible(true);
        
        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonAbonosInstitucionesActionPerformed

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
    private javax.swing.JButton jButtonAbonosInstituciones;
    private javax.swing.JButton jButtonConsultarSaldosInstituciones;
    private javax.swing.JButton jButtonRelacionDineroCaptadoInstituciones;
    private javax.swing.JButton jButtonRelacionDineroNoCaptadoInstituciones;
    private javax.swing.JButton jButtonRelacionMovimientosPorInstituciones;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTituloMenuPrincipal;
    private javax.swing.JLabel jLabelTituloModuloAdministracion;
    // End of variables declaration//GEN-END:variables
}
