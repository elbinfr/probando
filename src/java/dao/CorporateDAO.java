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
import java.util.ArrayList;
import java.util.List;
import models.Corporate;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class CorporateDAO {
    
    static Logger logger = Logger.getLogger((Class)CorporateDAO.class);
    
    private Connection cn = null;
    private ResultSet rs = null;
    private static CorporateDAO instancia;
    
    public static CorporateDAO getInstancia() {
        if (instancia == null) {
            instancia = new CorporateDAO();
        }
        return instancia;
    }
    
    public List verifyCredentials(String username, String password) throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String name = "";
        String query = "select * from usrsms.corporates where username=? "
                        + " and password=? ";
        
        List users = new ArrayList<Corporate>();
        try {
            
            ps=cn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Corporate user = new Corporate(
                   rs.getInt("id"),
                   rs.getString("name"),
                   rs.getString("username"),
                   rs.getString("password"),
                   rs.getString("email"),
                   rs.getString("virtual_line"),
                   rs.getInt("status"),
                   rs.getString("logo"),
                   rs.getInt("client_id"),
                   rs.getInt("corte")
                );
                users.add(user);
            }

        } catch (SQLException ex) {
            logger.error((Object)("MOWA-ERROR: error en logueo !!!" + ex.getMessage()));
            
        } finally {
            cn.close();
            if (ps != null) {
                ps.close();
            }
        }
        
        return users;
        
    }
}
