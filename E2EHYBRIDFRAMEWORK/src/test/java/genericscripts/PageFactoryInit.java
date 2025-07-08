package genericscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryInit
{
	public PageFactoryInit(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
