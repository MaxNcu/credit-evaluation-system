package com.scada.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.SysConfig;
import com.scada.service.SysConfigService;
import com.scada.utils.DataBackup;

public class SysManageAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private SysConfigService sysConfigService;
	protected HttpServletRequest request =null;
	protected HttpServletResponse response =null;
	private SysConfig sysConfig;
	//ҳ����Ϣ����
	private Integer pageSize;
	//ҳ���ҳ�����
	private Integer pageWidth;
	//session����Чʱ��
	private String sessionTime;
	//���ݱ��ݵ�·��
	private String databaseFilePath;
	
	public String show(){
		SysConfig sysConfig = sysConfigService.get(1);
		request.setAttribute("sessionValidTime", sysConfig.getSessionTime());
		request.setAttribute("pageSize", sysConfig.getPageSize());
		request.setAttribute("pageWidth", sysConfig.getPageWidth());
		return "show";
	}
	
	//����session����ʱ��
	public String sessionTime(){
		SysConfig sysConfig_time = sysConfigService.get(1);
		sysConfig_time.setSessionTime(Integer.parseInt(sessionTime));
		sysConfigService.update(sysConfig_time);
		
		HttpSession userSession = request.getSession();
		userSession.setMaxInactiveInterval(Integer.parseInt(sessionTime));
		return "sessionTime";
	}
	
	//���÷�ҳ
	public String page(){
		SysConfig sysConfig_page = sysConfigService.get(1);
		sysConfig_page.setPageSize(pageSize);
		sysConfig_page.setPageWidth(pageWidth);
		sysConfigService.update(sysConfig_page);
		return "page";
	}
	
	//���ݿⱸ��
	public String dataBackup(){
		try {
			DataBackup.backup(databaseFilePath);
			request.setAttribute("backupsuccess", "����ɹ�");
		} catch (Exception e) {
			request.setAttribute("backuperror", "����ʧ��");
		}
		return "dataBackup";
	}
	
//	//����ϵͳ�Ļ���������Ϣ
//	public String save(){
//		sysConfigService.update(sysConfig);
//		return "save";
//	}
	
	//------------------------get set����--------------------
	public SysConfigService getSysConfigService() {
		return sysConfigService;
	}

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}

	public String getDatabaseFilePath() {
		return databaseFilePath;
	}

	public void setDatabaseFilePath(String databaseFilePath) {
		this.databaseFilePath = databaseFilePath;
	}

	public SysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(SysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageWidth() {
		return pageWidth;
	}

	public void setPageWidth(Integer pageWidth) {
		this.pageWidth = pageWidth;
	}
	
	
}
