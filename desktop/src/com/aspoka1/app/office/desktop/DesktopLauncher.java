package com.aspoka1.app.office.desktop;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = TaskManager.TITLE;
		config.width = TaskManager.WIDTH;
		config.height = TaskManager.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new TaskManager(), config);
	}
}
