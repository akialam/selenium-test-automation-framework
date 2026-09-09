package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constant.Env;

public class PropertiesUtil {
	//Read property file
	
	public static String readProperty(Env env,String propertyName)  {
		File propertyFile=new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties properties =new Properties();
		try {
			fileReader = new FileReader(propertyFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(propertyName);
		
		
	}
	

}
