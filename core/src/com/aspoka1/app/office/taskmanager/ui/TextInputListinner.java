package com.aspoka1.app.office.taskmanager.ui;

import com.aspoka1.app.office.taskmanager.screens.AddTaskScreen;
import com.badlogic.gdx.Input.TextInputListener;

public class TextInputListinner implements TextInputListener{
	AddTaskScreen toMessage;
	
	public TextInputListinner(AddTaskScreen toMessage) {
		this.toMessage = toMessage;
	}
	
	@Override
	public void input(String text) {
		toMessage.incommingMessage(text);
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}

}
