package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown 
{
	static Select dropdwonAddress;
	public static void selectOptions(WebElement dropdwon, Object data)//1/2/3
	{
		dropdwonAddress = ObjectsOfActions.handlingDropdown(dropdwon);
		if(data instanceof Integer)
		{
		dropdwonAddress.selectByIndex((int) data);//int
		}
		else 
		{
			try 
			{
				dropdwonAddress.selectByValue((String) data);//string
			}
			catch (Exception e) 
			{
				dropdwonAddress.selectByVisibleText((String)data);//string
			}
		}
}
	public static void deSelectOptions(WebElement dropdwon, Object data)
	{
		dropdwonAddress = ObjectsOfActions.handlingDropdown(dropdwon);
		if(data == "DeseclectAll")
		{
		dropdwonAddress.deselectAll();
		}
		else if(data instanceof Integer)
		{
			dropdwonAddress.deselectByIndex((int) data);
		}
		else if(data instanceof String)
		{
			try {
				dropdwonAddress.deselectByValue((String) data);
			} catch (Exception e) {
				dropdwonAddress.deselectByVisibleText((String)data);
		}
		}
	}
	public static List<WebElement> fetchOptions(String input, WebElement dropdown)
	{
		List<WebElement> options = null;
		dropdwonAddress = ObjectsOfActions.handlingDropdown(dropdown);

		if(input.equals("GetAllOptions"))
		{
			options = dropdwonAddress.getOptions();
		}
		else if(input.equals("GetSelectedOptions"))
		{
			options = dropdwonAddress.getAllSelectedOptions();
		}
		else if(input.equals("GetFirstSelectedOption"))
		{
			options = (List<WebElement>) dropdwonAddress.getFirstSelectedOption();
		}
		return options;	
	}
}
