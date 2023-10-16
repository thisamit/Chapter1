package Page;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class Check {
	public WebDriver driver;
	@Test
	public void m2() throws InterruptedException {
	driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver","./driver.chromedriver");
	driver.get("https://www.grammarly.com/signin");
	
	driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("amitkumar0126@gmail.com");
	driver.findElement(By.xpath("//span[@class=\"base-module_text__C-qRo\"]")).click();
	Thread.sleep(2000);
	//driver.findElement(By.className("")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("fine123");
	Thread.sleep(2000);

	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class=\"base-module_text__C-qRo\"]")).click();
	Thread.sleep(2000);
	String at = driver.getTitle();
	String et = "grammarly";
	driver.close();
	if(at.equalsIgnoreCase(et))
	{
    	System.out.println("Test Successful");
    }
    else
    {
    	System.out.println("Test Failure");
    }

	String actualUrl="https://www.grammerly.com/";
	String expectedUrl= driver.getCurrentUrl(); 
	if(actualUrl.equalsIgnoreCase(expectedUrl)) 
	{ 
		System.out.println("Test passed"); 
	 }
	else 
	{
		System.out.println("Test failed"); 
	 } 


}
	
	@AfterTest
	public void teardown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.quit();
	}
}
