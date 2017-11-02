/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import helpers.StringHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author DELL
 */
public final class MessageService {
    
    public static void sentMessages(String msj,String numero, String usuario){
       
        String protocolo="HTTP";
        String response = "";

        BufferedReader rd = null;
        try {
             String request= "http://54.208.99.218:8080/MES2App/sendSMS.jsp?mensaje="
                            +StringHelper.maquetarEspacios(msj)+"&numero="+numero+"&usuario="+usuario;
            URL url = new URL(request);

            if (protocolo.equals("HTTPS")) {
                HttpsURLConnection conn1 = (HttpsURLConnection) url.openConnection();
                rd = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            } else {
                URLConnection conn2 = url.openConnection();
                rd = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
            }

            String line;
            while ((line = rd.readLine()) != null) {
                //Process line...
                response += line;
            }

        } catch (Exception e) {
            System.out.println("WEB REQUERIDA HA FALLADO");
        } finally {

            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException ex) {
                    System.out.println("PROBLEMA AL CERRA LA LECTURA");
                }
            }
        }

    }
    
}
