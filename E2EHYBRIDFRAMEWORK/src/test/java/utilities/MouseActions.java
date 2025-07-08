package utilities;

import org.openqa.selenium.WebElement;

public class MouseActions
{
	public static void rightClick(WebElement element)
	{
		ObjectsOfActions.mouseActions().contextClick(element).perform();
	}
	public static void leftClick(WebElement element)
	{
		ObjectsOfActions.mouseActions().click(element).perform();
	}
	public static void mouseHovering(WebElement element)
	{
		ObjectsOfActions.mouseActions().moveToElement(element).perform();
	}
	public static void doubleClick(WebElement element)
	{
		ObjectsOfActions.mouseActions().doubleClick(element).perform();
	}
	public static void dragAndDrop(WebElement element1,WebElement element2)
	{
		ObjectsOfActions.mouseActions().dragAndDrop(element1,element2).perform();
	}
	public static void clickAndHold(WebElement element)
	{
		ObjectsOfActions.mouseActions().clickAndHold(element).perform();
	}
	public static void releaseAction(WebElement element)
	{
		ObjectsOfActions.mouseActions().release(element).perform();

	}
	public static void dragElement(WebElement element, int x,int y)
	{
		ObjectsOfActions.mouseActions().moveToElement(element, x, y).perform();

	}
}
