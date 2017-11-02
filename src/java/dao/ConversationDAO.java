/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Conversation;
import models.Corporate;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class ConversationDAO {
    
    static Logger logger = Logger.getLogger((Class)CorporateDAO.class);
    
    private Connection cn = null;
    private ResultSet rs = null;
    
    private static ConversationDAO instance;
    
    public static ConversationDAO getInstance(){
        if(instance == null){
            instance = new ConversationDAO();
        }
        return instance;
    }
    
    public ArrayList<Conversation> getChat(String node,String msisdn) {
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        
        ArrayList chat = new ArrayList<Corporate>();
        try{
            String query = "select * from usrsms.chat where username = ? "
                    + " and msisdn = ? order by date";
            
            ps = cn.prepareStatement(query);
            ps.setString(1, node.toUpperCase());
            ps.setString(2, msisdn);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Conversation conversation = new Conversation(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("msisdn"),
                    rs.getString("text"),
                    rs.getTimestamp("date"),
                    rs.getInt("status"),
                    rs.getInt("type")
                );
                
                chat.add(conversation);
            }
        }catch(Exception e){
            logger.error("MOWA-ERROR: Al leer History Message " + e.getMessage());
        }
        
        return chat;
    }
}
