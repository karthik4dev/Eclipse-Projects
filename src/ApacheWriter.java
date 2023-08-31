
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApacheWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object record[][]= {{"Employee id","Employee Name","Department"},{1,"Aditya","Analyst"},{2,"Bharath","Junior Analyst"},
				{3,"Charan","Business User"},{4,"Durgesh","Clerk"}};
		XSSFWorkbook workbook=null;
		XSSFSheet sheet=null;
		FileOutputStream fos=null;
		try {
			workbook=new XSSFWorkbook();
			sheet=workbook.createSheet("Employee Sheet");
			int rows=record.length;
			int cols=record[0].length;
			for (int i = 0; i < rows; i++) {
				XSSFRow row=sheet.createRow(i);
				for (int j = 0; j < cols; j++) {
					XSSFCell cell = row.createCell(j);
					Object value=record[i][j];
					if(value instanceof Integer) {
						cell.setCellValue((Integer)value);
					}
					if(value instanceof Boolean) {
						cell.setCellValue((Boolean)value);
					}
					if(value instanceof String) {
						cell.setCellValue((String)value);
					}
					
				}
				String fileNameAndDest=".\\Employee.xlsx";
				fos=new FileOutputStream(fileNameAndDest);
				workbook.write(fos);
				System.out.println("File created");
				System.out.println("Please Check " + fileNameAndDest );
			}

		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}

}
