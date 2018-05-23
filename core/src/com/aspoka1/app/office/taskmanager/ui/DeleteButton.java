package com.aspoka1.app.office.taskmanager.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class DeleteButton extends AbstractButton{
	private static final long serialVersionUID = 1L;

	public DeleteButton(float x, float y) {
		super(x, y, new Texture("buttons/remove.png"));
	}

	public void render(Batch batch){
		super.render(batch);
	}

	public boolean isClicked(float x, float y){
		return contains(x, y);
	}
}
