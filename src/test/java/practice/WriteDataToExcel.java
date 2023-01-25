package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Load the file into fileInput stream
		FileInputStream fos=new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//Step2:create workbook
		Workbook wk = WorkbookFactory.create(fos);
		
		//Step3:Navigate to the requiredSheet
		Sheet sh = wk.getSheet("organisation");
		
		//step4:Navigate to the requires row
		Row rw = sh.getRow(4);
		
		//Step5:Navigate to the required cell
		Cell ce = rw.createCell(7);
		ce.setCellValue("12/5/2000");
		//add data
		Cell cl = rw.createCell(6);
		cl.setCellValue("ASHU");
		//add data1
		Cell cel = rw.createCell(5);
		cel.setCellValue("2.0520");
		
		//write into the file inputstream
		FileOutputStream fqs=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wk.write(fqs);
		System.out.println("data is added");
		
		
	}
}
