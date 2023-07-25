/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppForms;

import Libs.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
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
    ConcreteClient lot = new ConcreteClient();
    
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
        
        // initialize mylots model
        DefaultTableModel model = (DefaultTableModel) jTable_MyLots.getModel();
        
        // get lot array
        ArrayList<Lot> lots = lot.getLots();
        
        // create table and insert array data
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
    
    // table for Search
    private void displaySearchTable() {
        
        // initialize search model
        DefaultTableModel model = (DefaultTableModel) jTable_Search.getModel();
       
        // get lot array
        ArrayList<Lot> lots = lot.getLots();
        
        // create table and insert array data
        Object rowData[] = new Object[100];
        
        for (int i = 0; i < lots.size(); i++) {
            
            rowData[0] = lots.get(i).getSize();
            rowData[1] = lots.get(i).getBlock();
            rowData[2] = lots.get(i).getPrice();
            rowData[3] = lots.get(i).getStatus();
            model.addRow(rowData);
            
        }
        
        // table sorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<> (model);
        jTable_Search.setRowSorter(sorter);
     
        // filter array
        List<RowFilter<Object,Object>> filters = new ArrayList<>();
            // column filters
            filters.add(0, RowFilter.numberFilter(ComparisonType.AFTER, 0, 0)); // size filter lower bound
            filters.add(1, RowFilter.numberFilter(ComparisonType.BEFORE, 601, 0)); // size filter upper bount
            filters.add(2, RowFilter.regexFilter("", 1)); // loc filter item
            filters.add(3, RowFilter.numberFilter(ComparisonType.AFTER, 9999, 2)); // price filter lower bound
            filters.add(4, RowFilter.numberFilter(ComparisonType.BEFORE, 600001, 2)); // price filter upper bount
            filters.add(5, RowFilter.regexFilter("", 3)); // status filter item

            
        // size filter    
        drop_Size.addActionListener((ActionEvent event) -> {
            // if index == 0, show all
            if (drop_Size.getSelectedIndex() == 0) {
                filters.set(0, RowFilter.numberFilter(ComparisonType.AFTER, 0, 0));
                filters.set(1, RowFilter.numberFilter(ComparisonType.BEFORE, 601, 0));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else { // else apply filter
                // get Size input
                String sizeQuery = drop_Size.getSelectedItem().toString();
                // extract numbers and convert to int
                String[] splitSize = sizeQuery.split("-");
                int lowerSize = Integer.parseInt(splitSize[0]) - 1;
                int upperSize = Integer.parseInt(splitSize[1].split(" ")[0]) + 1;
                // plug converted values in and filter
                filters.set(0, RowFilter.numberFilter(ComparisonType.AFTER, lowerSize, 0));
                filters.set(1, RowFilter.numberFilter(ComparisonType.BEFORE, upperSize, 0));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });    
            
            
        // Location filter
        drop_Loc.addActionListener((ActionEvent event) -> {
            // if index == 0, show all
            if (drop_Loc.getSelectedIndex() == 0) {
                filters.set(2, RowFilter.regexFilter("", 1));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else { // else apply filter
                filters.set(2, RowFilter.regexFilter(drop_Loc.getSelectedItem().toString(), 1));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });
             
        // price filter
        drop_Price.addActionListener((ActionEvent event) -> {
            // if index == 0, show all
            if (drop_Price.getSelectedIndex() == 0) {
                filters.set(3, RowFilter.numberFilter(ComparisonType.AFTER, 9999, 2));
                filters.set(4, RowFilter.numberFilter(ComparisonType.BEFORE, 600001, 2));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else { // else apply filter
                // get Price input
                String priceQuery = drop_Price.getSelectedItem().toString();
                // extract numbers and convert to int
                String[] splitPrice = priceQuery.split("-");
                int lowerPrice = Integer.parseInt(splitPrice[0].substring(1).replace(",", "")) - 1;
                int upperPrice = Integer.parseInt(splitPrice[1].substring(1).replace(",", "")) + 1; 
                // plug converted values in and filter
                filters.set(3, RowFilter.numberFilter(ComparisonType.AFTER, lowerPrice, 2));
                filters.set(4, RowFilter.numberFilter(ComparisonType.BEFORE, upperPrice, 2));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            }
        });
        
        // Status filter
        drop_Stat.addActionListener((ActionEvent event) -> {
            // if index == 0, show all
            if (drop_Stat.getSelectedIndex() == 0) {
                filters.set(5, RowFilter.regexFilter("", 3));
                sorter.setRowFilter(RowFilter.andFilter(filters));
            } else { // else apply filter
                filters.set(5, RowFilter.regexFilter(drop_Stat.getSelectedItem().toString(), 3));
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
        jtxt_Price = new javax.swing.JTextField();
        btn_ExitLot = new javax.swing.JButton();
        btn_ReserveLot = new javax.swing.JButton();
        btn_BuyLot = new javax.swing.JButton();
        jtxt_Size = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxt_Loc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
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
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  My Lots  ", jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        drop_Size.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "How big?", "200-300 sq. m", "300-400 sq. m", "400-500 sq. m", "500-600 sq. m" }));

        drop_Loc.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        drop_Loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Where?", "Block 1", "Block 2", "Block 3", "Block 4", "Block 5" }));

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

        jLabel10.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel10.setText("Status");

        jTable_Search.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jTable_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lot Size (Sq. m)", "Location", "Price (USD, $)", "Status"
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
        jTable_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SearchMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Search);
        if (jTable_Search.getColumnModel().getColumnCount() > 0) {
            jTable_Search.getColumnModel().getColumn(0).setResizable(false);
            jTable_Search.getColumnModel().getColumn(1).setResizable(false);
            jTable_Search.getColumnModel().getColumn(2).setResizable(false);
            jTable_Search.getColumnModel().getColumn(3).setResizable(false);
        }

        jtxt_Price.setEditable(false);
        jtxt_Price.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        jtxt_Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_ExitLot.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        btn_ExitLot.setText("No, exit");
        btn_ExitLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitLotActionPerformed(evt);
            }
        });

        btn_ReserveLot.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        btn_ReserveLot.setText("Reserve Lot");
        btn_ReserveLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReserveLotActionPerformed(evt);
            }
        });

        btn_BuyLot.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        btn_BuyLot.setText("Buy lot");
        btn_BuyLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuyLotActionPerformed(evt);
            }
        });

        jtxt_Size.setEditable(false);
        jtxt_Size.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        jtxt_Size.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel11.setText("Size");

        jLabel12.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel12.setText("Location");

        jtxt_Loc.setEditable(false);
        jtxt_Loc.setFont(new java.awt.Font("Fira Code", 2, 14)); // NOI18N
        jtxt_Loc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jLabel13.setText("Price");

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
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel11))
                            .addComponent(btn_BuyLot, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jtxt_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(btn_ReserveLot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_ExitLot, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel13)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
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
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_BuyLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ReserveLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ExitLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
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
                .addGap(167, 167, 167)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(btn_genRep))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(btn_genRep)
                .addContainerGap(278, Short.MAX_VALUE))
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // generate report button, open ReportForm
    private void btn_genRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genRepActionPerformed
        repform.setVisible(true);        
    }//GEN-LAST:event_btn_genRepActionPerformed

    // select row; open BuyForm
    private void jTable_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SearchMouseClicked
        
        // get selected row
        int rowIndex = jTable_Search.getSelectedRow();
        
        String rowSize = jTable_Search.getValueAt(rowIndex, 0).toString(); // get value from Size
        String rowLoc = jTable_Search.getValueAt(rowIndex, 1).toString(); // get value from Location
        String rowPrice = jTable_Search.getValueAt(rowIndex, 2).toString(); // get value from Price
        String rowStat = jTable_Search.getValueAt(rowIndex, 3).toString().toLowerCase(); // get value from Status

        // if !Available, show dialogue box; else open BuyForm
        if (!"Available".equals(jTable_Search.getValueAt(rowIndex, 3).toString())) {
            JOptionPane.showMessageDialog(null, "Sorry, this lot as already been " + rowStat + ".");
        } else {
            // show on jtxt
            jtxt_Size.setText(rowSize + " sq. m");
            jtxt_Loc.setText(rowLoc);
            jtxt_Price.setText("$" + rowPrice);
        }
    }//GEN-LAST:event_jTable_SearchMouseClicked

    private void btn_ExitLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitLotActionPerformed
        dispose();
    }//GEN-LAST:event_btn_ExitLotActionPerformed

    private void btn_ReserveLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReserveLotActionPerformed
        // TODO add your handling code here:
//        ArrayList<Lot> lots = lot.getLots();
//        lot.buyLot();
        DefaultTableModel model = (DefaultTableModel) jTable_Search.getModel();
            
            if (jTable_Search.getSelectedRowCount() == 1 ) {
                jTable_Search.setValueAt("Reserved", jTable_Search.getSelectedRow(), 3);
                JOptionPane.showMessageDialog(this, "Lot reserved successfully!");
            } else if (jTable_Search.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Please select a lot.");
            }


    }//GEN-LAST:event_btn_ReserveLotActionPerformed

    private void btn_BuyLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuyLotActionPerformed
        // TODO add your handling code here:
        //buyLot();
        //ConcreteClient client = new ConcreteClient();
//        ArrayList<Lot> lots = lot.getLots();
//        lot.buyLot();

            if (jTable_Search.getSelectedRowCount() == 1 ) {
                jTable_Search.setValueAt("Sold", jTable_Search.getSelectedRow(), 3);
                JOptionPane.showMessageDialog(this, "Lot bought successfully!");
            } else if (jTable_Search.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Please select a lot.");
            }

        // Optionally, you can display a message to the user after buying the lot
        JOptionPane.showMessageDialog(this, "Lot bought successfully!");

    }//GEN-LAST:event_btn_BuyLotActionPerformed

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
    private javax.swing.JButton btn_BuyLot;
    private javax.swing.JButton btn_ExitLot;
    private javax.swing.JButton btn_ReserveLot;
    private javax.swing.JButton btn_genRep;
    private javax.swing.JComboBox<String> drop_Loc;
    private javax.swing.JComboBox<String> drop_Price;
    private javax.swing.JComboBox<String> drop_Size;
    private javax.swing.JComboBox<String> drop_Stat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    public javax.swing.JTable jTable_Search;
    public javax.swing.JTextField jtxt_Loc;
    public javax.swing.JTextField jtxt_Price;
    public javax.swing.JTextField jtxt_Size;
    // End of variables declaration//GEN-END:variables
}