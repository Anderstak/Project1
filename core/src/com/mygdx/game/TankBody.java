package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.*;

import static com.mygdx.game.Const.PPM;


public class TankBody {




    public Body creatTankBody(World world, int x, int y, int height, int width, boolean isStatic, short bit, short mask, short index, Object object) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.fixedRotation = true;
        bodyDef.position.x = x / PPM;
        bodyDef.position.y = y / PPM;

        if (isStatic) bodyDef.type = BodyDef.BodyType.StaticBody;
        else bodyDef.type = BodyDef.BodyType.DynamicBody;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.filter.categoryBits = bit;
        fixtureDef.filter.categoryBits = mask;
        fixtureDef.filter.categoryBits = index;

        fixtureDef.shape = shape;

        Body body = world.createBody(bodyDef).createFixture(fixtureDef).getBody();

        return body;


    }
}
