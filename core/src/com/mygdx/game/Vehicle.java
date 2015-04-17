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
    
    private float velocity;
    private double weight;
    private int startMotionDirection, finishMotionDirection, currentMotionDirection;
    private float xOnScreen, yOnScreen;
    protected int width, height;
    private boolean turn;  // признак поворота
    private int lanes;  // номера полосы движения
    private int timeToStart;  // время до старта
    private float stepVelocity;  // шаг, с которым изменяется скорость
    
    public Vehicle(int velocity, double weight, int startMotionDirection) {
        this.velocity = velocity;
        this.weight = weight;
        this.startMotionDirection = startMotionDirection;
        this.currentMotionDirection = startMotionDirection;
        this.finishMotionDirection = generateFinishMotionDirection(startMotionDirection);
        turn = false;
        this.stepVelocity = velocity / Constants.den;
        
        // вычисление полосы движения
        
        if (startMotionDirection == Constants.leftToRight && finishMotionDirection == Constants.bottomToTop || 
                startMotionDirection == Constants.rightToLeft && finishMotionDirection == Constants.topToBottom ||
                startMotionDirection == Constants.bottomToTop && finishMotionDirection == Constants.rightToLeft ||
                startMotionDirection == Constants.topToBottom && finishMotionDirection == Constants.leftToRight
                ) {
            lanes = Constants.first;
        } else if (startMotionDirection == finishMotionDirection) {
            lanes = Constants.second;
        } else {
            lanes = Constants.third;
        }
        
    }
    
    public IDraw drawAction;
    
    public void performDraw(ShapeRenderer sr) {
        drawAction.draw(sr, this);
    }
    
    public float getVelocity() {
        return this.velocity;
    }
    
    public void setVelocity(float velocity) {
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
    
    public int getCurrentMotionDirection() {
        return this.currentMotionDirection;
    }
    
    public void setCurrentMotionDirection(int currentMotionDirection) {
        this.currentMotionDirection = currentMotionDirection;
    }
    
    public float getXOnScreen() {
        return this.xOnScreen;
    }
    
    public void setXOnScreen(float xOnScreen) {
        this.xOnScreen = xOnScreen;
    }
    
    public float getYOnScreen() {
        return this.yOnScreen;
    }
    
    public void setYOnScreen(float yOnScreen) {
        this.yOnScreen = yOnScreen;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int width) {
        this.weight = width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean isTurned() {
        return turn;
    }
    
    public void makeTurn() {
        this.turn = true;
        this.currentMotionDirection = finishMotionDirection;
    }
    
    public int getLanes() {
        return this.lanes;
    }
    
    public void setLanes(int lanes) {
        this.lanes = lanes;
    }
    
    public int getTimeToStart() {
        return this.timeToStart;
    }
    
    public void setTimeToStart(int timeToStart) {
        this.timeToStart = timeToStart;
    }
    
    public void reduceTimeToStart() {
        if (timeToStart > 0)
            timeToStart--;
    }
    
    public float getStepVelocity() {
        return this.stepVelocity;
    }
    
    public void setStepVelocity(float stepVelocity) {
        this.stepVelocity = stepVelocity;
    }
    
    public void increaseVelocity() {
        velocity += stepVelocity;
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