/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.gui.panels;

import com.instituto.controladores.ControladorAlumno;
import com.instituto.controladores.ControladorDetallePagos;
import com.instituto.controladores.ControladorPagos;
import com.instituto.entidades.DetallePagos;
import com.instituto.entidades.Pagos;
import com.instituto.util.MaximaLongitud;
import com.instituto.util.NumeroDecimal;
import com.instituto.util.SoloNumeros;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class panNuevoPago extends javax.swing.JPanel {

    private ControladorPagos cp;
    private ControladorDetallePagos cdp;
    private ControladorAlumno ca;
    private Pagos p;
    /**
     * Creates new form panNuevoPago
     */
    public panNuevoPago(ControladorPagos cp, ControladorDetallePagos cdp, 
            ControladorAlumno ca) {
        this.cp = cp;
        this.cdp = cdp;
        this.ca= ca;
        p= null;
        initComponents();
        txtIdAlumno.addKeyListener(new MaximaLongitud(10));
        txtIdAlumno.addKeyListener(new SoloNumeros());
        txtIdMes.addKeyListener(new MaximaLongitud(6));
        txtIdMes.addKeyListener(new SoloNumeros());
        txtMontoAbonar.addKeyListener(new NumeroDecimal());
        txtMontoAbonar.addKeyListener(new MaximaLongitud(7));
    }
    
    public void mesActual() {
        GregorianCalendar now= new GregorianCalendar();
        txtIdMes.setText(now.get(GregorianCalendar.YEAR) + 
                ((now.get(GregorianCalendar.MONTH) + 1) < 10 ? "0":"") + 
                (now.get(GregorianCalendar.MONTH) + 1));
    }
    
    public void limpiar() {
        txtIdAlumno.setText("");
        txtAbonado.setText("");
        txtIdMes.setText("");
        txtMonto.setText("");
        txtMontoAbonar.setText("");
        txtMontoAbonar.setEditable(false);
        mesActual();
    }

    public void clean() {
        txtMonto.setText("");
        txtMontoAbonar.setText("");
        txtAbonado.setText("");
        txtMontoAbonar.setEditable(false);
    }

    public void load() {
        String idMes = txtIdMes.getText();
        String idAlumno = txtIdAlumno.getText();
        if (idMes.length() == 6 && idAlumno.length() == 10) {
            txtMontoAbonar.setEditable(true);
            p = cp.buscarPago(idAlumno, idMes);
            if (p != null) {
                txtMonto.setText(p.getMonto().toString());
                txtAbonado.setText(p.getAbonado().toString());
                if(txtMonto.getText().equals(txtAbonado.getText())) {
                    txtMontoAbonar.setEditable(false);
                    JOptionPane.showMessageDialog(this,
                        "El alumno ya completo este pago",
                        "Registrar Pago",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                clean();
                JOptionPane.showMessageDialog(this,
                        "Aun no se ha generado el pago de este mes",
                        "Registrar Pago",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            clean();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdMes = new javax.swing.JTextField();
        txtIdAlumno = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtAbonado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMontoAbonar = new javax.swing.JTextField();
        btnRegistrarPago = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel3.setText("Monto");

        jLabel2.setText("Alumno");

        jLabel1.setText("Mes");

        txtIdMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdMesFocusLost(evt);
            }
        });
        txtIdMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdMesKeyPressed(evt);
            }
        });

        txtIdAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdAlumnoFocusLost(evt);
            }
        });
        txtIdAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdAlumnoKeyPressed(evt);
            }
        });

        txtMonto.setEditable(false);

        txtAbonado.setEditable(false);

        jLabel4.setText("Abonado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdMes, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txtIdAlumno)
                            .addComponent(txtMonto)
                            .addComponent(txtAbonado))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Pago"));

        jLabel5.setText("Monto");

        txtMontoAbonar.setEditable(false);

        btnRegistrarPago.setText("Registrar");
        btnRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(txtMontoAbonar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrarPago)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMontoAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarPago)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdMesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdMesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            load();
        }
    }//GEN-LAST:event_txtIdMesKeyPressed

    private void txtIdAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdAlumnoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            load();
        }
    }//GEN-LAST:event_txtIdAlumnoKeyPressed

    private void txtIdAlumnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdAlumnoFocusLost
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_txtIdAlumnoFocusLost

    private void txtIdMesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdMesFocusLost
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_txtIdMesFocusLost

    private void btnRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPagoActionPerformed
        // TODO add your handling code here:
        boolean res= true;
        if(txtIdMes.getText().length() != 6) res= false;
        if(txtIdAlumno.getText().length() != 10) res= false;
        if(txtMontoAbonar.getText().length() == 0) res= false;
        if(p == null) res= false;
        if(res) {
            try {
                BigDecimal n= new BigDecimal(txtMontoAbonar.getText());
                DetallePagos dp= new DetallePagos();
                dp.setFecha(new GregorianCalendar().getTime());
                dp.setIdAlumno(ca.buscarAlumno(txtIdAlumno.getText()));
                dp.setIdMes(txtIdMes.getText());
                dp.setIdPagos(p);
                dp.setMonto(n);
                Exception ex= cdp.insertarDetallePagos(dp);
                if(ex == null) {
                    JOptionPane.showMessageDialog(this, "Se registro con exito el pago", 
                        "Registrar Pago", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else
                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
                        "Registrar Pago", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), 
                        "Registrar Pago", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se han ingresado todos los campos", 
                        "Registrar Pago", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarPagoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAbonado;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtIdMes;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoAbonar;
    // End of variables declaration//GEN-END:variables
}
