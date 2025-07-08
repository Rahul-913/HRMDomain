package genericscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import pageobjects.PIM_Page;

public class BasePage implements IApplicationConstants //initialization and utilization of browser
{
	public LoginPage lp;
	public DashboardPage dp;
	public static WebDriver driver;
	public PIM_Page pim;
	@Parameters("Browsers")//chrome/firefox
	@BeforeClass
	public void launchBrowser(String Browsers) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		switch(Browsers.toLowerCase().trim())
		{
		case "chrome":driver = new ChromeDriver();
						break;
		case "firefox":driver = new FirefoxDriver();
						break;
		default:System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(waitTime,TimeUnit.SECONDS);
		ReadPropertyFile.AccessData();
		driver.get(ReadPropertyFile.ReadData("QA_Url"));
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		pim = new PIM_Page(driver);
	}
	@BeforeMethod
	public void loginApplication()
	{
		lp.getUsn().sendKeys(ReadPropertyFile.ReadData("testUsn"));
		lp.getPsw().sendKeys(ReadPropertyFile.ReadData("testPsw"));
		lp.getLoginBtn().click();
	}
	@AfterMethod
	public void logoutApplication()
	{
		dp.getMenu().click();
		dp.getLogoutOption().click();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	
	}
}

