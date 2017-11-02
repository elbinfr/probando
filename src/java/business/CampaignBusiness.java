
package business;

import models.Corporate;
import helpers.FileHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CampaignBusiness {
    
    static Logger logger = Logger.getLogger((Class)CampaignBusiness.class);
    
    private boolean status;
    private String message;

    public CampaignBusiness() {
    }
    
    public boolean validateFileCampaign(File file, Corporate corporate) throws Exception, FileNotFoundException, IOException, SQLException{
        try{
            double sizeInMB = FileHelper.getFileSizeInMB(file);
            if ( sizeInMB > 2.0 ) {
                this.setMessage("Archivo muy pesado. Su archivo debe pesar como máximo 2 MB");
                return false;
            }
            
            InputStream fileSending = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fileSending);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row firstRow = sheet.getRow(sheet.getFirstRowNum());
            int lastRow = sheet.getLastRowNum();
            int firstColumn = firstRow.getFirstCellNum();
            int lastColumn = firstRow.getLastCellNum();
            /*
            int limit = CorporateDAO.getInstancia().findLimitMessages(corporate.getId());

            if (limit > 0) {
                if (lastRow > limit) {
                    this.setLimit("Has superado el limite de envío configurado. "
                            + "Te quedan " + limit + " mensajes permitidos");
                }
            }
            */

            if (sheet.getNumMergedRegions() > 0) {
                this.setMessage("El archivo no debe tener celdas combinadas.");
                return false;
            }

            if (lastRow > 70000) {
                this.setMessage("El archivo no debe tener más de 50 mil filas.");
                return false;
            }

            if (lastColumn > 5) {
                this.setMessage("El archivo no debe tener más de 5 columnas.");
                return false;
            }

            for (Cell cell : firstRow) {

                if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    String columnName = CellReference.convertNumToColString(cell.getColumnIndex());
                    this.setMessage("El encabezado de la columna " + columnName + " esta vacio, "
                            + "por favor elimine dicha columna en su archivo.");
                    return false;
                }
                if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                    this.setMessage("El encabezado de su archivo es incorrecto. Debe ser de formato texto");
                    return false;
                }
            }

            //Cabecera de Primera columna debe ser numero
            Cell firstCell = firstRow.getCell(firstColumn);
            if (!(firstCell.getStringCellValue().toUpperCase()).equals("NUMERO")) {
                this.setMessage("El encabezado de la primera columna debe ser: Numero");
                return false;
            }

            if (lastColumn == 2) {
                Cell lastCell = firstRow.getCell(lastColumn - 1);
                if (!(lastCell.getStringCellValue().toUpperCase()).equals("MENSAJE")) {
                    this.setMessage("El encabezado de la segunda columna debe ser: Mensaje");
                    return false;
                }
                for (Row row : sheet) {
                    Cell cell = row.getCell(lastColumn - 1);
                    if (cell.getStringCellValue().length() > 160) {
                        this.setMessage("El archivo contiene mensajes con más de 160 caracteres");
                        return false;
                    }
                }
            }
            
        }catch(Exception ex){
            logger.error((Object)("MOWA-ERROR (BUSINESS)!!! " + ex.getMessage()));
        }finally{
            
        }
        
        return true;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
