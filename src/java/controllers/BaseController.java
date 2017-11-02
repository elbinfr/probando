
package controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class BaseController extends ActionSupport implements SessionAware{
    
    private ValueStack stack= ActionContext.getContext().getValueStack();
    private Map<String, Object> currentSession;
    private Map<String, Object> currentRequest;
    private String errorMessage;
    private String statusAction;
    
    private HttpServletRequest request = ServletActionContext.getRequest();

    public ValueStack getStack() {
        return stack;
    }

    public void setStack(ValueStack stack) {
        this.stack = stack;
    }
    
    public Map<String, Object> getCurrentSession() {
        return currentSession;
    }

    public Map<String, Object> getCurrentRequest() {
        return currentRequest;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        currentSession = session;
    }
    
    public void setSession(String key, Object value){
        getCurrentSession().put(key, value);
    }
    
    public Object getSession(String key){
        return getCurrentSession().get(key);
    }
    
    public Object removeSession(String key){
        return getCurrentSession().remove(key);
    }

    public String getParameter(String parameterName){
        return request.getParameter(parameterName);
    }
    
    public void setParameter(String parameterName, Object parameter){
        request.setAttribute(parameterName, parameter);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatusAction() {
        return statusAction;
    }

    public void setStatusAction(String statusAction) {
        this.statusAction = statusAction;
    }
    
}
