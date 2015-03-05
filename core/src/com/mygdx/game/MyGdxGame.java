package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {
//    SpriteBatch batch;
//    Texture img;
    float scaleRoad = Constants.scaleRoad;
    float scaleMarking = Constants.scaleMarking;

    ShapeRenderer g;
    
    @Override
    public void create () {
//        batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");
        g = new ShapeRenderer();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor((float) 0.5, 1, (float) 0.5, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
//        ShapeRenderer g = new ShapeRenderer();
        
        g.setAutoShapeType(true);
        g.begin();
        g.set(ShapeRenderer.ShapeType.Filled);
        
        float[] q = {0f, 0f, 30f, 300f, 70f, 250f};
        g.polygon(q);
        
        // горизонтальная дорога
        g.setColor(Color.DARK_GRAY);
        g.rect(0, Constants.heightWindow / 2 - scaleRoad, Constants.widthWindow, scaleRoad * 2);

        // вертикальная дорога
        g.setColor(Color.DARK_GRAY);
        g.rect(Constants.widthWindow / 2 - scaleRoad, 0, scaleRoad * 2, Constants.heightWindow);

        
        // левый пешеходник
        g.setColor(Color.WHITE);
        float x = Constants.widthWindow / 2 - scaleRoad - Constants.widthCrosswalk - Constants.widthCrosswalk / 2;
        float y = Constants.heightWindow / 2 - scaleRoad + Constants.heightCrosswalk / 2;
        
        while (y < Constants.heightWindow / 2 + scaleRoad) {
        
            g.rect(x, y, Constants.widthCrosswalk, Constants.heightCrosswalk);
            y += 2 * Constants.heightCrosswalk;
        }
        
        // правый пешеходник
        x = Constants.widthWindow / 2 + scaleRoad + Constants.widthCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad + Constants.heightCrosswalk / 2;
        
        while (y < Constants.heightWindow / 2 + scaleRoad) {
        
            g.rect(x, y, Constants.widthCrosswalk, Constants.heightCrosswalk);
            y += 2 * Constants.heightCrosswalk;
        }
        
        // левая стоп-линия
        x = Constants.widthWindow / 2 - scaleRoad - Constants.widthCrosswalk - Constants.widthCrosswalk / 2 - 3 * Constants.heightCrosswalk;
        y = Constants.heightWindow / 2 - scaleRoad + Constants.heightCrosswalk;
        g.rect(x, y, Constants.heightCrosswalk, scaleRoad - 2 * Constants.heightCrosswalk);
        
        // левая горизонтальная прямая линия
        g.rect(0, Constants.heightWindow / 2 - scaleMarking, x - scaleMarking * 2, scaleMarking);
        
        // левые прерывистые линии
        float step = scaleRoad / 3;

        float startShortMarking = 0;
        
        while (startShortMarking + Constants.widthShortMarking < x - scaleMarking * 2) {
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - 2 * step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + 2 * step, Constants.widthShortMarking, scaleMarking);
            startShortMarking += 2 * Constants.widthShortMarking;
        }
        
        // правая стоп-линия
        x = Constants.widthWindow / 2 + scaleRoad + Constants.widthCrosswalk + Constants.widthCrosswalk / 2 + 2 * Constants.heightCrosswalk;
        y = Constants.heightWindow / 2 + Constants.heightCrosswalk;
        g.rect(x, y, Constants.heightCrosswalk, scaleRoad - 2 * Constants.heightCrosswalk);
        
        // правая горизонтальная прямая линия
        g.rect(x + 2 * Constants.heightCrosswalk, Constants.heightWindow / 2 - scaleMarking, x - scaleMarking * 2, scaleMarking);
        
        // правые прерывистые линии
        startShortMarking = x + 2 * Constants.widthShortMarking;
        while (startShortMarking < Constants.widthWindow) {
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking - 2 * step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + step, Constants.widthShortMarking, scaleMarking);
            g.rect(startShortMarking, Constants.heightWindow / 2 - scaleMarking + 2 * step, Constants.widthShortMarking, scaleMarking);
            startShortMarking += 2 * Constants.widthShortMarking;
        }
        
        // верхний пешеходник
        x = Constants.widthWindow / 2 - scaleRoad + Constants.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 + scaleRoad + Constants.widthCrosswalk / 2;
        
        while (x < Constants.widthWindow / 2 + scaleRoad - Constants.heightCrosswalk) {
            g.rect(x, y, Constants.heightCrosswalk, Constants.widthCrosswalk);
            x += 2 * Constants.heightCrosswalk;
        }
        
        // верхняя стоп-линия
        x = Constants.widthWindow / 2 - scaleRoad + Constants.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 + scaleRoad + Constants.widthCrosswalk / 2 + Constants.widthCrosswalk + 2 * Constants.heightCrosswalk;
        g.rect(x, y, scaleRoad - 2 * Constants.heightCrosswalk, Constants.heightCrosswalk);

        // верхняя горизонтальная линия
        g.rect(Constants.widthWindow / 2 - scaleMarking, y + 2 * Constants.heightCrosswalk, scaleMarking, Constants.heightWindow / 2);

        // верхние прерывистые линии
        startShortMarking = y + 2 * Constants.widthShortMarking;
        while (startShortMarking < Constants.heightWindow) {
            g.rect(Constants.widthWindow / 2 - scaleMarking - step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking - 2 * step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking + step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking + 2 * step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            startShortMarking += 2 * Constants.widthShortMarking;
        }
        
        // нижний пешеходник
        x = Constants.widthWindow / 2 - scaleRoad + Constants.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad - Constants.widthCrosswalk / 2 - Constants.widthCrosswalk;
        
        while (x < Constants.widthWindow / 2 + scaleRoad - Constants.heightCrosswalk) {
            g.rect(x, y, Constants.heightCrosswalk, Constants.widthCrosswalk);
            x += 2 * Constants.heightCrosswalk;
        }
        
        // нижняя стоп-линия
        x = Constants.widthWindow / 2 + Constants.heightCrosswalk / 2;
        y = Constants.heightWindow / 2 - scaleRoad - Constants.widthCrosswalk / 2 - Constants.widthCrosswalk - 3 * Constants.heightCrosswalk;
        g.rect(x, y, scaleRoad - 2 * Constants.heightCrosswalk, Constants.heightCrosswalk);
        
        // нижняя горизонтальная линия
        g.rect(Constants.widthWindow / 2 - scaleMarking, 0, scaleMarking, y - Constants.heightCrosswalk);
        
        // нижние прерывистые линии
        startShortMarking = y - 2 * Constants.widthShortMarking;
        while (startShortMarking > 0) {
            g.rect(Constants.widthWindow / 2 - scaleMarking - step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking - 2 * step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking + step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            g.rect(Constants.widthWindow / 2 - scaleMarking + 2 * step, startShortMarking, scaleMarking, Constants.widthShortMarking);
            startShortMarking -= 2 * Constants.widthShortMarking;
        }
        
        g.end();
    }
}
