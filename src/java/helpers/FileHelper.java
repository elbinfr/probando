
package helpers;

import java.io.File;


public final class FileHelper {
    
    public static double getFileSizeInMB (File file) {
        double length = file.length();
        length = length / Math.pow(1024.0,2);
        int fs = (int) Math.pow(10,2);
        
        return Math.rint(length*fs)/fs;
    }
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
}
