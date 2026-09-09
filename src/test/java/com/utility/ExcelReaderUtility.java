package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile() {
		
		File file=new File(System.getProperty("user.dir")+"\\testData\\loginData.xlsx");
		List<User> userList=null;
		
		XSSFWorkbook xssfWorkBook=null;;
		Row row;
		Cell firstCell;
		Cell secondCell;
		User user;
		XSSFSheet xssfSheet;
		Iterator<Row> iteratorData;
		try {
			xssfWorkBook = new XSSFWorkbook(file);
			xssfSheet=xssfWorkBook.getSheet("loginTestData");
			userList=new ArrayList<User>();
			iteratorData=xssfSheet.iterator();
			iteratorData.next();//Skip the column name;
		
			while(iteratorData.hasNext())
			{
				row=iteratorData.next();
				firstCell=row.getCell(0);
				secondCell=row.getCell(1);
				user=new User(firstCell.toString(), secondCell.toString());
				userList.add(user);
				
				
			}
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return userList.iterator();
		
	}

}
