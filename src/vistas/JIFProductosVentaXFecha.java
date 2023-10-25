// RAMA V2
// Actualizado dia: 25/10/23 hs: 15:38
package vistas;

import accesoADatos.ClienteData;
import accesoADatos.ProductoData;
import accesoADatos.VentaData;
import accesoADatos.ListadosData;
import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
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

public class JIFProductosVentaXFecha extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo1 = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    private DefaultTableModel modelo2 = new DefaultTableModel() {
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
    int filaSeleccionada = 0;

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
        jBlimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtIdVenta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoProductos = new javax.swing.JTable();
        jBsalir = new javax.swing.JButton();
        jBbuscarVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLtotalcomprobante = new javax.swing.JLabel();
        jLtotalVta = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Productos de una venta x fecha");

        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jBlimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBlimpiar.setText("Limpiar");
        jBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimpiarActionPerformed(evt);
            }
        });

        jtIdVenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        jtIdVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtIdVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtIdVenta);

        jtListadoProductos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        jBbuscarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jBbuscarVenta.setText("Buscar Venta");
        jBbuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarVentaActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        jLtotalcomprobante.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLtotalcomprobante.setText("Total del Comprobante $ ");

        jLtotalVta.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBbuscarVenta)
                            .addComponent(jLabel1))
                        .addGap(452, 452, 452)
                        .addComponent(jLabel11))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLtotalcomprobante)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLtotalVta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBlimpiar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
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
                    .addComponent(jBbuscarVenta)
                    .addComponent(jBlimpiar)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLtotalVta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLtotalcomprobante)
                    .addComponent(jBsalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarActionPerformed
        inicializaValores();
    }//GEN-LAST:event_jBlimpiarActionPerformed

    private void jBbuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarVentaActionPerformed
        // borra los datos desde donde se eligio en la jtable y se ven los datos
        DefaultTableModel tablemodel1 = (DefaultTableModel) jtIdVenta.getModel();
        tablemodel1.setRowCount(0);
        DefaultTableModel tablemodel2 = (DefaultTableModel) jtListadoProductos.getModel();
        tablemodel2.setRowCount(0);
        java.util.Date fechaSeleccionada = jdcFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaFormateada = sdf.format(fechaSeleccionada);
        // va a buscar a sql los datos de las ventas realizadas en la fecha ingresada en jdcFecha     
        for (Venta vta : lisdata.buscarDetalleVenta(fechaFormateada, 1)) {
            String importeFormateado = df.format(vta.getTotalVenta());
            modelo1.addRow(new Object[]{
                vta.getIdVenta(),
                vta.getCliente().getDni(),
                vta.getCliente().getApellido(),
                vta.getCliente().getNombre(),
                importeFormateado
            });
        }

        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO                
        if (jtIdVenta.getRowCount() == 0) {
            // se bloquearon para hacer mas practico la consulta
            // bloqueo ests dos lineas para que no se amolesto el mensaje cuando no encuentre un dato
            //JOptionPane.showMessageDialog(null, "No Existen Datos de Clientes", "Advertencia",
            //JOptionPane.WARNING_MESSAGE);            
        } else {
            //int linTabla = jTableBuscarCliente.getSelectedRow()+1;
            //int colTabla = jTableBuscarCliente.getSelectedColumn();            
        }
    }//GEN-LAST:event_jBbuscarVentaActionPerformed

    private void jtIdVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtIdVentaMouseClicked
        // captura la linea que se eligio en la tabla jtIdVenta
        filaSeleccionada = jtIdVenta.rowAtPoint(evt.getPoint());
        // captura el dato que esta en la columna del idVenta
        int idVentaABuscar = (int) jtIdVenta.getValueAt(filaSeleccionada, 0);
        //Object idVentaABuscar = jtIdVenta.getValueAt(filaSeleccionada, 0);
        //System.out.println("linea: "+filaSeleccionada);
        //System.out.println("idVenta: "+idVentaABuscar);
        // borra los datos de productos
        DefaultTableModel tablemodel2 = (DefaultTableModel) jtListadoProductos.getModel();
        tablemodel2.setRowCount(0);
        // va a buscar a sql los datos de los produtos de la venta elegia en jtIdVentafs
        for (DetalleVenta dvtas : lisdata.buscarDetalleProducto(idVentaABuscar, 1)) {
            int canti = (Integer) dvtas.getCantidad();
            // calcula el valor del precio unitario dvtas.getPrecioVenta() / dvtas.getCantidad()
            Double preUnileido = (Double) dvtas.getPrecioVenta();
            Double precioUnitario = preUnileido / canti;
            Double aPagar = (Double) dvtas.getPrecioVenta();
            //String importeF1 = df.format(dvtas.getPrecioVenta());                            
            String importeF1 = df.format(precioUnitario);
            String importeF2 = df.format(aPagar);
            modelo2.addRow(new Object[]{
                dvtas.getIdDetalleVenta(),
                dvtas.getProducto().getNombreProducto(),
                dvtas.getProducto().getDescripcion(),
                importeF1,
                dvtas.getCantidad(),
                importeF2
            });
        }
        // asigna el total vendido para porder verlo en jLtotalVta
        // captura el dato que esta en la columna del idVenta                                
        jLtotalVta.setText(jtIdVenta.getValueAt(filaSeleccionada, 4) + "");
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO                
        if (jtListadoProductos.getRowCount() == 0) {
            // se bloquearon para hacer mas practico la consulta
            // bloqueo ests dos lineas para que no se amolesto el mensaje cuando no encuentre un dato
            //JOptionPane.showMessageDialog(null, "No Existen Datos de Clientes", "Advertencia",
            //JOptionPane.WARNING_MESSAGE);            
        } else {
            //int linTabla = jtListadoProductos.getSelectedRow()+1;
            //int colTabla = jtListadoProductos.getSelectedColumn();            
        }

    }//GEN-LAST:event_jtIdVentaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscarVenta;
    private javax.swing.JButton jBlimpiar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLtotalVta;
    private javax.swing.JLabel jLtotalcomprobante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable jtIdVenta;
    private javax.swing.JTable jtListadoProductos;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera1() {
        TableColumnModel columnModel1 = jtIdVenta.getColumnModel();
        ((DefaultTableCellRenderer) jtIdVenta.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jtIdVenta.setRowHeight(30);

        modelo1.addColumn("IdVenta");
        modelo1.addColumn("DniCliente");
        modelo1.addColumn("Apellido");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("TotalVenta");

        jtIdVenta.setModel(modelo1);
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
        jtIdVenta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtIdVenta.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jtIdVenta.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        jtIdVenta.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);
        jtIdVenta.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }

    private void armarCabecera2() {
        TableColumnModel columnModel2 = jtListadoProductos.getColumnModel();
        ((DefaultTableCellRenderer) jtListadoProductos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jtListadoProductos.setRowHeight(30);

        modelo2.addColumn("Id");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Descripción");
        modelo2.addColumn("Precio Uni");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Precio a Pagar");

        jtListadoProductos.setModel(modelo2);
        columnModel2.getColumn(0).setPreferredWidth(60);
        columnModel2.getColumn(1).setPreferredWidth(190);
        columnModel2.getColumn(2).setPreferredWidth(390);
        columnModel2.getColumn(3).setPreferredWidth(150);
        columnModel2.getColumn(4).setPreferredWidth(95);
        columnModel2.getColumn(5).setPreferredWidth(150);

        // alinea al centro los datos en las columnas de las jtable
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jtListadoProductos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jtListadoProductos.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        jtListadoProductos.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
        jtListadoProductos.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jtListadoProductos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jtListadoProductos.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

    }

    private void inicializaValores() {
        // coloca la fecha actual al formulario de Detal le de Venta (de una fecha LocalDate a un jDateChooser
        //JDateChooser dateChooser = new JDateChooser(); // declaracion de un variable tipo jDateChooser
        LocalDate hoyEs = LocalDate.now();
        //System.out.println(hoyEs);
        Date date = Date.from(hoyEs.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        jdcFecha.setDate(date);

        // limpiar las 2 jtable
        DefaultTableModel tablemodel1 = (DefaultTableModel) jtIdVenta.getModel();
        tablemodel1.setRowCount(0);
        DefaultTableModel tablemodel2 = (DefaultTableModel) jtListadoProductos.getModel();
        tablemodel2.setRowCount(0);

        // limpiar el total calculado
        jLtotalVta.setText("");

        // coloca el cursor en le primer campo jTFbuscarclientedni      
        EventQueue.invokeLater(() -> jdcFecha.requestFocusInWindow());
    }

}
