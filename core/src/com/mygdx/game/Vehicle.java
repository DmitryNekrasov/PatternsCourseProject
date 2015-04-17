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
public abstract class Vehicle {
    
    private int velocity;
    private double weight;
    
    public Vehicle(int velocity, double weight) {
        this.velocity = velocity;
        this.weight = weight;
    }
    
    public int getVelocity() {
        return this.velocity;
    }
    
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
}
