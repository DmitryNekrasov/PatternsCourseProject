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
        float x = (float) Global.generateRandom(0, (int) Constants.widthWindow);
        float y = (float) Global.generateRandom(0, (int) Constants.heightWindow);
        sr.circle(x, y, 15);
    }
    
}
