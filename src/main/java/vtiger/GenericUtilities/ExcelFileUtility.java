package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  This class consists of Generic methods related to Excel sheet
 * @author ASHWINI
 *
 */
public class ExcelFileUtility {
/**
 *  This method will read data from excel sheet and return the value
 * @param sheet
 * @param rowno
 * @param Cellno
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheet,int rowno,int Cellno) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sh = wk.getSheet(sheet);
		 Row rw = sh.getRow(rowno);
		 Cell ce = rw.getCell(Cellno);
		String value = ce.getStringCellValue();
		wk.close();
		return value;
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fos=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wo = WorkbookFactory.create(fos);
		Sheet sh = wo.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	/**
	 * this method will write data into excel
	 * @param sheet
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int rowno,int cellno,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fox=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wk1 = WorkbookFactory.create(fox);
		Sheet sh = wk1.getSheet(sheet);
		Row rw = sh.getRow(rowno);
		Cell ce = rw.createCell(cellno);
		ce.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wk1.write(fos);
		wk1.close();
	}
	/**
	 * This method will read mutilple data from the excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sh = wk.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCel];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCel;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;	
		
	
	}
	
}
