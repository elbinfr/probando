/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Corporate;
import org.apache.struts2.ServletActionContext;
import services.FileService;

/**
 *
 * @author DELL
 */
public class OutgoingMessageController extends BaseController{
    
    @Override
    public String execute() throws Exception {
        setSession("menu","Mensajes");
        setSession("submenu","Enviados");
        return SUCCESS;
    }
    
    public String generateFile(){
        Corporate user = (Corporate) getSession("user");
        String username = user.getUsername();
        String from_date = getParameter("from_date");
        String to_date = getParameter("to_date");
        String filePath = "C:/home/ubuntu/mes/reports/";
        String fileName = "mensajesEnviados"+username;
        String extension = "csv";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try{

            Date fromDate = formatter.parse(from_date);
            Date toDate = formatter.parse(to_date);
            Calendar calendar = Calendar.getInstance();	
            calendar.setTime(new Timestamp(toDate.getTime())); // Configuramos la fecha que se recibe
            calendar.add(Calendar.DAY_OF_YEAR, 1); 
            String cabecera = "id;celular;mensaje;fecha de envio;estado;existe";
            String query = "select m.sending_id,m.msisdn,m.text,"
                    + "COALESCE(to_char(m.sending_date, 'DD/MM/YY HH24:MI:SS'),''),"
                    + "CASE WHEN m.status=2 THEN 'enviado' WHEN m.status=3 "
                    + "THEN 'en blacklist' WHEN m.status=4 THEN 'en indecopi' "
                    + "ELSE 'no enviado' END,"
                    + "CASE WHEN m.existe=1 THEN 'Si' ELSE 'No' END"
                    + " from usrsms.messages as m " +
                    "inner join usrsms.sendings as s on s.id = m.sending_id" +
                    " where s.corporate_id = '"+username+"' " +
                    "and s.scheduled_start_date between '"+new Timestamp(fromDate.getTime())+"'" +
                    "  and '"+calendar.getTime()+"' order by m.sending_id, m.id";
            
            FileService.generateSQLasFile(cabecera, filePath,fileName ,extension, query);
            fileName = fileName + "." + extension;
            FileService.download(filePath, fileName , fileName);
            
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        
        return SUCCESS;
    }
}
