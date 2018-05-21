package com.aspoka1.app.office.taskmanager.screens;

import java.util.ArrayList;
import java.util.List;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.InputTransform;
import com.aspoka1.app.office.taskmanager.tiles.TaskTile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MenuScreen implements Screen, GestureListener {
	private final TaskManager app;
	private OrthographicCamera camera;

	private Sprite background;

	private Rectangle tilesSpace;
	List<TaskTile> tiles = new ArrayList<TaskTile>();

	public MenuScreen(TaskManager app) {
		this.app = app;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

		background = new Sprite(new Texture("Menu.png"));

		tilesSpace = new Rectangle(25, 25, 430, 600);
		for (int i = 0; i < 1; i++) {
			tiles.add(new TaskTile(25, 475 - i * 150));
		}

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

		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(app.batch);
		}

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
		// float deltaX = InputTransform.getDeltaX(screenDeltaX);
		float deltaY = InputTransform.getDeltaY(screenDeltaY);

		if (tilesSpace.contains(x, y)) {
			if (deltaY > 0) {
				if (tiles.get(tiles.size() - 1).y < 25) {
					for (int i = 0; i < tiles.size(); i++) {
						tiles.get(i).scroll(deltaY);
					}
					if (tiles.get(tiles.size() - 1).y > 25) {
						float delta = 25 - tiles.get(tiles.size() - 1).y;
						for (int i = 0; i < tiles.size(); i++) {
							tiles.get(i).scroll(delta);
						}
					}
				}
			} else if (deltaY < 0) {
				if (tiles.get(0).y > 475) {
					for (int i = 0; i < tiles.size(); i++) {
						tiles.get(i).scroll(deltaY);
					}
					if (tiles.get(0).y < 475) {
						float delta = 475 - tiles.get(0).y;
						for (int i = 0; i < tiles.size(); i++) {
							tiles.get(i).scroll(delta);
						}
					}
				}
			}
		}

		return false;
	}

	//////////////////////////////
	////// NEEDLESS METHODS///////
	//////////////////////////////

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
