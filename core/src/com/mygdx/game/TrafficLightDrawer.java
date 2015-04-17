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
public class TrafficLightDrawer {
    
    private TrafficLight trafficLight;
    private ShapeRenderer sr;

    public TrafficLightDrawer(TrafficLight trafficLight, ShapeRenderer sr) {
        this.trafficLight = trafficLight;
        this.sr = sr;
    }
    
    public void draw() {
        
        sr.setColor(Color.BLACK);
        float x = trafficLight.getXOnScreen(), y = trafficLight.getYOnScreen();
        float width = trafficLight.getWidth() + 8, height = trafficLight.getHeight() + 12;
        sr.rect(x, y, width, height);
        
        if (trafficLight.isYellow())
            sr.setColor(Color.YELLOW);
        else
            sr.setColor(Color.DARK_GRAY);
        sr.circle(x + width / 2, y + height / 2, trafficLight.getRadius());
        
        if (trafficLight.isGreen())
            sr.setColor(Color.GREEN);
        else
            sr.setColor(Color.DARK_GRAY);
        sr.circle(x + width / 2, y + width / 2 - 1, trafficLight.getRadius());
        
        if (trafficLight.isRed())
            sr.setColor(Color.RED);
        else
            sr.setColor(Color.DARK_GRAY);
        sr.circle(x + width / 2, y + 2 * width + 3, trafficLight.getRadius());
    }
    
    
    
}
