package com.scada.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.User;
import com.scada.domain.UserRight;
import com.scada.service.UserRightService;
import com.scada.service.UserService;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private UserService userService;
	private UserRightService userRightService;
	private User user;
	protected HttpServletRequest request =null;
	protected HttpServletResponse response =null;


	/**
	 * �������е��û��Լ����е�Ȩ��
	 * ����userList��userRightIDs�У������ظ�ǰ̨��ҳ��
	 * @return
	 */
	public String list() {
		//��������û�
		List<User> list = userService.getAll();
		List<Integer> userRightIDs = new ArrayList<>();
		//�������Ȩ��
		List<UserRight> userRights = userRightService.getAll();
		for(int i=0;i<userRights.size();i++){
			userRightIDs.add(userRights.get(i).getRightId());
		}
		request.setAttribute("userList", list);
		request.setAttribute("userRightIDs", userRightIDs);
		return "list";
	}
	
	
	public String add(){
		user.setOnDutyDate(new Date());
		user.setIsDuty("��");
		user.setRightsId(Integer.parseInt(request.getParameter("userRightsId")));
		userService.save(user);
		return "add";
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UserRightService getUserRightService() {
		return userRightService;
	}

	public void setUserRightService(UserRightService userRightService) {
		this.userRightService = userRightService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
