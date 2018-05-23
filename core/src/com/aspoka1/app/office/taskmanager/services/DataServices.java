package com.aspoka1.app.office.taskmanager.services;

import java.time.LocalDate;

public class DataServices {
	public static boolean isGoodDataFormat(String date) {
		int day, month, year;

		if (date.length() != 10) {
			return false;
		}

		for (int i = 0; i < 10; i++) {
			if (i == 2) {
				if (((int) date.charAt(i) != 58) && ((int) date.charAt(i) != 45) && ((int) date.charAt(i) != 46)) {
					return false;
				}
			} else if (i == 5) {
				if (((int) date.charAt(i) != 58) && ((int) date.charAt(i) != 45)) {
					return false;
				}
			} else {
				if (((int) date.charAt(i) < 48) || ((int) date.charAt(i) > 57)) {
					return false;
				}
			}
		}
		day = ((int) date.charAt(0) - 48) * 10 + (int) date.charAt(1) - 48;
		month = ((int) date.charAt(3) - 48) * 10 + (int) date.charAt(4) - 48;
		year = ((int) date.charAt(6) - 48) * 1000 + ((int) date.charAt(7) - 48) * 100 + ((int) date.charAt(8) - 48) * 10
				+ (int) date.charAt(9) - 48;

		if ((day == 0) || (month == 0) || (year == 0)) {
			return false;
		}

		if ((day > 31) || (month > 12)) {
			return false;
		}

		if (month == 2) {
			if ((day > 28) && !(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))) {
				return false;
			} else if (day > 29) {
				return false;
			}
		} else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)
				|| (month == 12)) {
			if (day > 31) {
				return false;
			}
		} else if (day > 30) {
			return false;
		}
		return true;
	}

	public static LocalDate stringToDate(String string) {
		int day = ((int) string.charAt(0) - 48) * 10 + (int) string.charAt(1) - 48;
		int month = ((int) string.charAt(3) - 48) * 10 + (int) string.charAt(4) - 48;
		int year = ((int) string.charAt(6) - 48) * 1000 + ((int) string.charAt(7) - 48) * 100 + ((int) string.charAt(8) - 48) * 10
				+ (int) string.charAt(9) - 48;
		return LocalDate.of(year, month, day);
	}
	
	public static String dateToString(LocalDate date){
		String day, month, year;
		day = Integer.toString(date.getDayOfMonth());
		month = Integer.toString(date.getMonthValue());
		year = Integer.toString(date.getYear());
		
		if(day.length() == 1){
			day = '0' + day;
		}
		
		if(month.length() == 1){
			month = '0' + month;
		}
		
		return day + '.' + month + '.' + year;
	}
}
