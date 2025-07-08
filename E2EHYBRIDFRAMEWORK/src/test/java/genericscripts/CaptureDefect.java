package genericscripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureDefect extends BasePage
{
	public static void Defect(String TestcaseName) throws Throwable 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(screenShotPath+CurrentTimezone.timeZone()+" "+TestcaseName+".png");
		FileHandler.copy(temp, perm);		
	}

}
