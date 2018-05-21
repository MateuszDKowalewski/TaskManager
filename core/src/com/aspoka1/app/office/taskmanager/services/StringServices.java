package com.aspoka1.app.office.taskmanager.services;

import java.time.LocalDate;

public class StringServices {
	public static String dateToString(LocalDate date){
		String year, month, day;
		year = Integer.toString(date.getYear());
		month = Integer.toString(date.getMonthValue());
		day = Integer.toString(date.getDayOfMonth());
		month = (month.length() == 1) ? (month = '0' + month) : month;
		day = (day.length() == 1) ? (day = '0' + day) : day;
		return day + ':' + month + ':' + year;
	}
}
