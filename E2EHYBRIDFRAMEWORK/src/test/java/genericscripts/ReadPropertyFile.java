package genericscripts;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile extends BasePage
{
	static Properties pro;
	public static void AccessData() throws Exception
	{
		FileInputStream fis = new FileInputStream(propertyFilePath+"TestData.properties");
		pro = new Properties();
		pro.load(fis);
	}
	public static String ReadData(String key)
	{
		return pro.getProperty(key);
	}
}
