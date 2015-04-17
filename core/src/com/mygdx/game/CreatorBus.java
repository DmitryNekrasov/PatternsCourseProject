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
public class CreatorBus extends Creator {

    final private int minVelocity = 1, maxVelocity = 10;
    final private int minWeight = 50, maxWeight = 500;
    
    @Override
    public Vehicle factoryMethod() {
        int velocity = Global.generateRandom(minVelocity, maxVelocity);
        double weight = Global.generateRandom(minWeight, maxWeight) + Math.random();
        Bus bus = new Bus(velocity, weight);
        return bus;
    }
    
}
