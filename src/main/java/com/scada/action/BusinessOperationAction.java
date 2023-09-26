package com.scada.action;

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.scada.domain.BusinessOperation;
import com.opensymphony.xwork2.ActionSupport;
import com.scada.service.BusinessOperationService;
import com.scada.service.MachineRoomService;

public class BusinessOperationAction extends ActionSupport implements RequestAware{
	
	private BusinessOperationService businessOperationService;
	
	public BusinessOperationService getBusinessOperationService() {
		return businessOperationService;
	}
	public void setBusinessOperationService(BusinessOperationService businessOperationService) {
		this.businessOperationService = businessOperationService;
	}

	public String saveBusinessOperation(){
		BusinessOperation businessOperation = new BusinessOperation();
		businessOperation.setuserType("����");
		businessOperation.setcompanyName("��˾����");
		businessOperation.setresidentName("��������");
		businessOperation.setarea("��������");
		businessOperation.setcompanyNum("13800000000");
		businessOperation.setfamilyNum("01088889999");
		businessOperation.setownerName("��������");
		businessOperation.setmainName("��������");
		businessOperation.setsex("�Ա�");
		businessOperation.setbirthday("��������");
		businessOperation.setaddress("��ϵ��ַ");
		businessOperation.settel("��ϵ�绰");
		businessOperation.setmobile("�ֻ�����");
		businessOperation.setemail("��������");
		
		
		businessOperationService.saveBusinessOperation(businessOperation);
		return null;
	}
	public String input(){
		request.put("businessOperationAcyion", businessOperationService.getAll());
		return INPUT;
	}
	
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	public String show(){
		request.put("businessOperationAcyion", businessOperationService.getAll());
		return "show";
	}
	
		
}
