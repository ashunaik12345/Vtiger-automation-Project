package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePracties {

	@Test(dataProvider="phone")
	public void addProductToCart(String phone,int price,String model) {
		System.out.println(phone+" "+price+" "+model);
	}
	
	@DataProvider(name="phone")
	public static Object[][] getData() {
		                         //row,//colums
		Object[][] data=new Object[2][3];
		
		data[0][0]="Samsung";
		data[0][1]= 12000;
		data[0][2]="A80";
		
		data[1][0]="Iphone";
		data[1][1]= 16000;
		data[1][2]="S13";
		
		return data;
		
	}
	
	
	
	
}
