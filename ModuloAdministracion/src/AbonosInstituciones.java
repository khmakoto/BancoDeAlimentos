/***
 * AbonosInstituciones
 * 
 * JFrame que permite al usuario visualizar los abonos de instituciones basados
 * en el folio del abono, la institución y el saldo.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import java.awt.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class AbonosInstituciones extends javax.swing.JFrame {

    // Se declara arreglo de IDs en que se guardarán IDs Instituciones.
    private String sIDInstituciones[];
    
    // Se declara variable para saber el viejo valor del text field.
    private String sViejoTextField = "";
    
    /**
     * AbonosInstituciones
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public AbonosInstituciones() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Modificación del estilo de los títulos de las columnas en la tabla.
        jTableAbonosInstituciones.getTableHeader().setFont(new Font("SegoeUI", Font.PLAIN, 18));
        ((DefaultTableCellRenderer)jTableAbonosInstituciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
        
        // Se establece la fecha de los ObservingTextFields como la fecha de hoy.
        SimpleDateFormat sdfFormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datFechaActual = new java.util.Date();
        jTextFieldFecha.setText(sdfFormatoFecha.format(datFechaActual));
        
        // Se obtiene información de la base de datos y se ponen en sus JComboBox correspondientes.
        informacionInstituciones();
        
        // Se llena la tabla con los valores iniciales.
        informacionTabla();
        
        // Se obtiene el folio a poner para el presente abono.
        informacionFolio();
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
                    sIDInstituciones = new String[iTamInstituciones];
                    
                    // Se ejecuta query para obtener cada Institución.
                    sSQLQuery = "SELECT IDInstitucion, Institucion FROM Instituciones";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se itera sobre los resultados y se agregan al arreglo.
                    while(rsResultados.next()){
                        String sInstitucion = rsResultados.getString("Institucion");
                        String sID = rsResultados.getString("IDInstitucion");
                        sInstituciones[iI] = sInstitucion;
                        sIDInstituciones[iI] = sID;
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
     * informacionTabla
     * 
     * Descripción: Método que obtiene la información de los movimientos para
     * la institución seleccionada y llena jTableAbonosInstituciones con ella.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void informacionTabla(){
        // Se obtiene el ID del JComboBox.
        String sIDInstitucion = sIDInstituciones[ jComboBoxInstitucion.getSelectedIndex() ];
        
        // Se declara la conexión.
        Connection conConexion = null;
 
        // Se programa todo dentro de un try para revisar si hay problemas.
        try {
            // Se establece la conexión a la base de datos.
            String sDataBaseURL = "jdbc:sqlserver://MAKOTO\\SQLEXPRESS;databaseName=BancoDeAlimentos;integratedSecurity=true;";
            conConexion = DriverManager.getConnection(sDataBaseURL);
            
            // Si no hubo errores de conexión.
            if (conConexion != null) {
                // Se ejecuta query para obtener los datos de los movimientos.
                Statement stmtEstatuto = conConexion.createStatement();
                String sSQLQuery = "SELECT IDFolio, IDArea, IDPrograma, Importe, Saldo, Abono, Bonificacion, Donativo, Incobrable "
                    + "FROM MovCarAbo WHERE "
                    + "IDInstitucion = '" + sIDInstitucion + "'";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Vector que servirá de modelo para la tabla.
                Vector vecData = new Vector();
                
                // Mientras hayan resultados.
                while(rsResultados.next()){
                    // Se inicializa vector donde se guardarán los datos.
                    Vector vecResultados = new Vector(9);       
                    
                    // Se guardan los resultados en el vector.
                    for(int iI = 1; iI <= 9; iI++){
                        vecResultados.addElement(rsResultados.getObject(iI));
                    }
                    
                    // Se guarda el vector en el vector de datos.
                    vecData.addElement(vecResultados);
                }
                
                // Se establece vector con nombres de columnas
                Vector vecNombresColumnas = new Vector();
                vecNombresColumnas.addElement("Folio Vale");
                vecNombresColumnas.addElement("Área");
                vecNombresColumnas.addElement("Programa");
                vecNombresColumnas.addElement("Cargo");
                vecNombresColumnas.addElement("Saldo");
                vecNombresColumnas.addElement("Abono");
                vecNombresColumnas.addElement("Bonificación");
                vecNombresColumnas.addElement("Donativo");
                vecNombresColumnas.addElement("Incobrable");
                
                // Se genera nuevo modelo para la tabla basado en el vector de datos.
                DefaultTableModel dtmModel = new DefaultTableModel(vecData, vecNombresColumnas);
                
                // Se pone el nuevo modelo en la tabla.
                jTableAbonosInstituciones.setModel(dtmModel);
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
     * informacionFolio
     * 
     * Descripción: Método que obtiene el máximo folio para poner el siguiente
     * en el campo de texto correspondiente.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void informacionFolio(){
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
                String sSQLQuery = "SELECT COUNT(*) AS tamanio FROM MovCarAbo";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Se obtiene si hubo o no resultados.
                rsResultados.next();
                int iResultados = rsResultados.getInt("tamanio");
                
                // Si hubo resultados.
                if(iResultados > 0){
                    // Se ejecuta query para obtener Folio mayor.
                    sSQLQuery = "SELECT TOP 1 IDMovCarAbo FROM MovCarAbo ORDER BY IDMovCarAbo DESC";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    // Se declara ID.
                    int iIDFolio = 0;
                    
                    // Si hubo resultados.
                    if(rsResultados.next()){
                        iIDFolio = rsResultados.getInt("IDMovCarAbo");
                    }
                    
                    // Se aumenta ID en 1 y se pasa a String.
                    iIDFolio++;
                    String sIDFolio = Integer.toString(iIDFolio);
                    
                    /* Se hace padding con ceros a la izquierda hasta tener la
                     * longitud adecuada. */
                    while(sIDFolio.length() != 10){
                        sIDFolio = "0" + sIDFolio;
                    }
                    
                    // Se pone el nuevo folio en el campo de folio.
                    jTextFieldFolioAbono.setText(sIDFolio);
                }
                
                // Si no hubo resultados.
                else{
                    // Se establece el folio uno para el jTextField.
                    jTextFieldFolioAbono.setText("0000000001");
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

        jLabelAbonoInstituciones = new javax.swing.JLabel();
        jPanelOpciones = new javax.swing.JPanel();
        jLabelFolioAbono = new javax.swing.JLabel();
        jTextFieldFolioAbono = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabelInstitucion = new javax.swing.JLabel();
        jComboBoxInstitucion = new javax.swing.JComboBox();
        jLabelSaldo = new javax.swing.JLabel();
        jTextFieldSaldo = new javax.swing.JTextField();
        jLabelTotalAbono = new javax.swing.JLabel();
        jTextFieldTotalAbono = new javax.swing.JTextField();
        jLabelTotalBonificación = new javax.swing.JLabel();
        jTextFieldBonificacion = new javax.swing.JTextField();
        jLabelTotalDonativo = new javax.swing.JLabel();
        jTextFieldDonativo = new javax.swing.JTextField();
        jLabelTotalIncobrable = new javax.swing.JLabel();
        jTextFieldIncobrable = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAbonosInstituciones = new javax.swing.JTable();
        jButtonAtrás = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abonos de Instituciones");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabelAbonoInstituciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelAbonoInstituciones.setText("Abonos de Instituciones");

        jPanelOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelFolioAbono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFolioAbono.setText("Folio Abono:");

        jTextFieldFolioAbono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldFolioAbono.setEnabled(false);

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFecha.setText("Fecha:");

        jTextFieldFecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldFecha.setEnabled(false);

        jLabelInstitucion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelInstitucion.setText("Institución:");

        jComboBoxInstitucion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxInstitucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstitucionActionPerformed(evt);
            }
        });

        jLabelSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelSaldo.setText("Saldo:");

        jTextFieldSaldo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldSaldo.setText("0.0");
        jTextFieldSaldo.setToolTipText("");
        jTextFieldSaldo.setEnabled(false);

        jLabelTotalAbono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTotalAbono.setText("Total Abono:");

        jTextFieldTotalAbono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldTotalAbono.setText("0.0");
        jTextFieldTotalAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTotalAbonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTotalAbonoKeyTyped(evt);
            }
        });

        jLabelTotalBonificación.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTotalBonificación.setText("Bonificación:");

        jTextFieldBonificacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldBonificacion.setText("0.0");
        jTextFieldBonificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBonificacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBonificacionKeyTyped(evt);
            }
        });

        jLabelTotalDonativo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTotalDonativo.setText("Donativo:");

        jTextFieldDonativo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldDonativo.setText("0.0");
        jTextFieldDonativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDonativoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDonativoKeyTyped(evt);
            }
        });

        jLabelTotalIncobrable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTotalIncobrable.setText("Incobrable:");

        jTextFieldIncobrable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldIncobrable.setText("0.0");
        jTextFieldIncobrable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIncobrableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIncobrableKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTotalIncobrable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldIncobrable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFolioAbono)
                            .addComponent(jLabelInstitucion)
                            .addComponent(jLabelSaldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                                    .addComponent(jTextFieldFolioAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabelFecha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBoxInstitucion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTotalAbono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTotalBonificación, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTotalDonativo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldBonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldTotalAbono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldDonativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFolioAbono)
                    .addComponent(jTextFieldFolioAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFecha)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalAbono)
                    .addComponent(jTextFieldTotalAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelInstitucion)
                            .addComponent(jComboBoxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSaldo)
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalBonificación)
                            .addComponent(jTextFieldBonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDonativo)
                            .addComponent(jTextFieldDonativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalIncobrable)
                    .addComponent(jTextFieldIncobrable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableAbonosInstituciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableAbonosInstituciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio Vale", "Área", "Programa", "Cargo", "Saldo", "Abono", "Bonificación", "Donativo", "Incobrable"
            }
        ));
        jTableAbonosInstituciones.setRowHeight(30);
        jTableAbonosInstituciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableAbonosInstituciones);

        jButtonAtrás.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAtrás.setText("Atrás");
        jButtonAtrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrásActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabelAbonoInstituciones))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButtonAtrás, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jButtonGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelAbonoInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtrás)
                    .addComponent(jButtonGuardar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * jButtonAtrasActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón de
     * "Atrás".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonAtrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrásActionPerformed
        // Se crea el JFrame de la ventana a generar y se establece como visible.
        JFrame jFrameModuloAdministracion = new ModuloAdministracion();
        jFrameModuloAdministracion.setVisible(true);

        // Se deshace el JFrame actual.
        this.dispose();
    }//GEN-LAST:event_jButtonAtrásActionPerformed

    /**
     * jComboBoxInstitucionActionPerformed
     * 
     * Descripción: Método que se inicializa al cambiar la selección del
     * JComboBoxInstitucion.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jComboBoxInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstitucionActionPerformed
        informacionTabla();
    }//GEN-LAST:event_jComboBoxInstitucionActionPerformed

    /**
     * jTextFieldTotalAbonoKeyReleased
     * 
     * Descripción: Método que se inicializa al soltar una tecla escribiendo en
     * el jTextFieldTotalAbono.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldTotalAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTotalAbonoKeyReleased
        // Si se dejó vacío el campo se escribe 0 en él.
        if(jTextFieldTotalAbono.getText().equals("")){
            jTextFieldTotalAbono.setText("0.0");
        }
        
        /* Se manda llamar método para revisar mediante una expresión regular
         * el valor del text field. */
        
        // Si es válido se suma el valor al saldo total.
        if(revisarValor(jTextFieldTotalAbono)){
            double dSaldo = 0;
            double dAbono = Double.parseDouble(jTextFieldTotalAbono.getText());
            double dBonificacion = Double.parseDouble(jTextFieldBonificacion.getText());
            double dDonativo = Double.parseDouble(jTextFieldDonativo.getText());
            double dIncobrable = Double.parseDouble(jTextFieldIncobrable.getText());
            
            dSaldo = dSaldo + dAbono + dBonificacion + dDonativo + dIncobrable;
            
            jTextFieldSaldo.setText(Double.toString(dSaldo));
        }
        
        /* Si no es válido se regresa el valor al que tenía antes y se manda un
         * mensaje indicando esto. */
        else{
            jTextFieldTotalAbono.setText(sViejoTextField);
            
            JOptionPane.showMessageDialog(this,
                    "Escribe un valor numérico válido.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldTotalAbonoKeyReleased

    /**
     * jTextFieldTotalAbonoKeyTyped
     * 
     * Descripción: Método que se inicializa al presionar una tecla escribiendo en
     * el jTextFieldTotalAbono.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldTotalAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTotalAbonoKeyTyped
        // Se establece el valor del viejo text field.
        sViejoTextField = jTextFieldTotalAbono.getText();
    }//GEN-LAST:event_jTextFieldTotalAbonoKeyTyped

    /**
     * jTextFieldBonificacionKeyReleased
     * 
     * Descripción: Método que se inicializa al soltar una tecla escribiendo en
     * el jTextFieldBonificacion.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldBonificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBonificacionKeyReleased
        // Si se dejó vacío el campo se escribe 0 en él.
        if(jTextFieldBonificacion.getText().equals("")){
            jTextFieldBonificacion.setText("0.0");
        }
        
        /* Se manda llamar método para revisar mediante una expresión regular
         * el valor del text field. */
        
        // Si es válido se suma el valor al saldo total.
        if(revisarValor(jTextFieldBonificacion)){
            double dSaldo = 0;
            double dAbono = Double.parseDouble(jTextFieldTotalAbono.getText());
            double dBonificacion = Double.parseDouble(jTextFieldBonificacion.getText());
            double dDonativo = Double.parseDouble(jTextFieldDonativo.getText());
            double dIncobrable = Double.parseDouble(jTextFieldIncobrable.getText());
            
            dSaldo = dSaldo + dAbono + dBonificacion + dDonativo + dIncobrable;
            
            jTextFieldSaldo.setText(Double.toString(dSaldo));
        }
        
        /* Si no es válido se regresa el valor al que tenía antes y se manda un
         * mensaje indicando esto. */
        else{
            jTextFieldBonificacion.setText(sViejoTextField);
            
            JOptionPane.showMessageDialog(this,
                    "Escribe un valor numérico válido.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldBonificacionKeyReleased

    /**
     * jTextFieldBonificacionKeyTyped
     * 
     * Descripción: Método que se inicializa al presionar una tecla escribiendo en
     * el jTextFieldBonificacion.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldBonificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBonificacionKeyTyped
        // Se establece el valor del viejo text field.
        sViejoTextField = jTextFieldBonificacion.getText();
    }//GEN-LAST:event_jTextFieldBonificacionKeyTyped

    /**
     * jTextFieldDonativoKeyReleased
     * 
     * Descripción: Método que se inicializa al soltar una tecla escribiendo en
     * el jTextFieldBonificacion.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldDonativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDonativoKeyReleased
        // Si se dejó vacío el campo se escribe 0 en él.
        if(jTextFieldDonativo.getText().equals("")){
            jTextFieldDonativo.setText("0.0");
        }
        
        /* Se manda llamar método para revisar mediante una expresión regular
         * el valor del text field. */
        
        // Si es válido se suma el valor al saldo total.
        if(revisarValor(jTextFieldDonativo)){
            double dSaldo = 0;
            double dAbono = Double.parseDouble(jTextFieldTotalAbono.getText());
            double dBonificacion = Double.parseDouble(jTextFieldBonificacion.getText());
            double dDonativo = Double.parseDouble(jTextFieldDonativo.getText());
            double dIncobrable = Double.parseDouble(jTextFieldIncobrable.getText());
            
            dSaldo = dSaldo + dAbono + dBonificacion + dDonativo + dIncobrable;
            
            jTextFieldSaldo.setText(Double.toString(dSaldo));
        }
        
        /* Si no es válido se regresa el valor al que tenía antes y se manda un
         * mensaje indicando esto. */
        else{
            jTextFieldDonativo.setText(sViejoTextField);
            
            JOptionPane.showMessageDialog(this,
                    "Escribe un valor numérico válido.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldDonativoKeyReleased

    /**
     * jTextFieldDonativoKeyTyped
     * 
     * Descripción: Método que se inicializa al presionar una tecla escribiendo en
     * el jTextFieldDonativo.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldDonativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDonativoKeyTyped
        // Se establece el valor del viejo text field.
        sViejoTextField = jTextFieldDonativo.getText();
    }//GEN-LAST:event_jTextFieldDonativoKeyTyped

    /**
     * jTextFieldIncobrableKeyReleased
     * 
     * Descripción: Método que se inicializa al soltar una tecla escribiendo en
     * el jTextFieldIncobrable.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldIncobrableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIncobrableKeyReleased
        // Si se dejó vacío el campo se escribe 0 en él.
        if(jTextFieldIncobrable.getText().equals("")){
            jTextFieldIncobrable.setText("0.0");
        }
        
        /* Se manda llamar método para revisar mediante una expresión regular
         * el valor del text field. */
        
        // Si es válido se suma el valor al saldo total.
        if(revisarValor(jTextFieldIncobrable)){
            double dSaldo = 0;
            double dAbono = Double.parseDouble(jTextFieldTotalAbono.getText());
            double dBonificacion = Double.parseDouble(jTextFieldBonificacion.getText());
            double dDonativo = Double.parseDouble(jTextFieldDonativo.getText());
            double dIncobrable = Double.parseDouble(jTextFieldIncobrable.getText());
            
            dSaldo = dSaldo + dAbono + dBonificacion + dDonativo + dIncobrable;
            
            jTextFieldSaldo.setText(Double.toString(dSaldo));
        }
        
        /* Si no es válido se regresa el valor al que tenía antes y se manda un
         * mensaje indicando esto. */
        else{
            jTextFieldIncobrable.setText(sViejoTextField);
            
            JOptionPane.showMessageDialog(this,
                    "Escribe un valor numérico válido.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldIncobrableKeyReleased

    /**
     * jTextFieldIncobrableKeyTyped
     * 
     * Descripción: Método que se inicializa al presionar una tecla escribiendo en
     * el jTextFieldIncobrable.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jTextFieldIncobrableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIncobrableKeyTyped
        // Se establece el valor del viejo text field.
        sViejoTextField = jTextFieldIncobrable.getText();
    }//GEN-LAST:event_jTextFieldIncobrableKeyTyped

    /**
     * jButtonGuardarActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón de
     * "Guardar".
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // Se obtiene el ID de la institución seleccionada.
        String sIDInstitucion = sIDInstituciones[ jComboBoxInstitucion.getSelectedIndex() ];
        
        // Se obtiene el ID del Folio.
        String sIDFolio = jTextFieldFolioAbono.getText();
        
        // Se obtiene ID de movimiento.
        int iIDMovCarAbo = Integer.parseInt(sIDFolio);
        
        // Se obtiene la fecha.
        String sFecha = jTextFieldFecha.getText();
        
        // Se obtienen los valores de los campos de texto.
        String sAbono = jTextFieldTotalAbono.getText();
        String sDonativo = jTextFieldDonativo.getText();
        String sBonificacion = jTextFieldBonificacion.getText();
        String sIncobrable = jTextFieldIncobrable.getText();
        String sSaldo = jTextFieldSaldo.getText();
        
        // Se declara la conexión.
        Connection conConexion = null;
 
        // Se programa todo dentro de un try para revisar si hay problemas.
        try {
            // Se establece la conexión a la base de datos.
            String sDataBaseURL = "jdbc:sqlserver://MAKOTO\\SQLEXPRESS;databaseName=BancoDeAlimentos;integratedSecurity=true;";
            conConexion = DriverManager.getConnection(sDataBaseURL);
            
            // Si no hubo errores de conexión.
            if (conConexion != null) {
                // Se ejecuta query para insertar movimiento.
                Statement stmtEstatuto = conConexion.createStatement();
                String sSQLQuery = "INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, "
                    + "IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, "
                    + "Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, "
                    + "Incobrable) VALUES (" + Integer.toString(iIDMovCarAbo) + ", "
                    + "'" + sIDInstitucion + "', '000001', '000001', '" + sIDFolio + "', "
                    + "'Abono', '" + sIDFolio + "', '" + sFecha + "', 0, "
                    + sAbono + ", NULL, 'Pagado', " + sSaldo + ", " + sBonificacion + ", "
                    + sDonativo + ", " + sIncobrable + ")";
                
                stmtEstatuto.executeUpdate(sSQLQuery);
                
                // Se recarga la tabla.
                informacionTabla();
                
                // Se recarga ID de Folio.
                informacionFolio();
            }
        }
        
        /* Si hubo alguna excepción de SQL se manda mensaje indicándolo y se
         * imprime la traza programática. */
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al insertar datos.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jButtonGuardarActionPerformed

     /**
     * revisarValor
     * 
     * Descripción: Revisa el valor del JTextField para ver si es un valor
     * numérico válido.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private boolean revisarValor(JTextField jTextFieldActual){
        // Se obtiene nuevo valor del text field.
        String sNuevoTextField = jTextFieldActual.getText();
        
        // Se compara para ver si es o no un número válido.
        int iI = 0;
        int iLength = sNuevoTextField.length();
        while(iI < iLength && sNuevoTextField.charAt(iI) >= '0' &&
            sNuevoTextField.charAt(iI) <= '9'){
            iI++;
        }
        
        // Si es un entero se regresa true;
        if(iI == iLength){
            return true;
        }
        
        // Se revisa si tiene a lo más dos decimales y si estos son válidos.
        if(sNuevoTextField.charAt(iI) == '.'){
            iI++;
            if(iLength - iI <= 2){
                while(iI < iLength){
                    if(sNuevoTextField.charAt(iI) < '0' ||
                        sNuevoTextField.charAt(iI) > '9'){
                        return false;
                    }
                    iI++;
                }
                return true;
            }
            else{
                return false;
            }
        }
        
        // Si tiene algún valor inválido se regresa false.
        else{
            return false;
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
            java.util.logging.Logger.getLogger(AbonosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbonosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbonosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbonosInstituciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbonosInstituciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtrás;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox jComboBoxInstitucion;
    private javax.swing.JLabel jLabelAbonoInstituciones;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFolioAbono;
    private javax.swing.JLabel jLabelInstitucion;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTotalAbono;
    private javax.swing.JLabel jLabelTotalBonificación;
    private javax.swing.JLabel jLabelTotalDonativo;
    private javax.swing.JLabel jLabelTotalIncobrable;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAbonosInstituciones;
    private javax.swing.JTextField jTextFieldBonificacion;
    private javax.swing.JTextField jTextFieldDonativo;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldFolioAbono;
    private javax.swing.JTextField jTextFieldIncobrable;
    private javax.swing.JTextField jTextFieldSaldo;
    private javax.swing.JTextField jTextFieldTotalAbono;
    // End of variables declaration//GEN-END:variables
}
