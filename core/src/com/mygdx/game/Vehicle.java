/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author ScanNorOne
 */
public abstract class Vehicle {
    
    private int velocity;
    private double weight;
    private int startMotionDirection, finishMotionDirection;
    
    public Vehicle(int velocity, double weight, int startMotionDirection) {
        this.velocity = velocity;
        this.weight = weight;
        this.startMotionDirection = startMotionDirection;
        this.finishMotionDirection = generateFinishMotionDirection(startMotionDirection);
    }
    
    public IDraw drawAction;
    
    public void performDraw(ShapeRenderer sr) {
        drawAction.draw(sr, this);
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
    
    public int getStartMotionDirection() {
        return this.startMotionDirection;
    }
    
    public void setStartMotionDirection(int startMotionDirection) {
        this.startMotionDirection = startMotionDirection;
    }
    
    public int getFinishMotionDirection() {
        return this.finishMotionDirection;
    }
    
    public void setFinishMotionDirection(int finishMotionDirection) {
        this.finishMotionDirection = finishMotionDirection;
    }
    
    private int generateFinishMotionDirection(int startMotionDirection) {
        int tmp = Global.generateRandom(1, 3);
        int finish = startMotionDirection;
        switch (startMotionDirection) {
            case Constants.leftToRight:
                switch (tmp) {
                    case 1: finish = Constants.bottomToTop; break;
                    case 2: finish = Constants.topToBottom; break;
                }
                break;
                
            case Constants.rightToLeft :
                switch (tmp) {
                    case 1: finish = Constants.bottomToTop; break;
                    case 2: finish = Constants.topToBottom; break;
                }
                break;
                
            case Constants.bottomToTop:
                switch (tmp) {
                    case 1: finish = Constants.leftToRight; break;
                    case 2: finish = Constants.rightToLeft; break;
                }
                break;
                
            case Constants.topToBottom:
                switch (tmp) {
                    case 1: finish = Constants.leftToRight; break;
                    case 2: finish = Constants.rightToLeft; break;
                }
                break;
        }
        return finish;
    }
    
}
