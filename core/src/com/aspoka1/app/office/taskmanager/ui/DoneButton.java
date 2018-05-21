package com.aspoka1.app.office.taskmanager.ui;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class DoneButton extends AbstractButton {
	private static final long serialVersionUID = 1L;

	public DoneButton(float x, float y, int taskId, TaskManager app) {
		super(x, y, new Texture("buttons/undone.png"));
		if (app.getTask(taskId).isDone()) {
			super.setTexture(new Texture("buttons/done.png"));
		}
	}

	public void render(Batch batch) {
		super.render(batch);
	}

	public void isClicked(TaskManager app, float x, float y, int taskId) {
		if (contains(x, y)) {
			app.getTask(taskId).setDone(!app.getTask(taskId).isDone());
			if (app.getTask(taskId).isDone()) {
				super.setTexture(new Texture("buttons/done.png"));
			} else {
				super.setTexture(new Texture("buttons/undone.png"));
			}
		}
	}
}
