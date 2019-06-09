package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class Helpers {

	public static String getRandom() {
		Random rand = new Random();
		return Integer.toString(rand.nextInt(100) + 1);
	}

	public static String getDateTime(String dateFormat, String timeZone) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
		formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int unroundedMinutes = calendar.get(Calendar.MINUTE);
		int mod = unroundedMinutes % 5;
		calendar.add(Calendar.MINUTE, mod < 3 ? -mod : (5 - mod));
		return formatter.format(calendar.getTime()) + " " + timeZone;
	}
}