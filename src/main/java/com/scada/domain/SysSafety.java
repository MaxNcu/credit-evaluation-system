package com.scada.domain;

public class SysSafety {
	private Integer sysId;
	//�Ƿ����ú�̨��־
	private Boolean isEnableLog;
	//����¼ʧ�ܴ���
	private Integer loginFailureCount;
	//ip����ʱ��
	private Integer ipLockTime;
	//ip���ʽ�ֹ�Ƿ�����
	private Boolean isIPAccessProhibited;
	public Boolean getIsEnableLog() {
		return isEnableLog;
	}
	public void setIsEnableLog(Boolean isEnableLog) {
		this.isEnableLog = isEnableLog;
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
	public Boolean getIsIPAccessProhibited() {
		return isIPAccessProhibited;
	}
	public void setIsIPAccessProhibited(Boolean isIPAccessProhibited) {
		this.isIPAccessProhibited = isIPAccessProhibited;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	
	
}
