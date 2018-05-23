package com.aspoka1.app.office.taskmanager.screens;

import java.time.LocalDate;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.services.DataServices;
import com.aspoka1.app.office.taskmanager.services.InputTransform;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.aspoka1.app.office.taskmanager.ui.MenuButton;
import com.aspoka1.app.office.taskmanager.ui.SaveTaskButton;
import com.aspoka1.app.office.taskmanager.ui.TextInputListinner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;

public class AddTaskScreen extends AbstractScreen {
	private TaskManager app;
	private OrthographicCamera camera;

	private static Sprite background = new Sprite(new Texture("screens/AddTaskScreen.png"));
	private static BitmapFont latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	private static BitmapFont lobsterFont = new BitmapFont(Gdx.files.internal("fonts/lobster.fnt"));

	private TextInputListener listener = new TextInputListinner(this);

	private String title;
	private String description;
	private String dateText;
	private LocalDate endDate;

	private Rectangle titleHitBox;
	private Rectangle dateHitBox;
	private Rectangle descriptionHitBox;
	
	private MenuButton menuButton;
	private SaveTaskButton saveButton;

	private enum LastChange {
		NONE, TITLE, DATE, DESCRIPTION
	};

	private LastChange lastChange;

	public AddTaskScreen(TaskManager app) {
		this.app = app;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);

		title = "Tap to set title.";
		description = "Tap to set description.";
		dateText = "Tap to set date";
		lastChange = LastChange.NONE;

		titleHitBox = new Rectangle(30, 625, 420, 95);
		dateHitBox = new Rectangle(30, 550, 420, 30);
		descriptionHitBox = new Rectangle(30, 145, 420, 355);
		
		menuButton = new MenuButton(100, 55);
		saveButton = new SaveTaskButton(316, 55);

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
		lobsterFont.draw(app.batch, title, 30, 720, 420, 95, true);
		latoFont.draw(app.batch, dateText, 30, 580, 420, 30, true);
		latoFont.draw(app.batch, description, 30, 500, 420, 355, true);
		menuButton.render(app.batch);
		saveButton.render(app.batch);

		app.batch.end();
	}

	public void incommingMessage(String message) {
		switch (lastChange) {
		case TITLE:
			title = message;
			break;

		case DATE:
			if(DataServices.isGoodDataFormat(message)){
				endDate = DataServices.stringToDate(message);
				dateText = DataServices.dateToString(LocalDate.now()) + " - " + DataServices.dateToString(endDate);
			}else{
				Gdx.input.getTextInput(listener, "Wrong data format", "", "dd-mm-yyyy");
			}
			break;

		case DESCRIPTION:
			description = message;
			break;
			
		case NONE:
			break;
			
		default:
			break;
		}
	}

	@Override
	public boolean tap(float screenX, float screenY, int count, int button) {
		float x = InputTransform.getCursorToModelX(screenX);
		float y = InputTransform.getCursorToModelY(screenY);

		if (titleHitBox.contains(x, y)) {
			lastChange = LastChange.TITLE;
			Gdx.input.getTextInput(listener, "Write task title", "", "Title");
		}
		if (dateHitBox.contains(x, y)) {
			lastChange = LastChange.DATE;
			Gdx.input.getTextInput(listener, "Write task end data", "", "dd-mm-yyyy");
		}
		if (descriptionHitBox.contains(x, y)) {
			lastChange = LastChange.DESCRIPTION;
			Gdx.input.getTextInput(listener, "Write task description", "", "Description");
		}
		
		menuButton.isClicked(app, x, y);
		
		if(saveButton.isClicked(x, y)){
			if(dateText == "Tap to set date"){
				endDate = LocalDate.now();
			}
			app.addTask(new Task(title, description, LocalDate.now(), endDate, false));
			app.setScreen(new MenuScreen(app));
		}

		return false;
	}
}
