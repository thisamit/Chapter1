package baselibrary;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import prpertyutility.propertyutils;
import screenshotutility.ScreenShotUtility;
public class BaseLibrary {
	public static String urlpath=propertyutils.getreaddata("url","./testdata/config.properties");
	static public WebDriver driver=null;
	static public String browser=null;

	@BeforeTest
	@Parameters("browser")
	public  void browser(String browser) {
		this.browser=browser;
 		if(browser.equals("chrome"))
 		{
 			WebDriverManager.chromedriver().setup();
 			driver = new ChromeDriver();
 		}
		else if(browser.equals("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please provide a proper browser value..");
		}
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		driver.get(urlpath);
 	

}
 

@AfterMethod
public void getresultanalysis(ITestResult result) throws Exception
{
String name = result.getMethod().getMethodName();
System.out.println(name);
System.out.println(name+ "hhhhhhhhhhhh");
Reporter.log("Pass");

System.out.println(result.getStatus());
System.out.println(ITestResult.FAILURE);
	if(result.isSuccess())
	{
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ScreenShotUtility.getscreenshot(driver,browser+ "-Passed",name);
	}
	else if(result.getStatus()==ITestResult.FAILURE)
	{ 		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ScreenShotUtility.getscreenshot(driver,browser+ "-Failed",name);
	}
}
@AfterTest
public void teardown() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println(driver.getTitle()+ " "+browser);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.quit();
   
}
}