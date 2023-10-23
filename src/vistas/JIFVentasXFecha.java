package vistas;

import accesoADatos.ClienteData;
import accesoADatos.DetalleVentaData;
import accesoADatos.ProductoData;
import accesoADatos.VentaData;
import accesoADatos.ListadosData;
import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;

import accesoADatos.DetalleVentaData;
import entidades.Venta;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class JIFVentasXFecha extends javax.swing.JInternalFrame {
    
      private DefaultTableModel modelo1 = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    ClienteData clidata = new ClienteData();
    Cliente cli = new Cliente();
    ProductoData prodata = new ProductoData();
    Producto pro = new Producto();
    VentaData vtadata = new VentaData();
    Venta vta = new Venta();
    DetalleVentaData dvdata = new DetalleVentaData();
    DetalleVenta detvta = new DetalleVenta();
    ListadosData lisdata = new ListadosData();
    // arma el formato para numeros con decimales
    DecimalFormat df = new DecimalFormat("#.00");
    int filaSeleccionada=0;


    /**
     * Creates new form JIFVentasXFecha
     */
    public JIFVentasXFecha() {
        initComponents();       
        this.setTitle("FRAVEMAX - Listados de ventas por fecha");        
        // inicializa los valores pra una nuevo detalle de a venta
        inicializaValores();
        armarCabecera1();
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jBbuscarVenta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtIdListadoVentas = new javax.swing.JTable();
        jBsalir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLtotalcomprobante = new javax.swing.JLabel();
        jLtotalVta = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Ventas x fecha");

        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jBbuscarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBbuscarVenta.setText("Buscar Venta");
        jBbuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarVentaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtIdListadoVentas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtIdListadoVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtIdListadoVentas);

        jBsalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBsalir.setText("SALIR");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        jLtotalcomprobante.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLtotalcomprobante.setText("Total Ventas del Dia $ ");

        jLtotalVta.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLtotalcomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLtotalVta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jBbuscarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscarVenta)
                    .addComponent(jButton1))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBsalir, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLtotalcomprobante, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLtotalVta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicializaValores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBbuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarVentaActionPerformed
     // borra los datos desde donde se eligio en la jtable y se ven los datos
        DefaultTableModel tablemodel1 = (DefaultTableModel) jtIdListadoVentas.getModel();
        tablemodel1.setRowCount(0);            
        java.util.Date fechaSeleccionada = jdcFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaFormateada = sdf.format(fechaSeleccionada);
        // va a buscar a sql los datos de las ventas realizadas en la fecha ingresada en jdcFecha     
        Double acumuladoDia=0.00;
        for (Venta vta : lisdata.buscarDetalleVenta(fechaFormateada, 1)) {
            String importeFormateado = df.format(vta.getTotalVenta());                
            modelo1.addRow(new Object[]{
                vta.getIdVenta(),
                vta.getCliente().getDni(),
                vta.getCliente().getApellido(),
                vta.getCliente().getNombre(),
                importeFormateado                
            });
            Double ventaDelDia = (Double) vta.getTotalVenta();
            acumuladoDia=acumuladoDia+ventaDelDia;
        }
        // asigna el total vendido para porder verlo en jLtotalVta
        // captura el dato que esta en la columna del idVenta        
        jLtotalVta.setText(acumuladoDia+"");
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO                
        if (jtIdListadoVentas.getRowCount() == 0)
        {
            // se bloquearon para hacer mas practico la consulta
            // bloqueo ests dos lineas para que no se amolesto el mensaje cuando no encuentre un dato
            //JOptionPane.showMessageDialog(null, "No Existen Datos de Clientes", "Advertencia",
            //JOptionPane.WARNING_MESSAGE);            
        }        
        else
        {        
            //int linTabla = jTableBuscarCliente.getSelectedRow()+1;
            //int colTabla = jTableBuscarCliente.getSelectedColumn();            
        } 
    }//GEN-LAST:event_jBbuscarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscarVenta;
    private javax.swing.JButton jBsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLtotalVta;
    private javax.swing.JLabel jLtotalcomprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable jtIdListadoVentas;
    // End of variables declaration//GEN-END:variables
private void armarCabecera1() {     
        TableColumnModel columnModel1 = jtIdListadoVentas.getColumnModel();
        ((DefaultTableCellRenderer) jtIdListadoVentas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jtIdListadoVentas.setRowHeight(30);
        
        modelo1.addColumn("IdVenta");
        modelo1.addColumn("DniCliente");
        modelo1.addColumn("Apellido");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("TotalVenta");

        jtIdListadoVentas.setModel(modelo1);        
        columnModel1.getColumn(0).setPreferredWidth(50);
        columnModel1.getColumn(1).setPreferredWidth(40);
        columnModel1.getColumn(2).setPreferredWidth(100);
        columnModel1.getColumn(3).setPreferredWidth(100);
        columnModel1.getColumn(4).setPreferredWidth(70);
        
        
        
        // alinea al centro los datos en las columnas de las jtable
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jtIdListadoVentas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtIdListadoVentas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtIdListadoVentas.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        jtIdListadoVentas.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);
        jtIdListadoVentas.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);        
    }
    
       
    
    private void inicializaValores()
    {
      // coloca la fecha actual al formulario de Detal le de Venta (de una fecha LocalDate a un jDateChooser
      //JDateChooser dateChooser = new JDateChooser(); // declaracion de un variable tipo jDateChooser
        LocalDate hoyEs=LocalDate.now();        
        //System.out.println(hoyEs);
        Date date = Date.from(hoyEs.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        jdcFecha.setDate(date);
      
        
      
      // limpiar la jtable
        DefaultTableModel tablemodel1 = (DefaultTableModel) jtIdListadoVentas.getModel(); 
        tablemodel1.setRowCount(0);
        
      // limpiar el total calculado
        jLtotalVta.setText("");
                       
      // coloca el cursor en le primer campo jTFbuscarclientedni      
        EventQueue.invokeLater( () -> jdcFecha.requestFocusInWindow() );        
    }


}
