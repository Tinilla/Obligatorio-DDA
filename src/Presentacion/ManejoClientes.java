/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Ciudad;
import Dominio.Cliente;
import Dominio.Tambo;
import Dominio.Usuario;
import Presentacion.ModelosCbox.ModeloCbCiudad;
import Presentacion.ModelosTbl.ModeloTblClientes;
import static java.awt.image.ImageObserver.ABORT;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Negro
 */
public class ManejoClientes extends javax.swing.JFrame {
    private static Tambo controladora;
    
    private static ArrayList<Cliente> clientes;
    private static ManejoClientes instancia = null;
    
    private static ModeloTblClientes modeloTabla;
    private static Cliente clienteSeleccionado;
    private static ListSelectionModel lsmClientes;
    /**
     * Creates new form ManejoClientes
     */
    private ManejoClientes() throws SQLException {
        initComponents();
        controladora = Tambo.getInstancia();
        cargarDdlCiudad();
        cargarTabla();
        
        lsmClientes = tblClientes.getSelectionModel();
        lsmClientes.addListSelectionListener(new ListenerCliente());
        tblClientes.setSelectionModel(lsmClientes);
    }

    public static ManejoClientes getInstancia(Usuario usuario) throws SQLException{
        if(instancia == null){
            instancia = new ManejoClientes();
        }
        return instancia;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        btnAgregarNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        ddlCiudad = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarNuevo.setText("Agregar Nuevo");
        btnAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.setEnabled(false);
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        ddlCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jLabel1.setText("Nombre");

        jLabel2.setText("Razon social");

        jLabel3.setText("Rut");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("jLabel1");

        jLabel5.setText("Ciudad");

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtRazonSocial)
                                    .addComponent(txtRut)
                                    .addComponent(ddlCiudad, 0, 163, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregarNuevo)
                                .addGap(18, 18, 18)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCambios)
                            .addComponent(btnCancelar)
                            .addComponent(btnEliminar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ddlCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardarCambios)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregarNuevo)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoActionPerformed
        if(!faltanDatos()){
            if(!existe(Integer.parseInt(txtRut.getText()))){//un int no da para el RUT
                Cliente cliente = new Cliente();
                cliente.setNombre(txtNombre.getText());
                cliente.setRazonSocial(txtRazonSocial.getText());
                cliente.setRut(txtRut.getText());

                Ciudad ciudad = new Ciudad();
                ciudad.setId(ddlCiudad.getSelectedIndex()+1);
                cliente.setCiudad(ciudad);
                controladora.altaCliente(cliente);
                limpiar();
                cargarTabla();
            }else{
                //sout : si estado = 0 { cambiar estado en la bbdd a 1}
            }
        }else{
            //sout: faltan datos
        }
    }//GEN-LAST:event_btnAgregarNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        btnAgregarNuevo.setEnabled(true);
        btnGuardarCambios.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        ddlCiudad.setEnabled(true);
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int seleccion = tblClientes.getSelectedRow();
            if (seleccion != -1) {
                controladora.bajaCliente(clienteSeleccionado.getId());
            }
        cargarTabla();
        btnAgregarNuevo.setEnabled(true);
        btnGuardarCambios.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        ddlCiudad.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        int seleccion = tblClientes.getSelectedRow();
        if (seleccion != -1) {
            Cliente unCliente = new Cliente();
            unCliente.setId(clienteSeleccionado.getId());
            unCliente.setNombre(txtNombre.getText());
            unCliente.setRazonSocial(txtRazonSocial.getText());
            unCliente.setRut(txtRut.getText());
            controladora.modificarCliente(unCliente);
        }
        limpiar();
        cargarTabla();
        btnAgregarNuevo.setEnabled(true);
        btnGuardarCambios.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        ddlCiudad.setEnabled(true);
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private boolean faltanDatos(){
        return txtNombre.getText().equals("") || txtRazonSocial.getText().equals("")|| txtRut.getText().equals("");
    }
    private boolean existe(int rutCliente){
        Cliente cliente;
        cliente = controladora.buscarCliente(rutCliente);
        return cliente != null;
    }
    private void cargarDdlCiudad() throws SQLException{
        ModeloCbCiudad ciudades = new ModeloCbCiudad(controladora.listarCiudades());
        this.ddlCiudad.setModel(ciudades);
        this.ddlCiudad.setSelectedIndex(-1);
    }
    private void limpiar(){
        this.txtNombre.setText("");
        this.txtRazonSocial.setText("");
        this.txtRut.setText("");
        this.ddlCiudad.setSelectedIndex(-1);
    }
    private void cargarTabla(){
        List<Cliente> clientes = controladora.listarClientes();
        modeloTabla = new ModeloTblClientes(clientes);
        tblClientes.setModel(modeloTabla);
    }
    private class ListenerCliente implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int seleccion = tblClientes.getSelectedRow();
            if (seleccion != -1) {
                clienteSeleccionado = modeloTabla.getCliente(seleccion);
                cargarDatosCliente();
                btnGuardarCambios.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnAgregarNuevo.setEnabled(false);
                ddlCiudad.setEnabled(false);
            }
        }
    }
    private void cargarDatosCliente(){
        this.txtNombre.setText(clienteSeleccionado.getNombre());
        this.txtRazonSocial.setText(clienteSeleccionado.getRazonSocial());
        this.txtRut.setText(clienteSeleccionado.getRut());
        this.ddlCiudad.setSelectedItem(ABORT); //ELEGIR EL TIPO
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNuevo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JComboBox ddlCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
