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
public class TrafficLight {
    
    private boolean red;
    private boolean yellow;
    private boolean green;
    private float xOnScreen, yOnScreen;
    private float width, height;
    private float radius;

    public TrafficLight(boolean red, boolean yellow, boolean green, float xOnScreen, float yOnScreen, float radius) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.xOnScreen = xOnScreen;
        this.yOnScreen = yOnScreen;
        this.radius = radius;
        width = 2 * radius;
        height = 6 * radius;
    }
    
    public boolean isRed() {
        return red;
    }
    
    public boolean isYellow() {
        return yellow;
    }
    
    public boolean isGreen() {
        return green;
    }
    
    public float getXOnScreen() {
        return xOnScreen;
    }
    
    public void setXOnScreen(float xOnScreen) {
        this.xOnScreen = xOnScreen;
    }
    
    public float getYOnScreen() {
        return yOnScreen;
    }
    
    public void setYOnScreen(float yOnScreen) {
        this.yOnScreen = yOnScreen;
    }
    
    public float getWidth() {
        return this.width;
    }
    
    public void setWidth(float width) {
        this.width = width;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }
    
    public float getRadius() {
        return this.radius;
    }
    
    public void setRadius(float radius) {
        this.radius = radius;
    }
    
//    public void turn
    
    
    
}
