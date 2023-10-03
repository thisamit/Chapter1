package screenshotutility;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import baselibrary.BaseLibrary;

public class ScreenShotUtility extends BaseLibrary{
	 static public WebDriver driver;
	

		
		public static void getscreenshot(String foldername,String filename)  throws Exception {
				//Convert web driver object to TakeScreenshot
			String loc = System.getProperty("./screenshot");
			try {
				
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				//Move image file to new destination
				File DestFile=new File(loc+"/"+foldername+"/"+filename+".jpeg");
				System.out.println(DestFile);
				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
				}
//			String loc = System.getProperty("./screenshot");
//			try {
//				String path=loc+"/"+foldername+""+filename+".jpeg";
//				EventFiringWebDriver efw=new EventFiringWebDriver(driver);
//				File src = efw.getScreenshotAs(OutputType.FILE);
//				FileUtils.copyFile(src, new File(path));
//			} catch (Exception e) {
//				System.out.println("Issue in Getscreenshots "+e);
//			}
		//	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
				//Convert web driver object to TakeScreenshot

//			String loc = System.getProperty("./screenshot");
//			try {

			//String loc = System.getProperty("./screenshot");
//        	try {
//        		String loc="./screenshot/";
//			    String path=loc+foldername+"/"+filename+".jpeg";
//			    System.out.println(path);
//				TakesScreenshot scrShot=((TakesScreenshot)driver);
//			
//				File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
//			
//				FileUtils.copyFile(srcFile,new File(path));
//				}
		 catch (Exception e) {
		System.out.println("Issue in Getscreenshots "+e);
		}
		}
		
		
	}


