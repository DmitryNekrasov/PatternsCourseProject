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
public class Crossroads {
    
    final public float scaleRoad; // масштаб дороги
    final public float scaleMarking; // масштаб разметки
    final public float widthShortMarking; // ширина короткой разметки
    
    final public float widthCrosswalk; // ширина полоски пешеходника
    final public float heightCrosswalk; // высота полоски пешеходника
    
    private static Crossroads instance = null;
    
    private Crossroads() {
        scaleRoad = 50 * Constants.scale;
        scaleMarking = 1 * Constants.scale;
        widthShortMarking = 3 * Constants.scale;
        widthCrosswalk = 20 * Constants.scale;
        heightCrosswalk = 2 * Constants.scale;
    }
    
    public static Crossroads getInstance() {
        if (instance == null) {
            instance = new Crossroads();
        }
        return instance;
    }
    
}
