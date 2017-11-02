/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author DELL
 */
public class IndexController extends BaseController{
    
    @Override
    public String execute() throws Exception {
        setSession("menu","Inicio");
        setSession("submenu","");
        return SUCCESS;
    }
    
}
