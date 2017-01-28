package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class propertyFileReading {


	public static void main(String[] args) throws IOException {
		
		String projectPath= System.getProperty("user.dir");
		System.out.println(projectPath);
		Properties conf= new Properties();
		FileInputStream ip= new FileInputStream(new File(projectPath+"\\src\\main\\resources\\config\\config.properties"));
		
		conf.load(ip);
		
		System.out.println("Prop : " + conf.getProperty("DBPassword"));
		
		Set s=conf.keySet();
		
		Iterator it= s.iterator();
		while(it.hasNext()){
			String key= it.next().toString();
			System.out.println(key+ " : " + conf.getProperty(key));
		}
	}

}
