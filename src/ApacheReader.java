import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApacheReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook=null;
		XSSFSheet sheet= null;
		try {
			FileInputStream fiStream = new FileInputStream(".\\Book 4.xlsx");
			workbook=new XSSFWorkbook(fiStream);
			sheet=workbook.getSheetAt(0);

			int rows= sheet.getLastRowNum();
			int cols= sheet.getRow(1).getLastCellNum();

			for(int i =0;i<rows;i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<cols;j++) {
					XSSFCell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING: {
						System.out.println(cell.getStringCellValue());
						break;
					}
					case NUMERIC:{
						System.out.println(cell.getNumericCellValue());
						break;
					}
					
					}
				}
				System.out.println("--------------------------");
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
