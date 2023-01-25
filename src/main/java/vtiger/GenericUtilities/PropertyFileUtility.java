package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of generic method related to property file
 * @author ASHWINI
 *
 */
public class PropertyFileUtility {
	/**
	 * This method  will read the data from property file 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public  String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyfilePath);
		Properties poj=new Properties();
		poj.load(fis);
		String value = poj.getProperty(key);
		return value;

	}
}
