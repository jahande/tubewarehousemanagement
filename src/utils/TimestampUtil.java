package utils;

import java.sql.Timestamp;


public class TimestampUtil {
	public static String toSimpleString(Timestamp timestamp) {
		return timestamp.toString().substring(0, 19);
	}
	/**
	 * convert  sth like 1391/8/18 to timestamp
	 */
	public static Timestamp ShamsiToTimestamp(String shamsi) {
		String[] shamsis = shamsi.split("/");
		if(shamsis[1].length()==1){
			shamsis[1] = "0"+shamsis[1];
		}
		if(shamsis[2].length()==1){
			shamsis[2] = "0"+shamsis[2];
		}
		CalendarConversion calendarConversion = new CalendarConversion();
		calendarConversion.setIranianDate(new Integer(shamsis[0]).intValue(), new Integer(shamsis[1]).intValue(), new Integer(shamsis[2]).intValue());
		String timestampString = calendarConversion.getGregorianYear()+"-"+calendarConversion.getGregorianMonth()+"-"+calendarConversion.getGregorianDay()+" 00:00:00";
		return Timestamp.valueOf(timestampString);
	}
	/**
	 * 2012-11-08 00:00:00 to 1391/8/18 (Ex.)
	 * @param timestamp
	 * @return
	 */
	public static String timestampToShamsi(Timestamp timestamp) {
		String date = timestamp.toString().substring(0, 10);
		String[] dates = date.split("-");
		CalendarConversion calendarConversion = new CalendarConversion();
		calendarConversion.setGregorianDate(new Integer(dates[0]).intValue(), new Integer(dates[1]).intValue(), new Integer(dates[2]).intValue());
		return calendarConversion.getIranianDate();
		
	}
	/**
	 * returns number of day after(+) or previous(-) current time
	 * 0->today
	 * @param numberOfDays
	 * @return
	 */
	public static String shamsiOffset(int numberOfDays){
		return TimestampUtil.timestampToShamsi(new Timestamp(System.currentTimeMillis()+TimestampUtil.DAY_MILLIS*numberOfDays));
		
	}
	final static long DAY_MILLIS = 24*3600*1000;
}
