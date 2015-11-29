/***
 * MovimientosPorInstituciones
 * 
 * JFrame que permite al usuario generar un reporte de los movimientos por
 * instituciones dependiendo de su elección de Fecha de inicio y término, Área,
 * Programa, Subárea, Instituciones y estatus de movimientos.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class MovimientosPorInstituciones extends javax.swing.JFrame {

    /**
     * MovimientosPorInstituciones
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public MovimientosPorInstituciones() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
        
        // Se establece la fecha de los ObservingTextFields como la fecha de hoy.
        SimpleDateFormat sdfFormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datFechaActual = new java.util.Date();
        observingTextFieldFechaInicial.setText(sdfFormatoFecha.format(datFechaActual));
        observingTextFieldFechaFinal.setText(sdfFormatoFecha.format(datFechaActual));
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

        jLabelTituloRelacionMovimientosPorInstituciones = new javax.swing.JLabel();
        jPanelFechas = new javax.swing.JPanel();
        jLabelFechaInicial = new javax.swing.JLabel();
        observingTextFieldFechaInicial = new ObservingTextField();
        jButtonFechaInicial = new javax.swing.JButton();
        observingTextFieldFechaFinal = new ObservingTextField();
        jButtonFechaFinal = new javax.swing.JButton();
        jLabelFechaFinal = new javax.swing.JLabel();
        jPanelAreaPrograma = new javax.swing.JPanel();
        jLabelArea = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox();
        jLabelPrograma = new javax.swing.JLabel();
        jComboBoxPrograma = new javax.swing.JComboBox();
        jLabelSubarea = new javax.swing.JLabel();
        jComboBoxSubarea = new javax.swing.JComboBox();
        jPanelEstatusDeMovimientos = new javax.swing.JPanel();
        jLabelEstatusMovimientos = new javax.swing.JLabel();
        jComboBoxEstatusMovimientos = new javax.swing.JComboBox();
        jPanelInstituciones = new javax.swing.JPanel();
        jLabelInstituciones3 = new javax.swing.JLabel();
        jComboBoxInstituciones3 = new javax.swing.JComboBox();
        jButtonAtras = new javax.swing.JButton();
        jButtonGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relación de Movimientos por Instituciones");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabelTituloRelacionMovimientosPorInstituciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloRelacionMovimientosPorInstituciones.setText("Relación de Movimientos por Instituciones");

        jPanelFechas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelFechaInicial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFechaInicial.setText("Fecha Inicial:");

        observingTextFieldFechaInicial.setEnabled(false);
        observingTextFieldFechaInicial.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButtonFechaInicial.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonFechaInicial.setText("...");
        jButtonFechaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechaInicialActionPerformed(evt);
            }
        });

        observingTextFieldFechaFinal.setEnabled(false);
        observingTextFieldFechaFinal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButtonFechaFinal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonFechaFinal.setText("...");
        jButtonFechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechaFinalActionPerformed(evt);
            }
        });

        jLabelFechaFinal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFechaFinal.setText("Fecha Final:");

        javax.swing.GroupLayout jPanelFechasLayout = new javax.swing.GroupLayout(jPanelFechas);
        jPanelFechas.setLayout(jPanelFechasLayout);
        jPanelFechasLayout.setHorizontalGroup(
            jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechasLayout.createSequentialGroup()
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabelFechaInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(observingTextFieldFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFechaInicial)
                        .addGap(154, 154, 154)))
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabelFechaFinal)
                        .addGap(39, 39, 39))
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(observingTextFieldFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFechaFinal)))
                .addGap(152, 152, 152))
        );
        jPanelFechasLayout.setVerticalGroup(
            jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabelFechaInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(observingTextFieldFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFechaInicial)))
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabelFechaFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFechaFinal)
                            .addComponent(observingTextFieldFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAreaPrograma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelArea.setText("Área:");

        jComboBoxArea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelPrograma.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPrograma.setText("Programa:");

        jComboBoxPrograma.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSubarea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelSubarea.setText("Subárea:");

        jComboBoxSubarea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxSubarea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelAreaProgramaLayout = new javax.swing.GroupLayout(jPanelAreaPrograma);
        jPanelAreaPrograma.setLayout(jPanelAreaProgramaLayout);
        jPanelAreaProgramaLayout.setHorizontalGroup(
            jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaProgramaLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaProgramaLayout.createSequentialGroup()
                        .addComponent(jLabelArea)
                        .addGap(66, 66, 66)
                        .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                        .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrograma)
                            .addComponent(jLabelSubarea))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSubarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxPrograma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        jPanelAreaProgramaLayout.setVerticalGroup(
            jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArea)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrograma)
                    .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubarea)
                    .addComponent(jComboBoxSubarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEstatusDeMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelEstatusMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEstatusMovimientos.setText("Estatus de Movimientos:");

        jComboBoxEstatusMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxEstatusMovimientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelEstatusDeMovimientosLayout = new javax.swing.GroupLayout(jPanelEstatusDeMovimientos);
        jPanelEstatusDeMovimientos.setLayout(jPanelEstatusDeMovimientosLayout);
        jPanelEstatusDeMovimientosLayout.setHorizontalGroup(
            jPanelEstatusDeMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstatusDeMovimientosLayout.createSequentialGroup()
                .addGroup(jPanelEstatusDeMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstatusDeMovimientosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jComboBoxEstatusMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstatusDeMovimientosLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabelEstatusMovimientos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEstatusDeMovimientosLayout.setVerticalGroup(
            jPanelEstatusDeMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstatusDeMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEstatusMovimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEstatusMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInstituciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelInstituciones3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelInstituciones3.setText("Instituciones:");

        jComboBoxInstituciones3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxInstituciones3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelInstitucionesLayout = new javax.swing.GroupLayout(jPanelInstituciones);
        jPanelInstituciones.setLayout(jPanelInstitucionesLayout);
        jPanelInstitucionesLayout.setHorizontalGroup(
            jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                .addGroup(jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jComboBoxInstituciones3, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabelInstituciones3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInstitucionesLayout.setVerticalGroup(
            jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInstituciones3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxInstituciones3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonGenerarReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonGenerarReporte.setText("<html>\nGenerar<br/>\nReporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelEstatusDeMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jButtonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabelTituloRelacionMovimientosPorInstituciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelTituloRelacionMovimientosPorInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jPanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelEstatusDeMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * jButtonFechaInicialActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón del
     * DatePicker de "Fecha Inicial".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonFechaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechaInicialActionPerformed
        // Se obtiene la fecha actual.
        String sLang = null;
        final Locale locLocale = getLocale(sLang);

        /* Se genera el nuevo date picker, ligándolo al Observing Text Field
        * deseado y estableciéndole la fecha elegida. */
        DatePicker dpDatePicker = new DatePicker(observingTextFieldFechaInicial, locLocale);
        Date datSelectedDate = dpDatePicker.parseDate(observingTextFieldFechaInicial.getText());
        dpDatePicker.setSelectedDate(datSelectedDate);
        dpDatePicker.start(observingTextFieldFechaInicial);
    }//GEN-LAST:event_jButtonFechaInicialActionPerformed

    /**
     * jButtonFechaFinallActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón del
     * DatePicker de "Fecha Final".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonFechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechaFinalActionPerformed
        // Se obtiene la fecha actual.
        String sLang = null;
        final Locale locLocale = getLocale(sLang);

        /* Se genera el nuevo date picker, ligándolo al Observing Text Field
        * deseado y estableciéndole la fecha elegida. */
        DatePicker dpDatePicker = new DatePicker(observingTextFieldFechaFinal, locLocale);
        Date datSelectedDate = dpDatePicker.parseDate(observingTextFieldFechaFinal.getText());
        dpDatePicker.setSelectedDate(datSelectedDate);
        dpDatePicker.start(observingTextFieldFechaFinal);
    }//GEN-LAST:event_jButtonFechaFinalActionPerformed

    /**
     * jButtonAtrasActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón de
     * "Atrás".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameModuloAdministracion = new ModuloAdministracion();
        jFrameModuloAdministracion.setVisible(true);

        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    /**
     * getLocale
     * 
     * Descripción: Método usado por el DatePicker para obtener la fecha actual.
     * 
     * @param evt: String que guarda la Locale actual.
     * @return Locale: Regresa la zona horaria de la computadora.
     */
    private Locale getLocale(String sLoc) {
        if(sLoc != null && sLoc.length() > 0) {
            return new Locale(sLoc);
        }
        else {
            return Locale.US;
        }
    }
    
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
            java.util.logging.Logger.getLogger(MovimientosPorInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosPorInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosPorInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosPorInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // La forma se crea y se despliega.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosPorInstituciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonFechaFinal;
    private javax.swing.JButton jButtonFechaInicial;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxEstatusMovimientos;
    private javax.swing.JComboBox jComboBoxInstituciones3;
    private javax.swing.JComboBox jComboBoxPrograma;
    private javax.swing.JComboBox jComboBoxSubarea;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelEstatusMovimientos;
    private javax.swing.JLabel jLabelFechaFinal;
    private javax.swing.JLabel jLabelFechaInicial;
    private javax.swing.JLabel jLabelInstituciones3;
    private javax.swing.JLabel jLabelPrograma;
    private javax.swing.JLabel jLabelSubarea;
    private javax.swing.JLabel jLabelTituloRelacionMovimientosPorInstituciones;
    private javax.swing.JPanel jPanelAreaPrograma;
    private javax.swing.JPanel jPanelEstatusDeMovimientos;
    private javax.swing.JPanel jPanelFechas;
    private javax.swing.JPanel jPanelInstituciones;
    private ObservingTextField observingTextFieldFechaFinal;
    private ObservingTextField observingTextFieldFechaInicial;
    // End of variables declaration//GEN-END:variables
}
