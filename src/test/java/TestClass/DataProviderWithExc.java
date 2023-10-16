package TestClass;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screenshotutility.ScreenShotUtility;
public class DataProviderWithExc {
	String keyword=null;
	DataProviderWithExc de;	
	WebDriver driver;
	By searchbox=By.xpath("//textarea[@class=\"gLFyf\"]");
	By searchbutton=By.xpath("//input[@class=\"gNO89b\"]/following::input[@type=\"submit\"][2]");
	@BeforeMethod
	public void setup() throws InterruptedException {
	//WebDriverManager.safaridriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.switchTo().frame("callout");
	driver.findElement(By.xpath("//button[@class=\"M6CB1c rr4y5c\"]")).click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	
	}
	@Test(dataProvider="searchdataprovider")
	
		public void searchKeyword(String keyword) throws InterruptedException {
		//de=new DataProviderWithExc(driver);
		this.keyword=keyword;
		 Thread.sleep(2000);
		 driver.findElement(searchbox).sendKeys(keyword);
			Thread.sleep(1000);
			driver.findElement(searchbox).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(searchbutton).click();
			Thread.sleep(2000);
			System.out.println(driver.switchTo().alert().getText());	
			
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
	@AfterMethod()
	public void getresultanalysis(ITestResult result) throws Exception
	{
	String name = result.getMethod().getMethodName();
	System.out.println(name);
	
	System.out.println(ITestResult.FAILURE);
		if(result.isSuccess())
		{
			ScreenShotUtility.getscreenshot(driver,"Passed",name+"/"+keyword);
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			ScreenShotUtility.getscreenshot(driver,"Failed",name+"/"+keyword);
		}
	}
	
	@AfterMethod(dependsOnMethods="getresultanalysis")
	public void teardown() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println("Driver close");
	driver.quit();
	}
}
