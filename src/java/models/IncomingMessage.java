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
public class IncomingMessage {
    
    private int id;
    private String virtualLine;
    private String msisdn;
    private String txtMsg;
    private Date receivedDate;
    private Date replyDate;
    private int processStatus;
    private int recordStatus;
    private String node;
    private int campaignId;

    public IncomingMessage(int id, String msisdn, String txtMsg, Date receivedDate, Date replyDate, int processStatus, int campaignId, String node) {
        this.id = id;
        this.msisdn = msisdn;
        this.txtMsg = txtMsg;
        this.receivedDate = receivedDate;
        this.replyDate = replyDate;
        this.processStatus = processStatus;
        this.campaignId = campaignId;
        this.node = node;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVirtualLine() {
        return virtualLine;
    }

    public void setVirtualLine(String virtualLine) {
        this.virtualLine = virtualLine;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTxtMsg() {
        return txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        this.txtMsg = txtMsg;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public int getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
}
