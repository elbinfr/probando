/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Conversation {
    
    private int id;
    private String username;
    private String msisdn;
    private String text;
    private Date date;
    private int status;
    
    private int type;
    private String mo;//origin

    private int estado_envio;
    
    public Conversation(int id, String username, String msisdn, String text, Date date, int status, int type) {
        this.id = id;
        this.username = username;
        this.msisdn = msisdn;
        this.text = text;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public int getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(int estado_envio) {
        this.estado_envio = estado_envio;
    }
    
    
    
}
