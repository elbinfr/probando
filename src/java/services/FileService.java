/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Conexion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

/**
 *
 * @author DELL
 */
public final class FileService {
    
    public static BufferedWriter create(String filePath, String fileName, String extension) throws IOException{
        String route = filePath + fileName + "." +extension;
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(route));
        return fileWriter;
    }
    public static void write(BufferedWriter fileWriter) throws IOException{
        fileWriter.flush();
        fileWriter.close();
    }
    
    public static boolean exists(){
        return true;
    }
    
    public static boolean save(File archivo, String filePath, String archivoFileName, String newFileName, String extension) throws FileNotFoundException, IOException{
        
        File fileToCreate = new File(filePath, archivoFileName);
        FileUtils.copyFile(archivo, fileToCreate);

        File newfile = new File(filePath, newFileName + "." + extension);

        if (fileToCreate.renameTo(newfile)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void download(String route,String nameFile, String renameFile) throws FileNotFoundException, IOException {
        FileInputStream archivo = new FileInputStream(route+nameFile); 
        int longitud = archivo.available();
        byte[] datos = new byte[longitud];
        archivo.read(datos);
        archivo.close();

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+renameFile);    

        ServletOutputStream ouputStream = response.getOutputStream();
        ouputStream.write(datos);
        ouputStream.flush();
        ouputStream.close();
    }
   
    public static void generateSQLasFile(String cabecera,String filePath, String fileName, String extension, String query) throws IOException, SQLException{

        Connection cn = Conexion.getInstancia().miConexion();
        BufferedWriter fileWriter = create( filePath, fileName, extension);
        fileWriter.append(cabecera);
        fileWriter.append("\r\n");
        CopyManager cm = new CopyManager((BaseConnection) cn);
        cm.copyOut("COPY ("+ query +")"
            + " TO STDOUT WITH DELIMITER ';'", fileWriter);
        write(fileWriter);
    }
    
}
