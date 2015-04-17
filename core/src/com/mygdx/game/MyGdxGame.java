package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {

    ShapeRenderer sr;
    
    CrossroadDrawer crossroadDrawer;
    
    @Override
    public void create () {
        sr = new ShapeRenderer();
        Factory factory = new Factory();
        crossroadDrawer = new CrossroadDrawer(Crossroads.getInstance(), sr);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor((float) 0.5, 1, (float) 0.5, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        sr.setAutoShapeType(true);
        
        crossroadDrawer.draw();
        
    }
}
