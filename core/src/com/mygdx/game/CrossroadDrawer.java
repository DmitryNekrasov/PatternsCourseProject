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
public class CrossroadDrawer {
    
    private Crossroads crossroads;
    private final ShapeRenderer sr;
    private TrafficLightDrawer tld1, tld2, tld3, tld4;
    
    float scaleRoad;
    float scaleMarking;
    
    public CrossroadDrawer(Crossroads crossroads, ShapeRenderer sr) {
        this.crossroads = crossroads;
        this.sr = sr;
        scaleRoad = crossroads.scaleRoad;
        scaleMarking = crossroads.scaleMarking;
        
        float x1 = Constants.widthWindow / 2 - crossroads.scaleRoad - crossroads.gapTrafficLight - Constants.radius * 2 - 7;
        float x2 = Constants.widthWindow / 2 + crossroads.scaleRoad + crossroads.gapTrafficLight;
        float y1 = Constants.heightWindow / 2 - crossroads.scaleRoad - crossroads.gapTrafficLight - Constants.radius * 6 - 12;
        float y2 = Constants.heightWindow / 2 + crossroads.scaleRoad + crossroads.gapTrafficLight;
        
        Data.trafficLight1 = new TrafficLight(false, false, true, x1, y1, Constants.radius);
        Data.trafficLight2 = new TrafficLight(false, false, true, x2, y2, Constants.radius);
        Data.trafficLight3 = new TrafficLight(false, false, true, x2, y1, Constants.radius);
        Data.trafficLight4 = new TrafficLight(false, false, true, x1, y2, Constants.radius);
        
        tld1 = new TrafficLightDrawer(Data.trafficLight1, sr);
        tld2 = new TrafficLightDrawer(Data.trafficLight2, sr);
        tld3 = new TrafficLightDrawer(Data.trafficLight3, sr);
        tld4 = new TrafficLightDrawer(Data.trafficLight4, sr);
    }
    
    public void draw() {
        sr.begin();
        sr.set(ShapeRenderer.ShapeType.Filled);
        
        // горизонтальная дорога
        sr.setColor(Color.DARK_GRAY);
        sr.rect(0, Constants.heightWindow / 2 - scaleRoad, Constants.widthWindow, scaleRoad * 2);

        // вертикальная дорога
        sr.setColor(Color.DARK_GRAY);
        sr.rect(Constants.widthWindow / 2 - scaleRoad, 0, scaleRoad * 2, Constants.heightWindow);

        
        // левый пешеходник
        sr.setColor(Color.WHITE);
        float x = Constants.widthWindow / 2 - scaleRoad - crossroads.widthCrosswalk - crossroads.widthCrosswalk / 2;
        float y = Constants.heightWindow / 2 - scaleRoad + crossroads.heightCrosswalk / 2;
        
        while (y < Constants.heightWindow / 2 + scaleRoad) {
        
            sr.rect(x, y, crossroads.widthCrosswalk, crossroads.heightCrosswalk);
            y += 2 * crossroads.heightCrosswalk;
        }
        
        // правый пешеходник
        x = Constants.widthWindow / 2 + scaleRoad + crossroads.widthCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad + crossroads.heightCrosswalk / 2;
        
        while (y < Constants.heightWindow / 2 + scaleRoad) {
        
            sr.rect(x, y, crossroads.widthCrosswalk, crossroads.heightCrosswalk);
            y += 2 * crossroads.heightCrosswalk;
        }
        
        // левая стоп-линия
        x = Constants.widthWindow / 2 - scaleRoad - crossroads.widthCrosswalk - crossroads.widthCrosswalk / 2 - 3 * crossroads.heightCrosswalk;
        y = Constants.heightWindow / 2 - scaleRoad + crossroads.heightCrosswalk;
        sr.rect(x, y, crossroads.heightCrosswalk, scaleRoad - 2 * crossroads.heightCrosswalk);
        
        // левая горизонтальная прямая линия
        sr.rect(0, Constants.heightWindow / 2 - scaleMarking, x - scaleMarking * 2, scaleMarking);
        
        // левые прерывистые линии
        float step = scaleRoad / 3;

        float startShortMarking = 0;
        
        while (startShortMarking + crossroads.widthShortMarking < x - scaleMarking * 2) {
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - 2 * step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + 2 * step, crossroads.widthShortMarking, scaleMarking);
            startShortMarking += 2 * crossroads.widthShortMarking;
        }
        
        // правая стоп-линия
        x = Constants.widthWindow / 2 + scaleRoad + crossroads.widthCrosswalk + crossroads.widthCrosswalk / 2 + 2 * crossroads.heightCrosswalk;
        y = Constants.heightWindow / 2 + crossroads.heightCrosswalk;
        sr.rect(x, y, crossroads.heightCrosswalk, scaleRoad - 2 * crossroads.heightCrosswalk);
        
        // правая горизонтальная прямая линия
        sr.rect(x + 2 * crossroads.heightCrosswalk, Constants.heightWindow / 2 - scaleMarking, x - scaleMarking * 2, scaleMarking);
        
        // правые прерывистые линии
        startShortMarking = x + 2 * crossroads.widthShortMarking;
        while (startShortMarking < Constants.widthWindow) {
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - 2 * step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + step, crossroads.widthShortMarking, scaleMarking);
            sr.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + 2 * step, crossroads.widthShortMarking, scaleMarking);
            startShortMarking += 2 * crossroads.widthShortMarking;
        }
        
        // верхний пешеходник
        x = Constants.widthWindow / 2 - scaleRoad + crossroads.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 + scaleRoad + crossroads.widthCrosswalk / 2;
        
        while (x < Constants.widthWindow / 2 + scaleRoad - crossroads.heightCrosswalk) {
            sr.rect(x, y, crossroads.heightCrosswalk, crossroads.widthCrosswalk);
            x += 2 * crossroads.heightCrosswalk;
        }
        
        // верхняя стоп-линия
        x = Constants.widthWindow / 2 - scaleRoad + crossroads.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 + scaleRoad + crossroads.widthCrosswalk / 2 + crossroads.widthCrosswalk + 2 * crossroads.heightCrosswalk;
        sr.rect(x, y, scaleRoad - 2 * crossroads.heightCrosswalk, crossroads.heightCrosswalk);

        // верхняя горизонтальная линия
        sr.rect(Constants.widthWindow / 2 - scaleMarking, y + 2 * crossroads.heightCrosswalk, scaleMarking, Constants.heightWindow / 2);

        // верхние прерывистые линии
        startShortMarking = y + 2 * crossroads.widthShortMarking;
        while (startShortMarking < Constants.heightWindow) {
            sr.rect(Constants.widthWindow / 2 - scaleMarking - step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking - 2 * step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking + step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking + 2 * step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            startShortMarking += 2 * crossroads.widthShortMarking;
        }
        
        // нижний пешеходник
        x = Constants.widthWindow / 2 - scaleRoad + crossroads.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad - crossroads.widthCrosswalk / 2 - crossroads.widthCrosswalk;
        
        while (x < Constants.widthWindow / 2 + scaleRoad - crossroads.heightCrosswalk) {
            sr.rect(x, y, crossroads.heightCrosswalk, crossroads.widthCrosswalk);
            x += 2 * crossroads.heightCrosswalk;
        }
        
        // нижняя стоп-линия
        x = Constants.widthWindow / 2 + crossroads.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad - crossroads.widthCrosswalk / 2 - crossroads.widthCrosswalk - 3 * crossroads.heightCrosswalk;
        sr.rect(x, y, scaleRoad - 2 * crossroads.heightCrosswalk, crossroads.heightCrosswalk);
        
        // нижняя горизонтальная линия
        sr.rect(Constants.widthWindow / 2 - scaleMarking, 0, scaleMarking, y - crossroads.heightCrosswalk);
        
        // нижние прерывистые линии
        startShortMarking = y - 2 * crossroads.widthShortMarking;
        while (startShortMarking > 0) {
            sr.rect(Constants.widthWindow / 2 - scaleMarking - step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking - 2 * step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking + step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            sr.rect(Constants.widthWindow / 2 - scaleMarking + 2 * step, startShortMarking, scaleMarking, crossroads.widthShortMarking);
            startShortMarking -= 2 * crossroads.widthShortMarking;
        }
        
        motion();
        
        // тачки
        for (Vehicle next: Data.vehicles) {
            next.performDraw(sr);
        }
        
        // светофоры
        tld1.draw();
        tld2.draw();
        tld3.draw();
        tld4.draw();
        
        sr.end();
    }
    
    public void motion() {
        
        speedReduction();
        
        for (Vehicle next: Data.vehicles) {
            next.reduceTimeToStart();
            
            if (next.getTimeToStart() > 0)
                continue;
            
            next.increaseVelocity();  // увеличиваем скорость
            
            if (!next.isTurned()) {
            
                if (next.getLanes() == Constants.second) {
                    switch (next.getStartMotionDirection()) {
                        case Constants.leftToRight:
                            next.setXOnScreen(next.getXOnScreen() + next.getVelocity());
                            break;
                        case Constants.rightToLeft:
                            next.setXOnScreen(next.getXOnScreen() - next.getVelocity());
                            break;
                        case Constants.bottomToTop:
                            next.setYOnScreen(next.getYOnScreen() + next.getVelocity());
                            break;
                        default:
                            next.setYOnScreen(next.getYOnScreen() - next.getVelocity());
                            break;
                    }
                } else if (next.getLanes() == Constants.first) {
                    switch (next.getStartMotionDirection()) {
                        case Constants.leftToRight:
                            next.setXOnScreen(next.getXOnScreen() + next.getVelocity());
                            if (next.getXOnScreen() >= Crossroads.xFirstBottomToTop) {
                                next.setXOnScreen(Crossroads.xFirstBottomToTop);
                                next.makeTurn();
                            }
                            break;
                        case Constants.rightToLeft:
                            next.setXOnScreen(next.getXOnScreen() - next.getVelocity());
                            if (next.getXOnScreen() <= Crossroads.xFirstTopToBottom) {
                                next.setXOnScreen(Crossroads.xFirstTopToBottom);
                                next.makeTurn();
                            }
                            break;
                        case Constants.bottomToTop:
                            next.setYOnScreen(next.getYOnScreen() + next.getVelocity());
                            if (next.getYOnScreen() >= Crossroads.yFirstRightToLeft) {
                                next.setYOnScreen(Crossroads.yFirstRightToLeft);
                                next.makeTurn();
                            }
                            break;
                        default:
                            next.setYOnScreen(next.getYOnScreen() - next.getVelocity());
                            if (next.getYOnScreen() <= Crossroads.yFirstLeftToRight) {
                                next.setYOnScreen(Crossroads.yFirstLeftToRight);
                                next.makeTurn();
                            }
                            break;
                    }
                } else {
                    switch (next.getStartMotionDirection()) {
                        case Constants.leftToRight:
                            next.setXOnScreen(next.getXOnScreen() + next.getVelocity());
                            if (next.getXOnScreen() >= Crossroads.xThirdTopToBottom) {
                                next.setXOnScreen(Crossroads.xThirdTopToBottom);
                                next.makeTurn();
                            }
                            break;
                        case Constants.rightToLeft:
                            next.setXOnScreen(next.getXOnScreen() - next.getVelocity());
                            if (next.getXOnScreen() <= Crossroads.xThirdBottomToTop) {
                                next.setXOnScreen(Crossroads.xThirdBottomToTop);
                                next.makeTurn();
                            }
                            break;
                        case Constants.bottomToTop:
                            next.setYOnScreen(next.getYOnScreen() + next.getVelocity());
                            if (next.getYOnScreen() >= Crossroads.yThirdLeftToRight) {
                                next.setYOnScreen(Crossroads.yThirdLeftToRight);
                                next.makeTurn();
                            }
                            break;
                        default:
                            next.setYOnScreen(next.getYOnScreen() - next.getVelocity());
                            if (next.getYOnScreen() <= Crossroads.yThirdRightToLeft) {
                                next.setYOnScreen(Crossroads.yThirdRightToLeft);
                                next.makeTurn();
                            }
                            break;
                    }
                }
            
            } else {  // если тачка повернула
                switch (next.getFinishMotionDirection()) {
                    case Constants.leftToRight:
                        next.setXOnScreen(next.getXOnScreen() + next.getVelocity());
                        break;
                    case Constants.rightToLeft:
                        next.setXOnScreen(next.getXOnScreen() - next.getVelocity());
                        break;
                    case Constants.bottomToTop:
                        next.setYOnScreen(next.getYOnScreen() + next.getVelocity());
                        break;
                    default:
                        next.setYOnScreen(next.getYOnScreen() - next.getVelocity());
                        break;
                }
            }
             
        }
         
    }
    
    // снижение скорости при близком контакте
    public void speedReduction() {
        for (Vehicle veh1: Data.vehicles) {
            for (Vehicle veh2: Data.vehicles) {
                
                if (veh1 == veh2)
                    continue;
                
                if (veh1.getCurrentMotionDirection() == veh2.getCurrentMotionDirection()) {
                    switch (veh1.getCurrentMotionDirection()) {
                        case Constants.leftToRight:
                            if (veh2.getXOnScreen() + veh2.getWidth() + Constants.okGap < veh1.getXOnScreen() && veh2.getXOnScreen() + veh2.getWidth() + Constants.okGap + veh2.getVelocity() > veh1.getXOnScreen()) {
                                veh2.setVelocity(veh1.getVelocity() / Constants.correctionVelocity);
                            }
                            break;
                        case Constants.rightToLeft:
                            if (veh2.getXOnScreen() - Constants.okGap - veh1.getWidth() > veh1.getXOnScreen() && veh2.getXOnScreen() - Constants.okGap - veh1.getWidth() - veh2.getVelocity() < veh1.getXOnScreen()) {
                                veh2.setVelocity(veh1.getVelocity() / Constants.correctionVelocity);
                            }
                            break;
                        case Constants.bottomToTop:
                            if (veh2.getYOnScreen() + veh2.getWidth() + Constants.okGap < veh1.getYOnScreen() && veh2.getYOnScreen() + veh2.getWidth() + Constants.okGap + veh2.getVelocity() > veh1.getYOnScreen()) {
                                veh2.setVelocity(veh1.getVelocity() / Constants.correctionVelocity);
                            }
                            break;
                        default:
                            if (veh2.getYOnScreen() - Constants.okGap - veh1.getWidth() > veh1.getYOnScreen() && veh2.getYOnScreen() - Constants.okGap - veh1.getWidth() - veh2.getVelocity() < veh1.getYOnScreen()) {
                                veh2.setVelocity(veh1.getVelocity() / Constants.correctionVelocity);
                            }
                            break;
                    }
                }
            }
        }
    }
    
}