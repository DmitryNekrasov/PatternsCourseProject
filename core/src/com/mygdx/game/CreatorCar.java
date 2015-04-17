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
public class CreatorCar extends Creator {

    final private int minVelocity = 3, maxVelocity = 7;
    final private int minWeight = 50, maxWeight = 500;
    final private int minTimeToStart = 0, maxTimeToStart = 1000;
    
    @Override
    public Vehicle factoryMethod() {
        int velocity = Global.generateRandom(minVelocity, maxVelocity);
        double weight = Global.generateRandom(minWeight, maxWeight) + Math.random();
        int startMotionDirection = Global.generateRandom(1, 4);
        Car car = new Car(velocity, weight, startMotionDirection);
        
        car.setTimeToStart(Global.generateRandom(minTimeToStart, maxTimeToStart));
        
        float x = 0;//(float) Global.generateRandom(0, (int) Constants.widthWindow);
        float y = 0;//(float) Global.generateRandom(0, (int) Constants.widthWindow);
        
        if (car.getStartMotionDirection() == Constants.leftToRight) {
            x = -car.getWidth();
            switch (car.getLanes()) {
                case Constants.first: y = Crossroads.yFirstLeftToRight; break;
                case Constants.second: y = Crossroads.ySecondLeftToRight; break;
                default: y = Crossroads.yThirdLeftToRight; break;
            }
        } else if (car.getStartMotionDirection() == Constants.rightToLeft) {
            x = Constants.widthWindow;
            switch (car.getLanes()) {
                case Constants.first: y = Crossroads.yFirstRightToLeft; break;
                case Constants.second: y = Crossroads.ySecondRightToLeft; break;
                default: y = Crossroads.yThirdRightToLeft; break;
            }
        } else if (car.getStartMotionDirection() == Constants.bottomToTop) {
            y = -car.getWidth();
            switch (car.getLanes()) {
                case Constants.first: x = Crossroads.xFirstBottomToTop; break;
                case Constants.second: x = Crossroads.xSecondBottomToTop; break;
                default: x = Crossroads.xThirdBottomToTop; break;
            }
        } else {
            y = Constants.heightWindow;
            switch (car.getLanes()) {
                case Constants.first: x = Crossroads.xFirstTopToBottom; break;
                case Constants.second: x = Crossroads.xSecondTopToBottom; break;
                default: x = Crossroads.xThirdTopToBottom; break;
            }
        }
        
        car.setXOnScreen(x);
        car.setYOnScreen(y);
        return car;
    }
    
}
