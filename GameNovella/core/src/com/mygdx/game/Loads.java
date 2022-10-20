package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Loads implements Screen {
    final GameNovella game;
    private TextButton.TextButtonStyle buttonStyle;
    private TextButton backButton;
    private OrthographicCamera camera;
    private Texture background;
    private Stage stage;
    private BitmapFont textFont;
    Skin skin;

    public Loads(final GameNovella game){
        this.game = game;

        background = new Texture(Gdx.files.internal("menuBackground.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.WEIGHT, game.HEIGHT);


        stage = new Stage(new StretchViewport(game.WEIGHT, game.HEIGHT));

        Gdx.input.setInputProcessor(stage);

        textFont = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));

        skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("exit.pack"));
        skin.addRegions(atlas);
        skin.add("font",textFont,BitmapFont.class);

        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = textFont;
        buttonStyle.fontColor = Color.valueOf("#8E8574");

        backButton= new TextButton("Back",buttonStyle);
        backButton.setPosition(135, 80);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }
        });
        stage.addActor(backButton);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();

        game.batch.begin();
        game.batch.draw(background, 0, 0, game.WEIGHT, game.HEIGHT);
        game.batch.end();

        if(stage != null){
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
        }
        game.batch.begin();
        game.font.setColor( Color.BROWN);
        game.font.getData().setScale(1,1);
        game.font.draw(game.batch, game.madeInProgress, game.WEIGHT/2 - 130, game.HEIGHT/2 + 20);
        game.batch.end();


        game.batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        if(stage != null)stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        textFont.dispose();
        stage.dispose();
    }
}
