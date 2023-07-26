/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ConcreteClient implements Client {

    private ArrayList<Lot> lots = new ArrayList<> ();

    // array & getter
    public ArrayList<Lot> getLots() {
        // SQL db
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=CSS123LOOP;user=sa;password=123;encrypt=true;trustServerCertificate=true;");
            String query1 = "SELECT * FROM LOT";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            while (rs.next()) {
                Lot lot;
                lot = new Lot(rs.getInt("size"), rs.getString("block"), rs.getInt("price"), rs.getString("status"), rs.getInt("own"), rs.getInt("sno"));
                lots.add(lot);
            }            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 

    return lots;
}
    
    // abstract methods
    @Override
    public void buyLot() {   
        JOptionPane.showMessageDialog(null, "Lot bought successfully!");
    }

    @Override
    public void reserveLot() {
        JOptionPane.showMessageDialog(null, "Lot reserved successfully!");
    }

    @Override
    public void notifyClient() {
       JOptionPane.showMessageDialog(null, "Lot added to your My Lots tab.");
    }
    
}
