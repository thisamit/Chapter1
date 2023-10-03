package prpertyutility;

import java.io.FileInputStream;
import java.util.Properties;

//import baselibrary.BaseLibrary;

public class propertyutils{
//	public static void main(String[] args) {
//	
//	System.out.println(getreaddata("name","./testdata/config.properties"));
//	
//	}
		
	
		public static String getreaddata(String key, String filepath)
		{
			Properties prop= new Properties();
			try 
			{
				FileInputStream fis=new FileInputStream(filepath);
				
				prop.load(fis);
				
			} catch (Exception e) 
			{
				System.out.println("Issue in GetReaddata");
			}
			return prop.getProperty(key);
		}
		}
	


