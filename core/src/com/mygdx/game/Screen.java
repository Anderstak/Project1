package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.Const.*;

public class  Screen extends ApplicationAdapter {
 SpriteBatch batch;
 
 World world;
  
 OrthographicCamera camera;
 
 Box2DDebugRenderer b2dr;
 
 Body hero;
 
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		world = new World(new Vector2(0, 0), false);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH/PPM , HEIGHT / PPM);
		
		b2dr = new Box2DDebugRenderer();

		Object BIT_HERO;
		hero = new TankBody().createTankBody(world, 0, 0, 5, 5, false, BIT_HERO, BIT_HERO, (short) 1)
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
