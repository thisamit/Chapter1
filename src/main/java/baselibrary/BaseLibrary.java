package baselibrary;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import prpertyutility.propertyutils;
import screenshotutility.ScreenShotUtility;

public class BaseLibrary {
	public static String urlpath=propertyutils.getreaddata("url","./testdata/config.properties");
	 public static WebDriver driver;
	 
	
 @BeforeMethod
 @Parameters("browser")
public  void browser(String browser) {

	
// String brow=propertyutils.getreaddata("browser","./testdata/config.properties");


if(browser.equals("chrome"))
	{
WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
	}
else if(browser.equals("safari"))
{
WebDriverManager.safaridriver().setup();
driver = new SafariDriver();
}
	

else
	{
	System.out.println("Please provide a proper browser value..");
	}


	driver.get(urlpath);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		ScreenShotUtility.getscreenshot("Passed",name);
	}
	else if(result.getStatus()==ITestResult.FAILURE)
	{
		ScreenShotUtility.getscreenshot("Failed",name);
	}
}

@AfterTest
public void teardown() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.quit();
}
}

