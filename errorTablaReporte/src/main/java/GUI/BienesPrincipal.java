/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI;

import org.contenido.controlador.Controlador;
import org.contenido.controlador.controladorImpl.*;
import org.contenido.dto.*;
import org.contenido.modelo.Estado;
import org.contenido.modelo.Inmueble;
import org.contenido.reporte.ReporteXLSX;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;



/**
 *
 * @author SERT
 */
public class BienesPrincipal extends javax.swing.JFrame {


    BienDTO b1 = new BienDTO();
    {
        b1.setCodigo("pc");
        b1.setNombre("pc");
        b1.setDescripcion("de renzo");

        CategoriaDTO c1 = new CategoriaDTO();
        c1.setNombre("Dispositivo Electronico");

        EstadoDTO e1 = new EstadoDTO();
        e1.setTipo("En Mantenimiento");

        ResponsableDTO r1 = new ResponsableDTO();
        r1.setNombre("Italo Vasquez");

        InmuebleDTO i1 = new InmuebleDTO();
        i1.setNombre("Torre_A");

        AmbienteDTO a1 = new AmbienteDTO();
        a1.setNombre("A_101");
        a1.setInmuebleDTO(i1);

        b1.setFecha_registro(LocalDate.of(2025, 7, 13));

        b1.setCategoriaDTO(c1);
        b1.setEstado_actualDTO(e1);
        b1.setResponsableDTO(r1);
        b1.setAmbienteDTO(a1);
    }

    BienDTO b2 = new BienDTO();
    {
        b2.setCodigo("Laptop");
        b2.setNombre("Laptop");
        b2.setDescripcion("maquina superpotente");

        CategoriaDTO c2 = new CategoriaDTO();
        c2.setNombre("Dispositivo Electronico");

        EstadoDTO e2 = new EstadoDTO();
        e2.setTipo("De Baja");

        ResponsableDTO r2 = new ResponsableDTO();
        r2.setNombre("Italo Vasquez");

        InmuebleDTO i2 = new InmuebleDTO();
        i2.setNombre("Torre_A");

        AmbienteDTO a2 = new AmbienteDTO();
        a2.setNombre("A_101");
        a2.setInmuebleDTO(i2);

        b2.setFecha_registro(LocalDate.of(2025, 7, 13));

        b2.setCategoriaDTO(c2);
        b2.setEstado_actualDTO(e2);
        b2.setResponsableDTO(r2);
        b2.setAmbienteDTO(a2);
    }

    BienDTO b3 = new BienDTO();
    {
        b3.setCodigo("teclado");
        b3.setNombre("teclado");
        b3.setDescripcion("tecladomecánico");

        CategoriaDTO c3 = new CategoriaDTO();
        c3.setNombre("Dispositivo Electronico");

        EstadoDTO e3 = new EstadoDTO();
        e3.setTipo("De Baja");

        ResponsableDTO r3 = new ResponsableDTO();
        r3.setNombre("Italo Vasquez");

        InmuebleDTO i3 = new InmuebleDTO();
        i3.setNombre("Torre_A");

        AmbienteDTO a3 = new AmbienteDTO();
        a3.setNombre("A_101");
        a3.setInmuebleDTO(i3);

        b3.setFecha_registro(LocalDate.of(2025, 7, 13));

        b3.setCategoriaDTO(c3);
        b3.setEstado_actualDTO(e3);
        b3.setResponsableDTO(r3);
        b3.setAmbienteDTO(a3);
    }
    BienDTO b4 = new BienDTO();
    {
        b4.setCodigo("A_0002");
        b4.setNombre("Computadora");
        b4.setDescripcion("Computadora normal");
        CategoriaDTO c4 = new CategoriaDTO();
        c4.setNombre("Dispositivo Electronico");

        EstadoDTO e4 = new EstadoDTO();
        e4.setTipo("Activo");
        ResponsableDTO r4 = new ResponsableDTO();
        r4.setNombre("Italo Vasquez");

        InmuebleDTO i4 = new InmuebleDTO();
        i4.setNombre("Torre_A");
        AmbienteDTO a4 = new AmbienteDTO();
        a4.setNombre("A_102");
        a4.setInmuebleDTO(i4);
        b4.setFecha_registro(LocalDate.of(2025, 7, 13));

        b4.setCategoriaDTO(c4);
        b4.setEstado_actualDTO(e4);
        b4.setResponsableDTO(r4);
        b4.setAmbienteDTO(a4);
    }

    BienDTO b5 = new BienDTO();
    {
        b5.setCodigo("A_0002");
        b5.setNombre("Computadora");
        b5.setDescripcion("Computadora normal");
        CategoriaDTO c5 = new CategoriaDTO();
        c5.setNombre("Dispositivo Electronico");

        EstadoDTO e5 = new EstadoDTO();
        e5.setTipo("Activo");
        ResponsableDTO r5 = new ResponsableDTO();
        r5.setNombre("Italo Vasquez");

        InmuebleDTO i5 = new InmuebleDTO();
        i5.setNombre("Torre_A");
        AmbienteDTO a5 = new AmbienteDTO();
        a5.setNombre("A_102");
        a5.setInmuebleDTO(i5);
        b5.setFecha_registro(LocalDate.of(2025, 7, 13));

        b5.setCategoriaDTO(c5);
        b5.setEstado_actualDTO(e5);
        b5.setResponsableDTO(r5);
        b5.setAmbienteDTO(a5);
    }

    BienDTO b6 = new BienDTO();
    {
        b6.setCodigo("Cafetera");
        b6.setNombre("Cafetera");
        b6.setDescripcion("Cafetera que es para los docentes");

        CategoriaDTO c6 = new CategoriaDTO();
        c6.setNombre("Dispositivo Electronico");

        EstadoDTO e6 = new EstadoDTO();
        e6.setTipo("Activo");

        ResponsableDTO r6 = new ResponsableDTO();
        r6.setNombre("Victor Chung");

        InmuebleDTO i6 = new InmuebleDTO();
        i6.setNombre("Torre_A");

        AmbienteDTO a6 = new AmbienteDTO();
        a6.setNombre("A_101");
        a6.setInmuebleDTO(i6);

        b6.setFecha_registro(LocalDate.of(2025, 7, 13));

        b6.setCategoriaDTO(c6);
        b6.setEstado_actualDTO(e6);
        b6.setResponsableDTO(r6);
        b6.setAmbienteDTO(a6);
    }


    /**
     * Creates new form BienesPrincipal
     */
    Controlador<BienDTO> controlador = new BienControlador();
    List<BienDTO> listabien = controlador.listarTodo(); //controlador.listarTodo();
    
    public BienesPrincipal() {
        //listabien = List.of(b4, b5, b6, b1, b2, b3);
        initComponents();

        jComboBox4.removeAllItems();
        CategoriaDTO todosCat = new CategoriaDTO();
        todosCat.setId(0); 
        todosCat.setNombre("Todos");
        jComboBox4.addItem(todosCat);
        new CategoriaControlador().listarTodo().forEach(jComboBox4::addItem);
        
        jComboBox1.removeAllItems();
        EstadoDTO todosEst = new EstadoDTO();
        todosEst.setId(0); 
        todosEst.setTipo("Todos");
        jComboBox1.addItem(todosEst);
        new EstadoControlador().listarTodo().forEach(jComboBox1::addItem);
        
        jComboBox2.removeAllItems();
        AmbienteDTO todosAmb = new AmbienteDTO();
        todosAmb.setId(0); 
        todosAmb.setNombre("Todos");
        jComboBox2.addItem(todosAmb);
        new AmbienteControlador().listarTodo().forEach(jComboBox2::addItem);
        
        jComboBox3.removeAllItems();
        InmuebleDTO todosInm = new InmuebleDTO();
        todosInm.setId(0); 
        todosInm.setNombre("Todos");
        jComboBox3.addItem(todosInm);
        new InmuebleControlador().listarTodo().forEach(jComboBox3::addItem);
        
        cargarBien();
        
        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void removeUpdate(DocumentEvent e){ aplicarFiltros(); }
            public void changedUpdate(DocumentEvent e){ aplicarFiltros(); }
        };
        jTextField2.getDocument().addDocumentListener(dl);
        jTextField1.getDocument().addDocumentListener(dl);
        jTextField6.getDocument().addDocumentListener(dl);
        jTextField8.getDocument().addDocumentListener(dl);

        // Cuando cambie cualquiera de los combos:
        ActionListener al = e -> aplicarFiltros();
        jComboBox1.addActionListener(al);
        jComboBox2.addActionListener(al);
        jComboBox3.addActionListener(al);
        jComboBox4.addActionListener(al);
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBien = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PANEL_INICIO/logo1.jpg"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Control de Bienes");

        jLabel3.setText("Accede al historial completo de los bienes asignados");

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Atrás");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(134, 134, 134))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 243, 239));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Añadir bien");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar bien");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar según:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Categoría:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Responsable:");

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Exportar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ambiente:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha de registro:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Inmueble:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Código:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        TablaBien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaBien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(556, 556, 556)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6)
                                    .addComponent(jComboBox1, 0, 163, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(52, 54, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel7)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton3ActionPerformed


    private List<Object[]> convertirTablaLista() {
        List<Object[]> datosFiltrados = new ArrayList<>();

        if (TablaBien == null) {
            System.out.println("Tabla nula");
            return datosFiltrados;
        }

        TableModel modelo = TablaBien.getModel();
        int columnas = modelo.getColumnCount();

        // agregar encabezado a los datos
        String[] encabezado = new String[columnas];
        for (int i = 0; i < columnas; i++) {
            encabezado[i] = modelo.getColumnName(i);
        }
        datosFiltrados.add(encabezado); //agregamos el encabezado a los datos

        for (int i = 0; i < TablaBien.getRowCount(); i++) {
            int modelIndex = TablaBien.convertRowIndexToModel(i);
            Object[] fila = new Object[columnas];
            for (int j = 0; j < columnas; j++) {
                Object valor = modelo.getValueAt(modelIndex, j);
                fila[j] = (valor != null) ? valor : "";  // evitar null
            }
            datosFiltrados.add(fila);
        }

        return datosFiltrados;
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        /*TableModel modelo = TablaBien.getModel();
        int columnas = modelo.getColumnCount();

        String[] encabezado = new String[columnas];
        for (int i = 0; i < columnas; i++) {
            encabezado[i] = modelo.getColumnName(i);
        }*/

        List<Object[]> datos = convertirTablaLista();
        System.out.println("datos: " + datos);
        ReporteXLSX reporte = new ReporteXLSX("Filtrado", "Filtrado Bienes", "/Users/isra-macbook/Documents/", datos);
        System.out.println("otra vez");
        System.out.println("datos: " + datos);
        reporte.exportarReporte();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    private void cargarBien() {
    DefaultTableModel modelo = new DefaultTableModel(
        new String[]{
            "Código","Nombre","Descripción","Categoría","Estado",
            "Responsable a cargo","Inmueble","Ambiente","Fecha Registro"
        }, 0
    );

    for (BienDTO bien : listabien) {
        // nombre del inmueble (o vacío si no existe)
        String nombreInmueble = "";
        if (bien.getAmbienteDTO() != null 
            && bien.getAmbienteDTO().getInmuebleDTO() != null) {
            nombreInmueble = bien.getAmbienteDTO()
                                 .getInmuebleDTO()
                                 .getNombre(); 
        }

        modelo.addRow(new Object[]{
            bien.getCodigo(),                           // columna 0: Código
            bien.getNombre(),                           // 1
            bien.getDescripcion(),                      // 2
            bien.getCategoriaDTO()    != null 
                ? bien.getCategoriaDTO().getNombre()    // 3
                : "",
            bien.getEstado_actualDTO() != null 
                ? bien.getEstado_actualDTO().getTipo()  // 4
                : "",
            bien.getResponsableDTO()   != null 
                ? bien.getResponsableDTO().getNombre()  // 5
                : "",
            nombreInmueble,                             // 6: Inmueble
            (bien.getAmbienteDTO() != null 
                ? bien.getAmbienteDTO().getNombre() 
                : ""),                                  // 7: Ambiente
            bien.getFecha_registro()                    // 8
        });
    }

    // 3) Asignamos el modelo actualizado a la tabla
    TablaBien.setModel(modelo);
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
            java.util.logging.Logger.getLogger(BienesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BienesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BienesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BienesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BienesPrincipal().setVisible(true);
            }
        });
    }

    private void aplicarFiltros() {
    // Lectura de los textos de filtro
    String txtCodigo = jTextField2.getText().trim().toLowerCase();
    String txtNombre = jTextField1.getText().trim().toLowerCase();
    String txtResp   = jTextField6.getText().trim().toLowerCase();
    String txtFecha  = jTextField8.getText().trim();

    // Lectura de los combos (suponiendo que el índice 0 es "Todos" con id = 0)
    CategoriaDTO catSel  = (CategoriaDTO) jComboBox4.getSelectedItem();
    EstadoDTO   estSel  = (EstadoDTO)   jComboBox1.getSelectedItem();
    AmbienteDTO ambSel  = (AmbienteDTO) jComboBox2.getSelectedItem();
    InmuebleDTO inmSel  = (InmuebleDTO) jComboBox3.getSelectedItem();

    int catId = (catSel   != null ? catSel.getId()   : 0);
    int estId = (estSel   != null ? estSel.getId()   : 0);
    int ambId = (ambSel   != null ? ambSel.getId()   : 0);
    int inmId = (inmSel   != null ? inmSel.getId()   : 0);

    // Preparamos el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel(
        new String[]{
            "Código",
            "Nombre",
            "Descripción",
            "Categoría",
            "Estado",
            "Responsable",
            "Inmueble",
            "Ambiente",
            "Fecha Registro"
        },
        0
    );

    // Recorremos todos los bienes y aplicamos cada filtro
    for (BienDTO b : listabien) {
        // 1) Filtrar por codigo
        if (!txtCodigo.isEmpty() &&
            !b.getCodigo().toLowerCase().contains(txtCodigo)) {
            continue;
        }
        
        // 2) Filtrar por nombre
        if (!txtNombre.isEmpty() &&
            !b.getNombre().toLowerCase().contains(txtNombre)) {
            continue;
        }

        // 3) Filtrar por fecha (comparación por contains; adapta si quieres Date)
        if (!txtFecha.isEmpty() &&
            !b.getFecha_registro().toString().contains(txtFecha)) {
            continue;
        }

        // 4) Filtrar por categoría
        if (catId != 0 &&
            (b.getCategoriaDTO() == null || b.getCategoriaDTO().getId() != catId)) {
            continue;
        }

        // 5) Filtrar por estado
        if (estId != 0 &&
            (b.getEstado_actualDTO() == null || b.getEstado_actualDTO().getId() != estId)) {
            continue;
        }

        // 6) Filtrar por responsable
        if (!txtResp.isEmpty() &&
            (b.getResponsableDTO() == null ||
             !b.getResponsableDTO().getNombre().toLowerCase().contains(txtResp))) {
            continue;
        }

        // 7) Filtrar por ambiente
        if (ambId != 0 &&
            (b.getAmbienteDTO() == null || b.getAmbienteDTO().getId() != ambId)) {
            continue;
        }

        // 8) Filtrar por inmueble
        if (inmId != 0 &&
            (b.getAmbienteDTO() == null
             || b.getAmbienteDTO().getInmuebleDTO() == null
             || b.getAmbienteDTO().getInmuebleDTO().getId() != inmId)) {
            continue;
        }

        // A estas alturas, el bien pasa todos los filtros → lo agregamos
        // Primero obtenemos con seguridad los nombres de inmueble y ambiente
        String nombreInmueble = "";
        if (b.getAmbienteDTO() != null && b.getAmbienteDTO().getInmuebleDTO() != null) {
            nombreInmueble = b.getAmbienteDTO().getInmuebleDTO().getNombre();
        }

        String nombreAmbiente = "";
        if (b.getAmbienteDTO() != null) {
            nombreAmbiente = b.getAmbienteDTO().getNombre();
        }

        // Agregamos la fila al modelo
        model.addRow(new Object[]{
            b.getCodigo(),
            b.getNombre(),
            b.getDescripcion(),
            (b.getCategoriaDTO()    != null ? b.getCategoriaDTO().getNombre() : ""),
            (b.getEstado_actualDTO() != null ? b.getEstado_actualDTO().getTipo() : ""),
            (b.getResponsableDTO()   != null ? b.getResponsableDTO().getNombre() : ""),
            nombreInmueble,
            nombreAmbiente,
            b.getFecha_registro()
        });
    }

    // Asignamos el modelo resultante a la tabla
    TablaBien.setModel(model);
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable TablaBien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<EstadoDTO> jComboBox1;
    private javax.swing.JComboBox<AmbienteDTO> jComboBox2;
    private javax.swing.JComboBox<InmuebleDTO> jComboBox3;
    private javax.swing.JComboBox<CategoriaDTO> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
