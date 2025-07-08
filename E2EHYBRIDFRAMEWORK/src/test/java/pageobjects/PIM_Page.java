package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericscripts.PageFactoryInit;

public class PIM_Page extends PageFactoryInit {
	//declaration
	@FindBy(xpath ="//a[.='Add Employee']")
	private WebElement addEmp;
	@FindBy(name = "firstName")
	private WebElement fn;
	@FindBy(name = "middleName")
	private WebElement mn;
	@FindBy(name = "lastName")
	private WebElement ln;
	@FindBy(xpath = "//button[.=' Save ']")
	private WebElement saveBtn;
	//initialization
	public PIM_Page(WebDriver driver)
	{
		super(driver);
	}
	//utilization
	public WebElement getAddEmp()
	{
		return addEmp;
	}
	public WebElement getFn()
	{
		return fn;
	}
	public WebElement getMn()
	{
		return mn;
	}
	public WebElement getLn()
	{
		return ln;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
}
