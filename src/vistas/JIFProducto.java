package vistas;

import accesoADatos.ProductoData;
import entidades.Producto;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JIFProducto extends javax.swing.JInternalFrame {

    private boolean boton = false;
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c != 2) {
                return false;
            }
            return true;
        }

    };

    ProductoData prodata = new ProductoData();
    Producto pro = new Producto();

    private int idProductoABuscar = 0;
    private String seleccionBusqueda = "id";

    public JIFProducto() {
        initComponents();
        armarCabecera();
        this.setTitle("FRAVEMAX - Gestión de Productos");
        alComenzar();
    }

    public void alComenzar() {

        jtfBuscarProducto.setEnabled(true);
        jtfNombreProducto.setEnabled(false);
        jtfNombreProducto.setText("");
        jtfDescripcion.setEnabled(false);
        jtfDescripcion.setText("");
        jtfPrecio.setEnabled(false);
        jtfPrecio.setText("");
        jtfIdproducto.setEnabled(false);
        jtfIdproducto.setText("");
        jtfStock.setEnabled(false);
        jtfStock.setText("");
        jlEstadoProducto.setText("");
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        jbEliminar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jtfStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNombreProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbRecuperar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlEstadoProducto = new javax.swing.JLabel();
        jtfIdproducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfBuscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jbLimpiar = new javax.swing.JButton();
        jcbSeleccionBusqueda = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Productos");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Descripcion");

        jtfDescripcion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Precio");

        jtfPrecio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioActionPerformed(evt);
            }
        });

        jtfStock.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Stock");

        jtfNombreProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreProductoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Estado");

        jbModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbRecuperar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbRecuperar.setText("Recuperar");
        jbRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecuperarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlEstadoProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jtfIdproducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfIdproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdproductoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Id");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Buscar por");

        jtfBuscarProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarProductoActionPerformed(evt);
            }
        });
        jtfBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBuscarProductoKeyReleased(evt);
            }
        });

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        jbLimpiar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jcbSeleccionBusqueda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcbSeleccionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "nombre", "descripcion" }));
        jcbSeleccionBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSeleccionBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlEstadoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jcbSeleccionBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jcbSeleccionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlEstadoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar)
                    .addComponent(jbRecuperar)
                    .addComponent(jbSalir)
                    .addComponent(jbLimpiar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioActionPerformed

    private void jtfNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreProductoActionPerformed

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed
        prodata.recuperarProducto(Integer.parseInt(jtfIdproducto.getText()));
        jbRecuperar.setEnabled(false);
        borrarFilas();
        jlEstadoProducto.setForeground(Color.blue);
        jlEstadoProducto.setText("Activo");
    }//GEN-LAST:event_jbRecuperarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfIdproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdproductoActionPerformed

    private void jtfBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarProductoActionPerformed
        JTable jtProductos = (JTable) evt.getSource();
        int row = jtProductos.getSelectedRow();
        int col = jtProductos.getSelectedColumn();
        Object data2 = (Object) jtProductos.getValueAt(row, 1);
        Object data1 = (Object) jtProductos.getValueAt(row, 0);
        jtfBuscarProducto.setText(data2.toString());
    }//GEN-LAST:event_jtfBuscarProductoActionPerformed

    private void jtfBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarProductoKeyReleased

        String textoEnBuscarProducto = jtfBuscarProducto.getText();

        borrarFilas2();
        jtfIdproducto.setText("");
        jtfNombreProducto.setEnabled(false);
        jtfNombreProducto.setText("");
        jtfDescripcion.setEnabled(false);
        jtfDescripcion.setText("");
        jtfPrecio.setEnabled(false);
        jtfPrecio.setText("");
        jtfStock.setEnabled(false);
        jtfStock.setText("");
        jbLimpiar.setEnabled(true);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        jlEstadoProducto.setText("");

        if (seleccionBusqueda == "id") {

            if (!textoEnBuscarProducto.matches("\\d*")) {
                JOptionPane.showMessageDialog(this, "Ingrese un id válido");
                jtfBuscarProducto.setText("");
                jtfBuscarProducto.requestFocus();
                borrarFilas2();
            } else {
                for (Producto pro : prodata.listarProductosJTableParaGestionProducto()) {

                    if ((String.valueOf(pro.getIdProducto())).contains((jtfBuscarProducto.getText()))) {
                        modelo.addRow(new Object[]{
                            pro.getIdProducto(),
                            pro.getNombreProducto(),
                            pro.getDescripcion(),
                            pro.getPrecioActual(),
                            pro.getStock(),
                            pro.isEstado()
                        });
                    }

                }
            }

        } else if (seleccionBusqueda == "nombre") {

            for (Producto pro : prodata.listarProductosJTableParaGestionProducto()) {

                String textoIngresado = jtfBuscarProducto.getText();
                String textoIngresado2 = pro.getNombreProducto();
                int cantidadCaracteres = textoIngresado.length();
                int cantidadCaracteres2 = textoIngresado2.length();
                String compara1 = textoIngresado.substring(0, cantidadCaracteres);

                if (cantidadCaracteres2 >= cantidadCaracteres) {
                    String compara2 = textoIngresado2.substring(0, cantidadCaracteres);

                    if (compara1.toLowerCase().equals(compara2.toLowerCase())) {
                        modelo.addRow(new Object[]{
                            pro.getIdProducto(),
                            pro.getNombreProducto(),
                            pro.getDescripcion(),
                            pro.getPrecioActual(),
                            pro.getStock(),
                            pro.isEstado()
                        });
                    }

                }
            }

        } else if (seleccionBusqueda == "descripcion") {

            for (Producto pro : prodata.listarProductosJTableParaGestionProducto()) {

                if ((pro.getDescripcion()).contains((jtfBuscarProducto.getText()))) {
                    modelo.addRow(new Object[]{
                        pro.getIdProducto(),
                        pro.getNombreProducto(),
                        pro.getDescripcion(),
                        pro.getPrecioActual(),
                        pro.getStock(),
                        pro.isEstado()
                    });
                }

            }

        }

        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO  
        if (seleccionBusqueda == "id" && textoEnBuscarProducto.matches("\\d*")) {
            if (jtProductos.getRowCount() == 0) {
                String capturarDni = jtfBuscarProducto.getText();
                int opcion = JOptionPane.showOptionDialog(null,
                        "No existe ese producto. ¿Desea registrar uno nuevo?",
                        "Advertencia",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        new Object[]{"Sí", "No"},
                        JOptionPane.YES_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    boton = false;
                    jtfIdproducto.setText(jtfBuscarProducto.getText());
                    jtfIdproducto.setEnabled(false);

                    jtfBuscarProducto.setText("");
                    jtfBuscarProducto.setEnabled(false);

                    jtfNombreProducto.setEnabled(true);
                    jtfNombreProducto.requestFocus();
                    jtfDescripcion.setEnabled(true);
                    jtfPrecio.setEnabled(true);
                    jtfStock.setEnabled(true);
                    jbGuardar.setEnabled(true);
                    jbModificar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                    jbRecuperar.setEnabled(false);
                    jlEstadoProducto.setText("Activo");
                    jlEstadoProducto.setForeground(Color.blue);

                } else if (opcion == JOptionPane.NO_OPTION) {

                    jtfBuscarProducto.setText("");
                    jtfBuscarProducto.setEnabled(true);
                    jtfBuscarProducto.requestFocus();

                    jtfIdproducto.setText("");
                    jtfNombreProducto.setEnabled(false);
                    jtfNombreProducto.setText("");
                    jtfDescripcion.setEnabled(false);
                    jtfDescripcion.setText("");
                    jtfPrecio.setEnabled(false);
                    jtfPrecio.setText("");
                    jtfStock.setEnabled(false);
                    jtfStock.setText("");
                    jbGuardar.setEnabled(false);
                    jbModificar.setEnabled(false);
                    jbEliminar.setEnabled(false);
                    jbRecuperar.setEnabled(false);
                    jlEstadoProducto.setText("");

                }

            } else {
                int linTabla = jtProductos.getSelectedRow() + 1;
                int colTabla = jtProductos.getSelectedColumn();
                Object valorTabla = jtProductos.getValueAt(linTabla, 0);
                Producto pro2 = new Producto();
                pro2.setIdProducto((Integer) jtProductos.getValueAt(linTabla, 0));
                pro2.setNombreProducto((String) jtProductos.getValueAt(linTabla, 1));
                pro2.setDescripcion((String) jtProductos.getValueAt(linTabla, 2));
                pro2.setPrecioActual((Double) jtProductos.getValueAt(linTabla, 3));
                pro2.setStock((Integer) jtProductos.getValueAt(linTabla, 4));
                pro2.setEstado(true);

                if (jtfBuscarProducto.getText().isEmpty()) {
                    borrarFilas2();
                    jbLimpiar.setEnabled(false);
                }

            }

        } else if (seleccionBusqueda == "nombre") {

            if (jtProductos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No existe el producto con ese nombre");
                jtfBuscarProducto.setText("");
                jtfBuscarProducto.requestFocus();
            } else {
                int linTabla = jtProductos.getSelectedRow() + 1;
                int colTabla = jtProductos.getSelectedColumn();
                Object valorTabla = jtProductos.getValueAt(linTabla, 0);
                Producto pro2 = new Producto();
                pro2.setIdProducto((Integer) jtProductos.getValueAt(linTabla, 0));
                pro2.setNombreProducto((String) jtProductos.getValueAt(linTabla, 1));
                pro2.setDescripcion((String) jtProductos.getValueAt(linTabla, 2));
                pro2.setPrecioActual((Double) jtProductos.getValueAt(linTabla, 3));
                pro2.setStock((Integer) jtProductos.getValueAt(linTabla, 4));
                pro2.setEstado(true);

                if (jtfBuscarProducto.getText().isEmpty()) {
                    borrarFilas2();
                    jtfBuscarProducto.setText("");
                    jtfBuscarProducto.requestFocus();
                    jbLimpiar.setEnabled(false);
                }

            }

        } else if (seleccionBusqueda == "descripcion") {
            if (jtProductos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No existe el producto con esa descripción");
                jtfBuscarProducto.setText("");
                jtfBuscarProducto.requestFocus();
            } else {
                int linTabla = jtProductos.getSelectedRow() + 1;
                int colTabla = jtProductos.getSelectedColumn();
                Object valorTabla = jtProductos.getValueAt(linTabla, 0);
                Producto pro2 = new Producto();
                pro2.setIdProducto((Integer) jtProductos.getValueAt(linTabla, 0));
                pro2.setNombreProducto((String) jtProductos.getValueAt(linTabla, 1));
                pro2.setDescripcion((String) jtProductos.getValueAt(linTabla, 2));
                pro2.setPrecioActual((Double) jtProductos.getValueAt(linTabla, 3));
                pro2.setStock((Integer) jtProductos.getValueAt(linTabla, 4));
                pro2.setEstado(true);

                if (jtfBuscarProducto.getText().isEmpty()) {
                    borrarFilas2();
                    jtfBuscarProducto.setText("");
                    jtfBuscarProducto.requestFocus();
                    jbLimpiar.setEnabled(false);
                }

            }
        };
    }//GEN-LAST:event_jtfBuscarProductoKeyReleased

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked

        int filaSeleccionada = jtProductos.rowAtPoint(evt.getPoint());
        jtfBuscarProducto.setText("");
        jtfIdproducto.setText(jtProductos.getValueAt(filaSeleccionada, 0).toString());
        jtfNombreProducto.setText(jtProductos.getValueAt(filaSeleccionada, 1).toString());
        jtfDescripcion.setText(jtProductos.getValueAt(filaSeleccionada, 2) + "");
        jtfPrecio.setText(jtProductos.getValueAt(filaSeleccionada, 3) + "");
        jtfStock.setText(jtProductos.getValueAt(filaSeleccionada, 4) + "");
        jlEstadoProducto.setText(jtProductos.getValueAt(filaSeleccionada, 5).toString());

        if ((boolean) jtProductos.getValueAt(filaSeleccionada, 5)) {
            jlEstadoProducto.setForeground(Color.blue);
            jlEstadoProducto.setText("Activo");
            jbGuardar.setEnabled(false);
            jbModificar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbRecuperar.setEnabled(false);

        } else {
            jlEstadoProducto.setForeground(Color.red);
            jlEstadoProducto.setText("Baja");
            jbGuardar.setEnabled(false);
            jbModificar.setEnabled(false);
            jbEliminar.setEnabled(false);
            jbRecuperar.setEnabled(true);
        }

    }//GEN-LAST:event_jtProductosMouseClicked

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        if (boton == true) {

            pro.setIdProducto(Integer.parseInt(jtfIdproducto.getText()));

            pro.setNombreProducto(jtfNombreProducto.getText());
            pro.setDescripcion(jtfDescripcion.getText());
            pro.setPrecioActual(Double.parseDouble(jtfPrecio.getText()));
            pro.setStock(Integer.parseInt(jtfStock.getText()));
            pro.setEstado(true);

            //clidata.modificarCliente(cli);
            //alComenzar();
            borrarFilas2();
            jtfNombreProducto.setEnabled(false);
            jtfDescripcion.setEnabled(false);
            jtfPrecio.setEnabled(false);
            jtfStock.setEnabled(false);
            jbGuardar.setEnabled(false);
            prodata.modificarProducto(pro);
            boton = false;

        } else {

            String varNombreProducto = jtfNombreProducto.getText();
            String varDescripcion = jtfDescripcion.getText();
            String varPrecio = jtfPrecio.getText();
            String varStock = jtfStock.getText();

            if (varNombreProducto.isEmpty() || varDescripcion.isEmpty() || varPrecio.isEmpty() || varStock.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos antes de guardar el producto");
            } else {

                pro.setIdProducto(Integer.parseInt(jtfIdproducto.getText()));
                pro.setNombreProducto(jtfNombreProducto.getText());
                pro.setDescripcion(jtfDescripcion.getText());
                pro.setPrecioActual(Double.parseDouble(jtfPrecio.getText()));
                pro.setStock(Integer.parseInt(jtfStock.getText()));
                pro.setEstado(true);

                //alComenzar();
                borrarFilas2();
                jtfNombreProducto.setEnabled(false);
                jtfDescripcion.setEnabled(false);
                jtfPrecio.setEnabled(false);
                jtfStock.setEnabled(false);
                jbGuardar.setEnabled(false);
                System.out.println(pro.getIdProducto());
                prodata.guardarProducto(pro);
            }

        }
        boton = false;
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        prodata.eliminarProducto(Integer.parseInt(jtfIdproducto.getText()));
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        borrarFilas();
        //alComenzar();
        jlEstadoProducto.setForeground(Color.red);
        jlEstadoProducto.setText("Baja");
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        boton = true;
        jtfBuscarProducto.setEnabled(false);
        jtfNombreProducto.setEnabled(true);
        jtfDescripcion.setEnabled(true);
        jtfPrecio.setEnabled(true);
        jtfStock.setEnabled(true);
        jbGuardar.setEnabled(true);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed

        jtfBuscarProducto.setText("");
        jtfBuscarProducto.setEnabled(true);
        jtfBuscarProducto.requestFocus();

        jtfIdproducto.setText("");
        jtfIdproducto.setEnabled(false);

        jtfNombreProducto.setText("");
        jtfNombreProducto.setEnabled(false);

        jtfDescripcion.setText("");
        jtfDescripcion.setEnabled(false);

        jtfDescripcion.setText("");
        jtfDescripcion.setEnabled(false);

        jtfPrecio.setText("");
        jtfPrecio.setEnabled(false);

        jtfStock.setText("");
        jtfStock.setEnabled(false);

        jlEstadoProducto.setText("");

        jbLimpiar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);

        jcbSeleccionBusqueda.setSelectedIndex(0);
        seleccionBusqueda = "id";

        borrarFilas2();
        boton = false;
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jcbSeleccionBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSeleccionBusquedaActionPerformed
        jtfBuscarProducto.setText("");
        jtfBuscarProducto.requestFocus();
        borrarFilas2();

        if (jcbSeleccionBusqueda.getSelectedIndex() == 0) {
            seleccionBusqueda = "id";
        } else if (jcbSeleccionBusqueda.getSelectedIndex() == 1) {
            seleccionBusqueda = "nombre";
        } else if (jcbSeleccionBusqueda.getSelectedIndex() == 2) {
            seleccionBusqueda = "descripcion";
        }
    }//GEN-LAST:event_jcbSeleccionBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbRecuperar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbSeleccionBusqueda;
    private javax.swing.JLabel jlEstadoProducto;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField jtfBuscarProducto;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfIdproducto;
    private javax.swing.JTextField jtfNombreProducto;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfStock;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        TableColumnModel columnModel = jtProductos.getColumnModel();

        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        jtProductos.setModel(modelo);

        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(20);
        columnModel.getColumn(5).setPreferredWidth(20);

    }

    private void borrarFilas() {
        int filas = jtProductos.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void borrarFilas2() {
        modelo.setRowCount(0);
    }

}
