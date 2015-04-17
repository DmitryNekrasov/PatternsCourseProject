/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author ScanNorOne
 */
public class CarDrawer implements IDraw {

    @Override
    public void draw(ShapeRenderer sr, Vehicle vehicle) {
        sr.setColor(Color.RED);
        float x = vehicle.getXOnScreen();
        float y = vehicle.getYOnScreen();
        
        int widthRect, heightRect;
        
        if (!vehicle.isTurned()) {
            if (vehicle.getStartMotionDirection() == Constants.leftToRight || vehicle.getStartMotionDirection() == Constants.rightToLeft) {
                widthRect = vehicle.getWidth();
                heightRect = vehicle.getHeight();
            } else {
                widthRect = vehicle.getHeight();
                heightRect = vehicle.getWidth();
            }
        } else {
            if (vehicle.getFinishMotionDirection() == Constants.leftToRight || vehicle.getFinishMotionDirection() == Constants.rightToLeft) {
                widthRect = vehicle.getWidth();
                heightRect = vehicle.getHeight();
            } else {
                widthRect = vehicle.getHeight();
                heightRect = vehicle.getWidth();
            }
        }
        
        sr.rect(x, y, widthRect, heightRect);
        
        // отладка
//        sr.setColor(Color.YELLOW);
//        sr.rect(x, y, 10, 10);
    }
    
}