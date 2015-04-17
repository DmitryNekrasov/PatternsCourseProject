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
    
    // экранные координаты тачек на полосах движения
    public static float yFirstLeftToRight;
    public static float ySecondLeftToRight;
    public static float yThirdLeftToRight;
    
    public static float yFirstRightToLeft;
    public static float ySecondRightToLeft;
    public static float yThirdRightToLeft;
    
    public static float xFirstBottomToTop;
    public static float xSecondBottomToTop;
    public static float xThirdBottomToTop;
    
    public static float xFirstTopToBottom;
    public static float xSecondTopToBottom;
    public static float xThirdTopToBottom;
    
    private static Crossroads instance = null;
    
    private Crossroads() {
        scaleRoad = 50 * Constants.scale;
        scaleMarking = 1 * Constants.scale;
        widthShortMarking = 3 * Constants.scale;
        widthCrosswalk = 20 * Constants.scale;
        heightCrosswalk = 2 * Constants.scale;
        
        
        // вычисление экранных координат для тачек
        
        float midY = Constants.heightWindow / 2;
        float gap = scaleRoad / 3;
        
        float ultraGap = 4;
        
        yFirstLeftToRight = midY - gap + ultraGap;
        ySecondLeftToRight = midY - 2 * gap + ultraGap;
        yThirdLeftToRight = midY - 3 * gap + ultraGap;
        
        yFirstRightToLeft = midY + ultraGap;
        ySecondRightToLeft = midY + gap + ultraGap;
        yThirdRightToLeft = midY + 2 * gap + ultraGap;
        
        float midX = Constants.widthWindow / 2;
        
        xFirstBottomToTop = midX + ultraGap;
        xSecondBottomToTop = midX + gap + ultraGap;
        xThirdBottomToTop = midX + 2 * gap + ultraGap;
        
        xFirstTopToBottom = midX - gap + ultraGap;
        xSecondTopToBottom = midX - 2 * gap + ultraGap;
        xThirdBottomToTop = midX - 3 * gap + ultraGap;
        
    }
    
    public static Crossroads getInstance() {
        if (instance == null) {
            instance = new Crossroads();
        }
        return instance;
    }
    
}
