package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;

public class PreviewScreen extends AbstractScreen{
	private final TaskManager app;
	private OrthographicCamera camera;
	
	private int taskId;
	private String title;
	private String startDate;
	private String endDate;
	private String description;
	private boolean done;
	
	private Sprite background;
	
	public PreviewScreen(TaskManager app, int taskId,  Task task) {
		this.app = app;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);
		
		background = new Sprite(new Texture("screens/PreviewScreen.png"));
		
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

		background.draw(app.batch);

		app.batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}
}
