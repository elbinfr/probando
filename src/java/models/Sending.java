
package models;

import java.util.Date;


public class Sending implements java.io.Serializable{
    
    public static final int END_QUEUE = -99;
    public static final int PROCESS_FILE_NOT_LOADED = 1;
    public static final int PROCESS_FILE_LOAD_IN_PROCESS = 2;
    public static final int PROCESS_FILE_LOAD_ERROR = 3;
    public static final int PROCESS_SENDING_NOT_FINISHED = 4;
    public static final int PROCESS_SENDING_IN_PROCESS = 5;
    public static final int PROCESS_SENDING_STOPPED = 6;
    public static final int PROCESS_SENDING_FINISHED = 7;
    public static final int SENDING_VALID = 1;
    public static final int SENDING_DELETED = 2;
    
    private int id;
    private String corporateId;
    private String fileUrl;
    private int throughput;
    private String email;
    private Date scheduledStartDate;
    private Date scheduledEndDate;
    private int lastMessageId;
    private Date realStartDate;
    private Date realEndDate;
    private Integer totalMessages;
    private Integer totalOriginal;
    private Integer sentMessages;
    private Integer errorMessages;
    private Date creationDate;
    private int processStatus;
    private int recordStatus;
    private String fileUrlServer;
    private int flagBl;
    private String image;
    private String description;
    private int incorrectNumber;
    private int blacklistNumber;
    private int indecopiNumber;
    private int totalIncoming;
    private int flKeyword;    

    public Sending() {
    }

    public Sending(int id, String corporateId, String fileUrl, int throughput, String email, Date scheduledStartDate, Date scheduledEndDate, int lastMessageId, Date realStartDate, Date realEndDate, Integer totalMessages, Integer sentMessages, Integer errorMessages, Date creationDate, int processStatus, int recordStatus, String fileUrlServer, int flagBl, String image, String description, int incorrectNumber, int blacklistNumber, int indecopiNumber, int totalOriginal, int flKeyword) {
        this.id = id;
        this.corporateId = corporateId;
        this.fileUrl = fileUrl;
        this.throughput = throughput;
        this.email = email;
        this.scheduledStartDate = scheduledStartDate;
        this.scheduledEndDate = scheduledEndDate;
        this.lastMessageId = lastMessageId;
        this.realStartDate = realStartDate;
        this.realEndDate = realEndDate;
        this.totalMessages = totalMessages;
        this.totalOriginal = totalOriginal;
        this.sentMessages = sentMessages;
        this.errorMessages = errorMessages;
        this.creationDate = creationDate;
        this.processStatus = processStatus;
        this.recordStatus = recordStatus;
        this.fileUrlServer = fileUrlServer;
        this.flagBl = flagBl;
        this.image = image;
        this.description = description;
        this.incorrectNumber = incorrectNumber;
        this.blacklistNumber = blacklistNumber;
        this.indecopiNumber = indecopiNumber;
        this.flKeyword = flKeyword;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorporateId() {
        return this.corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getThroughput() {
        return this.throughput;
    }

    public void setThroughput(int throughput) {
        this.throughput = throughput;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getScheduledStartDate() {
        return this.scheduledStartDate;
    }

    public void setScheduledStartDate(Date scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public Date getScheduledEndDate() {
        return this.scheduledEndDate;
    }

    public void setScheduledEndDate(Date scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public int getLastMessageId() {
        return this.lastMessageId;
    }

    public void setLastMessageId(int lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public Date getRealStartDate() {
        return this.realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealEndDate() {
        return this.realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public Integer getTotalMessages() {
        return this.totalMessages;
    }

    public void setTotalMessages(Integer totalMessages) {
        this.totalMessages = totalMessages;
    }

    public Integer getSentMessages() {
        return this.sentMessages;
    }

    public Integer getTotalOriginal() {
        return totalOriginal;
    }

    public void setTotalOriginal(Integer totalOriginal) {
        this.totalOriginal = totalOriginal;
    }
    
    

    public void setSentMessages(Integer sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Integer getErrorMessages() {
        return this.errorMessages;
    }

    public void setErrorMessages(Integer errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getProcessStatus() {
        return this.processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    public int getRecordStatus() {
        return this.recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getFileUrlServer() {
        return this.fileUrlServer;
    }

    public void setFileUrlServer(String fileUrlServer) {
        this.fileUrlServer = fileUrlServer;
    }

    public int getFlagBl() {
        return flagBl;
    }

    public void setFlagBl(int flagBl) {
        this.flagBl = flagBl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the incorrectNumber
     */
    public int getIncorrectNumber() {
        return incorrectNumber;
    }

    /**
     * @param incorrectNumber the incorrectNumber to set
     */
    public void setIncorrectNumber(int incorrectNumber) {
        this.incorrectNumber = incorrectNumber;
    }
    
    public int getBlacklistNumber() {
        return blacklistNumber;
    }

    public void setBlacklistNumber(int blacklistNumber) {
        this.blacklistNumber = blacklistNumber;
    }

    public int getIndecopiNumber() {
        return indecopiNumber;
    }

    public void setIndecopiNumber(int indecopiNumber) {
        this.indecopiNumber = indecopiNumber;
    }

    public int getTotalIncoming() {
        return totalIncoming;
    }

    public void setTotalIncoming(int totalIncoming) {
        this.totalIncoming = totalIncoming;
    }

    public int getFlKeyword() {
        return flKeyword;
    }

    public void setFlKeyword(int flKeyword) {
        this.flKeyword = flKeyword;
    }
    
}
