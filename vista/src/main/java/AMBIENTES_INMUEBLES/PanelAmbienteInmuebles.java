/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AMBIENTES_INMUEBLES;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.contenido.PANEL_INICIO.PanelInicio;
import org.contenido.controlador.Controlador;
import org.contenido.controlador.controladorImpl.AmbienteControlador;
import org.contenido.controlador.controladorImpl.InmuebleControlador;
import org.contenido.controlador.controladorImpl.ResponsableControlador;
import org.contenido.dto.AmbienteDTO;
import org.contenido.dto.InmuebleDTO;
import org.contenido.dto.ResponsableDTO;

/**
 *
 * @author renzo
 */
public class PanelAmbienteInmuebles extends javax.swing.JFrame {

    /**
     * Creates new form PanelAmbiente
     */
    public PanelAmbienteInmuebles() {
        initComponents();
        cargarInmueblesEnTabla();
        cargarAmbientesEnTabla();
        buscar_inmuebles.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e){ filtrarInmuebles();}
        public void removeUpdate(DocumentEvent e){ filtrarInmuebles();}
        public void changedUpdate(DocumentEvent e){ filtrarInmuebles();}
        });
        buscar_ambientes.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e){ filtrarAmbientes();}
        public void removeUpdate(DocumentEvent e){ filtrarAmbientes();}
        public void changedUpdate(DocumentEvent e){ filtrarAmbientes();}
        
        });
    }
    
    Controlador<InmuebleDTO> controlador = new InmuebleControlador();
    List<InmuebleDTO> listaInmuebles = controlador.listarTodo();
    
    private void cargarInmueblesEnTabla() {
    // Crear el modelo de la tabla con los nombres de columnas
    DefaultTableModel modelo = new DefaultTableModel(
        new String[]{"Nombre","Descripción"}, 0
    );

    for (InmuebleDTO inmuebles : listaInmuebles) {
        modelo.addRow(new Object[]{
            inmuebles.getNombre(),
            inmuebles.getDescripcion()
            });
        }
    tabla_listarInmuebles.setModel(modelo);
    }
    private void filtrarInmuebles(){
    String nombreFiltro = buscar_inmuebles.getText().trim().toLowerCase();
    
    //crear un modelo vacio con las columnas
    DefaultTableModel modelo = new DefaultTableModel(
    new String[] {"Inmueble", "Descripción"}, 0
    );

    for (InmuebleDTO inmuebles : listaInmuebles) {
    boolean coincideNombre =inmuebles.getNombre().toLowerCase().contains(nombreFiltro);
    
        if (coincideNombre ){
            modelo.addRow(new Object[]{
                inmuebles.getNombre(),
                inmuebles.getDescripcion()
            });
        }
        tabla_listarInmuebles.setModel(modelo);
    }
   
}
    
    Controlador<AmbienteDTO> controlador2 = new AmbienteControlador();
    List<AmbienteDTO> listaAmbiente = controlador2.listarTodo();
    
    private void cargarAmbientesEnTabla() {
    // Crear el modelo de la tabla con los nombres de columnas
    DefaultTableModel modelo = new DefaultTableModel(
        new String[]{"Ambiente","Vinculado a"}, 0
    );

    for (AmbienteDTO ambientes : listaAmbiente) {
        modelo.addRow(new Object[]{
            ambientes.getNombre(),
            ambientes.getInmuebleDTO().getNombre()
            });
        }
    tabla_listarAmbientes.setModel(modelo);
    }
    
    private void filtrarAmbientes(){
    String nombreFiltro = buscar_ambientes.getText().trim().toLowerCase();
    
    //crear un modelo vacio con las columnas
    DefaultTableModel modelo = new DefaultTableModel(
    new String[] {"Ambiente", "Vinculado a"}, 0
    );

    for (AmbienteDTO ambientes : listaAmbiente) {
    boolean coincideNombre =ambientes.getNombre().toLowerCase().contains(nombreFiltro);
    
        if (coincideNombre ){
            modelo.addRow(new Object[]{
                ambientes.getNombre(),
                ambientes.getInmuebleDTO().getNombre()
            });
        }
        tabla_listarAmbientes.setModel(modelo);
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

        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        titulo4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buscar_ambientes = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buscar_inmuebles = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_listarInmuebles = new org.jdesktop.swingx.JXTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_listarAmbientes = new org.jdesktop.swingx.JXTable();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        titulo4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        titulo4.setForeground(new java.awt.Color(51, 51, 51));
        titulo4.setText("Ambientes e Inmuebles");
        titulo4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Visualiza la distribución de ambientes por inmuebles.");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Ambientes del inmueble seleccionado");

        buscar_ambientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_ambientesActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 102, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Inmuebles disponibles");

        buscar_inmuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_inmueblesActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 51, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tabla_listarInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Inmueble", "Descripción"
            }
        ));
        jScrollPane3.setViewportView(tabla_listarInmuebles);

        tabla_listarAmbientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ambiente", "Vinculado a"
            }
        ));
        jScrollPane1.setViewportView(tabla_listarAmbientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(buscar_inmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
                        .addComponent(buscar_ambientes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar_inmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton8))
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar_ambientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addGap(32, 32, 32))
        );

        jButton9.setBackground(new java.awt.Color(255, 102, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Atrás");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addContainerGap())))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_listarInmuebles.getSelectedRow();
    
        if (filaSeleccionada != -1) {
            // Buscar el nombre del responsable en la tabla seleccionada
            String nombreSeleccionado = tabla_listarInmuebles.getValueAt(filaSeleccionada, 0).toString();

            // Buscar en la lista original el responsable que tiene ese nombre (u otro campo único)
            InmuebleDTO seleccionado = null;
            for (InmuebleDTO r : listaInmuebles) {
                if (r.getNombre().equals(nombreSeleccionado)) {
                    seleccionado = r;
                    break;
                }
            }


            // Abrir la nueva interfaz y pasarle el objeto
            EditarInmueble obj = new EditarInmueble(seleccionado);
            obj.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un inmueble primero.");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AñadirRegistroAmbiente obj = new AñadirRegistroAmbiente();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        AñadirRegistroInmueble obj = new AñadirRegistroInmueble();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_listarInmuebles.getSelectedRow();
    
        if (filaSeleccionada != -1) {
            // Buscar el nombre del responsable en la tabla seleccionada
            String nombreSeleccionado = tabla_listarInmuebles.getValueAt(filaSeleccionada, 0).toString();

            // Buscar en la lista original el responsable que tiene ese nombre (u otro campo único)
            InmuebleDTO seleccionado = null;
            for (InmuebleDTO r : listaInmuebles) {
                if (r.getNombre().equals(nombreSeleccionado)) {
                    seleccionado = r;
                    break;
                }
            }

            int resultado= JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este inmueble?","Confirmar eliminación",JOptionPane.OK_CANCEL_OPTION);
        //si el usuario hace click en aceptar
        if(resultado == JOptionPane.OK_OPTION){
             Controlador<InmuebleDTO> controlador = new InmuebleControlador();
        controlador.eliminar(seleccionado.getId());
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un inmueble primero.");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_listarAmbientes.getSelectedRow();
    
        if (filaSeleccionada != -1) {
            // Buscar el nombre del responsable en la tabla seleccionada
            String nombreSeleccionado = tabla_listarAmbientes.getValueAt(filaSeleccionada, 0).toString();

            // Buscar en la lista original el responsable que tiene ese nombre (u otro campo único)
            AmbienteDTO seleccionado = null;
            for (AmbienteDTO r : listaAmbiente) {
                if (r.getNombre().equals(nombreSeleccionado)) {
                    seleccionado = r;
                    break;
                }
            }


            // Abrir la nueva interfaz y pasarle el objeto
            EditarAmbiente obj = new EditarAmbiente(seleccionado);
            obj.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un ambiente primero.");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_listarAmbientes.getSelectedRow();
    
        if (filaSeleccionada != -1) {
            // Buscar el nombre del responsable en la tabla seleccionada
            String nombreSeleccionado = tabla_listarAmbientes.getValueAt(filaSeleccionada, 0).toString();

            // Buscar en la lista original el responsable que tiene ese nombre (u otro campo único)
            AmbienteDTO seleccionado = null;
            for (AmbienteDTO r : listaAmbiente) {
                if (r.getNombre().equals(nombreSeleccionado)) {
                    seleccionado = r;
                    break;
                }
            }

            int resultado= JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este ambiente?","Confirmar eliminación",JOptionPane.OK_CANCEL_OPTION);
        //si el usuario hace click en aceptar
        if(resultado == JOptionPane.OK_OPTION){
             Controlador<AmbienteDTO> controlador = new AmbienteControlador();
        controlador.eliminar(seleccionado.getId());
        }
        
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un ambiente primero.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        PanelInicio obj = new PanelInicio();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void buscar_inmueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_inmueblesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buscar_inmueblesActionPerformed

    private void buscar_ambientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_ambientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_ambientesActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAmbienteInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAmbienteInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAmbienteInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAmbienteInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAmbienteInmuebles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar_ambientes;
    private javax.swing.JTextField buscar_inmuebles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable tabla_listarAmbientes;
    private org.jdesktop.swingx.JXTable tabla_listarInmuebles;
    private javax.swing.JLabel titulo4;
    // End of variables declaration//GEN-END:variables
}
