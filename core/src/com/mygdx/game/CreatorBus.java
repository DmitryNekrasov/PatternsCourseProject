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

    final private int minVelocity = 1, maxVelocity = 5;
    final private int minWeight = 50, maxWeight = 500;
    
    @Override
    public Vehicle factoryMethod() {
        int velocity = Global.generateRandom(minVelocity, maxVelocity);
        double weight = Global.generateRandom(minWeight, maxWeight) + Math.random();
        int startMotionDirection = Global.generateRandom(1, 4);
        Bus bus = new Bus(velocity, weight, startMotionDirection);
        float x = (float) Global.generateRandom(0, (int) Constants.widthWindow);
        float y = (float) Global.generateRandom(0, (int) Constants.heightWindow);
        
        if (bus.getStartMotionDirection() == Constants.leftToRight) {
            switch (bus.getLanes()) {
                case Constants.first: y = Crossroads.yFirstLeftToRight; break;
                case Constants.second: y = Crossroads.ySecondLeftToRight; break;
                default: y = Crossroads.yThirdLeftToRight; break;
            }
        } else if (bus.getStartMotionDirection() == Constants.rightToLeft) {
            switch (bus.getLanes()) {
                case Constants.first: y = Crossroads.yFirstRightToLeft; break;
                case Constants.second: y = Crossroads.ySecondRightToLeft; break;
                default: y = Crossroads.yThirdRightToLeft; break;
            }
        } else if (bus.getStartMotionDirection() == Constants.bottomToTop) {
            switch (bus.getLanes()) {
                case Constants.first: x = Crossroads.xFirstBottomToTop; break;
                case Constants.second: x = Crossroads.xSecondBottomToTop; break;
                default: x = Crossroads.xThirdBottomToTop; break;
            }
        } else {
            switch (bus.getLanes()) {
                case Constants.first: x = Crossroads.xFirstTopToBottom; break;
                case Constants.second: x = Crossroads.xSecondTopToBottom; break;
                default: x = Crossroads.xThirdTopToBottom; break;
            }
        }
        
        bus.setXOnScreen(x);
        bus.setYOnScreen(y);
        return bus;
    }
    
}
