package com.aspoka1.app.office.taskmanager.ui;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.screens.AddTaskScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class AddTaskButton extends AbstractButton{
	private static final long serialVersionUID = 1L;

	public AddTaskButton(float x, float y) {
		super(x, y, new Texture("buttons/add.png"));
	}
	
	public void render(Batch batch){
		super.render(batch);
	}
	
	public void isClicked(TaskManager app, float x, float y){
		if(contains(x, y)){
			app.setScreen(new AddTaskScreen(app));
		}
	}
}
