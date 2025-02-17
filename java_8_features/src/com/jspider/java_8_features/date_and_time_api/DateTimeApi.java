package com.jspider.java_8_features.date_and_time_api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeApi {
	public static void main(String[] args)
	{
		LocalDate date=LocalDate.now();
		System.out.println(date);
		DayOfWeek dayOfWeek=date.getDayOfWeek();
		System.out.println(dayOfWeek);
		Month month=date.getMonth();
		System.out.println(month);
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println(dateTime);
		LocalDate localDate=LocalDate.parse("1997-09-13");
		System.out.println(localDate);
	}
}
