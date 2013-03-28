/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.gui.panels;

import com.instituto.controladores.ControladorDetallePlanAcademico;
import com.instituto.controladores.ControladorEspecialidad;
import com.instituto.controladores.ControladorPlanAcademico;
import com.instituto.entidades.Especialidad;
import com.instituto.entidades.PlanAcademico;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class panListarPlanesAcademicos extends javax.swing.JPanel {
    private ControladorPlanAcademico cpa;
    private ControladorEspecialidad ce;
    private ControladorDetallePlanAcademico cdpa;
    private List<Especialidad> es;
    private List<PlanAcademico> pa;
    private DefaultTableModel dtm;
    /**
     * Creates new form panListarPlanesAcademicos
     */
    public panListarPlanesAcademicos(ControladorPlanAcademico cpa,
            ControladorEspecialidad ce,
            ControladorDetallePlanAcademico cdpa) {
        this.cpa= cpa;
        this.ce= ce;
        this.cdpa= cdpa;
        initComponents();
        dtm= (DefaultTableModel) tabla.getModel();
        pa= cpa.listarPlanesAcademicos();
        loadEspecialidades();
    }
    
    private void loadEspecialidades() {
        if(cmbEspecialidad != null) {
            cmbEspecialidad.removeAllItems();
            cmbEspecialidad.addItem("Todas Las Especialidades");
            es= ce.listarEspecialidades();
            for (Especialidad e : es) {
                cmbEspecialidad.addItem(e.getNombre());
            }
            loadPlanes();
        }
    }
    
    private void loadPlanes() {
        dtm.setRowCount(0);
        if(cmbEspecialidad.getSelectedIndex() == 0) {
            for (PlanAcademico p : pa) {
                dtm.addRow(new Object[]{p.getIdPlanAcademico(),
                    p.getDescripcion(), 
                    getNombreEspecialidad(p.getIdEspecialidad().getIdEspecialidad())});
            }
        } else if (cmbEspecialidad.getSelectedIndex() > 0) {
            for (PlanAcademico p : pa) {
                if(p.getIdEspecialidad().getIdEspecialidad().equals(
                        es.get(cmbEspecialidad.getSelectedIndex() - 1).getIdEspecialidad()))
                dtm.addRow(new Object[]{p.getIdPlanAcademico(),
                    p.getDescripcion(), 
                    getNombreEspecialidad(p.getIdEspecialidad().getIdEspecialidad())});
            }
        }
    }
    
    private String getNombreEspecialidad(String idEspecialidad) {
        for (Especialidad e : es) {
            if(e.getIdEspecialidad().equals(idEspecialidad)) 
                return e.getNombre();
        }
        return null;
    }
    
    private void loadDetalle() {
        if(tabla.getSelectedRow() >= 0) {
            JDialog frm= new JDialog();
            frm.setTitle(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            frm.setLayout(new BorderLayout());
            frm.add(new panListarDetallePlanAcademico(pa.get(tabla.getSelectedRow()), cdpa));
            frm.pack();
            frm.setLocation((getToolkit().getScreenSize().width - frm.getWidth()) / 2, 
                    (getToolkit().getScreenSize().height - frm.getHeight()) / 2);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila valida", 
                    "Plan Academico", JOptionPane.WARNING_MESSAGE);
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
        cmbEspecialidad = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jLabel1.setText("Especialidad");

        cmbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidadActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Plan Academico", "Descripcion", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2) {
            loadDetalle();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void cmbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidadActionPerformed
        // TODO add your handling code here:
        if(es != null && dtm != null && pa != null)
            loadPlanes();
    }//GEN-LAST:event_cmbEspecialidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
