/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppForms;

import Libs.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class MainForm extends javax.swing.JFrame {
    
    // initialize branching forms
    ReportForm repform = new ReportForm();
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        displayMyLotsTable(); 
        displaySearchTable();
    }
    
    // table for My Lots
    private void displayMyLotsTable() {
        
        DefaultTableModel model = (DefaultTableModel) jTable_MyLots.getModel();
        
        ConcreteClient lotlist = new ConcreteClient();
        ArrayList<Lot> lots = lotlist.listOfLots();
        
        Object rowData[] = new Object[100];
        
        for (int i = 0; i < lots.size(); i++) {
            
            rowData[0] = lots.get(i).getSize() + " sq. m";
            rowData[1] = lots.get(i).getBlock();
            rowData[2] = "$" + lots.get(i).getPrice();
            rowData[3] = lots.get(i).isOwn();
            model.addRow(rowData);
            
        }
        
        // table sorter
        TableRowSorter<DefaultTableModel> sortMyLot = new TableRowSorter<> (model);
        jTable_MyLots.setRowSorter(sortMyLot);
        
        // hide 'Own?' column
        TableColumnModel columnModel = jTable_MyLots.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(3));

        // sort values by numbers
        sortMyLot.setComparator(2, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
            }
        });
        
        // filter where isOwn = true
        sortMyLot.setRowFilter(RowFilter.regexFilter(Boolean.toString(true), 3));
        
    }
    
    private void displaySearchTable() {
        
        DefaultTableModel model = (DefaultTableModel) jTable_Search.getModel();
       
        ConcreteClient lotlist = new ConcreteClient();
        ArrayList<Lot> lots = lotlist.listOfLots();
        
        Object rowData[] = new Object[100];
        
        for (int i = 0; i < lots.size(); i++) {
            
            rowData[0] = lots.get(i).getSize() + " sq. m";
            rowData[1] = lots.get(i).getBlock();
            rowData[2] = "$" + lots.get(i).getPrice();
            rowData[3] = lots.get(i).getStatus();
            model.addRow(rowData);
            
        }
        
        
        // table sorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<> (model);
        jTable_Search.setRowSorter(sorter);
        
        // sort values by numbers
        sorter.setComparator(2, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
            }
        });
        
        // filter array
        List<RowFilter<Object,Object>> filters = new ArrayList<>();
            filters.add(0, RowFilter.regexFilter("", 0)); // size filter item
            filters.add(1, RowFilter.regexFilter("", 1)); // loc filter item
            filters.add(2, RowFilter.regexFilter("", 2)); // price filter item
            filters.add(3, RowFilter.regexFilter("", 3)); // status filter item

        // size filter    
        drop_Size.addActionListener((ActionEvent event) -> {
            
            
            if (drop_Loc.getSelectedIndex() == 0) {
                filters.set(0, RowFilter.regexFilter("", 0));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else {
//                filters.set(0, RowFilter.regexFilter(drop_Size.getSelectedItem().toString(), 0));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });    
            
            
        // Location filter
        drop_Loc.addActionListener((ActionEvent event) -> {
            
            if (drop_Loc.getSelectedIndex() == 0) {
                filters.set(1, RowFilter.regexFilter("", 1));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else {
                filters.set(1, RowFilter.regexFilter(drop_Loc.getSelectedItem().toString(), 1));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });
             
        // price filter
        drop_Price.addActionListener((ActionEvent event) -> {
            
            // if else hell
            
            if (drop_Price.getSelectedIndex() == 0) {
                filters.set(0, RowFilter.regexFilter("", 2));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else if (drop_Price.getSelectedIndex() == 1) {
//                filters.set(0, RowFilter.regexFilter(drop_Size.getSelectedItem().toString(), 2));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
            
            
        });
        
        // Status filter
        drop_Stat.addActionListener((ActionEvent event) -> {
            
            if (drop_Stat.getSelectedIndex() == 0) {
                filters.set(3, RowFilter.regexFilter("", 3));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else {
                filters.set(3, RowFilter.regexFilter(drop_Stat.getSelectedItem().toString(), 3));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_MyLots = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        drop_Size = new javax.swing.JComboBox<>();
        drop_Loc = new javax.swing.JComboBox<>();
        drop_Price = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        drop_Stat = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Search = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_genRep = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel6.setText("Lot location");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dirt Stock - Your Lot, Your Life");

        jLabel1.setFont(new java.awt.Font("Fira Code", 1, 30)); // NOI18N
        jLabel1.setText("Welcome to Dirt Stock!");

        jTabbedPane1.setFont(new java.awt.Font("Fira Code", 0, 18)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        jLabel2.setText("See all these lots? They're yours!");

        jTable_MyLots.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jTable_MyLots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lot Size (Sq. m)", "Location", "Price", "Own?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_MyLots.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_MyLots);
        if (jTable_MyLots.getColumnModel().getColumnCount() > 0) {
            jTable_MyLots.getColumnModel().getColumn(0).setResizable(false);
            jTable_MyLots.getColumnModel().getColumn(1).setResizable(false);
            jTable_MyLots.getColumnModel().getColumn(2).setResizable(false);
            jTable_MyLots.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("  My Lots  ", jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        drop_Size.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "How big?", "200-300 sq. m", "300-400 sq. m", "400-500 sq. m", "500-600 sq. m" }));

        drop_Loc.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Where?", "Block 1", "Block 2", "Block 3", "Block 4", "Block 5" }));
        drop_Loc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_LocItemStateChanged(evt);
            }
        });

        drop_Price.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Price.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "How much?", "$10,000-$50,000", "$50,000-$100,000", "$100,000-$300,000", "$300,000-$600,000" }));

        jLabel3.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        jLabel3.setText("Search for your one true lot!");

        jLabel4.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel4.setText("Lot size");

        jLabel7.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel7.setText("Price");

        jLabel5.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel5.setText("Location");

        drop_Stat.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Available" }));
        drop_Stat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_StatItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel10.setText("Status");

        jTable_Search.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jTable_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lot Size (Sq. m)", "Location", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Search.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_Search);
        if (jTable_Search.getColumnModel().getColumnCount() > 0) {
            jTable_Search.getColumnModel().getColumn(0).setResizable(false);
            jTable_Search.getColumnModel().getColumn(1).setResizable(false);
            jTable_Search.getColumnModel().getColumn(2).setResizable(false);
            jTable_Search.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(drop_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(drop_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(drop_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel10)
                            .addComponent(drop_Stat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drop_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drop_Stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drop_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(drop_Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );

        jTabbedPane1.addTab("  Search  ", jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Fira Code", 0, 24)); // NOI18N
        jLabel8.setText("Click the button.");

        btn_genRep.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        btn_genRep.setText("Generate Report");
        btn_genRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genRepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(btn_genRep))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(btn_genRep)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" Lot report ", jPanel5);

        jLabel9.setFont(new java.awt.Font("Fira Code", 0, 10)); // NOI18N
        jLabel9.setText("powered by Dirt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // generate report button, open ReportForm
    private void btn_genRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genRepActionPerformed

        repform.setVisible(true);
        
    }//GEN-LAST:event_btn_genRepActionPerformed

    private void drop_LocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_LocItemStateChanged
        
//        DefaultTableModel model = (DefaultTableModel) jTable_Search.getModel();
//       
//        ConcreteClient lotlist = new ConcreteClient();
//        ArrayList<Lot> lots = lotlist.listOfLots();
//        
//        Object rowData[] = new Object[100];
//        
//        for (int i = 0; i < lots.size(); i++) {
//            
//            rowData[0] = lots.get(i).getSize() + " sq. m";
//            rowData[1] = lots.get(i).getBlock();
//            rowData[2] = "$" + lots.get(i).getPrice();
//            rowData[3] = lots.get(i).getStatus();
//            model.addRow(rowData);
//            
//        }
//        
//        // table sorter
//        TableRowSorter<DefaultTableModel> sortLoc = new TableRowSorter<> (model);
//        jTable_Search.setRowSorter(sortLoc);
//        
//        // sort values by numbers
//        sortLoc.setComparator(2, new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
//            }
//        });
//        
//        String locQuery = drop_Loc.getSelectedItem().toString();
//        
//        switch (locQuery) {
//            
//            case "Block 1":
//                sortLoc.setRowFilter(RowFilter.regexFilter("Block 1", 1));
//                break;
//            case "Block 2":
//                sortLoc.setRowFilter(RowFilter.regexFilter("Block 2", 1));
//                break;
//            case "Block 3":
//                sortLoc.setRowFilter(RowFilter.regexFilter("Block 3", 1));
//                break;
//            case "Block 4":
//                sortLoc.setRowFilter(RowFilter.regexFilter("Block 4", 1));
//                break;
//            case "Block 5":
//                sortLoc.setRowFilter(RowFilter.regexFilter("Block 5", 1));
//                break;    
//        }
        
    }//GEN-LAST:event_drop_LocItemStateChanged

    private void drop_StatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_StatItemStateChanged
        
//        DefaultTableModel model = (DefaultTableModel) jTable_Search.getModel();
//       
//        ConcreteClient lotlist = new ConcreteClient();
//        ArrayList<Lot> lots = lotlist.listOfLots();
//        
//        Object rowData[] = new Object[100];
//        
//        for (int i = 0; i < lots.size(); i++) {
//            
//            rowData[0] = lots.get(i).getSize() + " sq. m";
//            rowData[1] = lots.get(i).getBlock();
//            rowData[2] = "$" + lots.get(i).getPrice();
//            rowData[3] = lots.get(i).getStatus();
//            model.addRow(rowData);
//            
//        }
//        
//        // table sorter
//        TableRowSorter<DefaultTableModel> sortStat = new TableRowSorter<> (model);
//        jTable_Search.setRowSorter(sortStat);
//        
//        // sort values by numbers
//        sortStat.setComparator(2, new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
//            }
//        });
//        
//        String statQuery = drop_Stat.getSelectedItem().toString();
//        
//        if (statQuery == "Available") {
//                sortStat.setRowFilter(RowFilter.regexFilter("Available", 3));
//        } else
//            jTable_Search.setRowSorter(sortStat);
        
    }//GEN-LAST:event_drop_StatItemStateChanged

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_genRep;
    private javax.swing.JComboBox<String> drop_Loc;
    private javax.swing.JComboBox<String> drop_Price;
    private javax.swing.JComboBox<String> drop_Size;
    private javax.swing.JComboBox<String> drop_Stat;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_MyLots;
    private javax.swing.JTable jTable_Search;
    // End of variables declaration//GEN-END:variables
}
