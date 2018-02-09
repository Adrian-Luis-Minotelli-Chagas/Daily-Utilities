package br.com.dailyutilities.dates;

import java.util.Calendar;

public class ConvertLongToDate {

	public static void main(String[] args) {
		Long timestamp = new Long(1517835540);
		
		if(args.length > 0) {
			timestamp = new Long(args[0]);
		}

		Calendar time = Calendar.getInstance();

		time.setTimeInMillis(((timestamp * 1000)));

		System.out.println(time.getTime());
	}

}
