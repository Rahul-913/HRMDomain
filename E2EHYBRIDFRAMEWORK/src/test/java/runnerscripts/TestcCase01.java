package runnerscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericscripts.BasePage;

public class TestcCase01 extends BasePage
{
	@Test(dataProvider = "Testdata")
	public void AddEmp(String fn, String mn, String ln)
	{
		dp.getPIM_Btn().click();
		pim.getAddEmp().click();
		pim.getFn().sendKeys(fn);
		pim.getMn().sendKeys(mn);
		pim.getLn().sendKeys(ln);
		pim.getSaveBtn().click();
	}
	
	@DataProvider(name = "Testdata")
	public String[][] TestData() throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData/Selenium.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();//10,9
		int lastCellNo = sheet.getRow(lastRow).getLastCellNum();//1,2
		String[][] data = new String[lastRow+1][lastCellNo];
		for(int r=0;r<=lastRow;r++)
		{
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<lastCellNo;c++)
			{
				XSSFCell cell = row.getCell(c);
				String val = cell.getStringCellValue();
				data[r][c] = val;
			}
		}
		return data;
	}
}
