package Libs;

import AppForms.MainForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConcreteClient implements Client {

    private ArrayList<Lot> lots = new ArrayList<>();

    // Constructor to initialize lots
    public ConcreteClient() {
        // Add hard-coded lots to the ArrayList
        // Format: Lot(size, block, price, status, own, sno)
        lots.add(new Lot(100, "A1", 50000, "Available", 0, 1));
        lots.add(new Lot(200, "B2", 75000, "Available", 0, 2));
        lots.add(new Lot(150, "C3", 60000, "Reserved", 1, 3));
    }

    // Getter for lots
    public ArrayList<Lot> getLots() {
        return lots;
    }

  public void reserveLot(int rowIndex, MainForm mainForm) {
    if (rowIndex >= 0 && "Available".equals(mainForm.getValueAtSearchTable(rowIndex, 3).toString())) {
        Lot selectedLot = lots.get(rowIndex);

        // Check if the 'own' count is less than 1
        if (selectedLot.getOwn() >= 1) {
            JOptionPane.showMessageDialog(null, "You can't reserve this lot! Please choose another one.");
            return; // Do not proceed with the reservation
        }

        // Increment the own count for the selected lot
        selectedLot.setOwn(selectedLot.getOwn() + 1);

        // Update the status to "Reserved" in the ArrayList
        selectedLot.setStatus("Reserved");

        // Notify the client
        JOptionPane.showMessageDialog(null, "Lot reserved successfully!");

        // Refresh the "My Lots" table to reflect the changes in MainForm
        mainForm.displayMyLotsTable();
    } else {
        JOptionPane.showMessageDialog(null, "You can't reserve this lot! Please choose another one.");
    }
}

public void buyLot(int rowIndex, MainForm mainForm) {
    if (rowIndex >= 0 && "Available".equals(mainForm.getValueAtSearchTable(rowIndex, 3).toString())) {
        Lot selectedLot = lots.get(rowIndex);

        // Check if the 'own' count is less than 1
        if (selectedLot.getOwn() >= 1) {
            JOptionPane.showMessageDialog(null, "You can't buy this lot! Please choose another one.");
            return; // Do not proceed with the purchase
        }

        // Increment the own count for the selected lot
        selectedLot.setOwn(selectedLot.getOwn() + 1);

        // Update the status to "Sold" in the ArrayList
        selectedLot.setStatus("Sold");

        // Notify the client
        JOptionPane.showMessageDialog(null, "Lot bought successfully!");

        // Refresh the "My Lots" table to reflect the changes in MainForm
        mainForm.displayMyLotsTable();
    } else {
        JOptionPane.showMessageDialog(null, "You can't buy this lot! Please choose another one.");
    }
}

    @Override
    public void notifyClient() {
        JOptionPane.showMessageDialog(null, "Lot added to your My Lots tab.");
    }

    @Override
    public void buyLot() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void reserveLot() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
