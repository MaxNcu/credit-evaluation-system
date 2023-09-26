package com.scada.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.scada.domain.User;

/**
 * session����
 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ȡ�������URL
        String url = ServletActionContext.getRequest().getRequestURL().toString();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setHeader("Pragma","No-cache");          
        response.setHeader("Cache-Control","no-cache");   
        response.setHeader("Cache-Control", "no-store");   
        response.setDateHeader("Expires",0);
        User user = null;
        //�Ե�¼��ע������ֱ�ӷ���,��������
        if (url.indexOf("loginAction_loginValidate")!=-1 || url.indexOf("loginAction_safeExit")!=-1 ){
            return invocation.invoke();
        }
        else{
            //��֤Session�Ƿ����
            if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
                //session����,ת��session������ʾҳ,������ת����¼ҳ��
                return "tologin";
            }
            else{
                user = (User)ServletActionContext.getRequest().getSession().getAttribute("global_user");
                //��֤�Ƿ��Ѿ���¼
                if (user==null){
                    //��δ��¼,��ת����¼ҳ��
                    return "tologin";
                }else{                    
                    return invocation.invoke();
                                
                }                
            }            
        }
	}

}
