package vistas;

import accesoADatos.ClienteData;
import entidades.Cliente;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JIFCliente extends javax.swing.JInternalFrame {

    private boolean guardarModificar = false;
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hace que todas las celdas sean no editables
        }
    };

    ClienteData clidata = new ClienteData();
    Cliente cli = new Cliente();

    /**
     * Creates new form JIFCliente
     */
    public JIFCliente() {
        initComponents();
        armarCabecera();
        this.setTitle("FRAVEMAX - Gestión de Clientes");
        jtfDni.setEnabled(false);
        jtfApellido.setEnabled(false);
        jtfNombre.setEnabled(false);
        jtfDomicilio.setEnabled(false);
        jtfTelefono.setEnabled(false);
        jbNuevo.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfDomicilio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefono = new javax.swing.JTextField();
        jtfDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbRecuperar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlEstadoCliente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfBuscarCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jtfIdCliente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Cliente");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Apellido:");

        jtfApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        jtfNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jtfDomicilio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Domicilio:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Teléfono:");

        jtfTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefonoActionPerformed(evt);
            }
        });

        jtfDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDniActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("DNI:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Estado:");

        jbNuevo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbNuevo.setText("Limpiar");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

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
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlEstadoCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlEstadoCliente.setText(" ");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Id:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Buscar por DNI");

        jtfBuscarCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jtfBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBuscarClienteKeyReleased(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtClientes);

        jtfIdCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jtfIdCliente.setText(" ");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jtfTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                                .addComponent(jtfDomicilio, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfDni))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfIdCliente)
                            .addComponent(jLabel7)
                            .addComponent(jlEstadoCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbModificar)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbRecuperar)
                    .addComponent(jbSalir))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jtfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelefonoActionPerformed

    private void jtfDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDniActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        
        guardarModificar = false;
        
        
        jtfBuscarCliente.setText("");
        jtfBuscarCliente.setEnabled(true);
        jtfBuscarCliente.requestFocus();

        jtfIdCliente.setText("");

        jtfDni.setEnabled(false);
        jtfDni.setText("");

        jtfApellido.setEnabled(false);
        jtfApellido.setText("");

        jtfNombre.setEnabled(false);
        jtfNombre.setText("");

        jtfDomicilio.setEnabled(false);
        jtfDomicilio.setText("");

        jtfTelefono.setEnabled(false);
        jtfTelefono.setText("");
        
        jbNuevo.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        jlEstadoCliente.setText("");
        
        borrarFilas2();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecuperarActionPerformed

        String nroIdTexto = jtfIdCliente.getText();
        int nroId = Integer.parseInt(nroIdTexto);
        clidata.recuperarCliente(nroId);
        jlEstadoCliente.setForeground(Color.blue);
        jlEstadoCliente.setText("Activo");
        jbRecuperar.setEnabled(false);
        borrarFilas2();

    }//GEN-LAST:event_jbRecuperarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarClienteKeyReleased

        borrarFilas2();

        jtfIdCliente.setText("");
        jtfDni.setEnabled(false);
        jtfDni.setText("");
        jtfApellido.setEnabled(false);
        jtfApellido.setText("");
        jtfNombre.setEnabled(false);
        jtfNombre.setText("");
        jtfDomicilio.setEnabled(false);
        jtfDomicilio.setText("");
        jtfTelefono.setEnabled(false);
        jtfTelefono.setText("");
        jbNuevo.setEnabled(true);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        jlEstadoCliente.setText("");

        for (Cliente cli : clidata.listarClientesJTableParaGestionCliente()) {

            if ((cli.getApellido()).contains((jtfBuscarCliente.getText()))
                    || (cli.getNombre()).contains((jtfBuscarCliente.getText()))
                    || (String.valueOf(cli.getDni())).contains((jtfBuscarCliente.getText()))) {
                modelo.addRow(new Object[]{
                    cli.getIdCliente(),
                    cli.getDni(),
                    cli.getApellido(),
                    cli.getNombre(),
                    cli.getDomicilio(),
                    cli.getTelefono(),
                    cli.isEstado()
                });
            }

        }
        // PARA CONSULTAR SI LA TABLA ESTA VACIA O NO        
        if (jtClientes.getRowCount() == 0) {
            String capturarDni = jtfBuscarCliente.getText();
            int opcion = JOptionPane.showOptionDialog(null,
                    "No existe ese cliente. ¿Desea registrar uno nuevo?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    JOptionPane.YES_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {

                jtfBuscarCliente.setText("");
                jtfBuscarCliente.setEnabled(false);
                jtfDni.setEnabled(true);
                jtfDni.setText(capturarDni);
                jtfDni.requestFocus();
                jtfApellido.setEnabled(true);
                jtfNombre.setEnabled(true);
                jtfDomicilio.setEnabled(true);
                jtfTelefono.setEnabled(true);
                jbGuardar.setEnabled(true);
                jbModificar.setEnabled(false);
                jbEliminar.setEnabled(false);
                jbRecuperar.setEnabled(false);
                jlEstadoCliente.setText("Activo");
                jlEstadoCliente.setForeground(Color.blue);

            } else if (opcion == JOptionPane.NO_OPTION) {
                
                jtfBuscarCliente.setText("");
                jtfBuscarCliente.setEnabled(true);
                jtfBuscarCliente.requestFocus();

                jtfIdCliente.setText("");
                jtfDni.setEnabled(false);
                jtfDni.setText("");
                jtfApellido.setEnabled(false);
                jtfApellido.setText("");
                jtfNombre.setEnabled(false);
                jtfNombre.setText("");
                jtfDomicilio.setEnabled(false);
                jtfDomicilio.setText("");
                jtfTelefono.setEnabled(false);
                jtfTelefono.setText("");
                jbGuardar.setEnabled(false);
                jbModificar.setEnabled(false);
                jbEliminar.setEnabled(false);
                jbRecuperar.setEnabled(false);
                jlEstadoCliente.setText("");

            }

        } else {
            int linTabla = jtClientes.getSelectedRow() + 1;
            int colTabla = jtClientes.getSelectedColumn();
            Object valorTabla = jtClientes.getValueAt(linTabla, 0);
            Cliente cli2 = new Cliente();
            cli2.setIdCliente((Integer) jtClientes.getValueAt(linTabla, 0));
            cli2.setDni((Integer) jtClientes.getValueAt(linTabla, 1));
            cli2.setApellido((String) jtClientes.getValueAt(linTabla, 2));
            cli2.setNombre((String) jtClientes.getValueAt(linTabla, 3));
            cli2.setDomicilio((String) jtClientes.getValueAt(linTabla, 4));
            cli2.setTelefono((String) jtClientes.getValueAt(linTabla, 5));
            cli2.setEstado(true);

            if (jtfBuscarCliente.getText().isEmpty()) {
                borrarFilas2();
            }

        }

    }//GEN-LAST:event_jtfBuscarClienteKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        


        if (guardarModificar == true) {
            cli.setIdCliente(Integer.parseInt(jtfIdCliente.getText()));
        }
        cli.setDni(Integer.parseInt(jtfDni.getText()));
        cli.setApellido(jtfApellido.getText());
        cli.setNombre(jtfNombre.getText());
        cli.setDomicilio(jtfDomicilio.getText());
        cli.setTelefono(jtfTelefono.getText());
        cli.setEstado(true);

        if (guardarModificar == true) {

            clidata.modificarCliente(cli);
            guardarModificar = false;

        } else {

            clidata.guardarCliente(cli);

        }

        jtfBuscarCliente.setText("");
        jtfBuscarCliente.setEnabled(true);
        jtfBuscarCliente.requestFocus();

        jtfDni.setEnabled(false);
        jtfApellido.setEnabled(false);
        jtfNombre.setEnabled(false);
        jtfDomicilio.setEnabled(false);
        jtfTelefono.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
        
        borrarFilas2();

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        int filaSeleccionada = jtClientes.rowAtPoint(evt.getPoint());
        jtfBuscarCliente.setText("");
        jtfIdCliente.setText(jtClientes.getValueAt(filaSeleccionada, 0).toString());
        jtfDni.setText(jtClientes.getValueAt(filaSeleccionada, 1).toString());
        jtfApellido.setText(jtClientes.getValueAt(filaSeleccionada, 2) + "");
        jtfNombre.setText(jtClientes.getValueAt(filaSeleccionada, 3) + "");
        jtfDomicilio.setText(jtClientes.getValueAt(filaSeleccionada, 4) + "");
        jtfTelefono.setText(jtClientes.getValueAt(filaSeleccionada, 5).toString());

        if ((boolean) jtClientes.getValueAt(filaSeleccionada, 6)) {
            jlEstadoCliente.setForeground(Color.blue);
            jlEstadoCliente.setText("Activo");
            jbModificar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbRecuperar.setEnabled(false);
        } else {
            jlEstadoCliente.setForeground(Color.red);
            jlEstadoCliente.setText("Baja");
            jbModificar.setEnabled(false);
            jbEliminar.setEnabled(false);
            jbRecuperar.setEnabled(true);
        }
    }//GEN-LAST:event_jtClientesMouseClicked

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        guardarModificar = true;

        jtfDni.setEnabled(false);
        jtfApellido.setEnabled(true);
        jtfNombre.setEnabled(true);
        jtfDomicilio.setEnabled(true);
        jtfTelefono.setEnabled(true);
        jbGuardar.setEnabled(true);
        jbModificar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbRecuperar.setEnabled(false);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
        int opcionEliminar = JOptionPane.showOptionDialog(null,
                    "¿Está seguro de eliminar el cliente?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    JOptionPane.YES_OPTION);

            if (opcionEliminar == JOptionPane.YES_OPTION) {
                
        String nroIdTexto = jtfIdCliente.getText();
        int nroId = Integer.parseInt(nroIdTexto);
        clidata.eliminarCliente(nroId);
        jlEstadoCliente.setForeground(Color.red);
        jlEstadoCliente.setText("Baja");
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        borrarFilas2();
            }
        
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbRecuperar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlEstadoCliente;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfBuscarCliente;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfDomicilio;
    private javax.swing.JLabel jtfIdCliente;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        TableColumnModel columnModel = jtClientes.getColumnModel();

        modelo.addColumn("Id");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Estado");
        jtClientes.setModel(modelo);

        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(20);
        columnModel.getColumn(6).setPreferredWidth(5);

    }

    private void borrarFilas() {
        int filas = jtClientes.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);

        }
    }

    private void borrarFilas2() {
        modelo.setRowCount(0);
    }

}
