package runnerscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericscripts.BasePage;

public class TestcCase2 extends BasePage
{
	@Test
	public void FetchTitle()
	{
//		Assert.fail();
		System.out.println(driver.getTitle());
	}

}
