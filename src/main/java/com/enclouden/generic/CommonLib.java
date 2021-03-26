package com.enclouden.generic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonLib {

	public static boolean filterDate(String dateStamp) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate dateTime=LocalDate.parse(dateStamp, dtf);
		LocalDate presentDate = LocalDate.now();
		LocalDate afterSevenDays = LocalDate.now().plusDays(7);
		if((dateTime.isAfter(presentDate)&& dateTime.isBefore(afterSevenDays))||dateTime.isEqual(presentDate)||dateTime.isEqual(afterSevenDays))
		{
			return true;
		}
		else
		{
			return false;
		}
}
}