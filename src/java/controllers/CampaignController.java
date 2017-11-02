
package controllers;

import business.CampaignBusiness;
import models.Corporate;
import models.Sending;
import services.ExcelService;
import helpers.UtilesHelper;
import com.jcfr.utiles.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class CampaignController extends BaseController{
    
    static Logger logger = Logger.getLogger((Class)CampaignController.class);
    
    private File campaignFile;    
    private String campaignFileContentType;
    private String campaignFileFileName;
    
    private String newFileName = "";
    private String stage;
    
    private String nameColumns;
    private String hideHeaders;
    private String errorList;
    private int totalRows;
    
    public String createCampaing() throws Exception{
        setSession("menu", "Campañas");
        setSession("submenu", "Crear campaña");
        setSession("optionCampaign", "personalizado");
        try{
            
        }catch(Exception ex){
            logger.error((Object)("MOWA-ERROR (ACTION)!!! " + ex.getMessage()));
        }finally{
            
        }
        
        return SUCCESS;
    }
    
    public String loadCampaignFile() throws Exception{
        setStage(null);
        setSession("optionCampaign", "archivo");
        
        Corporate corporate = (Corporate) getSession("user");
        CampaignBusiness campaignBusiness = new CampaignBusiness();
        Sending sending = new Sending();
        try{
            if(JUtil.JSU._vacio(campaignFile)){
                setErrorMessage("Debe selecionar un archivo xlsx.");
                setStatusAction("error");
                return SUCCESS;
            }
            if(!campaignBusiness.validateFileCampaign(campaignFile, corporate)){
                setErrorMessage(campaignBusiness.getMessage());
                setStatusAction("error");
                return SUCCESS;
            }
            
            Properties configProps = new Properties();
            configProps.load(CampaignController.class.getResourceAsStream("/config/mes.properties"));
            
            String filePath = configProps.getProperty("file.path", "/home/ubuntu/mes/loader/");
            BufferedReader entrada = new BufferedReader(new FileReader(campaignFile));           
            
            if (campaignFileContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
                sending.setFileUrl(campaignFileFileName);
                File fileToCreate = new File(filePath, campaignFileFileName);
                FileUtils.copyFile(campaignFile, fileToCreate);

                newFileName = Long.toString(UtilesHelper.getIdentificador());
                
                File newfile = new File(filePath, newFileName + ".xlsx");
                if (fileToCreate.renameTo(newfile)) {
                    logger.info("Rename succesful");
                } else {
                    logger.info("Rename failed");
                }
                
                sending.setFileUrlServer(newFileName + ".txt");
                
                ExcelService excelService = new ExcelService();
                excelService.readXLSXFile(newFileName, filePath);

                
                setNameColumns(excelService.getNameColumns());
                setHideHeaders(excelService.getHideHeaders());
                setErrorList(excelService.getErrorList());
                setTotalRows(excelService.getTotalRows());
                sending.setTotalMessages(getTotalRows());
                
                setStage("loadfile");
                setSession("sending", sending);
            }
            
        }catch(Exception ex){
            logger.error((Object)("MOWA-ERROR (ACTION)!!! " + ex.getMessage()));
        }finally{
            
        }
        
        return SUCCESS;
    }

    public File getCampaignFile() {
        return campaignFile;
    }

    public void setCampaignFile(File campaignFile) {
        this.campaignFile = campaignFile;
    }

    public String getCampaignFileContentType() {
        return campaignFileContentType;
    }

    public void setCampaignFileContentType(String campaignFileContentType) {
        this.campaignFileContentType = campaignFileContentType;
    }

    public String getCampaignFileFileName() {
        return campaignFileFileName;
    }

    public void setCampaignFileFileName(String campaignFileFileName) {
        this.campaignFileFileName = campaignFileFileName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getNameColumns() {
        return nameColumns;
    }

    public void setNameColumns(String nameColumns) {
        this.nameColumns = nameColumns;
    }

    public String getHideHeaders() {
        return hideHeaders;
    }

    public void setHideHeaders(String hideHeaders) {
        this.hideHeaders = hideHeaders;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getErrorList() {
        return errorList;
    }

    public void setErrorList(String errorList) {
        this.errorList = errorList;
    }
    
}
