/***
 * ListadoSaldosInstituciones
 * 
 * JFrame que permite al usuario listar los saldos a instituciones dependiendo
 * de su elección de Área, Programa e Institución.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ListadoSaldosInstituciones extends javax.swing.JFrame {

    /**
     * ListadoSaldosInstituciones
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public ListadoSaldosInstituciones() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Modificación del estilo de los títulos de las columnas en la tabla.
        jTableSaldosInstituciones.getTableHeader().setFont(new Font("SegoeUI", Font.PLAIN, 18));
        ((DefaultTableCellRenderer)jTableSaldosInstituciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
        
        // Se obtiene información de la base de datos y se ponen en sus JComboBox correspondientes.
        informacionAreas();
        informacionProgramas();
        informacionInstituciones();
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
                    
                    // Se ejecuta query para obtener cada Área.
                    sSQLQuery = "SELECT Area FROM Areas";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sArea = rsResultados.getString("Area");
                        sAreas[iI] = sArea;
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
                    
                    // Se ejecuta query para obtener cada Programa.
                    sSQLQuery = "SELECT Programa FROM Programas";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sPrograma = rsResultados.getString("Programa");
                        sProgramas[iI] = sPrograma;
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
     * informacionInstituciones
     * 
     * Descripción: Método que obtiene la información de todas los instituciones guardadas
     * en la base de datos y carga con esto el JComboBox correspondiente.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void informacionInstituciones(){
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
                String sSQLQuery = "SELECT COUNT(*) AS tamanio FROM Instituciones";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Si hubo resultados.
                if(rsResultados.next()){
                    // Se crea arreglo que servirá como modelo del JComboBox.
                    int iTamInstituciones = rsResultados.getInt("tamanio");
                    int iI = 0;
                    String sInstituciones[] = new String[iTamInstituciones];
                    
                    // Se ejecuta query para obtener cada Institución.
                    sSQLQuery = "SELECT Institucion FROM Instituciones";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sInstitucion = rsResultados.getString("Institucion");
                        sInstituciones[iI] = sInstitucion;
                        iI++;
                    }
                    
                    // Se establece el arreglo generado como modelo del JComboBox.
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sInstituciones);
                    jComboBoxInstitucion.setModel(cbmModelo);
                }
                
                // Si no hubo resultados.
                else{
                    // Se establece un arreglo vacío.
                    String sInstituciones[] = new String[1];
                    sInstituciones[0] = "---";
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sInstituciones);
                    jComboBoxInstitucion.setModel(cbmModelo);
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

        jPanelOpciones = new javax.swing.JPanel();
        jLabelArea = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox();
        jLabelPrograma = new javax.swing.JLabel();
        jComboBoxInstitucion = new javax.swing.JComboBox();
        jLabelInstitucion = new javax.swing.JLabel();
        jComboBoxPrograma = new javax.swing.JComboBox();
        jButtonAtras = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSaldosInstituciones = new javax.swing.JTable();
        jLabelTituloSaldosInstituciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Saldos de Instituciones");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanelOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelOpciones.setMaximumSize(new java.awt.Dimension(750, 180));
        jPanelOpciones.setMinimumSize(new java.awt.Dimension(750, 180));
        jPanelOpciones.setPreferredSize(new java.awt.Dimension(750, 180));

        jLabelArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelArea.setText("Área");

        jComboBoxArea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelPrograma.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPrograma.setText("Programa");

        jComboBoxInstitucion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxInstitucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelInstitucion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelInstitucion.setText("Institución");

        jComboBoxPrograma.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabelArea)))
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jComboBoxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabelPrograma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelInstitucion)
                        .addGap(117, 117, 117))))
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArea)
                    .addComponent(jLabelPrograma)
                    .addComponent(jLabelInstitucion))
                .addGap(18, 18, 18)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTableSaldosInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableSaldosInstituciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Institución", "Área", "Programa", "FolCarAbo", "Folio", "Fecha", "Cargo", "Abono", "Saldo"
            }
        ));
        jTableSaldosInstituciones.setEnabled(false);
        jTableSaldosInstituciones.setRowHeight(30);
        jTableSaldosInstituciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableSaldosInstituciones);

        jLabelTituloSaldosInstituciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloSaldosInstituciones.setText("Consultar Saldos de Instituciones");
        jLabelTituloSaldosInstituciones.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabelTituloSaldosInstituciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelTituloSaldosInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * jButtonAtrasActionPerformed
     * 
     * Descripción: Método que se ejecuta al hacer click en el botón de "Atrás".
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
            java.util.logging.Logger.getLogger(ListadoSaldosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoSaldosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoSaldosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoSaldosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // La forma se crea y se despliega.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoSaldosInstituciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxInstitucion;
    private javax.swing.JComboBox jComboBoxPrograma;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelInstitucion;
    private javax.swing.JLabel jLabelPrograma;
    private javax.swing.JLabel jLabelTituloSaldosInstituciones;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSaldosInstituciones;
    // End of variables declaration//GEN-END:variables
}
