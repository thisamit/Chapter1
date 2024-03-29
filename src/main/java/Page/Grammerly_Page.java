package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Grammerly_Page {
 public static WebDriver driver=null;
//	By email=By.xpath("//input[@id=\"email\"]");

	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement email;
	
	
	//By enter=By.xpath("//input[@name=\"password\"]");

	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement enter;
	
	//By signupname=By.xpath("//input[@name=\"name\"]");
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement signupname;
	
	//By con=By.xpath("//button[@type=\"submit\"]");
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement con; 

		public Grammerly_Page(WebDriver d) {
		   driver=d;
			PageFactory.initElements(driver,this);
		}
		
	



		public void sendemail() {
			//driver.findElement(email).sendKeys("amitkumar0126@gmail.com");
			email.clear();
		email.sendKeys("amitkumar0126@gmail.com");
		}
		public void entertext() throws InterruptedException {
			 //driver.findElement(enter).sendKeys("fine@123");
			enter.clear();
		enter.sendKeys("fine@123");
		}
		public void sendname() throws InterruptedException {
			// driver.findElement(signupname).sendKeys("Amit kumar");
			signupname.clear();
		signupname.sendKeys("Amit kumar");
		}
		public void clickonWidgets() throws InterruptedException{
			//driver.findElement(con).click();;
		con.click();
		}
}