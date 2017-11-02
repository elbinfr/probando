/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import models.Conversation;
import dao.ConversationDAO;

/**
 *
 * @author DELL
 */
public class ConversationBusiness {
    
    private static ConversationBusiness instance;
    
    public static ConversationBusiness getInstance(){
        if(instance == null){
            instance = new ConversationBusiness();
        }
        return instance;
    }
    
    public ArrayList<Conversation> getChat(String node,String msisdn) {
        return ConversationDAO.getInstance().getChat(node, msisdn);
    }
}
