package genericscripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersClass extends BasePage implements ITestListener 
{
	ExtentSparkReporter reporter;
	ExtentReports reports;
//	ExtentTest test;
	public void onStart(ITestContext context)
	{
		System.out.println(context.getName());
		reporter = new ExtentSparkReporter(extentReportsPath+context.getName()+" "+CurrentTimezone.timeZone()+".html");
		reporter.config().setDocumentTitle(context.getName());
		reporter.config().setReportName("ExecutionReport");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser","Chrome");
		reports.setSystemInfo("OS","Windows");
		System.out.println("TestExecutionCycleIsStarted");
	}
	public void onFinish(ITestContext context)
	{
		reports.flush();
		System.out.println("TestExecutionCycleIsTerminated");
	}
	public void onTestStart(ITestResult result)
	{
		ExtentTest test = reports.createTest(result.getName());
		test.log(Status.INFO,result.getName()+" Execution Is started");
		System.out.println(result.getName()+" ExecutionIsStarted");
	}
	public void onTestSuccess(ITestResult result)
	{
		ExtentTest test = reports.createTest(result.getName());
		test.log(Status.PASS,result.getName() +"Execution Is Success");
		System.out.println(result.getName()+" ExecutionIsSuccess");
	}
	public void onTestFailure(ITestResult result)
	{
		ExtentTest	test = reports.createTest(result.getName());
		test.log(Status.FAIL,result.getName()+" Execution Is failed");
		System.out.println(result.getName()+" ExecutionIsFailed");
		try {
			CaptureDefect.Defect(result.getName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		ExtentTest	test = reports.createTest(result.getName());
		test.log(Status.SKIP,"Execution Is skipped");
		System.out.println(result.getName()+" ExecutionIsSkipped");	
	}
}
