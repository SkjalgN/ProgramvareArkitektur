package com.badlogix.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class Task2 extends ApplicationAdapter {

    int posX = 0;
    int posY = 0;

    BitmapFont font;
    SpriteBatch batch;
    Texture img;
    Sprite sprite;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("heli1.png");
        sprite = new Sprite(img);
        sprite.flip(true,false);
    }

    @Override
    public void render () {
        ScreenUtils.clear(2f, 0, 2f, 1);
        String string = Integer.toString(posY);
        String string2 = Integer.toString(posX);
        font = new BitmapFont();

        batch.begin();
        font.draw(batch, string, 50, 450);
        font.draw(batch, string2, 50, 400);
        if (Gdx.input.getX()<=0){
            posX = 0;
        }
        else if(Gdx.input.getX()>=500){
            posX = 500;
        }
        else {
            posX = Gdx.input.getX();
        }
        if (480-Gdx.input.getY()<=0){
            posY = 0;
        } else if (480-Gdx.input.getY()>=415) {
            posY = 415;
        } else {
            posY = 480-Gdx.input.getY();
        }

        batch.draw(sprite,posX,posY);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}