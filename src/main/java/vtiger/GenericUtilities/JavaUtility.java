package vtiger.GenericUtilities;


import java.util.Date;
import java.util.Random;

/**
 * 
 * @author ASHWINI
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number for every run
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}
	/**
	 * This method will provide the system date
	 * @return
	 */
	
	public String getSystemDate() {
		Date d= new Date();
		String value = d.toString();
		return value;
	}
	/**
	 * this method will return the specific format
	 * @return
	 */
	public String getSystemDateInFormat() {
	Date d=new Date();
	String[] dArr = d.toString().split(" ");
	String date = dArr[2];
	String mon = dArr[1];
	String year = dArr[5];
	String time = dArr[3].replace(":", "-");
	String dateFormat = date+"-"+mon+"-"+year+" "+time;
	return dateFormat;
	}
}
