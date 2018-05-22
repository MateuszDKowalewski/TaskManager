package com.aspoka1.app.office.taskmanager.screens;

import java.time.LocalDate;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.ui.TextInputListinner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AddTaskScreen extends AbstractScreen{
	private TaskManager app;
	private OrthographicCamera camera;

	private static Sprite background = new Sprite(new Texture("screens/AddTaskScreen.png"));
	private static BitmapFont latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	private static BitmapFont lobsterFont = new BitmapFont(Gdx.files.internal("fonts/lobster.fnt"));
	
	private TextInputListener listener = new TextInputListinner();
	
	private String title;
	private String description;
	private String dateText;
	private LocalDate endDate;
	
	private enum LastChange {NONE, TITLE, DATE, DESCRIPTION};
	private LastChange lastChange;
	
	public AddTaskScreen(TaskManager app){
		this.app = app;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, TaskManager.WIDTH, TaskManager.HEIGHT);
		
		title = "Tap to set title. Make it longer";
		description = "Tap to set description. Make it longer, becouse I want to test multiline description.";
		dateText = "22:25:2018 - 22:05:2018";//"Tap to set date";
		lastChange = LastChange.NONE;
		
		//Gdx.input.getTextInput(listener, "Dialog Title", "Initial Textfield Value", "Hint Value");
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
		latoFont.draw(app.batch, description, 30, 140 + 360, 420, 355, true);

		app.batch.end();
	}
}
