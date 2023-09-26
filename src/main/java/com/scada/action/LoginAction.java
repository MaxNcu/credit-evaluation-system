package com.scada.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.User;
import com.scada.domain.UserRight;
import com.scada.service.SysConfigService;
import com.scada.service.UserRightService;
import com.scada.service.UserService;
import com.scada.utils.SystemLog;

public class LoginAction extends ActionSupport  implements ServletRequestAware,ServletResponseAware {

	private UserService userService;
	private UserRightService userRightService;
	private SysConfigService sysConfigService;
	protected HttpServletRequest request =null;
	protected HttpServletResponse response =null;
	private String username;
	private String password;

	/**
	 * ��¼��Ϣ��֤
	 * @return ��¼��Ϣ��ȷ�Ļ�����ת��ϵͳ����ҳ�棻��¼��Ϣ����Ļ������ص�¼ҳ��
	 */
	public String loginValidate(){
		User user = userService.findUserByLoginName(username);
		if(user==null || !user.getLoginPwd().equals(password)){
			this.addFieldError("loginError", "�û��������벻��ȷ����");
			return "error";
		}
		//����ϵͳ�����Լ��ײ���Ϣ
		request.setAttribute("sysConfigInfo", sysConfigService.get(1));
		//����session����Чʱ��
		HttpSession userSession = request.getSession();
		userSession.setMaxInactiveInterval(sysConfigService.get(1).getSessionTime());
		//���ɹ���¼���û���ӵ�session��
		request.getSession().setAttribute("global_user", user);
		UserRight userRight = userRightService.findUserRightById(user.getRightsId());
		//�����û���Ȩ����ӵ�session��
		request.getSession().setAttribute("global_user_userRight", userRight);
		//����½�˵�������¼����־��
		SystemLog.setSystemLog(user.getUsername(), this, "��¼��ϵͳ");
		//��¼��ʱʹ��ϵͳ���˵�����
		SystemLog.systemGlobalUser = user.getUsername();
		return "home";
	}
	
	/**
	 * ��ȫ�˳����Ƴ�session�е��û��Լ��û�Ȩ��
	 * @return ��ת����¼ҳ��
	 */
	public String safeExit(){
		//���˳�ϵͳ���˵�������¼����־��
		SystemLog.setSystemLog(((User)request.getSession().getAttribute("global_user")).getUsername(), this, "�˳���ϵͳ");
		request.getSession().removeAttribute("global_user");
		request.getSession().removeAttribute("global_user_userRight");
		return "exit";
	}
	

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserRightService getUserRightService() {
		return userRightService;
	}

	public void setUserRightService(UserRightService userRightService) {
		this.userRightService = userRightService;
	}
	
	public SysConfigService getSysConfigService() {
		return sysConfigService;
	}

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
