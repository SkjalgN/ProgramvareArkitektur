package com.badlogix.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class Task3 extends ApplicationAdapter {

    int pos1X = 0;
    int pos1Y = 0;
    int vel1X = 2;
    int vel1Y = 2;
    int pos2X = 300;
    int pos2Y = 100;
    int vel2X = 2;
    int vel2Y = 2;

    SpriteBatch batch1;
    SpriteBatch batch2;
    Texture img1;
    Texture img2;
    Texture img3;
    Texture img4;

    Sprite sprite1;
    Sprite sprite2;

    @Override
    public void create () {
        batch1 = new SpriteBatch();
        batch2 = new SpriteBatch();
        img1 = new Texture("heli1.png");
        img2 = new Texture("heli2.png");
        img3 = new Texture("heli3.png");
        img4 = new Texture("heli4.png");
        sprite1 = new Sprite(img1);
        sprite1.flip(true,false);
        sprite2 = new Sprite(img1);
        sprite2.flip(true,false);
    }

    @Override
    public void render () {
        ScreenUtils.clear(2f, 0, 2f, 1);
        batch1.begin();
        batch1.draw(sprite1, pos1X, pos1Y);
        batch1.end();
        pos1Y += vel1Y;
        pos1X += vel1X;
        if (pos1X >= 500 || pos1X <= 0){
            vel1X = -vel1X;
            sprite1.flip(true,false);
        }
        if (pos1Y >= 400 || pos1Y <= 0){
            vel1Y = -vel1Y;
        }
        batch2.begin();
        batch2.draw(sprite2, pos2X, pos2Y);
        batch2.end();
        pos2Y += vel2Y;
        pos2X += vel2X;
        if (pos2X >= 500 || pos2X <= 0){
            vel2X = -vel2X;
            sprite2.flip(true,false);
        }
        if (pos2Y >= 400 || pos2Y <= 0){
            vel2Y = -vel2Y;
        }

        if((((pos2X - pos1X) < 162) && ((pos2Y - pos1Y) < 65))  || (((pos1X - pos2X) < 162) && ((pos2Y - pos1Y) < 65))  || (((pos2X - pos1X) < 162) && ((pos1Y - pos2Y) < 65))){
            vel1X = -vel1X;
            vel2X = -vel2X;
            vel1Y = -vel1Y;
            vel2Y = -vel2Y;
            sprite1.flip(true,false);
            sprite2.flip(true,false);
        }

    }

    @Override
    public void dispose() {
        batch1.dispose();
        batch2.dispose();
        img1.dispose();
    }

}