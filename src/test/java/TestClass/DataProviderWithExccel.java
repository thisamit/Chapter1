package TestClass;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshotutility.ScreenShotUtility;

public class DataProviderWithExccel {
	
	WebDriver driver;
	@FindBy(xpath="//button[@class=\"M6CB1c rr4y5c\"]")
	WebElement click;
	
	@FindBy(xpath="//div[@class=\"SDkEP\"]")
	WebElement searchbox;
	//WebElement button=driver.findElement(By.xpath("//button[@class=\"M6CB1c rr4y5c\"]"));
	public DataProviderWithExccel(WebDriver driver){
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@BeforeMethod
	public void setup() {
	WebDriverManager.safaridriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	}
	@Test(dataProvider="searchdataprovider")
	
		public void searchKeyword(String keyword) throws InterruptedException {
		
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		 // new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("frame_name")));

		driver.switchTo().frame("callout");
		 WebElement button=driver.findElement(By.xpath("//button[@class=\"M6CB1c rr4y5c\"]"));
		 Thread.sleep(2000);
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
			
		 Thread.sleep(2000);
			searchbox.sendKeys(keyword);
			Thread.sleep(2000);
			searchbox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
		}
	@DataProvider(name="searchdataprovider")
	public Object[][] searchdataproviderMethod(){
		Object[][] searchdata=getdataExcel("./testdata/Monuments.xlsx","Sheet1");
//		 searchdata[0][0]="Taj Mahal";
//		 searchdata[1][0]="Hawa Mahal";
		
		return searchdata;
		
	}
	public String[][] getdataExcel(String filePath,String SheetName){
		
		
		String data[][]=null;
		try {
			FileInputStream file=new FileInputStream(filePath);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet excelsheet=wb.getSheet(SheetName);
			int lastrow =excelsheet.getLastRowNum()+1;
			int lastcol=excelsheet.getRow(0).getLastCellNum();
			data=new String[lastrow-1][lastcol];
			for(int currentrow=1;currentrow<lastrow;currentrow++) {
				for(int currentcell=0;currentcell<lastcol;currentcell++) {
					data[currentrow-1][currentcell]=excelsheet.getRow(currentrow).getCell(currentcell).getStringCellValue();
				}
			}
			wb.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return data;
		
	}
	@AfterMethod
	public void getresultanalysis(ITestResult result) throws Exception
	{
	String name = result.getMethod().getMethodName();
	System.out.println(name);
	System.out.println(result.getStatus());
	System.out.println(ITestResult.FAILURE);
		if(result.isSuccess())
		{
			ScreenShotUtility.getscreenshot(driver,"Passed",name);
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			ScreenShotUtility.getscreenshot(driver,"Failed",name);
		}
	}
	
//	@AfterTest
//	public void teardown() throws InterruptedException {
//	Thread.sleep(2000);
//	driver.quit();
//}
}
