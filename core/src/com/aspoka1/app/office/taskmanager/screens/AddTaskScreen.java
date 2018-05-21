package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AddTaskScreen extends AbstractScreen{
	private TaskManager app;
	private OrthographicCamera camera;

	private static Sprite background = new Sprite(new Texture("screens/AddTaskScreen.png"));
	
	public AddTaskScreen(TaskManager app){
		this.app = app;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		app.batch.setProjectionMatrix(camera.combined);
		app.batch.begin();

		background.draw(app.batch);

		app.batch.end();
	}
}
