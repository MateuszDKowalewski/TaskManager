package com.aspoka1.app.office.taskmanager.services;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.badlogic.gdx.Gdx;

public class InputTransform {
	public static float getCursorToModelX(float cursorX) {
		return (((float) cursorX) * TaskManager.WIDTH) / ((float) Gdx.graphics.getWidth());
	}

	public static float getCursorToModelY(float cursorY) {
		return ((float) (Gdx.graphics.getHeight() - cursorY)) * TaskManager.HEIGHT / ((float) Gdx.graphics.getHeight());
	}

	public static float getDeltaX(float deltaX) {
		return (((float) deltaX) * TaskManager.WIDTH) / ((float) Gdx.graphics.getWidth());
	}
	
	public static float getDeltaY(float deltaY) {
		return (((float) -deltaY) * TaskManager.HEIGHT) / ((float) Gdx.graphics.getHeight());
	}
}
