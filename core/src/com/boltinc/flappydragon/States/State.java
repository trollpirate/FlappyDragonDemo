package com.boltinc.flappydragon.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager mGameStateManager;

    protected State(GameStateManager gameStateManager) {
        this.mGameStateManager = gameStateManager;
        cam = new OrthographicCamera();
        mouse =  new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch spriteBatch);
}
