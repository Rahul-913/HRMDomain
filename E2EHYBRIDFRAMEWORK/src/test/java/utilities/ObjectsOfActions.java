package utilities;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericscripts.BasePage;

public class ObjectsOfActions extends BasePage
{
	public static Actions mouseActions()
	{
		return new Actions(driver);
	}
	public static Select handlingDropdown(WebElement dropdown)
	{
		return new Select(dropdown);
	}
	public static JavascriptExecutor handlingJavaScriptExecutor()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js;
	}
	public static Robot keyBoardFunctions() throws AWTException
	{
		return new Robot();
	}
}







