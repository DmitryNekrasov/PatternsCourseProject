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
public class Bus extends Vehicle {

    public Bus(int velocity, double weight, int startMotionDirection) {
        super(velocity, weight, startMotionDirection);
        drawAction = new BusDrawer();
        width = Constants.widthBus;
        height = Constants.heightBus;
    }
    
}
