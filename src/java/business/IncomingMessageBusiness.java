/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.IncomingMessageDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import models.IncomingMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class IncomingMessageBusiness {
    
    static Logger logger = Logger.getLogger((Class)CorporateBusiness.class);
    
    private static IncomingMessageBusiness instancia;
    
    public static IncomingMessageBusiness getInstance(){
        
        if( instancia == null){
            instancia = new IncomingMessageBusiness();
        }
        return instancia;
    }
    
    public ArrayList<IncomingMessage> findByUserName(String username) throws SQLException{
        return IncomingMessageDAO.getInstance().findByUserName(username);
    }
    
    public void updateProcessStatusById(String[] incomingArray) throws SQLException{
        
        for (int i=0;i<incomingArray.length;i++)
        {
            String id = incomingArray[i];
            IncomingMessageDAO.getInstance().updateProcessStatusById(Integer.parseInt(id), 2);
        }
    }
    
    public boolean updateProcessStatusByUser(String user) throws SQLException{
        return IncomingMessageDAO.getInstance().updateProcessStatusByUser(user);
    }
    
    public void updateRecordStatusById(String[] incomingArray) throws SQLException{
        
        for (int i=0;i<incomingArray.length;i++)
        {
            String id = incomingArray[i];
            IncomingMessageDAO.getInstance().updateRecordStatusById(Integer.parseInt(id), 2);
        }
    }
    
    public boolean updateRecordStatusByUser(String user) throws SQLException{
        return IncomingMessageDAO.getInstance().updateRecordStatusByUser(user);
    }
    
    public boolean updateReplyDate(String node,String msisdn){
        return IncomingMessageDAO.getInstance().updateReplyDate(node,msisdn);
    }
}
