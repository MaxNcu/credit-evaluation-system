package com.scada.domain;

/**
 * ���ù���
 * @author menghan
 *
 */
public class SysConfig {

	//����
	private Integer id;
	//ϵͳ����
	private String sysName;
	//ϵͳ����
	private String sysTitle;
	//logo��ַ
	private String sysLogoAddr;
	//ϵͳҳ��ײ���Ϣ����Ȩ��Ϣ��
	private String sysBottomMsg;
	//session����ʱ��
	private Integer sessionTime;
	//ҳ����Ϣ����
	private Integer pageSize;
	//ҳ����ҳ�����
	private Integer pageWidth;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getSysTitle() {
		return sysTitle;
	}
	public void setSysTitle(String sysTitle) {
		this.sysTitle = sysTitle;
	}
	public String getSysLogoAddr() {
		return sysLogoAddr;
	}
	public void setSysLogoAddr(String sysLogoAddr) {
		this.sysLogoAddr = sysLogoAddr;
	}
	public String getSysBottomMsg() {
		return sysBottomMsg;
	}
	public void setSysBottomMsg(String sysBottomMsg) {
		this.sysBottomMsg = sysBottomMsg;
	}
	public Integer getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Integer sessionTime) {
		this.sessionTime = sessionTime;
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
