package ExtentReportUtillity;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterClass implements ITestListener{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public void configureReport() {
		htmlReporter=new ExtentSparkReporter("ExtentReporterClass.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
	
	reports.setSystemInfo("Machine","Basic");
	reports.setSystemInfo("OS","Mac");
	reports.setSystemInfo("Browser","Safari/Chrome");
	reports.setSystemInfo("Name","Amit Kumar");
	
	htmlReporter.config().setDocumentTitle("Extent Listener Report");
	htmlReporter.config().setReportName("This is testing Purpose");
	htmlReporter.config().setTheme(Theme.DARK);
	
	}
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start Method..."+Result.getName());
	}
	public void onTestFailure(ITestResult Result) {
	 test=	reports.createTest(Result.getName());
	 test.log(Status.FAIL,MarkupHelper.createLabel("Name of test case failed: " +Result.getName(), ExtentColor.RED));
		System.out.println("On Failure Test case Method..." + Result.getName());
	}	
	public void onTestSkipped(ITestResult Result) {
		test=	reports.createTest(Result.getName());
		 test.log(Status.SKIP,MarkupHelper.createLabel("Name of test case skipped: " +Result.getName(), ExtentColor.YELLOW));
		System.out.println("On Skipped Test case Method..." +Result.getName());
	}
	public void onTestStart(ITestResult Result) {
		test=	reports.createTest(Result.getName());
		 test.log(Status.INFO,MarkupHelper.createLabel("Name of test case started: " +Result.getName(), ExtentColor.ORANGE));
		System.out.println("On Start Test case Method..." +Result.getName());
	}
	public void onTestSuccess(ITestResult Result) {	
		test=	reports.createTest(Result.getName());
		 test.log(Status.PASS,MarkupHelper.createLabel("Name of test case failed: " +Result.getName(), ExtentColor.GREEN));
	System.out.println("On Success Test case Method..." +Result.getName());
	}
	public void onFinish(ITestContext Result) {
		reports.flush();
		System.out.println("On Finished Method..." +Result.getName());
	}
}
