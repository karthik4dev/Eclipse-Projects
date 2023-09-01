import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
			FileInputStream fiStream = new FileInputStream(".\\Employee.xlsx");
			workbook=(XSSFWorkbook) WorkbookFactory.create(fiStream);
			sheet=workbook.getSheetAt(0);

			int rows= sheet.getLastRowNum();
			int cols= sheet.getRow(1).getLastCellNum();

			for(int i =0;i<rows;i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<cols;j++) {
					XSSFCell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING: {
						System.out.print(cell.getStringCellValue()+"|");
						break;
					}
					case NUMERIC:{
						System.out.print(cell.getNumericCellValue()+"|");
						break;
					}
					case FORMULA:{
						System.out.print(cell.getNumericCellValue()+"|");
						break;
					}
					case BLANK:{
						System.out.print(" Hello");
						break;
					}
					}
					if (j==cols-1) {
						System.out.println();
					}
					
				}
				System.out.println("--------------------------");
			}
			FormulaEvaluator evaluator=workbook.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue=evaluator.evaluate(sheet.getRow(5).getCell(3));
			System.err.print("Client has to pay = ");

			switch (cellValue.getCellType()) {
			case BOOLEAN:
				System.out.print(cellValue.getBooleanValue()+"$/month");
				break;
			case NUMERIC:
				System.out.print(cellValue.getNumberValue()+"$/month");
				break;
			case STRING:
				System.out.print(cellValue.getStringValue()+"$/month");
				break;
			case BLANK:
				break;
			case ERROR:
				break;
			case FORMULA:
				break;
			case _NONE:
				break;
			default:
				break;


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
