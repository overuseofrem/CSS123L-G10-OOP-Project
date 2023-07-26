/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface Client {
    
    public ArrayList<Lot> lots = new ArrayList<Lot>();
    
    void buyLot(int rowIndex);
    
    void reserveLot(int rowIndex);
    
    public void attach(Observer obs);
   
    public void remove(Observer obs);
    
    void notifyAllObservers();
    
}
