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
	private String done;

	private static BitmapFont latoFont = new BitmapFont(Gdx.files.internal("fonts/lato.fnt"));
	private static Texture texture = new Texture("TaskTile.png");

	public TaskTile(float x, float y, String title, LocalDate date, boolean isDone) {
		super(x, y, 430, 150);
		this.title = title;
		this.date = StringServices.dateToString(date);
		
		if(isDone){
			done = "Done";
		}else{
			done = "Undone";
		}
	}

	public void scroll(float y) {
		this.y += y;
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y);
		latoFont.draw(batch, date, x + 270, y + 115);
		latoFont.draw(batch, title, x + 10, y + 125, 250, 100, true);
		latoFont.draw(batch, done, x + 270, y + 50);
	}
}
