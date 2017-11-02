
package services;

import com.jcfr.utiles.JUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import models.Fila;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelService {
    
    private String nameColumns;
    private String hideHeaders;
    private String errorList;
    private int totalRows;

    public ExcelService() {
    }
    
    public void readXLSXFile(String fileName, String path) throws IOException {
        this.hideHeaders = "NO";
        
        ArrayList filas = new ArrayList();
        try {
            InputStream ExcelFileToRead = new FileInputStream(path + fileName + ".xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;

            Iterator<Row> rowIterator = sheet.iterator();
            int numberRow = 0;
            int totalColumnsCurrentRow = 0;
            int totalColumnsFirstRow = 0;
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator= row.cellIterator();
                ArrayList columnas = new ArrayList();
                Fila fila = new Fila();
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    cell.setCellType(Cell.CELL_TYPE_STRING); 
                    
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:                            
                            if(!JUtil.JSU._vacio(cell.getStringCellValue())){
                                columnas.add(cell.getStringCellValue());
                                if(numberRow == 0){
                                    this.nameColumns = this.getNameColumns() + "<li>{" + cell.getStringCellValue() + "}</li>";
                                    if(cell.getStringCellValue().equalsIgnoreCase("mensaje")){
                                        this.hideHeaders = "SI";
                                    }
                                }
                            }
                            break;
                    }
                }
                
                if(numberRow == 0){
                    totalColumnsFirstRow = columnas.size();
                    if(columnas.size() > 2){
                        this.hideHeaders = "NO";
                    }                    
                }
                
                totalColumnsCurrentRow = columnas.size();
                if(numberRow >= 1){
                    if(totalColumnsCurrentRow != totalColumnsFirstRow){
                        this.errorList = this.errorList + "<p>ERROR EN FILA: " + numberRow + "</p>";
                    }                    
                }
                
                fila.setColumnas(columnas);
                filas.add(fila);
                numberRow++;

            }
            this.totalRows = numberRow - 1;
        } catch (Exception e) {

        }

        //return filas;

    }

    public String getNameColumns() {
        return nameColumns;
    }

    public void setNameColumns(String nameColumns) {
        this.nameColumns = nameColumns;
    }

    public String getHideHeaders() {
        return hideHeaders;
    }

    public void setHideHeaders(String hideHeaders) {
        this.hideHeaders = hideHeaders;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public String getErrorList() {
        return errorList;
    }

    public void setErrorList(String errorList) {
        this.errorList = errorList;
    }
    
    
}
