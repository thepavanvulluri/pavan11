package learningMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public Object[][] readMultipleData(String sheetName) throws IOException {
		File file=new File("./src/test/resources/testData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		int row_count=sheet.getPhysicalNumberOfRows();
		int col_count=sheet.getRow(1).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[row_count-1][col_count];
		
		for(int i=0;i<row_count-1;i++) {
			for(int j=0;j<col_count;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	

}
