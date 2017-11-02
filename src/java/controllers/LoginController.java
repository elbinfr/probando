/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.CorporateBusiness;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import models.Corporate;

/**
 *
 * @author DELL
 */
public class LoginController extends BaseController{
    
    private String message = "";
    private String username;
    private String password;
    
    @Override
    public String execute() throws Exception {
        
        if ((username == "") || (password == "")) {
            setErrorMessage("Por favor ingrese un usuario y una contraseña.");
            return "invalidLogin";
        }
        
        List users = new ArrayList<Corporate>();
        users = CorporateBusiness.getInstancia().verifyCredentials(username, password);
        if ((users == null) || (users.isEmpty())) {
            setErrorMessage("El usuario y/o contraseña no son correctos");
            return "invalidLogin";
            
        }
        
        Corporate user = (Corporate) users.get(0);
        
        if(user.getStatus() == 0){
            setErrorMessage("Usuario inhabilitado. Comunicarse con su asesor.");
            return "invalidLogin";
        }
        
        if(user.getStatus() == 3){
            setErrorMessage("Su tiempo de pruebas ha finalizado. Comunicarse con su asesor");
            return "invalidLogin";
        }
        
        int corte = 0;
        if(user.getCorte() == 1){
            Calendar calendario = Calendar.getInstance();
            int hora =calendario.get(Calendar.HOUR_OF_DAY);
            if(hora >= 19){
                corte = 1;
            }
        }
        
        setSession("user", user);
        
        return SUCCESS;
    }   
    
    public String logout(){
        removeSession("user");
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
