/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.gui.panels;

import com.instituto.controladores.ControladorCurso;
import com.instituto.controladores.ControladorEspecialidad;
import com.instituto.controladores.ControladorNombreCurso;
import com.instituto.controladores.ControladorPeriodo;
import com.instituto.controladores.ControladorProfesor;
import com.instituto.entidades.Curso;
import com.instituto.entidades.Especialidad;
import com.instituto.entidades.NombreCurso;
import com.instituto.entidades.Periodo;
import com.instituto.entidades.Profesor;
import com.instituto.util.MaximaLongitud;
import java.awt.Color;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author root
 */
public class panNuevoCursoDictar extends javax.swing.JPanel {
    private ControladorNombreCurso cc;
    private ControladorEspecialidad ce;
    private ControladorProfesor cp;
    private ControladorPeriodo cpe;
    private ControladorCurso ccu;
    private List<NombreCurso> cursos;
    private List<Profesor> profesores;
    private List<Periodo> periodos;
    private List<Especialidad> especialidadaes;
    /**
     * Creates new form panNuevoCurso
     */
    public panNuevoCursoDictar(ControladorNombreCurso cc, ControladorEspecialidad ce,
            ControladorProfesor cp, ControladorPeriodo cpe, ControladorCurso ccu) {
        this.cc= cc;
        this.ce= ce;
        this.cp= cp;
        this.cpe= cpe;
        this.ccu= ccu;
        initComponents();
        cursos= cc.listarNombreCursos();
        especialidadaes = ce.listarEspecialidades();
        profesores= cp.listarProfesores();
        periodos= cpe.listarPeriodo();
        txtCodigo.addKeyListener(new MaximaLongitud(8));
        llenarEspecialidades();
        llenarCursos();
        llenarPeriodos();
        llenarProfesores();
    }
    
    private void llenarEspecialidades() {
        cmbEspecialidad.removeAllItems();
        for (Especialidad e : especialidadaes) {
            cmbEspecialidad.addItem(e.getNombre());
        }
    }
    private void llenarCursos() {
        Especialidad e= especialidadaes.get(cmbEspecialidad.getSelectedIndex());
        cmbNombreCurso.removeAllItems();
        for (NombreCurso nc : cursos) {
            if(e.getIdEspecialidad().equals(nc.getIdEspecialidad().getIdEspecialidad()))
                cmbNombreCurso.addItem(nc.getDescripcion());
        }
    }
    
    private void llenarPeriodos() {
        cmbPeriodo.removeAllItems();
        for (Periodo p : periodos) {
            System.out.println(p.getFechaFin().getTime() + " " + 
                    new GregorianCalendar().getTime().getTime());
            if(p.getFechaFin().getTime() > new GregorianCalendar().getTime().getTime())
                cmbPeriodo.addItem(p.getIdPeriodo());
        }
    }
    
    private void llenarProfesores() {
        cmbProfesor.removeAllItems();
        for (Profesor p : profesores) {
            if(p.getActivo())
                cmbProfesor.addItem(p.getNombres() + " " + p.getApellidoPaterno() + 
                    " " + p.getApellidoMaterno());
        }
    }
    
    public void limpiar() {
        cmbEspecialidad.setSelectedIndex(0);
        cmbNombreCurso.setSelectedIndex(0);
        cmbPeriodo.setSelectedIndex(0);
        cmbProfesor.setSelectedIndex(0);
        txtCodigo.setText("");
        Border b= cmbEspecialidad.getBorder();
        txtCodigo.setBorder(b);
    }
    
    public void insertarCurso() {
        boolean res= true;
        Curso nc= new Curso();
        if(txtCodigo.getText().length() > 0) {
            nc.setIdCurso(txtCodigo.getText());
        }else res= false;
        if(cmbNombreCurso.getSelectedIndex() >= 0) {
            nc.setIdNombreCurso(cursos.get(cmbNombreCurso.getSelectedIndex()));
        }else res= false;
        if(cmbPeriodo.getSelectedIndex() >= 0) {
            nc.setIdPeriodo(periodos.get(cmbPeriodo.getSelectedIndex()));
        }else res= false;
        if(cmbProfesor.getSelectedIndex() >= 0) {
            nc.setIdProfesor(profesores.get(cmbProfesor.getSelectedIndex()));
        }else res= false;
        if(res) {
            Exception ex= ccu.insertarCurso(nc);
            if(ex == null) {
                JOptionPane.showMessageDialog(this, "Se registro con exito el curso", 
                    "Curso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else
                JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Curso", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se registraron los campos obligatorios", 
                    "Curso", JOptionPane.INFORMATION_MESSAGE);
            Border b= BorderFactory.createEtchedBorder(Color.red, Color.red);
            txtCodigo.setBorder(b);
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
        cmbEspecialidad = new javax.swing.JComboBox();
        cmbNombreCurso = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbProfesor = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        jLabel1.setText("Especialidad");

        jLabel2.setText("Curso");

        cmbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidadActionPerformed(evt);
            }
        });

        jLabel3.setText("Periodo");

        jLabel4.setText("Profesor");

        jLabel5.setText("Codigo");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNombreCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProfesor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(208, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidadActionPerformed
        // TODO add your handling code here:
        llenarCursos();
    }//GEN-LAST:event_cmbEspecialidadActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        insertarCurso();
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbNombreCurso;
    private javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JComboBox cmbProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
