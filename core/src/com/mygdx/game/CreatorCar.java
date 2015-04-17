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

    final private int minVelocity = 1, maxVelocity = 10;
    final private int minWeight = 50, maxWeight = 500;
    
    @Override
    public Vehicle factoryMethod() {
        int velocity = Global.generateRandom(minVelocity, maxVelocity);
        double weight = Global.generateRandom(minWeight, maxWeight) + Math.random();
        int startMotionDirection = Global.generateRandom(1, 4);
        Car car = new Car(velocity, weight, startMotionDirection);
        float x = (float) Global.generateRandom(0, (int) Constants.widthWindow);
        float y = (float) Global.generateRandom(0, (int) Constants.widthWindow);
        
        if (car.getStartMotionDirection() == Constants.leftToRight) {
            switch (car.getLanes()) {
                case Constants.first: y = Crossroads.yFirstLeftToRight; break;
                case Constants.second: y = Crossroads.ySecondLeftToRight; break;
                default: y = Crossroads.yThirdLeftToRight; break;
            }
        } else if (car.getStartMotionDirection() == Constants.rightToLeft) {
            switch (car.getLanes()) {
                case Constants.first: y = Crossroads.yFirstRightToLeft; break;
                case Constants.second: y = Crossroads.ySecondRightToLeft; break;
                default: y = Crossroads.yThirdRightToLeft; break;
            }
        }
        
        car.setXOnScreen(x);
        car.setYOnScreen(y);
        return car;
    }
    
}
