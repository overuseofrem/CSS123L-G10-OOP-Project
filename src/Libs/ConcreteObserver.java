/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() { 
        JOptionPane.showMessageDialog(null, "Please restart Dirt Stock to see changes.");
    }
    
}
