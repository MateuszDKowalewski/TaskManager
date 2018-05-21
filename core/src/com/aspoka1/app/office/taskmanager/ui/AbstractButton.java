package com.aspoka1.app.office.taskmanager.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractButton extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	private Texture texture = new Texture("ExampleTaskTile.png");
	
	public AbstractButton(float x, float y, Texture texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
		width = texture.getWidth();
		height = texture.getHeight();
	}
	
	protected void render(Batch batch){
		batch.draw(texture, x, y);
	}
	
	protected void setTexture(Texture texture){
		this.texture = texture;
	}

}
