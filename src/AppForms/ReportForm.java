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


    /**
     * Creates new form ReportForm
     */
    public ReportForm() {
        initComponents();
        displayReportTable(); // display table
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // closes only current window
    }
    
    private void displayReportTable() {
        
        // initialize report model
        DefaultTableModel model = (DefaultTableModel) jTable_Report.getModel();
       
        // ConcreteClient instance and get array
        ConcreteClient lot = new ConcreteClient();
        ArrayList<Lot> lots = lot.getLots();
        
        // create table and insert array data
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
        jTable_Report.setRowSorter(sorter);
        
        // sort values by numbers
        sorter.setComparator(2, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(Integer.parseInt(s1.replaceAll("[^\\d]", "")), Integer.parseInt(s2.replaceAll("[^\\d]", "")));
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Report = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dirt Stock - Lot Report");

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
        setLocationRelativeTo(null);
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
