
package interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterceptorAcceso extends AbstractInterceptor{
    private String publicActions;
    private List<String> actionsWithoutFilter = new ArrayList<String>();
    
    @Override
    public void init()
    {
        actionsWithoutFilter = Arrays.asList(publicActions.split(","));
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result = Action.LOGIN;
        
        String currentAction = (String)ActionContext.getContext().get(ActionContext.ACTION_NAME);

        if (actionInvocation.getInvocationContext().getSession().containsKey("usuario")
                || actionsWithoutFilter.contains(currentAction) )
        {
            result = actionInvocation.invoke();
        }

        return result;
    }

    public void setPublicActions(String publicActions) {
        this.publicActions = publicActions;
    }
    
}
