package Page;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		
//		String s="112";
//		
//	
//		int n=Integer.parseInt(s);
//		System.out.println(n+2);
//		Scanner sc=new Scanner(System.in);
//		int usernum=0;
//		
//		int randomnum=(int)(Math.random()*100);
//		do {
//			System.out.print("Guess the number:");
//			usernum=sc.nextInt();
//			if(usernum==randomnum){
//				System.out.println("You guess the right number!!");
//				break;
//			}
//			else if(randomnum>usernum){
//				System.out.println("Number is greater than your number");
//				
//			}
//			else{
//				System.out.println("Number is lower tan your number");
//			}
//			
//		}
//		while(usernum>=0) ;
//		}


	// TODO Auto-generated method stub


	
//WebElement s=driver.findElement(By.xpath("//select[@title=\"Search in\"]"));
//		
//		Thread.sleep(1000);
//		
//		Select s1=new Select(s);
//		s1.selectByValue("Amazon Fashion");
			
		WebDriverManager.safaridriver().setup();
		WebDriver driver=new SafariDriver();
		driver.get("https://www.industrybuying.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		//driver.switchTo().frame("id=\"_hjSafeContext_96767495\"");
		driver.findElement(By.xpath("//button[text()=\"No thanks\"]")).click();
		ArrayList<String>elm=new ArrayList<String>();
		List<WebElement> industry = driver.findElements(By.xpath("//span[@id=\"search_concept\"]//following::li[@class=\"AH_SearchCat\"]"));
		 
        for(int i=0;i<=industry.size()-1;i++) {
        	elm.add(industry.get(i).getText());
        	System.out.print(elm.get(i));
        	
        } 
        
      
        
        System.out.print(elm);
        for(int i=industry.size()-1;i>=0;i--) {
        	if(industry.get(i).getText().equalsIgnoreCase(elm.get(i))) {
        		System.out.print(industry.get(i).getText());
        		Assert.assertEquals(industry.get(i).getText(), elm.get(i));
        		
        	}
        }
		
  
       
//        Collections.reverse(elm);
//        System.out.print(elm);
        driver.quit(); 
        
		//driver.switchTo().defaultContent();
		
//		driver.switchTo().alert().dismiss();
//		Thread.sleep(1000);
//		
//	
		
//        for (String webEl : elm) {
//            String name1 = webEl;
//            System.out.println(name1);
//        }
 
       
//        
//        ArrayList<String> arr=new ArrayList<>();
//        arr.add("amit");
//        arr.add("kumar");
        
        
        //for(int i=industry.size()-1;i>=0;i--) {
//        if(industry.get(i).getText().equalsIgnoreCase(elm.get(i))) {
//       		System.out.println(industry.get(i).getText()+ " Reverse-Equal "+ elm.get(i));
////        }
//        	}
//        
//
//        for (WebElement webElement : industry) {
//            String name = webElement.getText();
//            System.out.println(name);
//        }
//    
//        
//   
    
//		WebElement em=driver.findElement(By.xpath("//span[@id=\"search_concept\"]//following::li[@class=\"AH_SearchCat\"]"));
//		List<WebElement> elm=new ArrayList<>();
//		
//		for(int i=0;i<=50;i++) {
//			elm.add(em);
//		}
		
//	}
	}
}
