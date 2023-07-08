package constant;

public class Time {
	public static int hour = 7;
	public static int minute = 0;
	public static int second = 0;

	public static void changeTime(int newHour, int newMinute, int newSecond) {
		hour = newHour;
		minute = newMinute;
		second = newSecond;
	}
}
