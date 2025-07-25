/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package INVENTARIO;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.contenido.PANEL_INICIO.PanelInicio;
import org.contenido.controlador.Controlador;
import org.contenido.controlador.controladorImpl.InventarioControlador;
import org.contenido.dto.InventarioDTO;

/**
 *
 * @author SERT
 */
public class ModuloDeInventario extends javax.swing.JFrame {

    /**
     * Creates new form ModuloDeInventario
     */
    Controlador<InventarioDTO> controladori = new InventarioControlador();
    List<InventarioDTO> listainventario = controladori.listarTodo();
    private List<InventarioDTO> listaFiltradaInventario = new java.util.ArrayList<>();
    public ModuloDeInventario() {
        initComponents();
        cargarInventario();
        
            // Filtro dinámico por nombre
        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarPorNombre(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarPorNombre(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarPorNombre(); }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Modificar = new javax.swing.JButton();
        AñadirRegistro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Modificar2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_inventario = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 30)); // NOI18N
        jLabel1.setText("Módulo de Inventario");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setText("Gestionar el registro, la actualización y la consulta de bienes.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventario/logo.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventario/cerrar-sesion.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1300, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTextField1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Modificar.setBackground(new java.awt.Color(255, 102, 0));
        Modificar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventario/anadir.png"))); // NOI18N
        Modificar.setText("Modificar");
        Modificar.setActionCommand("✓ Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        AñadirRegistro.setBackground(new java.awt.Color(255, 102, 0));
        AñadirRegistro.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        AñadirRegistro.setForeground(new java.awt.Color(255, 255, 255));
        AñadirRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventario/nuevo.png"))); // NOI18N
        AñadirRegistro.setText("Añadir inventario");
        AñadirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirRegistroActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Buscar por nombre de inventario:");

        Modificar2.setBackground(new java.awt.Color(255, 102, 0));
        Modificar2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        Modificar2.setForeground(new java.awt.Color(255, 255, 255));
        Modificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventario/reporte1.png"))); // NOI18N
        Modificar2.setText("Visualizar inventario");
        Modificar2.setActionCommand("✓ Modificar");
        Modificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar2ActionPerformed(evt);
            }
        });

        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha de inicio", "Fecha de fin", "Responsable"
            }
        ));
        jScrollPane2.setViewportView(tabla_inventario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(Modificar2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(AñadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AñadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Modificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 196, 1290, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1205, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void AñadirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirRegistroActionPerformed
        // TODO add your handling code here:
        AñadirInventario obj = new AñadirInventario();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_AñadirRegistroActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int filaVisual = tabla_inventario.getSelectedRow();
        if (filaVisual == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un inventario.");
            return;
        }
        InventarioDTO InventarioSeleccionado = listaFiltradaInventario.get(filaVisual);
        ModificarInventario obj = new ModificarInventario(InventarioSeleccionado);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_ModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PanelInicio obj = new PanelInicio();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Modificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar2ActionPerformed
        int filaVisual = tabla_inventario.getSelectedRow();
        if (filaVisual == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un inventario.");
            return;
        }
        InventarioDTO InventarioSeleccionado = listaFiltradaInventario.get(filaVisual);
        DetalleInventario obj = new DetalleInventario(InventarioSeleccionado);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_Modificar2ActionPerformed

    private void cargarInventario() {
        DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Codigo Inventario", "Descripcion", "Fecha realizada"}, 0
        );

        listaFiltradaInventario.clear();

        for (InventarioDTO inventario : listainventario) {
            listaFiltradaInventario.add(inventario);

            modelo.addRow(new Object[]{
                inventario.getNombre(),
                inventario.getDescripcion(),
                inventario.getFechaInicio()
            });
        }

        tabla_inventario.setModel(modelo);
    }
    private void filtrarPorNombre() {
        String texto = jTextField1.getText().trim().toLowerCase();

        DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Codigo Inventario", "Descripcion", "Fecha realizada"}, 0
        );

        listaFiltradaInventario.clear();

        for (InventarioDTO inventario : listainventario) {
            String nombre = inventario.getNombre() != null ? inventario.getNombre().toLowerCase() : "";

            if (texto.isEmpty() || nombre.contains(texto)) {
                listaFiltradaInventario.add(inventario);  // sincronizamos lista filtrada

                modelo.addRow(new Object[]{
                    inventario.getNombre(),
                    inventario.getDescripcion(),
                    inventario.getFechaInicio()
                });
            }
        }

        tabla_inventario.setModel(modelo);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloDeInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloDeInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloDeInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloDeInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloDeInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirRegistro;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Modificar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private java.awt.PopupMenu popupMenu1;
    private org.jdesktop.swingx.JXTable tabla_inventario;
    // End of variables declaration//GEN-END:variables
}
