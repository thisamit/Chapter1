package waitutility;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import baselibrary.BaseLibrary;

public class WaitUtility extends BaseLibrary{
public static WebDriver driver;
	
	

		
		public static void elementisclickable(WebElement ele, Duration time)
		{
			WebDriverWait wait= new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		
		public static void fluentwaitisclickable(WebElement ele)
		{
			@SuppressWarnings("deprecation")
			Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(Exception.class);
			
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		
		
		
	}

