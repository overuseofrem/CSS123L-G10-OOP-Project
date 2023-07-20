package Libs;

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
    private String status; // "Available", "Sold", "Reserved"
   
    // constructor
    public Lot(int size, String block, int price, String status) {
        this.size = size;
        this.block = block;
        this.price = price;
        this.status = status;
    }
    
    // methods
    public int getSize() {
        return size;
    }

    public String getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
    
}
