package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.StringServices;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;

public class PreviewScreen extends AbstractScreen {
	private final TaskManager app;
	private OrthographicCamera camera;

	private int taskId;
	private String title;
	private String date;
	private String description;
	private boolean done;

	private static Sprite background = new Sprite(new Texture("screens/PreviewScreen.png"));
	private static BitmapFont latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	private static BitmapFont lobsterFont = new BitmapFont(Gdx.files.internal("fonts/lobster.fnt"));

	public PreviewScreen(TaskManager app, int taskId, Task task) {
		this.app = app;
		this.taskId = taskId;
		title = task.getTitle();
		date = "from " + StringServices.dateToString(task.getStartDate()) + " to "
				+ StringServices.dateToString(task.getEndDate());
		description = task.getDescription();
		done = task.isDone();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

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
		lobsterFont.draw(app.batch, title, 25, 730, 420, 80, true);
		latoFont.draw(app.batch, date, 25, 615, 420, 30, true);
		latoFont.draw(app.batch, description, 25, 470, 420, 100, true);

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
