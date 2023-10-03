package TestClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import org.openqa.selenium.WebDriver;
import Page.Grammerly_Page;
import baselibrary.BaseLibrary;
import excelutility.getreaddata;
import retryattempts.RetryAnalyser;
public class TestProp  extends BaseLibrary {
	   static public WebDriver driver;
	   Grammerly_Page raku;
	 
		  



	
	@Test(priority=1,retryAnalyzer = RetryAnalyser.class)


	public void run() {
		
System.out.println(getreaddata.getExcedata("./testdata/testdata.xlsx",1,1));
}
	@Test(priority =2,retryAnalyzer = RetryAnalyser.class)
public void check() throws InterruptedException {
		raku= new Grammerly_Page(driver);
		Thread.sleep(4000);
		raku.sendemail();
		Thread.sleep(3000);
		raku.entertext();
		Thread.sleep(3000);
		raku.sendname();
		Thread.sleep(3000);
		raku.clickonWidgets();
		
		
	}
}