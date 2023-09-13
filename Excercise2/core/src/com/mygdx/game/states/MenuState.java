package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.StartGame;

public class MenuState extends State{

    private Texture background;
    private Texture playbtn;
    float var =(float)0.5;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("sky.png");
        playbtn = new Texture("playbtn.png");
    }



    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
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
        sb.draw(playbtn,(StartGame.WIDTH/2)-(playbtn.getWidth()*var/2), StartGame.HEIGHT/2-(playbtn.getHeight()*var/2),
                playbtn.getWidth()*var,playbtn.getHeight()*var);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}
