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
public class ConcreteClient implements Client {
    
    private ArrayList<Lot> lots = new ArrayList<> ();

    // array
    public ArrayList listOfLots() {

    lots = new ArrayList<>();

    // lot values (20 lots per block, 100 lots in total)

    // block 1
        lots.add(new Lot(250, "Block 1", 50000, "Reserved", true));
        lots.add(new Lot(300, "Block 1", 70000, "Sold", true));
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
        lots.add(new Lot(300, "Block 2", 20000, "Available", false));
        lots.add(new Lot(200, "Block 2", 10000, "Available", false));

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
    
    // abstract methods
    
    ConcreteObserver observers = new ConcreteObserver();
    
    @Override
    public void buyLot(ArrayList<Lot> lots) {
        
        // check if status == "Available", set to "Sold"
        
    }

    @Override
    public void reserveLot(ArrayList<Lot> lots) {
        
        
        // check if status == "Available", set to "Reserved"
        
    }
    
    @Override
    public void notifyClient() {
        
    }
    
}
