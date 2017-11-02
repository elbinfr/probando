/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import models.IncomingMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class IncomingMessageDAO {
    
    static Logger logger = Logger.getLogger((Class)CorporateDAO.class);
    
    private Connection cn = null;
    private ResultSet rs = null;
    
    private static IncomingMessageDAO instancia;
    
    public static IncomingMessageDAO getInstance(){
        if(instancia == null){
            instancia = new IncomingMessageDAO();
        }
        return instancia;
    }
    
    public ArrayList<IncomingMessage> findByUserName(String username) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        
        ArrayList list = new ArrayList<IncomingMessage>();
        try{
            String query = "select * from usrsms.incoming_message where node = ?" +
                            " and campaign_id is not null and record_status <> 2" +
                            " order by id desc;";
            
            ps = cn.prepareStatement(query);
            ps.setString(1, username.toUpperCase());
            rs = ps.executeQuery();
            
            while(rs.next()){
                IncomingMessage incomingMessage = new IncomingMessage(                        
                        rs.getInt("id"),
                        rs.getString("msisdn"),
                        rs.getString("txt_msg"),
                        rs.getTimestamp("received_date"),
                        rs.getDate("reply_date"),
                        rs.getInt("process_status"),
                        rs.getInt("campaign_id"),
                        rs.getString("node")
                );
                
                list.add(incomingMessage);
            }
            
        }catch(SQLException ex) {
            logger.error("MOWA-ERROR: Al leer Incoming Message " + ex.getMessage());
        } finally {
            if(cn != null){
                cn.close();
            }            
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        
        return list;
    }
    
    public boolean updateProcessStatusById(int id, int process_status) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        int response=0;
        try {
            
            String query = "update usrsms.incoming_message set process_status = ?" +
                            " where id = ?";
            
            ps = cn.prepareStatement(query);
            ps.setInt(1, process_status);
            ps.setInt(2, id);
            
            response=ps.executeUpdate();
            if(response == 0){
                return false;
            }

        } catch (SQLException ex) {
            logger.error("MOWA-ERROR: Al actualizar Process status Incoming Message " + ex.getMessage());
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }
        
        return true;
    }
    
    public boolean updateProcessStatusByUser(String user) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        int response=0;
        try {
            
            String query = "update usrsms.incoming_message set process_status = 2" +
                            " where node = ? and process_status = 1";
            
            
            ps = cn.prepareStatement(query);
            ps.setString(1, user.toUpperCase());
            
            response=ps.executeUpdate();
            if(response == 0){
                return false;
            }

        } catch (SQLException ex) {
            logger.error("MOWA-ERROR: Al actualizar Process status Incoming Message " + ex.getMessage());
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }
        
        return true;
    }
    
    public boolean updateRecordStatusById(int id, int record_status) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        int response=0;
        try {
            
            String query = "update usrsms.incoming_message set record_status = ?" +
                            " where id = ?";
            
            ps = cn.prepareStatement(query);
            ps.setInt(1, record_status);
            ps.setInt(2, id);
            
            response=ps.executeUpdate();
            if(response == 0){
                return false;
            }

        } catch (SQLException ex) {
            logger.error("MOWA-ERROR: Al actualizar Process status Incoming Message " + ex.getMessage());
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }
        
        return true;
    }
    
    public boolean updateRecordStatusByUser(String user) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        int response=0;
        try {
            
            String query = "update usrsms.incoming_message set record_status = 2" +
                            " where node = ? and record_status = 1";
            
            
            ps = cn.prepareStatement(query);
            ps.setString(1, user.toUpperCase());
            
            response=ps.executeUpdate();
            if(response == 0){
                return false;
            }

        } catch (SQLException ex) {
            logger.error("MOWA-ERROR: Al actualizar Process status Incoming Message " + ex.getMessage());
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }
        
        return true;
    }
    
    public boolean updateReplyDate(String node,String msisdn){
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        int response=0;
        
        try{
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
            String query = "update usrsms.incoming_message set reply_date = ? ,"
                    + "process_status = 2 where msisdn = ? and node = ?";
            
            ps = cn.prepareStatement(query);
            ps.setTimestamp(1, sqlDate);
            ps.setString(2, msisdn);
            ps.setString(3, node);
            
            response=ps.executeUpdate();
            if(response == 0){
                return false;
            }
 
        }catch(Exception e){
            logger.error("MOWA-ERROR: Al actualizar Process status Incoming Message " + e.getMessage());
        }
        
        return true;
    }
}
