/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JIFLogin extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFLogin
     */
    public JIFLogin() {
        initComponents();
        this.setTitle("FRAVEMAX - GRUPO 33");

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUsuarioLogin = new javax.swing.JTextField();
        jpfPassLogin = new javax.swing.JPasswordField();

        setName("jiflogueo"); // NOI18N

        jbIngresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbIngresar.setText("Ingresar");
        jbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoFraveMax.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("CONTRASEÑA");

        jtfUsuarioLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jpfPassLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jpfPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpfPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jbIngresar)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jbIngresar.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarActionPerformed

        String password = new String(jpfPassLogin.getPassword());
        MenuPrincipalFraveMax menuPrincipalFraveMax = (MenuPrincipalFraveMax) getTopLevelAncestor();

        if (jtfUsuarioLogin.getText().equals("grupo33") && password.equals("33")) {
        //if (jtfUsuarioLogin.getText().equals("") && password.equals("")) {
            //MenuPrincipal menuPrincipal = (MenuPrincipal) getTopLevelAncestor();
            menuPrincipalFraveMax.editarObloquearMenues(true, true, true, false);
            JOptionPane.showMessageDialog(this, "Usuario logueado con éxito");
            this.setEnabled(false);
            this.setVisible(false);

        } else {
            if (jtfUsuarioLogin.getText().equals("") || password.equals("")) {
                //MenuPrincipal menuPrincipal = (MenuPrincipal) getTopLevelAncestor();
                JOptionPane.showMessageDialog(this, "Por favor, complete los datos para ingresar");

            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
            }
            jtfUsuarioLogin.setText("");
            jpfPassLogin.setText("");
        }


    }//GEN-LAST:event_jbIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbIngresar;
    private javax.swing.JPasswordField jpfPassLogin;
    private javax.swing.JTextField jtfUsuarioLogin;
    // End of variables declaration//GEN-END:variables

}
