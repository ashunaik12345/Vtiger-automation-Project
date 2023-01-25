package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPracties {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility jutil=new JavaUtility();
		int data = jutil.getRandomNumber();
		System.out.println(data);
		
		String sys = jutil.getSystemDate();
		System.out.println(sys);
		
		String format = jutil.getSystemDateInFormat();
		System.out.println(format);
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String valu = putil.readDataFromPropertyFile("browser");
		System.out.println(valu);
		System.out.println(putil.readDataFromPropertyFile("url"));
		
		ExcelFileUtility eUtil= new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Contacts", 1, 2);
		System.out.println(value);
		
		eUtil.writeDataIntoExcel("Contacts", 4, 4, "ashwini");
		System.out.println("data added");
		System.out.println(eUtil.getRowCount("Contacts"));
	}
}
