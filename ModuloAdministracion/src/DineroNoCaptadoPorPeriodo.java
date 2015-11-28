/***
 * DineroNoCaptadoPorPeriodo
 * 
 * JFrame que permite al usuario generar un reporte del dinero no captado de
 * instituciones dependiendo de su elección de Fecha de inicio y término, Área,
 * Programa e Instituciones.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class DineroNoCaptadoPorPeriodo extends javax.swing.JFrame {

    /* Se declaran arreglos de IDs en que se guardarán IDs de Áreas, Programas e
     * Instituciones. */
    private String sIDAreas[];
    private String sIDProgramas[];
    
    /**
     * DineroNoCaptadoPorPeriodo
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public DineroNoCaptadoPorPeriodo() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
        
        // Se obtiene información de la base de datos y se ponen en sus JComboBox correspondientes.
        informacionAreas();
        informacionProgramas();
    }

    /**
     * informacionAreas
     * 
     * Descripción: Método que obtiene la información de todas las áreas guardadas
     * en la base de datos y carga con esto el JComboBox correspondiente.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void informacionAreas(){
        // Se declara la conexión.
        Connection conConexion = null;
 
        // Se programa todo dentro de un try para revisar si hay problemas.
        try {
            // Se establece la conexión a la base de datos.
            String sDataBaseURL = "jdbc:sqlserver://MAKOTO\\SQLEXPRESS;databaseName=BancoDeAlimentos;integratedSecurity=true;";
            conConexion = DriverManager.getConnection(sDataBaseURL);
            
            // Si no hubo errores de conexión.
            if (conConexion != null) {
                // Se ejecuta query para saber el tamaño del JComboBox.
                Statement stmtEstatuto = conConexion.createStatement();
                String sSQLQuery = "SELECT COUNT(*) AS tamanio FROM Areas";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Si hubo resultados.
                if(rsResultados.next()){
                    // Se crea arreglo que servirá como modelo del JComboBox.
                    int iTamAreas = rsResultados.getInt("tamanio");
                    int iI = 0;
                    String sAreas[] = new String[iTamAreas];
                    sIDAreas = new String[iTamAreas];
                    
                    // Se ejecuta query para obtener cada Área.
                    sSQLQuery = "SELECT IDArea, Area FROM Areas";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sArea = rsResultados.getString("Area");
                        String sID = rsResultados.getString("IDArea");
                        sAreas[iI] = sArea;
                        sIDAreas[iI] = sID;
                        iI++;
                    }
                    
                    // Se establece el arreglo generado como modelo del JComboBox.
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sAreas);
                    jComboBoxArea.setModel(cbmModelo);
                }
                
                // Si no hubo resultados.
                else{
                    // Se establece un arreglo vacío.
                    String sAreas[] = new String[1];
                    sAreas[0] = "---";
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sAreas);
                    jComboBoxArea.setModel(cbmModelo);
                }
            }
 
        }
        
        // Si hubo alguna excepción de SQL se imprime la traza programática de ésta.
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        // Independientemente de si hubo conexión o no.
        finally {
            // Se cierra la conexión a la base de datos si estaba abierta.
            try {
                if (conConexion != null && !conConexion.isClosed()) {
                    conConexion.close();
                }
            }
            
            /* Si hubo alguna excepción de SQL se imprime la traza programática
             * de ésta. */
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * informacionProgramas
     * 
     * Descripción: Método que obtiene la información de todos los programas guardados
     * en la base de datos y carga con esto el JComboBox correspondiente.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void informacionProgramas(){
        // Se declara la conexión.
        Connection conConexion = null;
 
        // Se programa todo dentro de un try para revisar si hay problemas.
        try {
            // Se establece la conexión a la base de datos.
            String sDataBaseURL = "jdbc:sqlserver://MAKOTO\\SQLEXPRESS;databaseName=BancoDeAlimentos;integratedSecurity=true;";
            conConexion = DriverManager.getConnection(sDataBaseURL);
            
            // Si no hubo errores de conexión.
            if (conConexion != null) {
                // Se ejecuta query para saber el tamaño del JComboBox.
                Statement stmtEstatuto = conConexion.createStatement();
                String sSQLQuery = "SELECT COUNT(*) AS tamanio FROM Programas";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Si hubo resultados.
                if(rsResultados.next()){
                    // Se crea arreglo que servirá como modelo del JComboBox.
                    int iTamProgramas = rsResultados.getInt("tamanio");
                    int iI = 0;
                    String sProgramas[] = new String[iTamProgramas];
                    sIDProgramas = new String[iTamProgramas];
                    
                    // Se ejecuta query para obtener cada Programa.
                    sSQLQuery = "SELECT IDPrograma, Programa FROM Programas";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sPrograma = rsResultados.getString("Programa");
                        String sID = rsResultados.getString("IDPrograma");
                        sProgramas[iI] = sPrograma;
                        sIDProgramas[iI] = sID;
                        iI++;
                    }
                    
                    // Se establece el arreglo generado como modelo del JComboBox.
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sProgramas);
                    jComboBoxPrograma.setModel(cbmModelo);
                }
                
                // Si no hubo resultados.
                else{
                    // Se establece un arreglo vacío.
                    String sProgramas[] = new String[1];
                    sProgramas[0] = "---";
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sProgramas);
                    jComboBoxPrograma.setModel(cbmModelo);
                }
            }
 
        }
        
        // Si hubo alguna excepción de SQL se imprime la traza programática de ésta.
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        // Independientemente de si hubo conexión o no.
        finally {
            // Se cierra la conexión a la base de datos si estaba abierta.
            try {
                if (conConexion != null && !conConexion.isClosed()) {
                    conConexion.close();
                }
            }
            
            /* Si hubo alguna excepción de SQL se imprime la traza programática
             * de ésta. */
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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

        jLabelTituloRelacionDineroNoCaptadoInstituciones = new javax.swing.JLabel();
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
        jPanelInstituciones = new javax.swing.JPanel();
        jLabelInstituciones = new javax.swing.JLabel();
        jComboBoxInstituciones = new javax.swing.JComboBox();
        jButtonAtras = new javax.swing.JButton();
        jButtonGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relación de Dinero No Captado de Instituciones");
        setResizable(false);

        jLabelTituloRelacionDineroNoCaptadoInstituciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloRelacionDineroNoCaptadoInstituciones.setText("Relación de Dinero No Captado por Instituciones");

        jPanelFechas.setBorder(new javax.swing.border.SoftBevelBorder(0));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(observingTextFieldFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFechaInicial))
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabelFechaInicial)))
                .addGap(143, 143, 143)
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFechasLayout.createSequentialGroup()
                        .addComponent(observingTextFieldFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFechaFinal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabelFechaFinal)
                        .addGap(39, 39, 39)))
                .addGap(152, 152, 152))
        );
        jPanelFechasLayout.setVerticalGroup(
            jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addComponent(jLabelFechaInicial)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFechaInicial)
                            .addComponent(observingTextFieldFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelFechaFinal)
                    .addGroup(jPanelFechasLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFechaFinal)
                            .addComponent(observingTextFieldFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelAreaPrograma.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabelArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelArea.setText("Área:");

        jComboBoxArea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelPrograma.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPrograma.setText("Programa:");

        jComboBoxPrograma.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelAreaProgramaLayout = new javax.swing.GroupLayout(jPanelAreaPrograma);
        jPanelAreaPrograma.setLayout(jPanelAreaProgramaLayout);
        jPanelAreaProgramaLayout.setHorizontalGroup(
            jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                        .addComponent(jLabelPrograma)
                        .addGap(24, 24, 24)
                        .addComponent(jComboBoxPrograma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                        .addComponent(jLabelArea)
                        .addGap(66, 66, 66)
                        .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanelAreaProgramaLayout.setVerticalGroup(
            jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaProgramaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArea)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAreaProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrograma)
                    .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelInstituciones.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabelInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelInstituciones.setText("Instituciones:");

        jComboBoxInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxInstituciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelInstitucionesLayout = new javax.swing.GroupLayout(jPanelInstituciones);
        jPanelInstituciones.setLayout(jPanelInstitucionesLayout);
        jPanelInstitucionesLayout.setHorizontalGroup(
            jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                .addGroup(jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jComboBoxInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabelInstituciones)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInstitucionesLayout.setVerticalGroup(
            jPanelInstitucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstitucionesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTituloRelacionDineroNoCaptadoInstituciones)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(jButtonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelTituloRelacionDineroNoCaptadoInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jPanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
        java.util.Date datSelectedDate = dpDatePicker.parseDate(observingTextFieldFechaInicial.getText());
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
        java.util.Date datSelectedDate = dpDatePicker.parseDate(observingTextFieldFechaFinal.getText());
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
            java.util.logging.Logger.getLogger(DineroNoCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DineroNoCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DineroNoCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DineroNoCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // La forma se crea y se despliega.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DineroNoCaptadoPorPeriodo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonFechaFinal;
    private javax.swing.JButton jButtonFechaInicial;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxInstituciones;
    private javax.swing.JComboBox jComboBoxPrograma;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelFechaFinal;
    private javax.swing.JLabel jLabelFechaInicial;
    private javax.swing.JLabel jLabelInstituciones;
    private javax.swing.JLabel jLabelPrograma;
    private javax.swing.JLabel jLabelTituloRelacionDineroNoCaptadoInstituciones;
    private javax.swing.JPanel jPanelAreaPrograma;
    private javax.swing.JPanel jPanelFechas;
    private javax.swing.JPanel jPanelInstituciones;
    private ObservingTextField observingTextFieldFechaFinal;
    private ObservingTextField observingTextFieldFechaInicial;
    // End of variables declaration//GEN-END:variables
}
