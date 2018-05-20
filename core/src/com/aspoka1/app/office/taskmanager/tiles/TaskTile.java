package com.aspoka1.app.office.taskmanager.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TaskTile extends Rectangle{
	private static final long serialVersionUID = 1L;

	Texture texture;
	
	public TaskTile(float x, float y) {
		super(x, y, 430, 150);
		
		texture = new Texture("ExampleTaskTile.png");
	}
	
	public void scroll(float y){
		this.y += y;
	}
	
	public void render(SpriteBatch batch){
		batch.draw(texture, x, y);
	}
	
}
