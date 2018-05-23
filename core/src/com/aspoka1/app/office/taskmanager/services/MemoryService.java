package com.aspoka1.app.office.taskmanager.services;

import java.time.LocalDate;

import com.aspoka1.app.office.taskmanager.TaskManager;
import com.aspoka1.app.office.taskmanager.tasks.Task;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class MemoryService {
	public static final String APP_PRFS = "com.aspoka1.app.office.taskmanager.prfs";
	public static final String APP_TASK_AMMOUNT = "com.aspoka1.app.office.taskmanager.prfs.ammount";
	public static final String APP_TITLE = "com.aspoka1.app.office.taskmanager.prfs.title";
	public static final String APP_START_DATA_DAY = "com.aspoka1.app.office.taskmanager.prfs.starDataDay";
	public static final String APP_START_DATA_MONTH = "com.aspoka1.app.office.taskmanager.prfs.starDataMonth";
	public static final String APP_START_DATA_YEAR = "com.aspoka1.app.office.taskmanager.prfs.starDataYear";
	public static final String APP_END_DATA_DAY = "com.aspoka1.app.office.taskmanager.prfs.endDataDay";
	public static final String APP_END_DATA_YEAR = "com.aspoka1.app.office.taskmanager.prfs.endDataYear";
	public static final String APP_END_DATA_MONTH = "com.aspoka1.app.office.taskmanager.prfs.endDataMonth";
	public static final String APP_DESCRIPTION = "com.aspoka1.app.office.taskmanager.prfs.description";
	public static final String APP_IS_DONE = "com.aspoka1.app.office.taskmanager.prfs.isDone";

	private TaskManager app;
	private Preferences prefs;

	public MemoryService(TaskManager app) {
		this.app = app;
		prefs = Gdx.app.getPreferences(APP_PRFS);
	}

	public int getAmmount() {
		System.out.println(prefs.getInteger(APP_TASK_AMMOUNT));
		return prefs.getInteger(APP_TASK_AMMOUNT);
	}

	public Task getTask(int i) {
		String n = Integer.toString(i);
		String title = prefs.getString(APP_TITLE + n, "Title not found");
		String description = prefs.getString(APP_DESCRIPTION + n, "Description not found");
		boolean done = prefs.getBoolean(APP_IS_DONE + n, false);
		int startDay = prefs.getInteger(APP_START_DATA_DAY + n, 0);
		int startMonth = prefs.getInteger(APP_START_DATA_MONTH + n, 0);
		int startYear = prefs.getInteger(APP_START_DATA_YEAR + n, 0);

		int endDay = prefs.getInteger(APP_END_DATA_DAY + n, 0);
		int endMonth = prefs.getInteger(APP_END_DATA_MONTH + n, 0);
		int endYear = prefs.getInteger(APP_END_DATA_YEAR + n, 0);

		return new Task(title, description, LocalDate.of(startYear, startMonth, startDay),
				LocalDate.of(endYear, endMonth, endDay), done);
	}

	public void saveAll(int ammount) {
		prefs.putInteger(APP_TASK_AMMOUNT, ammount);
		//System.out.println(ammount);
		Task task;
		for (int i = 0; i < ammount; i++) {
			//System.out.println('i');
			task = app.getTask(i);
			prefs.putString(APP_TITLE + Integer.toString(i), task.getTitle());
			prefs.putInteger(APP_START_DATA_DAY + Integer.toString(i), task.getStartDate().getDayOfMonth());
			prefs.putInteger(APP_START_DATA_MONTH + Integer.toString(i), task.getStartDate().getMonthValue());
			prefs.putInteger(APP_START_DATA_YEAR + Integer.toString(i), task.getStartDate().getYear());
			prefs.putInteger(APP_END_DATA_DAY + Integer.toString(i), task.getEndDate().getDayOfMonth());
			prefs.putInteger(APP_END_DATA_MONTH + Integer.toString(i), task.getEndDate().getMonthValue());
			prefs.putInteger(APP_END_DATA_YEAR + Integer.toString(i), task.getEndDate().getYear());
			prefs.putString(APP_DESCRIPTION + Integer.toString(i), task.getDescription());
			prefs.putBoolean(APP_IS_DONE + Integer.toString(i), task.isDone());
		}
		prefs.flush();
	}
}