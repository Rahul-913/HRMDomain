package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericscripts.PageFactoryInit;

public class LoginPage extends PageFactoryInit {
	//declaration
	@FindBy(name = "username")
	private WebElement usn;
	@FindBy(name = "password")
	private WebElement psw;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	//initialization
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	//utilization
	public WebElement getUsn()
	{
		return usn;
	}
	public WebElement getPsw()
	{
		return psw;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
}
