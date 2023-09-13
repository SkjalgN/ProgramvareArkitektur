package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

import jdk.javadoc.internal.tool.Start;


public class StartGame extends ApplicationAdapter {

	//singleton pattern



	//World Parameters
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;

	//code
	private GameStateManager gsm;
	private SpriteBatch batch;




	@Override
	public void create () {
	batch = new SpriteBatch();
	gsm = GameStateManager.getInstance();
	Gdx.gl.glClearColor(1,0,0,1);
	gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}