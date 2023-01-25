package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Load the file into fileInput stream
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");

		//Step2:create workbook
		Workbook wk = WorkbookFactory.create(fis);
		
		//Step3:Navigate to the requiredSheet
		Sheet sh = wk.getSheet("Organisation");


		//step4:Navigate to the requires row
		Row rw = sh.getRow(4);

		//Step5:Navigate to the required cell
		Cell cl = rw.getCell(3);
		Cell ce = rw.getCell(2);
		Cell cell = rw.getCell(1);
		//Step6:capture the data present inside the cell
		String value = cl.getStringCellValue();
		System.out.println(value);
		String val = ce.getStringCellValue();
		System.out.println(val);
		System.out.println(cell.getStringCellValue());






	}
}
