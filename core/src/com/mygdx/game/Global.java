/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.Random;

/**
 *
 * @author ScanNorOne
 */
public class Global {
    
    public static Random random = new Random();
    public static int generateRandom(int left, int right) {
        return Math.abs(random.nextInt()) % (right - left + 1) + left;
    }
    
}
