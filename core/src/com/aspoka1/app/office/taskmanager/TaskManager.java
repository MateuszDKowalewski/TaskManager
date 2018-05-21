package com.aspoka1.app.office.taskmanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.aspoka1.app.office.taskmanager.screens.MenuScreen;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TaskManager extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 755;
	public static final String TITLE = "TaskManager";
	
	public SpriteBatch batch;
	public ShapeRenderer render;

	private List<Task> tasks = new ArrayList<Task>();
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		render = new ShapeRenderer();
		
		createTasks();
		
		this.screen = new MenuScreen(this);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		render.dispose();
	}
	
	public Task getTask(int i){
		return tasks.get(i);
	}
	
	public int getTasksSize(){
		return tasks.size();
	}
	
	private void createTasks(){
		tasks.add(new Task("Task 1", "It is the best description nr 1", LocalDate.now(), LocalDate.of(2018, 5, 21), false));
		tasks.add(new Task("Task 2", "It is the best description nr 2", LocalDate.now(), LocalDate.of(2018, 5, 22), false));
		tasks.add(new Task("Task 3", "It is the best description nr 3", LocalDate.now(), LocalDate.of(2018, 5, 23), false));
		tasks.add(new Task("Task 4", "It is the best description nr 4", LocalDate.now(), LocalDate.of(2018, 5, 24), false));
		tasks.add(new Task("Task 5", "It is the best description nr 5", LocalDate.now(), LocalDate.of(2018, 5, 25), false));
		tasks.add(new Task("Task 6", "It is the best description nr 6", LocalDate.now(), LocalDate.of(2018, 5, 26), false));
		tasks.add(new Task("Task 7", "It is the best description nr 7", LocalDate.now(), LocalDate.of(2018, 5, 27), false));
		tasks.add(new Task("Task 8", "It is the best description nr 8", LocalDate.now(), LocalDate.of(2018, 5, 28), false));
		tasks.add(new Task("Task 9", "It is the best description nr 9", LocalDate.now(), LocalDate.of(2018, 5, 29), false));
		tasks.add(new Task("Task 10", "It is the best description nr 10", LocalDate.now(), LocalDate.of(2018, 5, 30), false));
	}
}
