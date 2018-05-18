package com.aspoka1.app.office.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.aspoka1.app.office.TaskManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "TaskManager";
		config.width = 480;
		config.height = 800;
		config.resizable = false;
		new LwjglApplication(new TaskManager(), config);
	}
}
