import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteToFile {
	
	
	private static final String FILE_PATH = "/Users/klafrance/Desktop/Computer wipe/Results.xlsx";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final WriteToFile INSTANCE = new WriteToFile();

    public static WriteToFile getInstance() {
        return INSTANCE;
    }

    WriteToFile() {
    	writeResultsToExcel();
    }


    public static void writeResultsToExcel(){

    	List<Winner> excelList = AppRuner.winnerList;
        Workbook workbook = new XSSFWorkbook();

        Sheet ResultsSheet = workbook.createSheet("Results");

        int rowIndex = 0;
        int cellIndex = 0;
        Row row = ResultsSheet.createRow(rowIndex++);
        row.createCell(cellIndex++).setCellValue("ID");
        row.createCell(cellIndex++).setCellValue("Winner");
        for(Winner winner : excelList){
        	
            row = ResultsSheet.createRow(rowIndex++);
            cellIndex = 0;
 
            row.createCell(cellIndex++).setCellValue(winner.getId());
            row.createCell(cellIndex++).setCellValue(winner.getUsername());

        }

        try {
        	ResultsSheet.autoSizeColumn(0);
        	ResultsSheet.autoSizeColumn(1);
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
	
	

}
