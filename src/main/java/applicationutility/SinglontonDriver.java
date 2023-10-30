package applicationutility;

import org.openqa.selenium.WebDriver;

import baselibrary.BaseLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SinglontonDriver extends BaseLibrary {
	
	private SinglontonDriver(){
		
	}
	private static WebDriver getSinglontonInstance() {
		if(null==driver) {
			
		WebDriverManager.chromedriver().setup();
		WebDriverManager.safaridriver().setup();
		WebDriverManager.firefoxdriver().setup();
		}
		
		return driver;
		
	}

}
