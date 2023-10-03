package applicationutility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationUtils {
	static WebDriver driver;
	public static void clickme(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	
	public static void sendkeys(WebElement ele,String value)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(value);
		
	}
	public static void Doubleclick(WebElement ele)
	{
		Actions act= new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public static void rightclick(WebElement ele)
	{
		Actions act= new Actions(driver);
		act.contextClick(ele).perform();
	}
	public static void changewindow(int tabno)
	{
		Set<String> set = driver.getWindowHandles();
		ArrayList<String>tabs=new ArrayList<String>(set);
		driver.switchTo().window(tabs.get(tabno));
	}

}
