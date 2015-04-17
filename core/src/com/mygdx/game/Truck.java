/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author ScanNorOne
 */
public class Truck extends Vehicle {

    public Truck(int velocity, double weight, int startMotionDirection) {
        super(velocity, weight, startMotionDirection);
        drawAction = new TruckDrawer();
        width = Constants.widthTruck;
        height = Constants.heightTruck;
    }
    
}
