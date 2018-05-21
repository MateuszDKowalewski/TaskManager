package com.aspoka1.app.office.taskmanager.screens;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.InputTransform;
import com.aspoka1.app.office.taskmanager.services.StringServices;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.aspoka1.app.office.taskmanager.ui.DoneButton;
import com.aspoka1.app.office.taskmanager.ui.MenuButton;
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

	private static Sprite background = new Sprite(new Texture("screens/PreviewScreen.png"));
	private static BitmapFont latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	private static BitmapFont lobsterFont = new BitmapFont(Gdx.files.internal("fonts/lobster.fnt"));
	
	private MenuButton menu;
	private DoneButton doneButton;

	public PreviewScreen(TaskManager app, int taskId, Task task) {
		this.app = app;
		this.taskId = taskId;
		title = task.getTitle();
		date = "from " + StringServices.dateToString(task.getStartDate()) + " to "
				+ StringServices.dateToString(task.getEndDate());
		description = task.getDescription();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

		menu = new MenuButton(25, 500);
		doneButton = new DoneButton(391, 500, taskId, app);
		
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
		menu.render(app.batch);
		doneButton.render(app.batch);
		
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
		menu.isClicked(app, x, y);
		doneButton.isClicked(app, x, y, taskId);
		
		return false;
	}
}
