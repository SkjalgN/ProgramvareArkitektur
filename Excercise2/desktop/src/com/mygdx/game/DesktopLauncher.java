package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.PlayState;
import com.mygdx.game.states.State;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {

		//Testing av Singleton pattern
		GameStateManager startGame1 = GameStateManager.getInstance();
		GameStateManager startGame2 = GameStateManager.getInstance();
		if(startGame2 == startGame1){
			System.out.print("Singleton pattern implementation fungerer");
		} else{
			System.out.print("Singleton pattern implementation fungerer IKKE");
		}

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("My GDX Game");
		config.setWindowedMode(StartGame.WIDTH, StartGame.HEIGHT);

		new Lwjgl3Application(new StartGame(), config);





	}
}
