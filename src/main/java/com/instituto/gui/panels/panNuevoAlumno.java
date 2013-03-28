/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.gui.panels;

import com.instituto.controladores.ControladorAlumno;
import com.instituto.entidades.Alumno;
import com.instituto.util.MaximaLongitud;
import com.instituto.util.SoloNumeros;
import java.awt.Color;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

/**
 *
 * @author root
 */
public class panNuevoAlumno extends javax.swing.JPanel {
    private ControladorAlumno ca;
    /**
     * Creates new form panNuevoAlumno
     */
    public panNuevoAlumno(ControladorAlumno ca, Alumno a) {
        this.ca= ca;
        initComponents();
        txtApellidoM.addKeyListener(new MaximaLongitud(25));
        txtApellidoP.addKeyListener(new MaximaLongitud(25));
        txtCelular.addKeyListener(new MaximaLongitud(12));
        txtCelular.addKeyListener(new SoloNumeros());
        txtCodigo.addKeyListener(new MaximaLongitud(10));
        txtCodigo.addKeyListener(new SoloNumeros());
        txtDNI.addKeyListener(new MaximaLongitud(8));
        txtDNI.addKeyListener(new SoloNumeros());
        txtDireccion.addKeyListener(new MaximaLongitud(200));
        txtEmail.addKeyListener(new MaximaLongitud(100));
        txtNombre.addKeyListener(new MaximaLongitud(50));
        txtTelefono.addKeyListener(new MaximaLongitud(12));
        txtTelefono.addKeyListener(new SoloNumeros());
        llenarDatos(a);
    }
    
    private void llenarDatos(Alumno a) {
        if(a != null) {
            txtApellidoM.setText(a.getApellidoMaterno());
            txtApellidoP.setText(a.getApellidoPaterno());
            txtCelular.setText(a.getCelular());
            txtCodigo.setText(a.getIdAlumno());
            txtDNI.setText(a.getDni());
            txtDireccion.setText(a.getDireccion());
            txtEmail.setText(a.getEmail());
            txtNombre.setText(a.getNombres());
            txtTelefono.setText(a.getTelefono());
            String f[]= a.getFechaIngreso().toString().substring(0, 10).split("-");
            txtFecha.setText(f[2] + "/" + f[1] + "/" + f[0]);
            txtCodigo.setEditable(false);
        }
    }
    
    public void limpiar() {
        Border b= txtCelular.getBorder();
        txtApellidoM.setBorder(b);
        txtApellidoP.setBorder(b);
        txtCodigo.setBorder(b);
        txtDNI.setBorder(b);
        txtDireccion.setBorder(b);
        txtNombre.setBorder(b);
        txtFecha.setBorder(b);
        txtApellidoM.setText("");
        txtApellidoP.setText("");
        txtCelular.setText("");
        txtCodigo.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtFecha.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }
    
    public void registrarAlumno() {
        Alumno a= new Alumno();
        boolean res= true;
        if(txtCodigo.getText().length() > 0) {
            a.setIdAlumno(txtCodigo.getText());
            a.setContrasena(txtCodigo.getText());
        } else res= false;
        if(txtApellidoM.getText().length() > 0) {
            a.setApellidoMaterno(txtApellidoM.getText());
        } else res= false;
        if(txtApellidoP.getText().length() > 0) {
            a.setApellidoPaterno(txtApellidoP.getText());
        } else res= false;
        
        if(txtDireccion.getText().length() > 0) {
            a.setDireccion(txtDireccion.getText());
        } else res= false;
        if(txtDNI.getText().length() == 8) {
            a.setDni(txtDNI.getText());
        } else res= false;
        if(txtFecha.getText().length() > 0) {
            String d[]= txtFecha.getText().split("/");
            GregorianCalendar gc= new GregorianCalendar(Integer.parseInt(d[2]), 
                Integer.parseInt(d[1]) - 1, Integer.parseInt(d[0]));
            a.setFechaIngreso(gc.getTime());
        } else res= false;
        if(txtNombre.getText().length() > 0) {
            a.setNombres(txtNombre.getText());
        } else res= false;
        a.setCelular(txtCelular.getText());
        a.setEmail(txtEmail.getText());
        a.setTelefono(txtTelefono.getText());
        if(res) {
            Exception ex= ca.insertarAlumno(a);
            if(ex == null) {
                JOptionPane.showMessageDialog(this, "Se registro con exito el alumno", 
                    "Alumno", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else
                JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Alumno", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se registraron los campos obligatorios", 
                    "Alumno", JOptionPane.INFORMATION_MESSAGE);
            Border b= BorderFactory.createEtchedBorder(Color.red, Color.red);
            txtCodigo.setBorder(b);
            txtApellidoM.setBorder(b);
            txtApellidoP.setBorder(b);
            txtDNI.setBorder(b);
            txtDireccion.setBorder(b);
            txtFecha.setBorder(b);
            txtNombre.setBorder(b);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();

        jLabel1.setText("Codigo Alumno");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        jLabel5.setText("Direccion");

        jLabel6.setText("Celular");

        jLabel7.setText("Telefono");

        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));

        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));

        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setText("Email");

        jLabel9.setText("DNI");

        txtDNI.setForeground(new java.awt.Color(0, 0, 0));

        btnOk.setText("Aceptar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Ingreso");

        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOk)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtApellidoP)
                            .addComponent(txtDireccion)
                            .addComponent(txtCelular)
                            .addComponent(txtTelefono)
                            .addComponent(txtEmail)
                            .addComponent(txtDNI)
                            .addComponent(txtApellidoM)
                            .addComponent(txtCodigo)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        registrarAlumno();
    }//GEN-LAST:event_btnOkActionPerformed

    private JDatePickerImpl dp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
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
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
