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
public class Constants {
    
    final public static float scale = (float) 1;
    
    final public static float widthWindow = 1300; // ширина окна
    final public static float heightWindow = 800; // высота окна
    
    // направления движения транспортного средства
    final public static int leftToRight = 1;
    final public static int rightToLeft = 2;
    final public static int bottomToTop = 3;
    final public static int topToBottom = 4;
    
    // размеры тачек
    final public static int widthCar = 8;
    final public static int heightCar = 7;
    final public static int widthBus = 15;
    final public static int heightBus = 7;
    final public static int widthTruck = 10;
    final public static int heightTruck = 7;
    
    // допустимое расстояние между тачками
    final public static float okGap = 5;
    
    // полосы движения
    final public static int first = 1;
    final public static int second = 2;
    final public static int third = 3;
    
    // переменная, на которую мы делим рандом, чтобы скорость росла не слишком быстро
    final public static float den = 20f;
    
    // поправка скорости
    final public static float correctionVelocity = 1.5f;

}
