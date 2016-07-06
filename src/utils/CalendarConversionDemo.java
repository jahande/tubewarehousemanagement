package utils;

/**
 * <p>Title: Calender Conversion Demo Program</p>
 * <p>Description: Demonstration program to show the capabilities of the
 * calendar conversion class.</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * @author Siamak Azodolmolky (azods@yahoo.com)
 * @version 1.00 (Build 8405)
 */

public class CalendarConversionDemo {
  public static void main(String[] args) {
    // Invoking the default constructor to show the current date
    CalendarConversion calendarConversion = new CalendarConversion();

    System.out.println("------------------------------------------------------");
    System.out.println("      'Calendar Conversion Demonstration Program'");
    System.out.println("               Ver. 1.00, 11 August 2005");
    System.out.println(" Report bugs to: Siamak Azodolmolky (azods@yahoo.com)");
    System.out.println("------------------------------------------------------");
    // Presenting the current day using the 'toString()' method
    System.out.println("Today:" + calendarConversion);

    //getDayofWeek()
    System.out.println("Day of Week using getDayOfWeek():[" +
                       calendarConversion.getDayOfWeek() + "] (Monday=0..Sunday=6)");

    //getGregorianDate(), getGregorianYear(), getGregorianMonth(), getGregorianDay()
    System.out.println("Gregorian date:" + calendarConversion.getGregorianDate());
    System.out.println("Gregorian Year,Month,Day:[" +
                       calendarConversion.getGregorianYear() + "," +
                       calendarConversion.getGregorianMonth() + "," +
                       calendarConversion.getGregorianDay() + "]");

    //getIranianDate(), getIranianYear(), getIranianMonth(), getIranianDay()
    System.out.println("Iranian date:" + calendarConversion.getIranianDate());
    System.out.println("Iranian Year,Month,Day:[" +
                       calendarConversion.getIranianYear() + "," +
                       calendarConversion.getIranianMonth() + "," +
                       calendarConversion.getIranianDay() + "]");

    //getJulianDate(), getJulianYear(), getJulianMonth(), getJulianDay()
    System.out.println("Julian date:" + calendarConversion.getJulianDate());
    System.out.println("Julian Year,Month,Day:[" +
                       calendarConversion.getJulianYear() + "," +
                       calendarConversion.getJulianMonth() + "," +
                       calendarConversion.getJulianDay() + "]");
    //getWeekDayStr()
    System.out.println("Week day:" + calendarConversion.getWeekDayStr());

    // nextDay()
    calendarConversion.nextDay();
    System.out.println("Next Day:" + calendarConversion);

    //nextDay(10), Next ten days
    calendarConversion.nextDay(10);
    System.out.println("Next 10 Days:" + calendarConversion);

    // PreviousDay(10), Previous ten days
    calendarConversion.previousDay(10);
    System.out.println("Previous 10 Days:" + calendarConversion);

    // previousDay()
    calendarConversion.previousDay();
    System.out.println("Previous Day:" + calendarConversion);

    // setGregorianDate() to 20 March 2005
    calendarConversion.setGregorianDate(2005, 3, 20);
    System.out.println("Set Gregorian date to '20 March 2005', other dates:\n" +
                       calendarConversion);

    // setIranianDate() to 1 Farvardin 1
    calendarConversion.setIranianDate(1, 1, 1);
    System.out.println("Set Iranian date to '1 Farvardin 1', other dates:\n" +
                       calendarConversion);

    // setJulianDate() to 20 March 2005
    calendarConversion.setJulianDate(2005, 3, 20);
    System.out.println("Set Julian date to '20 march 2005', other dates:\n" +
                       calendarConversion);

    System.out.println("------------------------------------------------------");
  }
}
