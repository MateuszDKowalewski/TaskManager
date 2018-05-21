package com.aspoka1.app.office.taskmanager.tasks;

import java.time.LocalDate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TaskTile extends Rectangle {
	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private String startDateString;
	private String endDateString;
	private LocalDate startDate;
	private LocalDate endDate;

	private static BitmapFont latoFont;
	Texture texture;

	public TaskTile(float x, float y) {
		super(x, y, 430, 150);
		title = "Example task title Example task title";
		description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam aliquam urna enim, eget accumsan diam facilisis vel. Etiam vehicula ante.";
		startDate = LocalDate.now();
		endDate = LocalDate.now();
		setupFonts();
		setupStrings();
		texture = new Texture("ExampleTaskTile.png");
	}

	public TaskTile(float x, float y, String title, String description, LocalDate startDate, LocalDate endDate) {
		super(x, y, 430, 150);
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		setupFonts();
		setupStrings();
		texture = new Texture("ExampleTaskTile.png");
	}

	public void scroll(float y) {
		this.y += y;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y);
		latoFont.draw(batch, endDateString, x + 270, y + 115);
		latoFont.draw(batch, title, x + 10, y + 125, 250, 100, true);
	}

	private void setupFonts() {
		latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	}

	private void setupStrings() {
		String year, month, day;

		year = Integer.toString(endDate.getYear());
		month = Integer.toString(endDate.getMonthValue());
		day = Integer.toString(endDate.getDayOfMonth());
		month = (month.length() == 1) ? (month = '0' + month) : month;
		day = (day.length() == 1) ? (day = '0' + day) : day;
		endDateString = day + ':' + month + ':' + year;

		year = Integer.toString(startDate.getYear());
		month = Integer.toString(startDate.getMonthValue());
		day = Integer.toString(startDate.getDayOfMonth());
		month = (month.length() == 1) ? (month = '0' + month) : month;
		day = (day.length() == 1) ? (day = '0' + day) : day;
		startDateString = day + ':' + month + ':' + year;
	}

}
