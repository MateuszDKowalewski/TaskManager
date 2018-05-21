package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.InputTransform;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.aspoka1.app.office.taskmanager.tasks.TaskTile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;

public class MenuScreen extends AbstractScreen {
	private final TaskManager app;
	private OrthographicCamera camera;

	private Sprite background;

	private Rectangle tilesSpace;
	private TaskTile [] tasks;
	private int amountOfTasks;
	
	public MenuScreen(TaskManager app) {
		this.app = app;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

		background = new Sprite(new Texture("Menu.png"));

		tilesSpace = new Rectangle(25, 25, 430, 600);
		amountOfTasks = app.getTasksSize();
		tasks = new TaskTile[amountOfTasks];
		Task task;
		for (int i = 0; i < amountOfTasks; i++) {
			task = app.getTask(i);
			tasks[i] = new TaskTile(25, 475 - i * 150, task.getTitle(), task.getEndDate());
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

		for (int i = 0; i < amountOfTasks; i++) {
			tasks[i].render(app.batch);
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
		
		if(tilesSpace.contains(x, y)){
			for(int i = 0;  i < amountOfTasks; i++){
				if(tasks[i].contains(x, y)){
					app.setScreen(new PreviewScreen(app, i, app.getTask(i)));
				}
			}
		}

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
				if (tasks[amountOfTasks - 1].y < 25) {
					for (int i = 0; i < amountOfTasks; i++) {
						tasks[i].scroll(deltaY);
					}
					if (tasks[amountOfTasks - 1].y > 25) {
						float delta = 25 - tasks[amountOfTasks - 1].y;
						for (int i = 0; i < amountOfTasks; i++) {
							tasks[i].scroll(delta);
						}
					}
				}
			} else if (deltaY < 0) {
				if (tasks[0].y > 475) {
					for (int i = 0; i < amountOfTasks; i++) {
						tasks[i].scroll(deltaY);
					}
					if (tasks[0].y < 475) {
						float delta = 475 - tasks[0].y;
						for (int i = 0; i < amountOfTasks; i++) {
							tasks[i].scroll(delta);
						}
					}
				}
			}
		}

		return false;
	}

}
