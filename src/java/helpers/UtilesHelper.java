
package helpers;

import java.util.Calendar;


public final class UtilesHelper {
    
    public static long getIdentificador(){
        
        Calendar calendar = Calendar.getInstance();
        long tiempo=calendar.getTimeInMillis();
        
        return tiempo;
        
    }
}
