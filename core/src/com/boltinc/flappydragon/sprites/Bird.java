package com.boltinc.flappydragon.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector3 mPosition;
    private Vector3 mVelocity;

    private Rectangle bounds;       //Bird hit-box
    private Texture animationTexture;

    private Animation birdAnimation;

    public Bird(int x, int y) {
        mPosition = new Vector3(x, y, 0);
        mVelocity = new Vector3(0,0,0);
        animationTexture = new Texture("bird_animation.png");
        birdAnimation = new Animation(new TextureRegion(animationTexture), 3, 0.5f);
        bounds = new Rectangle(x, y, animationTexture.getWidth()/3, animationTexture.getHeight());
    }

    public void update(float dt) {
        birdAnimation.update(dt);
        if(mPosition.y > 0)
            mVelocity.add(0, GRAVITY, 0);
        mVelocity.scl(dt);
        mPosition.add(MOVEMENT*dt, mVelocity.y, 0);
        if(mPosition.y<0)
            mPosition.y = 0;
        mVelocity.scl(1/dt);
        bounds.setPosition(mPosition.x, mPosition.y);
    }

    public Vector3 getPosition() {
        return mPosition;
    }

    public TextureRegion getBirdTexture() {
        return birdAnimation.getFrame();
    }

    public void jump() {
        mVelocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose(){
        animationTexture.dispose();
    }
}