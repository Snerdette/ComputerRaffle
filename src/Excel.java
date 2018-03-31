import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	static List<String> userList = new ArrayList<>();
	static List<String> computerList = new ArrayList<>();
	ArrayList<String> list = new ArrayList<>();
	

	 public Excel(){
		
		/*printUsers();
		
		printComputers();*/
		
	 }
	  static List getData(String filePath) {
		List excelList = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();

			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator rowIterator = sheet.iterator();

				while (rowIterator.hasNext()) {

					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();

				CELL:	while (cellIterator.hasNext()) {
						Cell cell = (Cell) cellIterator.next();

							if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
								String email = cell.getStringCellValue();
																
								if((email.contains("@")) & email != null){
									String username = email.substring(0, (email.indexOf("@")));
									try{
										userList.add(username);
									}catch (Exception e){
										System.out.print("fail to set Email for " + email + " error " + e);
									}
								}else {
									continue;
								}
	
							} else if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()){
								int id = (int) cell.getNumericCellValue();
								
								if(id > 500 && id != 0){
								
									String compId = String.valueOf(id);
									computerList.add(compId);
								} else { 
									break; 
								}
								
							}
								
							else { break CELL; }
							}
						}

					
				}
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(computerList.size() > 0 ){
			excelList = computerList;
			
		}else if(userList.size() > 0 ){
			excelList = userList;
		}
		
		return excelList;
	}
	
	static void printUsers(){
		for(String email : userList){
			System.out.print(email + ", ");
		}
	}
	
	static void printComputers(){
		for(String id : computerList){
			System.out.print("ID: " + id +", ");
		}
	}

	

}
