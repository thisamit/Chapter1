package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class Grammerly_Page extends BaseLibrary{
	WebDriver driver;


	@FindBy(xpath="//input[@id='id']")
	 WebElement email;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement enter;
	
	@FindBy(xpath="//input[@id='name']")
	 WebElement signupname;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	 WebElement con; 

  


		public Grammerly_Page(WebDriver d) {
		
			
			driver=d;
			PageFactory.initElements(driver, this);
		}

		
		public void sendemail() throws InterruptedException {
			Thread.sleep(2000);
			email.sendKeys("amitkumar0126@gmail.com");
		}
		public void entertext() throws InterruptedException {
			Thread.sleep(2000);
			enter.sendKeys("fine@123");
		}
		public void sendname() throws InterruptedException {
			Thread.sleep(2000);
			signupname.sendKeys("Amit kumar");
		}
		public void clickonWidgets() throws InterruptedException
		{
			Thread.sleep(2000);
			con.click();
		}
	
		
		
		
		
		



}
