package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Helpers {

	public static String getRandom() {
		Random rand = new Random();
		return Integer.toString(rand.nextInt(100) + 1);
	}

	public static String getDateTime(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
		String dateTime = formatter.format(new Date());
		if (format.equals("mm") && (!dateTime.endsWith("5") || !dateTime.endsWith("0"))) {
			dateTime = Integer.toString(Math.round(Integer.parseInt(dateTime) / 5) * 5);
			if (dateTime.length() == 1) {
				dateTime = "0" + dateTime;
			}
		}
		return dateTime;
	}
}
