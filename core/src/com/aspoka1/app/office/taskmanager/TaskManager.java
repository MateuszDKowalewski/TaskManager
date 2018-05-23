package com.aspoka1.app.office.taskmanager;

import java.util.ArrayList;
import java.util.List;

import com.aspoka1.app.office.taskmanager.screens.MenuScreen;
import com.aspoka1.app.office.taskmanager.services.MemoryService;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TaskManager extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 755;
	public static final String TITLE = "TaskManager";

	private MemoryService memory;

	public SpriteBatch batch;
	public ShapeRenderer render;

	private List<Task> tasks = new ArrayList<Task>();

	@Override
	public void create() {
		batch = new SpriteBatch();
		render = new ShapeRenderer();

		memory = new MemoryService(this);
		int amount = memory.getAmmount();
		for (int i = 0; i < amount; i++) {
			tasks.add(memory.getTask(i));
		}

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
	
	public void changeIsTaskDone(int taskId){
		memory.changeIsDone(taskId);
	}

	public void addTask(Task task) {
		tasks.add(task);
		memory.addTask(task);
	}

	public Task getTask(int i) {
		return tasks.get(i);
	}

	public int getTasksSize() {
		return tasks.size();
	}
	
	public void deleteTask(int taskId){
		tasks.remove(taskId);
		memory.clear();
		memory.saveAll(tasks.size());
	}
}
