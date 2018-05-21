package com.aspoka1.app.office.taskmanager;

import com.aspoka1.app.office.taskmanager.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TaskManager extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 755;
	public static final String TITLE = "TaskManager";
	
	public SpriteBatch batch;
	public ShapeRenderer render;

	@Override
	public void create() {
		batch = new SpriteBatch();
		render = new ShapeRenderer();
		
		this.screen = new MenuScreen(this);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		render.dispose();
	}
}
