package com.scada.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.SysSafety;
import com.scada.service.SysSafetyService;

public class SysSafetyAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private SysSafetyService sysSafetyService;
	protected HttpServletRequest request =null;
	protected HttpServletResponse response =null;
	//�Ƿ����ú�̨��־
	private Integer isEnableLog;
	//����¼ʧ�ܴ���
	private Integer loginFailureCount;
	//ip����ʱ��
	private Integer ipLockTime;
	//ip���ʽ�ֹ�Ƿ�����
	private Integer isIPAccessProhibited; 
	
	//��ʾҳ��
	public String show(){
		request.setAttribute("sysSafetyInfo", sysSafetyService.get(1));
		return "show";
	}

	//������ύ����Ϣ
	public String save(){
		SysSafety sysSafety = sysSafetyService.get(1);
		if(ipLockTime!=null)
			sysSafety.setIpLockTime(ipLockTime);
		if(isEnableLog==1)
			sysSafety.setIsEnableLog(true);
		else
			sysSafety.setIsEnableLog(false);
		if(isIPAccessProhibited==1)
			sysSafety.setIsIPAccessProhibited(true);
		else
			sysSafety.setIsIPAccessProhibited(false);
		if(loginFailureCount!=null)
			sysSafety.setLoginFailureCount(loginFailureCount);
		sysSafetyService.update(sysSafety);
		return "save";
	}
	
	
	//getter ��   setter
	public SysSafetyService getSysSafetyService() {
		return sysSafetyService;
	}

	public void setSysSafetyService(SysSafetyService sysSafetyService) {
		this.sysSafetyService = sysSafetyService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Integer getIpLockTime() {
		return ipLockTime;
	}

	public void setIpLockTime(Integer ipLockTime) {
		this.ipLockTime = ipLockTime;
	}

	public Integer getIsEnableLog() {
		return isEnableLog;
	}

	public void setIsEnableLog(Integer isEnableLog) {
		this.isEnableLog = isEnableLog;
	}

	public Integer getIsIPAccessProhibited() {
		return isIPAccessProhibited;
	}

	public void setIsIPAccessProhibited(Integer isIPAccessProhibited) {
		this.isIPAccessProhibited = isIPAccessProhibited;
	}

	
	
}

