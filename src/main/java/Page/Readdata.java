package Page;


import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readdata {


	   public static void main(String[] args){
		   String value="";
	        String docName = "./testdata/testdata.xlsx";
	        try{
	            InputStream xlsxDoc = new FileInputStream(docName);
	            XSSFWorkbook wb = new XSSFWorkbook(xlsxDoc);
	            XSSFSheet sheet = wb.getSheetAt(0);
	            System.out.println(sheet.getSheetName());   
	           value= sheet.getRow(0).getCell(1).getStringCellValue();
	          
	        }
	        catch(Exception e){  
	            e.printStackTrace();
	        }
	        System.out.println(value);
	     }

}
	

