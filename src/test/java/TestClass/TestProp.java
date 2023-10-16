package TestClass;
import org.testng.annotations.Test;
import Page.Grammerly_Page;
import baselibrary.BaseLibrary;
import excelutility.getreaddata;
import retryattempts.RetryAnalyser;
public class TestProp extends BaseLibrary{
	  Grammerly_Page raku;
	  TestProp tp;
	@Test(priority=1,retryAnalyzer = RetryAnalyser.class)
	public void run() {
		System.out.println(getreaddata.getExcedata("./testdata/testdata.xlsx",1,1));
	}
	@Test(priority =2,retryAnalyzer = RetryAnalyser.class)
	public void check() throws InterruptedException {
		raku= new Grammerly_Page(driver);
		
		Thread.sleep(2000);
		raku.sendemail();
		Thread.sleep(2000);
		raku.entertext();
		Thread.sleep(1000);
		raku.sendname();
		Thread.sleep(1000);
		raku.clickonWidgets();
	}
}