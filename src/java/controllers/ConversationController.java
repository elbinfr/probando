/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.ConversationBusiness;
import business.IncomingMessageBusiness;
import java.util.ArrayList;
import models.Conversation;
import models.Corporate;
import org.apache.log4j.Logger;
import services.MessageService;

/**
 *
 * @author DELL
 */
public class ConversationController extends BaseController{
    
    static Logger logger = Logger.getLogger((Class)ConversationController.class);
    
    private ArrayList<Conversation> messages = new ArrayList<Conversation>();
    
    private int id;
    private String msisdn;
    private String node;
    private String text;
    
    @Override
    public String execute() throws Exception {
        setSession("menu","CHAT CRM");
        setSession("submenu","");
        setMessages(ConversationBusiness.getInstance().getChat(node,msisdn));
        
        return SUCCESS;
    }
    
    public String reply(){
        Corporate user = (Corporate) getSession("user");

        try{
            String mensaje = getParameter("text");
            String msisdn = getParameter("msisdn");
            String node = getParameter("node");
            MessageService.sentMessages(mensaje , msisdn, node);
            IncomingMessageBusiness.getInstance().updateReplyDate(node, msisdn);
        }catch(Exception e){
            logger.error("MOWA-ERROR: Al responder chat " + e.getMessage());
        }
        
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public ArrayList<Conversation> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Conversation> messages) {
        this.messages = messages;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
    
    
   
}
