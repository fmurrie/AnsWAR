package tiempo;

public class Display
{
	public void printTime(int hour, int minute, int second)
	{
		String fullHour = "";

		fullHour += (hour > 9) ? ":" + hour : "0" + hour;
		fullHour += (minute > 9) ? ":" + minute : ":0" + minute;
		fullHour += (second > 9) ? ":" + second : ":0" + second;

		System.out.println(fullHour);
	}
}
