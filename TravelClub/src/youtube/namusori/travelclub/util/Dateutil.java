package youtube.namusori.travelclub.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dateutil {
	
	public static String today(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format((Calendar.getInstance().getTime()));
	}
	public static String today() {
		return today("yyyy.MM.dd");
	}

}
