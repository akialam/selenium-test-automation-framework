package com.utility;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.constant.Env;
public class JSONUtility {

	
	public static Environment readJSON(Env env )  {
		Gson gSon=new Gson();
		File gsonFile=new File(System.getProperty("user.dir")+"\\config\\config.json");
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(gsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config=gSon.fromJson(fileReader,Config.class);
		System.out.println(env);
		System.out.println(config.getEnvironments().get(env.name()));
	Environment environment=config.getEnvironments().get(env.name());
	
	return environment;
	}
}
