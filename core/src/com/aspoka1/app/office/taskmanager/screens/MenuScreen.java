package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.InputTransform;
import com.aspoka1.app.office.taskmanager.tiles.TaskTile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class MenuScreen implements Screen, GestureListener {
	private final TaskManager app;
	private OrthographicCamera camera;

	private Sprite background;

	TaskTile taskTile1;
	TaskTile taskTile2;
	TaskTile taskTile3;
	TaskTile taskTile4;

	public MenuScreen(TaskManager app) {
		this.app = app;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

		background = new Sprite(new Texture("Menu.png"));

		taskTile1 = new TaskTile(25, 475);
		taskTile2 = new TaskTile(25, 325);
		taskTile3 = new TaskTile(25, 175);
		taskTile4 = new TaskTile(25, 25);

		GestureDetector gd = new GestureDetector(this);
		Gdx.input.setInputProcessor(gd);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		app.batch.setProjectionMatrix(camera.combined);
		app.batch.begin();

		taskTile1.render(app.batch);
		taskTile2.render(app.batch);
		taskTile3.render(app.batch);
		taskTile4.render(app.batch);
		background.draw(app.batch);

		app.batch.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tap(float screenX, float screenY, int count, int button) {
		float x = InputTransform.getCursorToModelX(screenX);
		float y = InputTransform.getCursorToModelY(screenY);

		return false;
	}

	@Override
	public boolean longPress(float screenX, float screenY) {
		float x = InputTransform.getCursorToModelX(screenX);
		float y = InputTransform.getCursorToModelY(screenY);

		return false;
	}

	@Override
	public boolean pan(float screenX, float screenY, float screenDeltaX, float screenDeltaY) {
		float x = InputTransform.getCursorToModelX(screenX);
		float y = InputTransform.getCursorToModelY(screenY);
		float deltaX = InputTransform.getDeltaX(screenDeltaX);
		float deltaY = InputTransform.getDeltaY(screenDeltaY);

		return false;
	}

	//////////////////////////
	///// NEEDLESS METHODS/////
	//////////////////////////

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pinchStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

}
