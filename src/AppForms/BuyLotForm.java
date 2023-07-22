/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AppForms;
import Libs.Lot;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author espirituwong
 */
public class BuyLotForm extends javax.swing.JPanel {

//    private ArrayList<Lot> availableLots;
    
    /**
     * Creates new form BuyLotPanel
     */
    
    public BuyLotForm(ArrayList<Lot> availableLots) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // closes only current window

    }    
        
//    public BuyLotForm(ArrayList<Lot> availableLots) {
//      this.availableLots = availableLots;
//        initComponents();
//        populateLotsChoice();
//    }

//    private void populateLotsChoice() {
//        for (Lot lot : availableLots) {
//            choice1.add(lot.getLocation());
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btn_ReserveLot = new javax.swing.JButton();
        btn_BuyLot = new javax.swing.JButton();
        btn_ExitLot = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 18)); // NOI18N
        jLabel2.setText("Are you sure you want this lot?");

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

        btn_ExitLot.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        btn_ExitLot.setText("No, exit");
        btn_ExitLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitLotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btn_BuyLot, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ReserveLot, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel2)))
                .addGap(42, 42, 42)
                .addComponent(btn_ExitLot, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_BuyLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ReserveLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ExitLot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );
    }// </editor-fold>//GEN-END:initComponents

    // reserve lot btn
    private void btn_ReserveLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReserveLotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ReserveLotActionPerformed

    // buy lot btn
    private void btn_BuyLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuyLotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_BuyLotActionPerformed

    // exit btn
    private void btn_ExitLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitLotActionPerformed
        
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        
    }//GEN-LAST:event_btn_ExitLotActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuyLot;
    private javax.swing.JButton btn_ExitLot;
    private javax.swing.JButton btn_ReserveLot;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
