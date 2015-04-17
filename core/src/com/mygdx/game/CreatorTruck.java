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
public class CreatorTruck extends Creator {

    final private int minVelocity = 1, maxVelocity = 3;
    final private int minWeight = 50, maxWeight = 500;
    final private int minTimeToStart = 0, maxTimeToStart = 1000;
    
    @Override
    public Vehicle factoryMethod() {
        int velocity = Global.generateRandom(minVelocity, maxVelocity);
        double weight = Global.generateRandom(minWeight, maxWeight) + Math.random();
        int startMotionDirection = Global.generateRandom(1, 4);
        Truck truck = new Truck(velocity, weight, startMotionDirection);
        
        truck.setTimeToStart(Global.generateRandom(minTimeToStart, maxTimeToStart));
        
        float x, y;
        
        if (truck.getStartMotionDirection() == Constants.leftToRight) {
            x = -truck.getWidth();
            switch (truck.getLanes()) {
                case Constants.first: y = Crossroads.yFirstLeftToRight; break;
                case Constants.second: y = Crossroads.ySecondLeftToRight; break;
                default: y = Crossroads.yThirdLeftToRight; break;
            }
        } else if (truck.getStartMotionDirection() == Constants.rightToLeft) {
            x = Constants.widthWindow;
            switch (truck.getLanes()) {
                case Constants.first: y = Crossroads.yFirstRightToLeft; break;
                case Constants.second: y = Crossroads.ySecondRightToLeft; break;
                default: y = Crossroads.yThirdRightToLeft; break;
            }
        } else if (truck.getStartMotionDirection() == Constants.bottomToTop) {
            y = -truck.getWidth();
            switch (truck.getLanes()) {
                case Constants.first: x = Crossroads.xFirstBottomToTop; break;
                case Constants.second: x = Crossroads.xSecondBottomToTop; break;
                default: x = Crossroads.xThirdBottomToTop; break;
            }
        } else {
            y = Constants.heightWindow;
            switch (truck.getLanes()) {
                case Constants.first: x = Crossroads.xFirstTopToBottom; break;
                case Constants.second: x = Crossroads.xSecondTopToBottom; break;
                default: x = Crossroads.xThirdTopToBottom; break;
            }
        }
        
        truck.setXOnScreen(x);
        truck.setYOnScreen(y);
        return truck;
    }
    
}
