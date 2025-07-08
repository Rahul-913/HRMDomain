package genericscripts;

import java.util.Date;

public class CurrentTimezone
{
	public static String timeZone()
	{
		Date d = new Date();
		String d1 = d.toString();
		String d2 = d1.replace(":","-");
		return d2;
	}
}
