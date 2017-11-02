/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.IncomingMessageBusiness;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import models.Corporate;
import models.IncomingMessage;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DELL
 */
public class IncomingMessageController extends BaseController{
    
    private ArrayList<IncomingMessage> messages = new ArrayList<IncomingMessage>();
    private int code;
    private String message;
    
    @Override
    public String execute() throws Exception {
        setSession("menu","Mensajes");
        setSession("submenu","Recibidos");
        Corporate user = (Corporate) getSession("user");
        setMessages(IncomingMessageBusiness.getInstance().findByUserName(user.getUsername()));
        
        return SUCCESS;
    }
    
    public String read() throws IOException{
        String data = getParameter("data");
        String[] a_data = data.split(";");
        
        String incoming_messages = a_data[0];
        String all = a_data[1];

        String a_messages = incoming_messages.replace("]", "").replace("[", "");
        Corporate user = (Corporate) getSession("user");
        
        code = 400;
        message = "Actualización correcta";
        
        try{
            if(Boolean.parseBoolean(all)){
            
                if(!IncomingMessageBusiness.getInstance().updateProcessStatusByUser(user.getUsername())){
                    code = 401;
                    message = "No se pudieron actualizar los datos. Intentelo de nuevo";
                }
                
            }else{
                String[] incomingArray = a_messages.split(",");
                IncomingMessageBusiness.getInstance().updateProcessStatusById(incomingArray);
            }
        }catch(Exception e){
            code = 401;
            message = "[IncomingMessageController:update] error:" + e.getMessage();
        }
        
        return SUCCESS;
    }
    
    public String delete(){
        
        String data = getParameter("data");
        String[] a_data = data.split(";");
        
        String incoming_messages = a_data[0];
        String all = a_data[1];

        String a_messages = incoming_messages.replace("]", "").replace("[", "");
        Corporate user = (Corporate) getSession("user");
        
        code = 400;
        message = "Actualización correcta";
        
        try{
            if(Boolean.parseBoolean(all)){
            
                if(!IncomingMessageBusiness.getInstance().updateRecordStatusByUser(user.getUsername())){
                    code = 401;
                    message = "No se pudieron actualizar los datos. Intentelo de nuevo";
                }
                
            }else{
                String[] incomingArray = a_messages.split(",");
                IncomingMessageBusiness.getInstance().updateRecordStatusById(incomingArray);
            }
        }catch(Exception e){
            code = 401;
            message = "[IncomingMessageController:update] error:" + e.getMessage();
        }
        
        return SUCCESS;
    }

    public ArrayList<IncomingMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<IncomingMessage> messages) {
        this.messages = messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
