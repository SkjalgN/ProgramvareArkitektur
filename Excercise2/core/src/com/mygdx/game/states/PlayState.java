package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.StartGame;

import jdk.javadoc.internal.tool.Start;

public class PlayState extends State{

    private Texture heli;
    private Texture background;
    private Sprite sprite;

    int posX = 0;
    int posY = 0;
    int velX = 4;
    int velY = 4;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("sky.png");
        heli = new Texture("heli1.png");
        sprite = new Sprite(heli);
        sprite.flip(true,false);

    }



    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, StartGame.WIDTH, StartGame.HEIGHT);
        sb.draw(sprite,posX,posY);
        sb.end();
        posX += velX;
        posY += velY;
        if (posX >= StartGame.WIDTH - heli.getWidth() || posX <= 0){
            velX = -velX;
            sprite.flip(true,false);
        }
        if (posY >= StartGame.HEIGHT - heli.getHeight() || posY <= 0){
            velY = -velY;
        }
    }

    @Override
    public void dispose() {
        heli.dispose();
        background.dispose();
    }
}
