package com.aspoka1.app.office.taskmanager.tasks;

import java.time.LocalDate;

import com.aspoka1.app.office.taskmanager.services.StringServices;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TaskTile extends Rectangle {
	private static final long serialVersionUID = 1L;

	private String title;
	private String date;

	private static BitmapFont latoFont;
	Texture texture;

	public TaskTile(float x, float y, String title, LocalDate date) {
		super(x, y, 430, 150);
		this.title = title;
		this.date = StringServices.dateToString(date);
		latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
		texture = new Texture("ExampleTaskTile.png");
	}

	public void scroll(float y) {
		this.y += y;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y);
		latoFont.draw(batch, date, x + 270, y + 115);
		latoFont.draw(batch, title, x + 10, y + 125, 250, 100, true);
	}
}
