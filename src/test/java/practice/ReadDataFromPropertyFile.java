package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		//step 1: read the file in java readable format using file input stream

		FileInputStream fis=new FileInputStream("./src/test/resources/CommanData.properties");

		//step 2: Create object of propety class from java.ytil
		Properties pobj=new Properties();

		//step 3: 
		pobj.load(fis);

		//step 4: provide the key &read the value
		String url = pobj.getProperty("url");
		System.out.println(url);
		
		String browser = pobj.getProperty("browser");
		System.out.println(browser);
		
	}
}
