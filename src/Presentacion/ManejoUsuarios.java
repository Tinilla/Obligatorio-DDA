/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Tambo;
import Dominio.TipoUsuario;
import Dominio.Usuario;
import Presentacion.ModelosCbox.ModeloCbTipoUsuario;
import Presentacion.ModelosTbl.ModeloTblUsuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Equipo
 */
public class ManejoUsuarios extends javax.swing.JFrame {
    private static Tambo controladora;
    private static Usuario usuarioLogueado;
    
    private static ArrayList<Usuario> usuarios;
    private static ManejoUsuarios instancia = null;
    
    private static ModeloTblUsuario modeloTabla;
    private static Usuario usuarioSeleccionado;
    private static ListSelectionModel lsmUsuarios;
    /**
     * Creates new form ManejoUsuarios
     */
    public ManejoUsuarios(Usuario usuario) {
        initComponents();
        controladora = Tambo.getInstancia();
        verificarPermisos();
        cargarTabla();
        lsmUsuarios = tblUsuarios.getSelectionModel();
        lsmUsuarios.addListSelectionListener(new ListenerUsuario());
        tblUsuarios.setSelectionModel(lsmUsuarios);
        //this.rbgTipoMostrar.setSelected(rbEncargadosPlanta, true);
        //cargarTabla();
    }
    
    private boolean esMaster(){
        return usuarioLogueado.getTipo().getNombre().equals("Administrador");
    }
    
    private void verificarPermisos(){
        if(!esMaster()){
            this.rbAdministradores.setEnabled(false);
        }
        cargarTiposUsuario();
    }
    
    private void cargarTiposUsuario(){
        String criterio = "todos";
        if(!esMaster()){
            criterio = "encargados";
        }
        ModeloCbTipoUsuario tipos = new ModeloCbTipoUsuario(controladora.listarTiposUsuario(criterio));
        this.cbTipoUsuario.setModel(tipos);
        this.cbTipoUsuario.setSelectedIndex(-1);
    }
    
    private boolean faltanDatos(){
        return this.txtContrasena.getText().equals("") || this.txtNombreUsuario.getText().equals("") || this.cbTipoUsuario.getSelectedIndex() == -1;
    }
    
    private void limpiarCampos(){
        txtContrasena.setText("");
        txtNombreUsuario.setText("");
        cbTipoUsuario.setSelectedIndex(-1);
    }
    
    private void cargarTabla(){
        String criterio = "encargados";
        if(rbAdministradores.isSelected()){
            criterio = "administradores";
        }
        List<Usuario> usuarios = controladora.listarUsuarios(criterio);
        modeloTabla = new ModeloTblUsuario(usuarios);
        tblUsuarios.setModel(modeloTabla);
    }
    
    private class ListenerUsuario implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int seleccion = tblUsuarios.getSelectedRow();
            if (seleccion != -1) {
                usuarioSeleccionado = modeloTabla.getUsuario(seleccion);
                cargarDatosUsuario();
            }
        }
    }
    
    private void cargarDatosUsuario(){
        this.txtNombreUsuario.setText(usuarioSeleccionado.getNombreUsuario());
        this.txtContrasena.setText(usuarioSeleccionado.getNombreUsuario());
        this.cbTipoUsuario.setSelectedItem(ABORT); //ELEGIR EL TIPO
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        rbgTipoMostrar = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        cbTipoUsuario = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        rbAdministradores = new javax.swing.JRadioButton();
        rbEncargadosPlanta = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manejo de usuarios");

        jLabel1.setText("jLabel1");

        jLabel2.setText("Nombre de usuario");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Tipo de usuario");

        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);

        rbgTipoMostrar.add(rbAdministradores);
        rbAdministradores.setText("Administradores");
        rbAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdministradoresActionPerformed(evt);
            }
        });

        rbgTipoMostrar.add(rbEncargadosPlanta);
        rbEncargadosPlanta.setSelected(true);
        rbEncargadosPlanta.setText("Encargados de planta");
        rbEncargadosPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEncargadosPlantaActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setText("Mostrar:");

        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombreUsuario)
                                            .addComponent(txtContrasena)
                                            .addComponent(cbTipoUsuario, 0, 170, Short.MAX_VALUE)))
                                    .addComponent(btnRegistrar))
                                .addGap(16, 16, 16)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbAdministradores)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbEncargadosPlanta))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5))
                                    .addComponent(btnModificar)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnModificar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRegistrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbAdministradores)
                                    .addComponent(rbEncargadosPlanta)))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void rbAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdministradoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAdministradoresActionPerformed

    private void rbEncargadosPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEncargadosPlantaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEncargadosPlantaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(!faltanDatos()){
            String nombre = txtNombreUsuario.getText();
            String contrasena = txtContrasena.getText();
            TipoUsuario tipoUsuario = ((ModeloCbTipoUsuario)cbTipoUsuario.getModel()).getElementAt(cbTipoUsuario.getSelectedIndex());
            Usuario elUsuario = new Usuario(nombre, contrasena, tipoUsuario);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JRadioButton rbAdministradores;
    private javax.swing.JRadioButton rbEncargadosPlanta;
    private javax.swing.ButtonGroup rbgTipoMostrar;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
