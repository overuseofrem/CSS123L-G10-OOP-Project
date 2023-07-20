package Libs;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 10
 */
public class Lot {
    
    // attributes
    private int size; // we can amend "sq. m" or just have the number
    private String block; // "Block 1-5" or change to [int] if you just want the number
    private int price; // amend "$". if interested in decimals, use [double]
    private String status;// "Available", "Sold", "Reserved"
    private boolean own; // user owns this lot?
   
    // constructor
    public Lot(int size, String block, int price, String status, boolean own) {
        this.size = size;
        this.block = block;
        this.price = price;
        this.status = status;
        this.own = own;
    }
    
    // methods
    public int getSize() { // get lot size
        return size;
    }

    public String getBlock() { // get lot block
        return block;
    }

    public int getPrice() { // get lot price
        return price;
    }

    public String getStatus() { // get lot status
        return status;
    }

    public void setStatus(String status) { // set lot status
        this.status = status;              // use when buying/reserving
    }                                      // call and use to modify

    public boolean isOwn() {               // check if user owns this lot
        return own;
    }
    
    public void setOwn(boolean own) { // set ownership
        this.own = own;               // used to display at MyLots table
    }                                 // call and use when 
    
}
