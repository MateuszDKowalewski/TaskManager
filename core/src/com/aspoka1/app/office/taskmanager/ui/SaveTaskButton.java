package com.aspoka1.app.office.taskmanager.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class SaveTaskButton extends AbstractButton {
	private static final long serialVersionUID = 1L;

	public SaveTaskButton(float x, float y) {
		super(x, y, new Texture("buttons/add.png"));
	}

	public void render(Batch batch) {
		super.render(batch);
	}

	public boolean isClicked(float x, float y) {
		if (contains(x, y)) {
			return true;
		} else {
			return false;
		}
	}

}
