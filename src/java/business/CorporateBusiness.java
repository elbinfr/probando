/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.CorporateDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class CorporateBusiness {
    
    static Logger logger = Logger.getLogger((Class)CorporateBusiness.class);
    
    private Connection cn = null;
    private ResultSet rs = null;
    private static CorporateBusiness instancia;
    
    public static CorporateBusiness getInstancia() {
        if (instancia == null) {
            instancia = new CorporateBusiness();
        }
        return instancia;
    }
    
    public List verifyCredentials(String username, String password) throws SQLException{
        return CorporateDAO.getInstancia().verifyCredentials(username, password);
    }
}
