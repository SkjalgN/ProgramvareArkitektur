package com.badlogix.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Task4 extends ApplicationAdapter {

    BitmapFont font;
    private SpriteBatch batch;
    private Texture ball;
    private Texture paddle;
    private Texture paddle2;
    private Vector2 ballPos;
    private Vector2 ballVel;
    private Vector2 paddlePos;
    private Vector2 paddlePos2;

    private int score = 10000;
    private float Scale = 0.1f;

    @Override
    public void create () {
        batch = new SpriteBatch();
        ball = new Texture(Gdx.files.internal("circle.png"));
        paddle = new Texture(Gdx.files.internal("line.png"));
        paddle2 = new Texture(Gdx.files.internal("line.png"));
        ballPos = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        ballVel = new Vector2(100, 100);
        paddlePos = new Vector2(50, Gdx.graphics.getHeight() / 2);
        paddlePos2 = new Vector2(Gdx.graphics.getWidth()-paddle.getWidth()*Scale-50, Gdx.graphics.getHeight() / 2);

    }

    @Override
    public void render () {
        ScreenUtils.clear(2f, 0, 2f, 1);
        String string = "Beklager, rakk ikke mer :( Skal gjøre ferdig øvingen i løpet av uken på egenhånd :)";
        font = new BitmapFont();

        ballPos.add(ballVel.cpy().scl(Gdx.graphics.getDeltaTime()));

        if (ballPos.x < 0 || ballPos.x > Gdx.graphics.getWidth()-ball.getWidth()*Scale) {
            ballVel.x = -ballVel.x;
        }

        if (ballPos.y < 0 || ballPos.y > Gdx.graphics.getHeight()-ball.getHeight()*Scale) {
            ballVel.y = -ballVel.y;
        }

        batch.begin();
        font.draw(batch, string, Gdx.graphics.getWidth()/2-250, 400);
        batch.draw(ball, ballPos.x, ballPos.y, ball.getWidth() * Scale, ball.getHeight() * Scale);
        batch.draw(paddle, paddlePos.x, paddlePos.y, paddle.getWidth() * Scale, paddle.getHeight() * Scale);
        batch.draw(paddle2, paddlePos2.x, paddlePos2.y, paddle2.getWidth() * Scale, paddle2.getHeight() * Scale);
        batch.end();

    }

    @Override
    public void dispose () {
        batch.dispose();
        ball.dispose();
        paddle.dispose();
    }
}
