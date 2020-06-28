/**
 * 
 */
package br.com.sistemawebapp.util;

import java.util.Date;

/**
 * @author antonio
 *
 */
public class ConversorUtil {
	public static Date convertDateEUAToBR(Date date) {
		return new Date(date.getYear(), monthEUAToBr(date.getMonth()), date.getDate());
	}

	public static Date convertDateEUAToBR(String date) {
		final String dataArray[] = date.split("-");
		return new Date(Integer.parseInt(dataArray[0]), monthEUAToBr(Integer.parseInt(dataArray[1])), Integer.parseInt(dataArray[2]));
	}

	private static String checkNumber(Integer number) {
		if (number > 9) {
			return number.toString();
		}
		return "0" + number;
	}

	private static String ckeckYear(Integer number) {
		final Integer startYear = 1900;

		return String.valueOf((startYear + number));
	}
	
	private static Integer checkYearSub(Integer year) {
		final Integer startYear = 1900;
		System.out.println(year-startYear);
		return year-startYear;
	}

	public static String convertDateStringEUAToBR(Date date) {
		return checkNumber(date.getDate()) + "/" + checkNumber(monthEUAToBr(date.getMonth())) + "/" + ckeckYear(date.getYear());
	}

	public static String convertDateStringEUAToBR(String date) {
		final String dateArray[] = date.split("-");
		return checkNumber(Integer.parseInt(dateArray[2])) + "/" + checkNumber(monthEUAToBr(Integer.parseInt(dateArray[1]))) + "/"
				+ checkNumber(Integer.parseInt(dateArray[0]));
	}

	public static Date convertDateStringBRToEUA(String date) {
		final String dateArray[] = date.split("/");
		return new Date(checkYearSub(Integer.parseInt(dateArray[2])), monthBRToEUA(Integer.parseInt(dateArray[1])), Integer.parseInt(dateArray[0]));
	}
	
	private static Integer monthEUAToBr(Integer month) {
		return month + 1;
	}
	
	private static Integer monthBRToEUA(Integer month) {
		System.out.println(month);
		return month - 1;
	}
	
	public static String convertDateStringBRToEUA(String date, int pos) {
		final String dateArray[] = date.split("/");
		
		return dateArray[2] + "-" + checkNumber(monthBRToEUA(Integer.parseInt(dateArray[1]))) + "-" +
				checkNumber(Integer.parseInt(dateArray[0]));
	}
	
	public static Date convertDateBRToEUA(Date date) {
		return new Date(Integer.parseInt(ckeckYear(date.getYear())), Integer.parseInt(checkNumber(monthBRToEUA(date.getMonth()))),
				Integer.parseInt(checkNumber(date.getDate())));
	}
	
	public static Date convertDateBRToEUA(String date) {
		final String dateArray[] = date.split("/");
		return new Date(Integer.parseInt(dateArray[2]), monthBRToEUA(Integer.parseInt(dateArray[1])),
				Integer.parseInt(checkNumber(Integer.parseInt(dateArray[0]))));
	}
}
