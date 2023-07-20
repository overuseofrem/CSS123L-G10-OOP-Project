/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppForms;

import Libs.*;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class ReportForm extends javax.swing.JFrame {
    
    private ArrayList<Lot> lots = new ArrayList<> ();

    /**
     * Creates new form ReportForm
     */
    public ReportForm() {
        initComponents();
        displayTable(); // display table
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // closes only current window
    }
    
    public ArrayList listOfLots() {
    
        lots = new ArrayList<>();
        
        // lot values (20 lots per block, 100 lots in total)
        
        // block 1
            lots.add(new Lot(250, "Block 1", 50000, "Reserved", false));
            lots.add(new Lot(300, "Block 1", 70000, "Sold", false));
            lots.add(new Lot(500, "Block 1", 69000, "Available", false));
            lots.add(new Lot(600, "Block 1", 500000, "Reserved", false));
            lots.add(new Lot(200, "Block 1", 12000, "Available", false));
            lots.add(new Lot(250, "Block 1", 50000, "Available", false));
            lots.add(new Lot(400, "Block 1", 50000, "Sold", false));
            lots.add(new Lot(460, "Block 1", 50000, "Available", false));
            lots.add(new Lot(520, "Block 1", 20000, "Available", false));
            lots.add(new Lot(600, "Block 1", 120000, "Sold", false));
            lots.add(new Lot(600, "Block 1", 50000, "Reserved", false));
            lots.add(new Lot(402, "Block 1", 98000, "Available", false));
            lots.add(new Lot(400, "Block 1", 55000, "Available", false));
            lots.add(new Lot(500, "Block 1", 80000, "Available", false));
            lots.add(new Lot(580, "Block 1", 100000, "Available", false));
            lots.add(new Lot(300, "Block 1", 37000, "Sold", false));
            lots.add(new Lot(240, "Block 1", 50000, "Reserved", false));
            lots.add(new Lot(380, "Block 1", 500000, "Reserved", false));
            lots.add(new Lot(200, "Block 1", 54000, "Available", false));
            lots.add(new Lot(280, "Block 1", 68000, "Sold", false));
        
        // block 2
            lots.add(new Lot(510, "Block 2", 201790, "Available", false));
            lots.add(new Lot(230, "Block 2", 100970, "Sold", false));
            lots.add(new Lot(530, "Block 2", 200670, "Available", false));
            lots.add(new Lot(220, "Block 2", 90875, "Available", false));
            lots.add(new Lot(590, "Block 2", 200280, "Available", false));
            lots.add(new Lot(500, "Block 2", 80660, "Available", false));
            lots.add(new Lot(220, "Block 2", 70000, "Reserved", false));
            lots.add(new Lot(220, "Block 2", 74000, "Available", false));
            lots.add(new Lot(290, "Block 2", 120000, "Available", false));
            lots.add(new Lot(500, "Block 2", 550000, "Available", false));
            lots.add(new Lot(400, "Block 2", 500000, "Available", false));
            lots.add(new Lot(450, "Block 2", 98000, "Sold", false));
            lots.add(new Lot(560, "Block 2", 55000, "Sold", false));
            lots.add(new Lot(350, "Block 2", 98900, "Available", false));
            lots.add(new Lot(600, "Block 2", 600000, "Available", false));
            lots.add(new Lot(430, "Block 2", 130000, "Available", false));
            lots.add(new Lot(210, "Block 2", 55000, "Available", false));
            lots.add(new Lot(440, "Block 2", 81000, "Reserved", false));
            lots.add(new Lot(300, "Block 2", 10000, "Available", false));
            lots.add(new Lot(200, "Block 2", 9000, "Available", false));
        
        // block 3
        
            lots.add(new Lot(200, "Block 3", 90000, "Reserved", false));
            lots.add(new Lot(250, "Block 3", 120000, "Available", false));
            lots.add(new Lot(300, "Block 3", 100000, "Available", false));
            lots.add(new Lot(350, "Block 3", 190700, "Available", false));
            lots.add(new Lot(600, "Block 3", 450000, "Available", false));
            lots.add(new Lot(550, "Block 3", 550530, "Available", false));
            lots.add(new Lot(450, "Block 3", 320000, "Available", false));
            lots.add(new Lot(300, "Block 3", 200000, "Sold", false));
            lots.add(new Lot(480, "Block 3", 470000, "Available", false));
            lots.add(new Lot(330, "Block 3", 400000, "Available", false));
            lots.add(new Lot(320, "Block 3", 580000, "Available", false));
            lots.add(new Lot(290, "Block 3", 100000, "Available", false));
            lots.add(new Lot(250, "Block 3", 130000, "Sold", false));
            lots.add(new Lot(360, "Block 3", 400500, "Reserved", false));
            lots.add(new Lot(540, "Block 3", 600000, "Available", false));
            lots.add(new Lot(500, "Block 3", 580000, "Reserved", false));
            lots.add(new Lot(600, "Block 3", 600000, "Available", false));
            lots.add(new Lot(340, "Block 3", 400980, "Available", false));
            lots.add(new Lot(330, "Block 3", 230000, "Available", false));
            lots.add(new Lot(440, "Block 3", 500000, "Sold", false));
            
        
        // block 4
        
            lots.add(new Lot(520, "Block 4", 200000, "Available", false));
            lots.add(new Lot(580, "Block 4", 280000, "Sold", false));
            lots.add(new Lot(220, "Block 4", 30800, "Available", false));
            lots.add(new Lot(540, "Block 4", 250000, "Reserved", false));
            lots.add(new Lot(490, "Block 4", 360000, "Reserved", false));
            lots.add(new Lot(360, "Block 4", 280000, "Available", false));
            lots.add(new Lot(230, "Block 4", 95000, "Available", false));
            lots.add(new Lot(580, "Block 4", 600000, "Sold", false));
            lots.add(new Lot(220, "Block 4", 100000, "Sold", false));
            lots.add(new Lot(270, "Block 4", 150000, "Sold", false));
            lots.add(new Lot(260, "Block 4", 148000, "Sold", false));
            lots.add(new Lot(430, "Block 4", 500000, "Available", false));
            lots.add(new Lot(200, "Block 4", 98000, "Available", false));
            lots.add(new Lot(550, "Block 4", 480000, "Reserved", false));
            lots.add(new Lot(200, "Block 4", 10000, "Available", false));
            lots.add(new Lot(260, "Block 4", 36000, "Sold", false));
            lots.add(new Lot(420, "Block 4", 540000, "Sold", false));
            lots.add(new Lot(540, "Block 4", 600000, "Reserved", false));
            lots.add(new Lot(490, "Block 4", 490000, "Available", false));
            lots.add(new Lot(360, "Block 4", 120000, "Reserved", false));
        
        // block 5
        
            lots.add(new Lot(230, "Block 5", 54000, "Sold", false));
            lots.add(new Lot(580, "Block 5", 480000, "Sold", false));
            lots.add(new Lot(220, "Block 5", 36000, "Available", false));
            lots.add(new Lot(260, "Block 5", 70000, "Reserved", false));
            lots.add(new Lot(430, "Block 5", 125000, "Available", false));
            lots.add(new Lot(580, "Block 5", 460000, "Reserved", false));
            lots.add(new Lot(220, "Block 5", 12000, "Available", false));
            lots.add(new Lot(590, "Block 5", 500000, "Sold", false));
            lots.add(new Lot(350, "Block 5", 200900, "Sold", false));
            lots.add(new Lot(600, "Block 5", 590000, "Reserved", false));
            lots.add(new Lot(360, "Block 5", 530000, "Available", false));
            lots.add(new Lot(540, "Block 5", 500000, "Available", false));
            lots.add(new Lot(550, "Block 5", 520000, "Sold", false));
            lots.add(new Lot(580, "Block 5", 570000, "Available", false));
            lots.add(new Lot(360, "Block 5", 140000, "Available", false));
            lots.add(new Lot(330, "Block 5", 100000, "Sold", false));
            lots.add(new Lot(350, "Block 5", 120000, "Available", false));
            lots.add(new Lot(400, "Block 5", 380000, "Sold", false));
            lots.add(new Lot(410, "Block 5", 400000, "Sold", false));
            lots.add(new Lot(480, "Block 5", 570000, "Available", false));
        
        return lots;
    }
    
    // getList
    public ArrayList<Lot> getList() {
        return lots;
    }
    
    public void displayTable() {
        
        DefaultTableModel model = (DefaultTableModel) jTable_Report.getModel();
        ArrayList<Lot> lots = listOfLots();
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
        
        // sort values by numbers
        sorter.setComparator(2, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
            }
        });
        
        jTable_Report.setRowSorter(sorter);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Report = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Fira Code", 0, 24)); // NOI18N
        jLabel1.setText("Lot report");

        jTable_Report.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jTable_Report.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Report.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_Report);
        if (jTable_Report.getColumnModel().getColumnCount() > 0) {
            jTable_Report.getColumnModel().getColumn(0).setResizable(false);
            jTable_Report.getColumnModel().getColumn(1).setResizable(false);
            jTable_Report.getColumnModel().getColumn(2).setResizable(false);
            jTable_Report.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Report;
    // End of variables declaration//GEN-END:variables
}
