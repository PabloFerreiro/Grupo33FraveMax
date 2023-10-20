
package vistas;

import accesoADatos.DetalleVentaData;
import entidades.Venta;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JIFProductosVentaXFecha extends javax.swing.JInternalFrame {
    
     private DefaultTableModel modelo1 = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    private DefaultTableModel modelo2 = new DefaultTableModel(){
    public boolean isCellEditable (int f, int c){               
        return false;
    }
    };

    /**
     * Creates new form JIFProductosVentaXFecha
     */
    public JIFProductosVentaXFecha() {
        initComponents();       
        this.setTitle("FRAVEMAX - Listados de productos de una venta por fecha");        
        // inicializa los valores pra una nuevo detalle de a venta
        inicializaValores();
        armarCabecera1();
        armarCabecera2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtIdVenta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoProductos = new javax.swing.JTable();
        jBsalir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Productos de una venta x fecha");

        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtIdVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdVenta", "TotalVenta"
            }
        ));
        jScrollPane1.setViewportView(jtIdVenta);

        jtListadoProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Descripcion", "Precio Uni", "Cantidad", "Precio a Pagar"
            }
        ));
        jtListadoProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jtListadoProductos);

        jBsalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBsalir.setText("SALIR");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Buscar Venta");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jLabel1))
                        .addGap(452, 452, 452)
                        .addComponent(jLabel11))
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jBsalir)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
    this.dispose(); 
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    inicializaValores();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable jtIdVenta;
    private javax.swing.JTable jtListadoProductos;
    // End of variables declaration//GEN-END:variables
    
    private void armarCabecera1() {     
        TableColumnModel columnModel1 = jtIdVenta.getColumnModel();
        modelo1.addColumn("IdVenta");
        modelo1.addColumn("DniCliente");
        modelo1.addColumn("Apellido");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("TotalVenta");

        jtIdVenta.setModel(modelo1);        
        columnModel1.getColumn(0).setPreferredWidth(30);
        columnModel1.getColumn(1).setPreferredWidth(40);
        columnModel1.getColumn(2).setPreferredWidth(100);
        columnModel1.getColumn(3).setPreferredWidth(100);
        columnModel1.getColumn(4).setPreferredWidth(70);

        // alinea al centro los datos en las columnas de las jtable
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jtIdVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtIdVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtIdVenta.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jtIdVenta.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        // alinea a la derecha los datos numericos en las columnas de las jtable        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        
    }
    
        private void armarCabecera2() {     
        TableColumnModel columnModel2 = jtListadoProductos.getColumnModel();        
        modelo2.addColumn("Id");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Descripción");
        modelo2.addColumn("Precio Uni");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Precio a Pagar");
        modelo2.addColumn("Stock");
        jtListadoProductos.setModel(modelo2);                
        columnModel2.getColumn(0).setPreferredWidth(100);
        columnModel2.getColumn(1).setPreferredWidth(170);
        columnModel2.getColumn(2).setPreferredWidth(360);
        columnModel2.getColumn(3).setPreferredWidth(100);
        columnModel2.getColumn(4).setPreferredWidth(100);
        columnModel2.getColumn(5).setPreferredWidth(100);
        columnModel2.getColumn(6).setPreferredWidth(100);
        // alinea al centro los datos en las columnas de las jtable
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jtListadoProductos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        // alinea a la derecha los datos numericos en las columnas de las jtable
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jtListadoProductos.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jtListadoProductos.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        jtListadoProductos.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        jtListadoProductos.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
    }
    
    private void inicializaValores()
    {
      // coloca la fecha actual al formulario de Detal le de Venta (de una fecha LocalDate a un jDateChooser
      //JDateChooser dateChooser = new JDateChooser(); // declaracion de un variable tipo jDateChooser
        LocalDate hoyEs=LocalDate.now();        
        //System.out.println(hoyEs);
        Date date = Date.from(hoyEs.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        jdcFecha.setDate(date);
      
        
      
      // limpiar las 3 jtable
        DefaultTableModel tablemodel1 = (DefaultTableModel) jtIdVenta.getModel(); 
        tablemodel1.setRowCount(0);
        DefaultTableModel tablemodel2 = (DefaultTableModel) jtListadoProductos.getModel(); 
        tablemodel2.setRowCount(0);
               
      // coloca el cursor en le primer campo jTFbuscarclientedni      
        EventQueue.invokeLater( () -> jdcFecha.requestFocusInWindow() );        
    }



}
