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
public class Factory {
    
    final private int minCountVehicle = 10, maxCountVehicle = 20;
    
    public Factory() {
        
        int countVehicle = Global.generateRandom(minCountVehicle, maxCountVehicle);
        
        for (int i = 0; i < countVehicle; i++) {
            Creator creator;
            int tmp = Global.generateRandom(1, 3);
            switch (tmp) {
                case 1: creator = new CreatorCar(); break;
                case 2: creator = new CreatorBus(); break;
                default: creator = new CreatorTruck(); break;
            }
            Data.vehicles.add(creator.factoryMethod());
        }
        
    }
    
}
