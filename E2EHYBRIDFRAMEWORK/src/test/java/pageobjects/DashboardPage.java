package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericscripts.PageFactoryInit;

public class DashboardPage extends PageFactoryInit
{
	//declaration
		@FindBy(xpath  = "(//img[@alt='profile picture'])[1]")
		private WebElement Menu;
		@FindBy(xpath = "//a[.='Logout']")
		private WebElement LogoutOption;
		@FindBy(xpath = "//span[.='PIM']")
		private WebElement PIM_Btn;
		//initialization
		public DashboardPage(WebDriver driver)
		{
			super(driver);
		}
		//utilization
		public WebElement getMenu()
		{
			return Menu;
		}
		public WebElement getLogoutOption()
		{
			return LogoutOption;
		}
		public WebElement getPIM_Btn()
		{
			return PIM_Btn;
		}
}

