/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author DELL
 */
public final class StringHelper {
    
    public static String maquetarEspacios(String msj){
        
        String rpta=msj.replaceAll(" ","%20");
        
        return rpta;
        
    }
    
}
