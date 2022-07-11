package dpproject;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class uticodedataprovider {
	public String getData(String fileName, String sheetName, int rowNumber, int columnNumber) throws Exception {
		Workbook workbook = WorkbookFactory.create(new File(fileName));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		return row.getCell(columnNumber).getStringCellValue().trim();
	}

	public int getRowCount(String fileName, String sheetName) throws Exception {
		return WorkbookFactory.create(new File(fileName)).getSheet(sheetName).getLastRowNum() + 1;
	}
	@SuppressWarnings("resource")
	public int getColumnCount(String fileName, String sheetName) throws Exception {
		return new XSSFWorkbook(new FileInputStream(fileName)).getSheet(sheetName).getRow(0).getLastCellNum();
	}
}
