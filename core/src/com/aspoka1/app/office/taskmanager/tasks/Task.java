package com.aspoka1.app.office.taskmanager.tasks;

import java.time.LocalDate;

public class Task {
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean done;

	public Task(String title, String description, LocalDate startDate, LocalDate endDate, boolean done) {
		this.setTitle(title);
		this.setDescription(description);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setDone(done);
	}

	/////////////////////////////////
	////// GETTERS AND SETTERS///////
	/////////////////////////////////

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
