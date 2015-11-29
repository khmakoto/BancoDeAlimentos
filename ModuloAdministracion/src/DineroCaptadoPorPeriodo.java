/***
 * DineroCaptadoPorPeriodo
 * 
 * JFrame que permite al usuario generar un reporte del dinero captado de
 * instituciones dependiendo de su elección de Fecha de inicio y término, Área,
 * Programa e Instituciones.
 * 
 * @author Humberto Makoto Morimoto Burgos      A01280458
 * @author Oscar Abraham González Quintanilla   A01195653
 * @author Marcel Benítez Martínez              A01139855
 * @author Marco Antonio Ramírez Alarcón        A01191344
 * @author Ricardo Pérez Pérez                  A01035082
 */

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class DineroCaptadoPorPeriodo extends javax.swing.JFrame {

    /* Se declaran arreglos de IDs en que se guardarán IDs de Áreas, Programas e
     * Instituciones. */
    private String sIDAreas[];
    private String sIDProgramas[];
    private String sIDInstituciones[];
    
    /**
     * DineroCaptadoPorPeriodo
     * 
     * Descripción: Método constructor que establece las condiciones iniciales
     * del JFrame.
     * 
     * @param N/A.
     * @return N/A.
     */
    public DineroCaptadoPorPeriodo() {
        /* Se manda llamar método automáticamente generado por IDE para
         * establecer las condiciones iniciales del JFrame. */
        initComponents();
        
        // Acción para hacer que la ventana aparezca en el centro de la pantalla.
        Dimension dimDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimDimension.width / 2 - this.getSize().width / 2, dimDimension.height / 2 - this.getSize().height / 2);
        
        // Se obtiene información de la base de datos y se ponen en sus JComboBox correspondientes.
        informacionAreas();
        informacionProgramas();
        informacionInstituciones();
        
        // Se establece la fecha de los ObservingTextFields como la fecha de hoy.
        SimpleDateFormat sdfFormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datFechaActual = new java.util.Date();
        observingTextFieldFechaInicial.setText(sdfFormatoFecha.format(datFechaActual));
        observingTextFieldFechaFinal.setText(sdfFormatoFecha.format(datFechaActual));
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
                    jComboBoxInstituciones.setModel(cbmModelo);
                }
                
                // Si no hubo resultados.
                else{
                    // Se establece un arreglo vacío.
                    String sInstituciones[] = new String[1];
                    sInstituciones[0] = "---";
                    DefaultComboBoxModel cbmModelo = new DefaultComboBoxModel(sInstituciones);
                    jComboBoxInstituciones.setModel(cbmModelo);
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

        jLabelTituloRelacionDineroCaptadoInstituciones = new javax.swing.JLabel();
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
        jButtonGenerarPDF = new javax.swing.JButton();
        jButtonGenerarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relación de Dinero Captado de Instituciones");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabelTituloRelacionDineroCaptadoInstituciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloRelacionDineroCaptadoInstituciones.setText("Relación de Dinero Captado de Instituciones");

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

        jPanelAreaPrograma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(31, Short.MAX_VALUE)
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

        jPanelInstituciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jButtonGenerarPDF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonGenerarPDF.setText("<html> <center>Generar<br/> PDF</center>");
        jButtonGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarPDFActionPerformed(evt);
            }
        });

        jButtonGenerarExcel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonGenerarExcel.setText("<html> <center>Generar<br/> Excel</center>");
        jButtonGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jButtonGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jButtonGenerarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabelTituloRelacionDineroCaptadoInstituciones)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelTituloRelacionDineroCaptadoInstituciones)
                .addGap(18, 18, 18)
                .addComponent(jPanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAreaPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGenerarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
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
     * jButtonGenerarPDFActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón de
     * "Generar PDF". Genera un archivo PDF de acuerdo a las especificaciones
     * establecidas.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarPDFActionPerformed
        /* Se pone el código en medio de un try para atrapar excepciones en el
         * parse de las fechas. */
        try {
            // Se obtienen las fechas inicial y final para comparar.
            SimpleDateFormat sdfFormato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datFechaInicial = sdfFormato.parse(observingTextFieldFechaInicial.getText());
            java.util.Date datFechaFinal = sdfFormato.parse(observingTextFieldFechaFinal.getText());
            
            // Si la fecha final es mayor a la inicial.
            if(datFechaFinal.after(datFechaInicial)){
                // Se atrapan excepciones de Archivos y Documentos.
                try {
                    // Se manda generar el archivo PDF.
                    generarPDF();
                }
                catch (FileNotFoundException ex) {
                    System.out.println("Excepción: Archivo no encontrado.");
                }
                catch (DocumentException ex) {
                    System.out.println("Excepción en el documento PDF.");
                }
            }
            
            // Si la fecha final es menor o igual a la inicial.
            else{
                // Se genera una alerta indicando esto.
                JOptionPane.showMessageDialog(this,
                    "Elige una fecha final que sea mayor a la inicial.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        // Si hubo una excepción se marca en consola.
        catch (ParseException ex) {
            System.out.println("Excepción de parsing de fechas.");
        }
    }//GEN-LAST:event_jButtonGenerarPDFActionPerformed

    /**
     * jButtonGenerarExcelActionPerformed
     * 
     * Descripción: Método que se inicializa al hacer click en el botón de
     * "Generar Excel". Genera un archivo CSV de acuerdo a las especificaciones
     * establecidas.
     * 
     * @param evt: Evento que mandó llamar al método.
     * @return N/A.
     */
    private void jButtonGenerarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarExcelActionPerformed
         /* Se pone el código en medio de un try para atrapar excepciones en el
         * parse de las fechas. */
        try {
            // Se obtienen las fechas inicial y final para comparar.
            SimpleDateFormat sdfFormato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datFechaInicial = sdfFormato.parse(observingTextFieldFechaInicial.getText());
            java.util.Date datFechaFinal = sdfFormato.parse(observingTextFieldFechaFinal.getText());
            
            // Si la fecha final es mayor a la inicial.
            if(datFechaFinal.after(datFechaInicial)){
            }
            
            // Si la fecha final es menor o igual a la inicial.
            else{
                // Se genera una alerta indicando esto.
                JOptionPane.showMessageDialog(this,
                    "Elige una fecha final que sea mayor a la inicial.",
                    "Alerta!",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        // Si hubo una excepción se marca en consola.
        catch (ParseException ex) {
            System.out.println("Excepción de parsing de fechas.");
        }
    }//GEN-LAST:event_jButtonGenerarExcelActionPerformed

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
     * generarPDF
     * 
     * Descripción: Método usado para generar el archivo PDF de acuerdo a los
     * elementos seleccionados.
     * 
     * @param N/A.
     * @return N/A.
     */
    private void generarPDF() throws FileNotFoundException, DocumentException{
        /* Se obtienen los IDs de los elementos seleccionados en los JComboBox y
         * las fechas seleccionadas en los DatePickers. */
        String sIDArea = sIDAreas[ jComboBoxArea.getSelectedIndex() ];
        String sIDPrograma = sIDProgramas[ jComboBoxPrograma.getSelectedIndex() ];
        String sIDInstitucion = sIDInstituciones[ jComboBoxInstituciones.getSelectedIndex() ];
        String sFechaInicial = observingTextFieldFechaInicial.getText();
        String sFechaFinal = observingTextFieldFechaFinal.getText();

        // Se declara la conexión.
        Connection conConexion = null;
 
        // Se programa todo dentro de un try para revisar si hay problemas.
        try {
            // Se establece la conexión a la base de datos.
            String sDataBaseURL = "jdbc:sqlserver://MAKOTO\\SQLEXPRESS;databaseName=BancoDeAlimentos;integratedSecurity=true;";
            conConexion = DriverManager.getConnection(sDataBaseURL);
            
            // Si no hubo errores de conexión.
            if (conConexion != null) {
                // Se ejecuta query para saber si hay resultados.
                Statement stmtEstatuto = conConexion.createStatement();
                String sSQLQuery = "SELECT COUNT(*) AS tamanio "
                    + "FROM MovCarAbo WHERE "
                    + "IDArea = '" + sIDArea + "' AND "
                    + "IDPrograma = '" + sIDPrograma + "' AND "
                    + "IDInstitucion = '" + sIDInstitucion + "' AND "
                    + "Estatus = 'Pagado' AND "
                    + "FechaMov >= CAST('" + sFechaInicial + "' AS DATE) AND "
                    + "FechaMov <= CAST('" + sFechaFinal + "' AS DATE)";
                ResultSet rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                
                // Se obtiene el tamaño.
                rsResultados.next();
                int iTam = rsResultados.getInt("tamanio");
                
                // Si el tamaño no es cero.
                if(iTam > 0){
                    // Se ejecuta query para obtener resultados.
                    sSQLQuery = "SELECT IDFolio, FechaMov, Abono "
                        + "FROM MovCarAbo WHERE "
                        + "IDArea = '" + sIDArea + "' AND "
                        + "IDPrograma = '" + sIDPrograma + "' AND "
                        + "IDInstitucion = '" + sIDInstitucion + "' AND "
                        + "Estatus = 'Pagado' AND "
                        + "FechaMov >= CAST('" + sFechaInicial + "' AS DATETIME) AND "
                        + "FechaMov <= CAST('" + sFechaFinal + "' AS DATETIME)";
                    rsResultados = stmtEstatuto.executeQuery(sSQLQuery);
                    
                    /* Se declaran valores que se utilizarán para creación de
                     * PDF. */
                    String sArchivo = "C:/Users/HumbertoMakoto/Desktop/Relación de Dinero Captado.pdf";
                    com.itextpdf.text.Font fntTitulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18, com.itextpdf.text.Font.BOLD);
                    com.itextpdf.text.Font fntResaltado = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.BOLD);
                    com.itextpdf.text.Font fntNormal = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.NORMAL);
                    
                    // Se genera el archivo y se abre.
                    Document docDocumento = new Document();
                    PdfWriter.getInstance(docDocumento, new FileOutputStream(sArchivo));
                    docDocumento.open();
                    
                    // Se genera la metadata del documento.
                    docDocumento.addTitle("Relación de Dinero Captado");
                    docDocumento.addAuthor("Banco de Alimentos de Cáritas");
                    docDocumento.addCreator("Banco de Alimentos de Cáritas");
                    
                    // Se genera la fecha del archivo.
                    SimpleDateFormat sdfFormato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date datFechaActual = new java.util.Date();
                    Paragraph parFecha = new Paragraph(sdfFormato.format(datFechaActual), fntNormal);
                    parFecha.setAlignment(Element.ALIGN_RIGHT);
                    docDocumento.add(parFecha);
                    
                    // Se genera el título del archivo.
                    Paragraph parTitulo = new Paragraph("BANCO DE ALIMENTOS", fntTitulo);
                    parTitulo.setAlignment(Element.ALIGN_CENTER);
                    docDocumento.add(parTitulo);
                    
                    // Se genera el subtítulo del archivo.
                    Paragraph parSubtitulo = new Paragraph("Relación de Dinero Captado", fntResaltado);
                    parSubtitulo.setAlignment(Element.ALIGN_CENTER);
                    docDocumento.add(parSubtitulo);
                    
                    // Se pone institución.
                    Paragraph parInstitucion = new Paragraph((String)jComboBoxInstituciones.getSelectedItem(), fntNormal);
                    parInstitucion.setAlignment(Element.ALIGN_CENTER);
                    docDocumento.add(parInstitucion);
                    
                    // Se agregan algunos espacios en blanco.
                    Paragraph parLineaBlanco = new Paragraph(" ");
                    docDocumento.add(parLineaBlanco);
                    docDocumento.add(parLineaBlanco);
                    
                    /* Se crea tabla para poner información obtenida de base de
                     * datos y se establecen sus headers. */
                    PdfPTable ptbTabla = new PdfPTable(5);
                    PdfPCell pclHeader1 = new PdfPCell(new Phrase("Área"));
                    pclHeader1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    PdfPCell pclHeader2 = new PdfPCell(new Phrase("Programa"));
                    pclHeader2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    PdfPCell pclHeader3 = new PdfPCell(new Phrase("Folio"));
                    pclHeader3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    PdfPCell pclHeader4 = new PdfPCell(new Phrase("Fecha"));
                    pclHeader4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    PdfPCell pclHeader5 = new PdfPCell(new Phrase("Abono"));
                    pclHeader5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    ptbTabla.addCell(pclHeader1);
                    ptbTabla.addCell(pclHeader2);
                    ptbTabla.addCell(pclHeader3);
                    ptbTabla.addCell(pclHeader4);
                    ptbTabla.addCell(pclHeader5);
                    ptbTabla.setHeaderRows(1);
                    
                    // Se obtienen strings de área y programa seleccionados.
                    String sArea = (String)jComboBoxArea.getSelectedItem();
                    String sPrograma = (String)jComboBoxPrograma.getSelectedItem();
                    
                    // Se declara variable donde se guardará saldo total.
                    double dAbono = 0;
                    double dAbonoTotal = 0;
                    
                    // Se agregan resultados de la base de datos a la tabla.
                    while(rsResultados.next()){
                        ptbTabla.addCell(sArea);
                        ptbTabla.addCell(sPrograma);
                        ptbTabla.addCell(rsResultados.getString("IDFolio"));
                        java.util.Date datFecha = rsResultados.getDate("FechaMov");
                        ptbTabla.addCell(sdfFormato.format(datFecha));
                        dAbono = rsResultados.getDouble("Abono");
                        dAbonoTotal += dAbono;
                        ptbTabla.addCell(Double.toString(dAbono));
                    }
                    
                    // Se agrega saldo total al documento.
                    for(int iI = 0; iI < 3; iI++){
                        ptbTabla.addCell("");
                    }
                    ptbTabla.addCell(new PdfPCell(new Phrase("Total", fntResaltado)));
                    ptbTabla.addCell(new PdfPCell(new Phrase(Double.toString(dAbonoTotal), fntResaltado)));
                    
                    // Se agrega la tabla al documento.
                    docDocumento.add(ptbTabla);
                    
                    // Se cierra el archivo.
                    docDocumento.close();
                    
                    // Se genera una alerta indicando que se creó el archivo.
                    JOptionPane.showMessageDialog(this,
                        "El archivo se creó correctamente en su escritorio.",
                        "Éxito!",
                        JOptionPane.PLAIN_MESSAGE);
                }
                // Si el tamaño es cero.
                else{
                    // Se genera una alerta indicando esto.
                    JOptionPane.showMessageDialog(this,
                        "No hay valores con esos datos.",
                        "Alerta!",
                        JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(DineroCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DineroCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DineroCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DineroCaptadoPorPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // La forma se crea y se despliega.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DineroCaptadoPorPeriodo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonFechaFinal;
    private javax.swing.JButton jButtonFechaInicial;
    private javax.swing.JButton jButtonGenerarExcel;
    private javax.swing.JButton jButtonGenerarPDF;
    private javax.swing.JComboBox jComboBoxArea;
    private javax.swing.JComboBox jComboBoxInstituciones;
    private javax.swing.JComboBox jComboBoxPrograma;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelFechaFinal;
    private javax.swing.JLabel jLabelFechaInicial;
    private javax.swing.JLabel jLabelInstituciones;
    private javax.swing.JLabel jLabelPrograma;
    private javax.swing.JLabel jLabelTituloRelacionDineroCaptadoInstituciones;
    private javax.swing.JPanel jPanelAreaPrograma;
    private javax.swing.JPanel jPanelFechas;
    private javax.swing.JPanel jPanelInstituciones;
    private ObservingTextField observingTextFieldFechaFinal;
    private ObservingTextField observingTextFieldFechaInicial;
    // End of variables declaration//GEN-END:variables
}
