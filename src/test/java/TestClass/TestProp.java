package TestClass;
import org.testng.annotations.Test;
import Page.Grammerly_Page;
import baselibrary.BaseLibrary;
import excelutility.getreaddata;
import retryattempts.RetryAnalyser;
public class TestProp extends BaseLibrary{
	 // Grammerly_Page raku;
	  TestProp tp;
	//@Test(priority=0,retryAnalyzer = RetryAnalyser.class)
//	@Test(priority=1)
//	  public void run() {
//		System.out.println(getreaddata.getExcedata("./testdata/testdata.xlsx",1,1));
//	}
	//@Test(priority=1,retryAnalyzer = RetryAnalyser.class)
	@Test
	public void check() throws InterruptedException {
		Grammerly_Page raku= new Grammerly_Page(BaseLibrary.driver);
		Thread.sleep(2000);
		raku.sendemail();
		Thread.sleep(2000);
		raku.entertext();
		Thread.sleep(1000);
		raku.sendname();
		Thread.sleep(1000);
		raku.clickonWidgets();
		Thread.sleep(2000);
	}
}