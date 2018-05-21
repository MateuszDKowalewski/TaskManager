package com.aspoka1.app.office.taskmanager.ui;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.screens.MenuScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MenuButton extends AbstractButton{
	private static final long serialVersionUID = 1L;
	
	public MenuButton(float x, float y) {
		super(x, y, new Texture("buttons/menu.png"));
	}
	
	public void render(Batch batch){
		super.render(batch);
	}

	public void isClicked(TaskManager app, float x, float y){
		if(contains(x, y)){
			app.setScreen(new MenuScreen(app));
		}
	}
}
